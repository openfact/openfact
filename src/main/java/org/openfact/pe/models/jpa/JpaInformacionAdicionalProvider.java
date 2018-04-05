package org.openfact.pe.models.jpa;

import org.openfact.core.models.jpa.entities.OrganizacionEntity;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.InformacionAdicionalProvider;
import org.openfact.pe.models.jpa.entities.InformacionAdicionalEntity;

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
    public Optional<InformacionAdicionalModel> getOrganizacionInformacionAdicional(String id) {
        OrganizacionEntity companyEntity = em.find(OrganizacionEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.InformacionAdicionalOrganizacion");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        InformacionAdicionalEntity additionalInfoEntity = em.find(InformacionAdicionalEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            InformacionAdicionalEntity newAdditionalInfo = new InformacionAdicionalEntity();
            newAdditionalInfo.setOrganizacion(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new InformacionAdicionalAdapter(em, additionalInfoEntity));
    }

}
