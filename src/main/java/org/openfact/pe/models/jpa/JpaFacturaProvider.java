package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.ErrorType;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
import org.openfact.pe.models.jpa.entities.FacturaEntity;
import org.openfact.pe.models.jpa.entities.ValidacionEntity;
import org.openfact.pe.models.types.TipoInvoice;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaFacturaProvider extends JpaAbstractInvoiceProvider implements FacturaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.facturas.prefijo")
    private Optional<String> PREFIJO_FACTURAS;

    private FacturaModel toModel(FacturaEntity facturaEntity) {
        return new FacturaAdapter(em, facturaEntity);
    }

    @Override
    protected String getPrefijo() {
        return TipoInvoice.FACTURA.getPrefijo() + PREFIJO_FACTURAS.orElse("");
    }

    @Override
    public synchronized FacturaModel createFactura(OrganizationModel organization) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, FacturaEntity.class, Optional.empty());
        return createFactura(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organization, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, FacturaEntity.class, Optional.of(serie));
        return createFactura(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        ValidacionEntity validacionEntity = new ValidacionEntity();
        validacionEntity.setId(ModelUtils.generateId());
        validacionEntity.setEstado(false);
        validacionEntity.setError(ErrorType.esperando_procesar);
        validacionEntity.setErrorDescripcion("Esperando procesar");

        FacturaEntity facturaEntity = new FacturaEntity();
        facturaEntity.setId(ModelUtils.generateId());
        facturaEntity.setSerie(serie);
        facturaEntity.setNumero(numero);
        facturaEntity.setEstado(EstadoComprobantePago.ABIERTO);
        facturaEntity.setCreatedAt(Calendar.getInstance().getTime());
        facturaEntity.setOrganization(OrganizationAdapter.toEntity(organizacion, em));

        facturaEntity.setDatosVenta(datosVentaEntity);
        facturaEntity.setValidacion(validacionEntity);

        em.persist(datosVentaEntity);
        em.persist(validacionEntity);
        em.persist(facturaEntity);
        em.flush();
        return toModel(facturaEntity);
    }

    @Override
    public Optional<FacturaModel> getFactura(String id) {
        FacturaEntity entity = em.find(FacturaEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(new FacturaAdapter(em, entity));
    }

    @Override
    public Optional<FacturaModel> getFactura(String id, OrganizationModel organization) {
        return getFactura(id, organization.getId());
    }

    @Override
    public Optional<FacturaModel> getFactura(String id, String organizationId) {
        TypedQuery<FacturaEntity> q = em.createNamedQuery("getFacturasPorId", FacturaEntity.class);
        q.setParameter("organizationId", organizationId);
        q.setParameter("facturaId", id);
        List<FacturaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public Optional<FacturaModel> getFacturaBySerieYNumero(String serie, int numero, OrganizationModel organization) {
        TypedQuery<FacturaEntity> q = em.createNamedQuery("getFacturasPorSerieYNumero", FacturaEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("serie", serie);
        q.setParameter("numero", numero);
        List<FacturaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<FacturaModel> getFacturas(String organizationId, EstadoComprobantePago estado) {
        return getFacturas(organizationId, estado, -1, -1);
    }

    @Override
    public List<FacturaModel> getFacturas(String organizationId, EstadoComprobantePago estado, int offset, int limit) {
        EntityGraph<?> graph = em.getEntityGraph("graph.ListFacturas");
        TypedQuery<FacturaEntity> query = em.createNamedQuery("getDistinctFacturasPorEstado", FacturaEntity.class);
        query.setParameter("organizationId", organizationId);
        query.setParameter("estado", estado);
        query.setHint("javax.persistence.fetchgraph", graph);
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
    public List<FacturaModel> getFacturas(OrganizationModel organization, EstadoComprobantePago estado) {
        return getFacturas(organization.getId(), estado);
    }

    @Override
    public List<FacturaModel> getFacturas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit) {
        return getFacturas(organization.getId(), estado, offset, limit);
    }

    @Override
    public long getTotalFacturasPorEstado(OrganizationModel organization, EstadoComprobantePago estado) {
        return getTotalPorEstado(organization.getId(), FacturaEntity.class, estado);
    }

    @Override
    public long getTotalFacturasPorEstado(String organizationId, EstadoComprobantePago estado) {
        return getTotalPorEstado(organizationId, FacturaEntity.class, estado);
    }

}
