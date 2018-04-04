package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaFacturaPEModel;
import org.openfact.pe.models.BoletaFacturaPEProvider;
import org.openfact.pe.models.jpa.entities.BoletaFacturaPEEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class JpaBoletaFacturaPEProvider implements BoletaFacturaPEProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BoletaFacturaPEModel addBoletaFactura(OrganizationModel organizacion, String idAsignado) {
        BoletaFacturaPEEntity entity = new BoletaFacturaPEEntity();
        entity.setId(ModelUtils.generateId());
        entity.setIdAsignado(idAsignado);
        entity.setOrganizacion(OrganizationAdapter.toEntity(organizacion, em));
        em.persist(entity);

        return new BoletaFacturaPEAdapter(em, entity);
    }

}
