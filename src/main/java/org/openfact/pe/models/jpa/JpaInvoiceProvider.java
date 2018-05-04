package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.Labels;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.InvoiceModel;
import org.openfact.pe.models.InvoiceProvider;
import org.openfact.pe.models.jpa.entities.CdrEntity;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
import org.openfact.pe.models.jpa.entities.InvoiceEntity;
import org.openfact.pe.models.jpa.entities.EstadoSunatEntity;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.SunatUtils;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaInvoiceProvider implements InvoiceProvider {

    private static final String CODIGO_TIPO_COMPROBANTE = "codigoTipoComprobante";
    private static final String ESTADO_COMPROBANTE = "estadoComprobante";

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    private InvoiceModel toModel(InvoiceEntity invoiceEntity) {
        return new InvoiceAdapter(em, invoiceEntity);
    }

    private EntityGraph<?> getListGraph() {
        return em.getEntityGraph("graph.ListInvoices");
    }

    @Override
    public synchronized InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, tipoInvoice, Optional.empty());
        return createInvoice(organization, tipoInvoice, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public synchronized InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, tipoInvoice, Optional.of(serie));
        return createInvoice(organization, tipoInvoice, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        CdrEntity cdrEntity = new CdrEntity();
        cdrEntity.setId(ModelUtils.generateId());

        EstadoSunatEntity estadoSunatEntity = new EstadoSunatEntity();
        estadoSunatEntity.setId(ModelUtils.generateId());
        estadoSunatEntity.setEstado(false);

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(ModelUtils.generateId());
        invoiceEntity.setSerie(serie);
        invoiceEntity.setNumero(numero);
        invoiceEntity.setCodigoTipoComprobante(tipoInvoice.getCodigo());
        invoiceEntity.setEstado(EstadoComprobantePago.ABIERTO);
        invoiceEntity.setCreatedAt(Calendar.getInstance().getTime());
        invoiceEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        invoiceEntity.setDatosVenta(datosVentaEntity);
        invoiceEntity.setCdr(cdrEntity);
        invoiceEntity.setEstadoSunat(estadoSunatEntity);

        em.persist(datosVentaEntity);
        em.persist(cdrEntity);
        em.persist(estadoSunatEntity);
        em.persist(invoiceEntity);
        em.flush();
        return toModel(invoiceEntity);
    }

    @Override
    public Optional<InvoiceModel> getInvoice(String id) {
        InvoiceEntity entity = em.find(InvoiceEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(toModel(entity));
    }

    @Override
    public Optional<InvoiceModel> getInvoice(OrganizationModel organization, String id) {
        TypedQuery<InvoiceEntity> q = em.createNamedQuery("getInvoicesPorId", InvoiceEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("invoiceId", id);
        List<InvoiceEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public Optional<InvoiceModel> getInvoiceBySerieYNumero(OrganizationModel organization, String serie, int numero) {
        TypedQuery<InvoiceEntity> q = em.createNamedQuery("getInvoicesPorSerieYNumero", InvoiceEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("serie", serie);
        q.setParameter("numero", numero);
        List<InvoiceEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<InvoiceModel> buscarInvoice(OrganizationModel organization, String filterText) {
        return buscarInvoice(organization, filterText, -1, -1);
    }

    @Override
    public List<InvoiceModel> buscarInvoice(OrganizationModel organization, String filterText, int offset, int limit) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("filterDistinctInvoices", InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("filterText", "%" + filterText.toLowerCase());
        query.setHint("javax.persistence.fetchgraph", getListGraph());
        if (offset != -1) {
            query.setFirstResult(offset);
        }
        if (limit != -1) {
            query.setMaxResults(limit);
        }
        return query.getResultList().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public long getInvoicesCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("countInvoices");
        query.setParameter("organizationId", organization.getId());
        return ((Long) query.getSingleResult());
    }

    private AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organization, TipoInvoice tipoInvoice, Optional<String> optionalSerie) {
        Optional<InvoiceEntity> ultimoComprobante;
        if (!optionalSerie.isPresent()) {
            TypedQuery<InvoiceEntity> query = em.createNamedQuery("getInvoicesEmpezandoPorLasMasRecientes", InvoiceEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("codigo", tipoInvoice.getCodigo());
            query.setMaxResults(1);
            List<InvoiceEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        } else {
            TypedQuery<InvoiceEntity> query = em.createNamedQuery("getInvoicesConSerieEmpezandoPorLasMasRecientes", InvoiceEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("codigo", tipoInvoice.getCodigo());
            query.setParameter("serie", optionalSerie.get());
            query.setMaxResults(1);
            List<InvoiceEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        }

        if (ultimoComprobante.isPresent()) {
            InvoiceEntity entity = ultimoComprobante.get();
            String ultimaSerie = entity.getSerie();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<InvoiceEntity> query = em.createNamedQuery("getInvoicesPorSerieYNumero", InvoiceEntity.class);
                    query.setParameter("organizationId", organization.getId());
                    query.setParameter("serie", ultimaSerie);
                    query.setParameter("numero", siguienteNumero);
                    query.setMaxResults(1);
                    List<InvoiceEntity> resultList = query.getResultList();
                    if (!resultList.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(ultimaSerie, siguienteNumero);
            } else {
                String nuevaSerie = SunatUtils.incrementarSerie(ultimaSerie);
                return siguienteSerieNumero(organization, tipoInvoice, Optional.of(nuevaSerie));
            }
        } else {
            String serie = optionalSerie.orElseGet(() -> tipoInvoice.getPrefijo() + 1);
            serie = SunatUtils.getSerieConCerosCompletados(serie, 4);
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

}
