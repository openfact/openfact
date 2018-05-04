package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.BajaEntity;
import org.openfact.pe.models.jpa.entities.EstadoSunatEntity;
import org.openfact.pe.models.types.TipoBaja;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaBajaProvider implements BajaProvider {

    @PersistenceContext
    private EntityManager em;

    private BajaModel toModel(BajaEntity bajaEntity) {
        return new BajaAdapter(em, bajaEntity);
    }

    private EntityGraph<?> getListGraph() {
        return em.getEntityGraph("graph.ListBajas");
    }

    private String getPrefijo(OrganizationModel organization) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setTimeZone(organization.getTimeZone());

        Date currentDate = Calendar.getInstance().getTime();
        return sdf.format(currentDate);
    }

    private String formatDate(OrganizationModel organization, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setTimeZone(organization.getTimeZone());

        return sdf.format(date);
    }

    @Override
    public synchronized BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado) {
        AbstractMap.SimpleEntry<Date, Integer> serieNumero = siguienteSerieNumero(organization, Optional.empty());
        return createBaja(organization, invoiceAfectado, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public synchronized BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado, Date fechaGeneracion) {
        AbstractMap.SimpleEntry<Date, Integer> serieNumero = siguienteSerieNumero(organization, Optional.of(fechaGeneracion));
        return createBaja(organization, invoiceAfectado, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado, Date fechaGeneracionBaja, int numero) {
        EstadoSunatEntity estadoSunatEntity = new EstadoSunatEntity();
        estadoSunatEntity.setId(ModelUtils.generateId());
        estadoSunatEntity.setEstado(false);

        BajaEntity bajaEntity = new BajaEntity();
        bajaEntity.setId(ModelUtils.generateId());
        bajaEntity.setNumero(numero);
        bajaEntity.setFechaEmision(fechaGeneracionBaja);
        bajaEntity.setSerie(TipoBaja.BAJA.getPrefijo() + formatDate(organization, fechaGeneracionBaja) + "-" + numero);
        bajaEntity.setEstado(EstadoComprobantePago.ABIERTO);
        bajaEntity.setInvoice(InvoiceAdapter.toEntity(invoiceAfectado, em));

        bajaEntity.setEstadoSunat(estadoSunatEntity);

        em.persist(estadoSunatEntity);
        em.persist(bajaEntity);
        em.flush();
        return toModel(bajaEntity);
    }

    @Override
    public Optional<BajaModel> getBaja(String id) {
        BajaEntity entity = em.find(BajaEntity.class, id);
        if (entity == null) return Optional.empty();
        return Optional.of(toModel(entity));
    }

    @Override
    public Optional<BajaModel> getBaja(OrganizationModel organization, String id) {
        TypedQuery<BajaEntity> q = em.createNamedQuery("getBajasPorId", BajaEntity.class);
        q.setParameter("organizationId", organization.getId());
        q.setParameter("bajaId", id);
        List<BajaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<BajaModel> buscarBajas(OrganizationModel organization, String filterText) {
        return buscarBajas(organization, filterText, -1, -1);
    }

    @Override
    public List<BajaModel> buscarBajas(OrganizationModel organization, String filterText, int offset, int limit) {
        TypedQuery<BajaEntity> query = em.createNamedQuery("filterDistinctBajas", BajaEntity.class);
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
    public long getBajasCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("countBajas");
        query.setParameter("organizationId", organization.getId());
        return ((Long) query.getSingleResult());
    }

    private AbstractMap.SimpleEntry<Date, Integer> siguienteSerieNumero(OrganizationModel organization, Optional<Date> optionalDate) {
        Date fechaGeneracionBaja = optionalDate.orElse(Calendar.getInstance().getTime());

        TypedQuery<BajaEntity> query = em.createNamedQuery("getBajasEmpezandoPorLasMasRecientes", BajaEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("fechaGeneracionBaja", fechaGeneracionBaja, TemporalType.DATE);
        query.setMaxResults(1);
        List<BajaEntity> resultList = query.getResultList();
        Optional<BajaEntity> ultimoComprobante = JpaUtils.getFirstResult(resultList);

        if (ultimoComprobante.isPresent()) {
            BajaEntity entity = ultimoComprobante.get();
            Date ultimaGeneracionBaja = entity.getFechaEmision();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            return new AbstractMap.SimpleEntry<>(ultimaGeneracionBaja, siguienteNumero);
        } else {
            return new AbstractMap.SimpleEntry<>(Calendar.getInstance().getTime(), 1);
        }
    }

}
