package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;
import org.openfact.pe.models.jpa.entities.NotaDebitoEntity;
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
public class JpaNotaDebitoProvider extends JpaAbstractNotaProvider implements NotaDebitoProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.notas_debito.prefijo")
    private Optional<String> PREFIJO_NOTAS_DEBITO;

    private NotaDebitoModel toModel(NotaDebitoEntity notaDebitoEntity) {
        return new NotaDebitoAdapter(em, notaDebitoEntity);
    }

    @Override
    protected String getPrefijo(InvoiceModel invoice) {
        return invoice.getSerie().substring(0, 1) + PREFIJO_NOTAS_DEBITO.orElse("");
    }

    @Override
    public NotaDebitoModel createNotaDebito(OrganizationModel organization, InvoiceModel invoice, String tipoNota) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, NotaDebitoEntity.class, invoice, Optional.empty());
        return createNotaDebito(organization, invoice, tipoNota, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaDebitoModel createNotaDebito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, NotaDebitoEntity.class, invoice, Optional.of(serie));
        return createNotaDebito(organization, invoice, tipoNota, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public NotaDebitoModel createNotaDebito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie, int numero) {
        DatosVentaEntity datosVentaEntity = new DatosVentaEntity();
        datosVentaEntity.setId(ModelUtils.generateId());

        ValidacionEntity validacionEntity = new ValidacionEntity();
        validacionEntity.setId(ModelUtils.generateId());
        validacionEntity.setEstado(false);
        validacionEntity.setError(ErrorType.esperando_procesar);
        validacionEntity.setErrorDescripcion("Esperando procesar");

        NotaDebitoEntity notaDebitoEntity = new NotaDebitoEntity();
        notaDebitoEntity.setId(ModelUtils.generateId());
        notaDebitoEntity.setSerie(serie);
        notaDebitoEntity.setNumero(numero);
        notaDebitoEntity.setTipoNota(tipoNota);
        notaDebitoEntity.setEstado(EstadoComprobantePago.ABIERTO);
        notaDebitoEntity.setCreatedAt(Calendar.getInstance().getTime());
        notaDebitoEntity.setDocumentoAsociado(AbstractInvoiceAdapter.toEntity(invoice, em));
        notaDebitoEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        notaDebitoEntity.setDatosVenta(datosVentaEntity);
        notaDebitoEntity.setValidacion(validacionEntity);

        em.persist(datosVentaEntity);
        em.persist(validacionEntity);
        em.persist(notaDebitoEntity);
        em.flush();
        return toModel(notaDebitoEntity);
    }

    @Override
    public Optional<NotaDebitoModel> getNotaDebito(String id) {
        NotaDebitoEntity entity = em.find(NotaDebitoEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(new NotaDebitoAdapter(em, entity));
    }

    @Override
    public Optional<NotaDebitoModel> getNotaDebito(String id, OrganizationModel organization) {
        return getNotaDebito(id, organization.getId());
    }

    @Override
    public Optional<NotaDebitoModel> getNotaDebito(String id, String organizationId) {
        TypedQuery<NotaDebitoEntity> q = em.createNamedQuery("getNotaDebitoPorId", NotaDebitoEntity.class);
        q.setParameter("organizationId", organizationId);
        q.setParameter("notaDebitoId", id);
        List<NotaDebitoEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<NotaDebitoModel> getNotasDebito(String organizationId, EstadoComprobantePago estado) {
        return getNotasDebito(organizationId, estado, -1, -1);
    }

    @Override
    public List<NotaDebitoModel> getNotasDebito(String organizationId, EstadoComprobantePago estado, int offset, int limit) {
        EntityGraph<?> graph = em.getEntityGraph("graph.ListNotasCredito");
        TypedQuery<NotaDebitoEntity> query = em.createNamedQuery("getDistinctNotasDebitoPorEstado", NotaDebitoEntity.class);
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
    public List<NotaDebitoModel> getNotasDebito(OrganizationModel organization, EstadoComprobantePago estado) {
        return getNotasDebito(organization.getId(), estado);
    }

    @Override
    public List<NotaDebitoModel> getNotasDebito(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit) {
        return getNotasDebito(organization.getId(), estado, offset, limit);
    }

    @Override
    public long getTotalNotasDebitoPorEstado(OrganizationModel organization, EstadoComprobantePago estado) {
        return getTotalPorEstado(organization, NotaDebitoEntity.class, estado);
    }

}
