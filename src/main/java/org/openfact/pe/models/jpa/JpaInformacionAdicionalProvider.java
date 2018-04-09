package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.InformacionAdicionalProvider;
import org.openfact.pe.models.jpa.entities.OrganizacionInformacionAdicionalEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaInformacionAdicionalProvider implements InformacionAdicionalProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(String id) {
        OrganizationEntity companyEntity = em.find(OrganizationEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.InformacionAdicionalOrganizacion");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        OrganizacionInformacionAdicionalEntity additionalInfoEntity = em.find(OrganizacionInformacionAdicionalEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            OrganizacionInformacionAdicionalEntity newAdditionalInfo = new OrganizacionInformacionAdicionalEntity();
            newAdditionalInfo.setOrganizacion(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new OrganizacionInformacionAdicionalAdapter(em, additionalInfoEntity));
    }

    @Override
    public Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(OrganizationModel organization) {
        return getOrganizacionInformacionAdicional(organization.getId());
    }

}
