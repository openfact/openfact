package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.ErrorType;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.BoletaEntity;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
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
public class JpaBoletaProvider extends JpaAbstractInvoiceProvider implements BoletaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.boletas.prefijo")
    private Optional<String> PREFIJO_BOLETAS;

    private BoletaModel toModel(BoletaEntity boletaEntity) {
        return new BoletaAdapter(em, boletaEntity);
    }

    @Override
    protected String getPrefijo() {
        return TipoInvoice.BOLETA.getPrefijo() + PREFIJO_BOLETAS.orElse("");
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organization) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, BoletaEntity.class, Optional.empty());
        return createBoleta(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organization, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, BoletaEntity.class, Optional.of(serie));
        return createBoleta(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public BoletaModel createBoleta(OrganizationModel organization, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        ValidacionEntity validacionEntity = new ValidacionEntity();
        validacionEntity.setId(ModelUtils.generateId());
        validacionEntity.setEstado(false);
        validacionEntity.setError(ErrorType.esperando_procesar);
        validacionEntity.setErrorDescripcion("Esperando procesar");

        BoletaEntity boletaEntity = new BoletaEntity();
        boletaEntity.setId(ModelUtils.generateId());
        boletaEntity.setSerie(serie);
        boletaEntity.setNumero(numero);
        boletaEntity.setEstado(EstadoComprobantePago.ABIERTO);
        boletaEntity.setCreatedAt(Calendar.getInstance().getTime());
        boletaEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        boletaEntity.setDatosVenta(datosVentaEntity);
        boletaEntity.setValidacion(validacionEntity);

        em.persist(datosVentaEntity);
        em.persist(validacionEntity);
        em.persist(boletaEntity);
        em.flush();
        return toModel(boletaEntity);
    }

    @Override
    public Optional<BoletaModel> getBoleta(String id) {
        BoletaEntity entity = em.find(BoletaEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(toModel(entity));
    }

    @Override
    public Optional<BoletaModel> getBoleta(String id, String organizationId) {
        TypedQuery<BoletaEntity> q = em.createNamedQuery("getBoletasPorId", BoletaEntity.class);
        q.setParameter("organizationId", organizationId);
        q.setParameter("boletaId", id);
        List<BoletaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public Optional<BoletaModel> getBoleta(String id, OrganizationModel organization) {
        return getBoleta(id, organization.getId());
    }

    @Override
    public Optional<BoletaModel> getBoletaBySerieYNumero(String serie, int numero, OrganizationModel organization) {
        TypedQuery<BoletaEntity> q = em.createNamedQuery("getBoletasPorSerieYNumero", BoletaEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("serie", serie);
        q.setParameter("numero", numero);
        List<BoletaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<BoletaModel> getBoletas(String organizationId, EstadoComprobantePago estado) {
        return getBoletas(organizationId, estado, -1, -1);
    }

    @Override
    public List<BoletaModel> getBoletas(String organizationId, EstadoComprobantePago estado, int offset, int limit) {
        EntityGraph<?> graph = em.getEntityGraph("graph.ListBoletas");
        TypedQuery<BoletaEntity> query = em.createNamedQuery("getDistinctBoletasPorEstado", BoletaEntity.class);
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
    public List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado) {
        return getBoletas(organization.getId(), estado);
    }

    @Override
    public List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit) {
        return getBoletas(organization.getId(), estado, offset, limit);
    }

    @Override
    public long getTotalBoletasPorEstado(OrganizationModel organization, EstadoComprobantePago estado) {
        return getTotalPorEstado(organization.getId(), BoletaEntity.class, estado);
    }

    @Override
    public long getTotalBoletasPorEstado(String organizationId, EstadoComprobantePago estado) {
        return getTotalPorEstado(organizationId, BoletaEntity.class, estado);
    }

}
