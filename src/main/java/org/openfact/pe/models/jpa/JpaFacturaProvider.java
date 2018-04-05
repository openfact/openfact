package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.jpa.entities.BoletaEntity;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaFacturaProvider implements FacturaProvider {

    @PersistenceContext
    private EntityManager em;

    private FacturaModel toModel(FacturaEntity facturaEntity) {
        EstadoComprobantePago estado = facturaEntity.getEstado();
        switch (estado) {
            case BLOQUEADO:
                return new ReadOnlyFacturaAdapter(em, facturaEntity);
            default:
                return new FacturaAdapter(em, facturaEntity);
        }
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion) {
        return null;
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie) {
        return null;
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie, int numero) {
        FacturaEntity entity = new FacturaEntity();
        entity.setId(ModelUtils.generateId());
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setEstado(EstadoComprobantePago.DESBLOQUEADO);
        entity.setCreatedAt(Calendar.getInstance().getTime());
        entity.setOrganizacion(OrganizationAdapter.toEntity(organizacion, em));

        em.persist(entity);
        em.flush();
        return toModel(entity);
    }

    @Override
    public Optional<FacturaModel> getBoletaFactura(OrganizationModel organizacion, String id) {
        TypedQuery<FacturaEntity> q = em.createNamedQuery("GetFacturaByOrganizationIdAndFacturaId", FacturaEntity.class);
        q.setParameter("organizacionId", organizacion);
        q.setParameter("facturaId", id);
        List<FacturaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public boolean remove(OrganizationModel organizacion, FacturaModel factura) {
        if (factura.getEstado().equals(EstadoComprobantePago.BLOQUEADO)) return false;
        return false;
    }

}
