package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
import org.openfact.pe.models.jpa.entities.NotaCreditoEntity;
import org.openfact.pe.models.jpa.entities.ValidacionEntity;
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
public class JpaNotaCreditoProvider extends JpaAbstractNotaProvider implements NotaCreditoProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.notas_credito.prefijo")
    private Optional<String> PREFIJO_NOTAS_CREDITO;

    private NotaCreditoModel toModel(NotaCreditoEntity notaCreditoEntity) {
        return new NotaCreditoAdapter(em, notaCreditoEntity);
    }

    @Override
    protected String getPrefijo(InvoiceModel invoice) {
        return invoice.getSerie().substring(0, 1) + PREFIJO_NOTAS_CREDITO.orElse("");
    }

    @Override
    public NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, NotaCreditoEntity.class, invoice, Optional.empty());
        return createNotaCredito(organization, invoice, tipoNota, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, NotaCreditoEntity.class, invoice, Optional.of(serie));
        return createNotaCredito(organization, invoice, tipoNota, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        ValidacionEntity validacionEntity = new ValidacionEntity();
        validacionEntity.setId(ModelUtils.generateId());
        validacionEntity.setEstado(false);
        validacionEntity.setError(ErrorType.esperando_procesar);
        validacionEntity.setErrorDescripcion("Esperando procesar");

        NotaCreditoEntity notaCreditoEntity = new NotaCreditoEntity();
        notaCreditoEntity.setId(ModelUtils.generateId());
        notaCreditoEntity.setSerie(serie);
        notaCreditoEntity.setNumero(numero);
        notaCreditoEntity.setTipoNota(tipoNota);
        notaCreditoEntity.setEstado(EstadoComprobantePago.ABIERTO);
        notaCreditoEntity.setCreatedAt(Calendar.getInstance().getTime());
        notaCreditoEntity.setDocumentoAsociado(AbstractInvoiceAdapter.toEntity(invoice, em));
        notaCreditoEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        notaCreditoEntity.setDatosVenta(datosVentaEntity);
        notaCreditoEntity.setValidacion(validacionEntity);

        em.persist(datosVentaEntity);
        em.persist(validacionEntity);
        em.persist(notaCreditoEntity);
        em.flush();
        return toModel(notaCreditoEntity);
    }

    @Override
    public Optional<NotaCreditoModel> getNotaCredito(String id) {
        NotaCreditoEntity entity = em.find(NotaCreditoEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(new NotaCreditoAdapter(em, entity));
    }

    @Override
    public Optional<NotaCreditoModel> getNotaCredito(String id, OrganizationModel organization) {
        return getNotaCredito(id, organization.getId());
    }

    @Override
    public Optional<NotaCreditoModel> getNotaCredito(String id, String organizationId) {
        TypedQuery<NotaCreditoEntity> q = em.createNamedQuery("getNotaCreditoPorId", NotaCreditoEntity.class);
        q.setParameter("organizationId", organizationId);
        q.setParameter("notaCreditoId", id);
        List<NotaCreditoEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<NotaCreditoModel> getNotasCredito(String organizationId, EstadoComprobantePago estado) {
        return getNotasCredito(organizationId, estado, -1, -1);
    }

    @Override
    public List<NotaCreditoModel> getNotasCredito(String organizationId, EstadoComprobantePago estado, int offset, int limit) {
        EntityGraph<?> graph = em.getEntityGraph("graph.ListNotasCredito");
        TypedQuery<NotaCreditoEntity> query = em.createNamedQuery("getDistinctNotasCreditoPorEstado", NotaCreditoEntity.class);
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
    public List<NotaCreditoModel> getNotasCredito(OrganizationModel organization, EstadoComprobantePago estado) {
        return getNotasCredito(organization.getId(), estado);
    }

    @Override
    public List<NotaCreditoModel> getNotasCredito(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit) {
        return getNotasCredito(organization.getId(), estado, -1, -1);
    }

    @Override
    public long getTotalNotasCreditoPorEstado(OrganizationModel organization, EstadoComprobantePago estado) {
        return getTotalPorEstado(organization, NotaCreditoEntity.class, estado);
    }

}
