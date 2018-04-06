package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.jpa.entities.FacturaEntity;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.SUNATUtils;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaFacturaProvider implements FacturaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.facturas.prefijo")
    private Optional<String> PREFIJO_FACTURAS;

    private FacturaModel toModel(FacturaEntity facturaEntity) {
        EstadoComprobantePago estado = facturaEntity.getEstado();
        switch (estado) {
            case BLOQUEADO:
                return new ReadOnlyFacturaAdapter(em, facturaEntity);
            default:
                return new FacturaAdapter(em, facturaEntity);
        }
    }

    private AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organization, Optional<String> optionalSerie) {
        Optional<FacturaEntity> ultimoComprobante;
        if (!optionalSerie.isPresent()) {
            TypedQuery<FacturaEntity> query1 = em.createNamedQuery("getFacturasEmpezandoPorLasMasRecientes", FacturaEntity.class);
            query1.setParameter("organizationId", organization.getId());
            query1.setMaxResults(1);
            List<FacturaEntity> resultList = query1.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        } else {
            TypedQuery<FacturaEntity> query1 = em.createNamedQuery("getFacturasConSerieEmpezandoPorLasMasRecientes", FacturaEntity.class);
            query1.setParameter("organizationId", organization.getId());
            query1.setParameter("serie", optionalSerie.get());
            query1.setMaxResults(1);
            List<FacturaEntity> resultList = query1.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        }

        if (ultimoComprobante.isPresent()) {
            FacturaEntity entity = ultimoComprobante.get();
            String ultimaSerie = entity.getSerie();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<FacturaEntity> query2 = em.createNamedQuery("GetFacturaPorSerieYNumero", FacturaEntity.class);
                    query2.setParameter("organizationId", organization);
                    query2.setParameter("serie", ultimaSerie);
                    query2.setParameter("numero", siguienteNumero);
                    query2.setMaxResults(1);
                    List<FacturaEntity> resultList = query2.getResultList();
                    if (!resultList.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(ultimaSerie, siguienteNumero);
            } else {
                String nuevaSerie = SUNATUtils.incrementarSerie(ultimaSerie);
                return siguienteSerieNumero(organization, Optional.of(nuevaSerie));
            }
        } else {
            String serie;
            if (optionalSerie.isPresent()) {
                serie = optionalSerie.get();
            } else {
                serie = TipoInvoice.FACTURA.getPrefijo() + PREFIJO_FACTURAS.orElse("") + 1;
            }
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

    @Override
    public synchronized FacturaModel createFactura(OrganizationModel organization) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, Optional.empty());
        return createFactura(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organization, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, Optional.of(serie));
        return createFactura(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie, int numero) {
        FacturaEntity entity = new FacturaEntity();
        entity.setId(ModelUtils.generateId());
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setEstado(EstadoComprobantePago.DESBLOQUEADO);
        entity.setCreatedAt(Calendar.getInstance().getTime());
        entity.setOrganization(OrganizationAdapter.toEntity(organizacion, em));

        em.persist(entity);
        em.flush();
        return toModel(entity);
    }

    @Override
    public Optional<FacturaModel> getFactura(OrganizationModel organization, String id) {
        TypedQuery<FacturaEntity> q = em.createNamedQuery("GetFacturaPorId", FacturaEntity.class);
        q.setParameter("organizationId", organization);
        q.setParameter("facturaId", id);
        List<FacturaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public boolean remove(FacturaModel factura) {
        if (factura.getEstado().equals(EstadoComprobantePago.BLOQUEADO)) return false;
        em.createNamedQuery("DeleteFactura").setParameter("facturaId", factura.getId()).executeUpdate();
        em.flush();
        return true;
    }

}
