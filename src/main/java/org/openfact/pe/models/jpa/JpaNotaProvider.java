package org.openfact.pe.models.jpa;

import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.CdrEntity;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
import org.openfact.pe.models.jpa.entities.NotaEntity;
import org.openfact.pe.models.jpa.entities.EstadoSunatEntity;
import org.openfact.pe.models.types.TipoNota;
import org.openfact.pe.models.utils.SunatUtils;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaNotaProvider implements NotaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    private NotaModel toModel(NotaEntity notaEntity) {
        return new NotaAdapter(em, notaEntity);
    }

    private EntityGraph<?> getListGraph() {
        return em.getEntityGraph("graph.ListNotas");
    }

    private String getPrefijo(InvoiceModel invoice) {
        return invoice.getSerie().substring(0, 1);
    }

    @Override
    public NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, tipoNota, invoiceAfectado, Optional.empty());
        return createNota(organization, tipoNota, invoiceAfectado, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, tipoNota, invoiceAfectado, Optional.of(serie));
        return createNota(organization, tipoNota, invoiceAfectado, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        CdrEntity cdrEntity = new CdrEntity();
        cdrEntity.setId(ModelUtils.generateId());

        EstadoSunatEntity estadoSunatEntity = new EstadoSunatEntity();
        estadoSunatEntity.setId(ModelUtils.generateId());
        estadoSunatEntity.setEstado(false);

        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setId(ModelUtils.generateId());
        notaEntity.setSerie(serie);
        notaEntity.setNumero(numero);
        notaEntity.setCodigoTipoComprobante(tipoNota.getCodigo());
        notaEntity.setEstado(EstadoComprobantePago.ABIERTO);
        notaEntity.setCreatedAt(Calendar.getInstance().getTime());
        notaEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        notaEntity.setInvoiceAfectado(InvoiceAdapter.toEntity(invoiceAfectado, em));

        notaEntity.setDatosVenta(datosVentaEntity);
        notaEntity.setCdr(cdrEntity);
        notaEntity.setEstadoSunat(estadoSunatEntity);

        em.persist(datosVentaEntity);
        em.persist(cdrEntity);
        em.persist(estadoSunatEntity);
        em.persist(notaEntity);
        em.flush();
        return toModel(notaEntity);
    }

    @Override
    public Optional<NotaModel> getNota(String id) {
        NotaEntity entity = em.find(NotaEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(new NotaAdapter(em, entity));
    }

    @Override
    public Optional<NotaModel> getNota(OrganizationModel organization, String id) {
        TypedQuery<NotaEntity> q = em.createNamedQuery("getNotasPorId", NotaEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("notaId", id);
        List<NotaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public Optional<NotaModel> getNotaBySerieYNumero(OrganizationModel organization, String serie, int numero) {
        TypedQuery<NotaEntity> q = em.createNamedQuery("getNotasPorSerieYNumero", NotaEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("serie", serie);
        q.setParameter("numero", numero);
        List<NotaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<NotaModel> buscarNota(OrganizationModel organization, String filterText) {
        return buscarNota(organization, filterText, -1, -1);
    }

    @Override
    public List<NotaModel> buscarNota(OrganizationModel organization, String filterText, int offset, int limit) {
        TypedQuery<NotaEntity> query = em.createNamedQuery("filterDistinctNotas", NotaEntity.class);
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
    public long getNotasCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("countNotas");
        query.setParameter("organizationId", organization.getId());
        return ((Long) query.getSingleResult());
    }

    private AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado, Optional<String> optionalSerie) {
        Optional<NotaEntity> ultimoComprobante;
        if (!optionalSerie.isPresent()) {
            TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasEmpezandoPorLasMasRecientes", NotaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("codigo", tipoNota.getCodigo());
            query.setMaxResults(1);
            List<NotaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        } else {
            if (!optionalSerie.get().startsWith(invoiceAfectado.getSerie().substring(0, 1))) {
                throw new ModelRuntimeException("Serie no coincide con la serie del invoice afectado");
            }

            TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasConSerieEmpezandoPorLasMasRecientes", NotaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("codigo", tipoNota.getCodigo());
            query.setParameter("serie", optionalSerie.get());
            query.setMaxResults(1);
            List<NotaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        }

        if (ultimoComprobante.isPresent()) {
            NotaEntity entity = ultimoComprobante.get();
            String ultimaSerie = entity.getSerie();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasPorSerieYNumero", NotaEntity.class);
                    query.setParameter("organizationId", organization.getId());
                    query.setParameter("serie", ultimaSerie);
                    query.setParameter("numero", siguienteNumero);
                    query.setMaxResults(1);
                    List<NotaEntity> resultList = query.getResultList();
                    if (!resultList.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(ultimaSerie, siguienteNumero);
            } else {
                String nuevaSerie = SunatUtils.incrementarSerie(ultimaSerie);
                return siguienteSerieNumero(organization, tipoNota, invoiceAfectado, Optional.of(nuevaSerie));
            }
        } else {
            String serie = optionalSerie.orElseGet(() -> getPrefijo(invoiceAfectado) + 1);
            serie = SunatUtils.getSerieConCerosCompletados(serie, 4);
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

}
