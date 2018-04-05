package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaFacturaModel;
import org.openfact.pe.models.BoletaFacturaProvider;
import org.openfact.pe.models.jpa.entities.BoletaFacturaEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class JpaBoletaFacturaProvider implements BoletaFacturaProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BoletaFacturaModel addBoletaFactura(OrganizationModel organizacion, String idAsignado) {
        BoletaFacturaEntity entity = new BoletaFacturaEntity();
        entity.setId(ModelUtils.generateId());
        entity.setIdAsignado(idAsignado);
        entity.setOrganizacion(OrganizationAdapter.toEntity(organizacion, em));
        em.persist(entity);

        return new BoletaFacturaAdapter(em, entity);
    }

}
