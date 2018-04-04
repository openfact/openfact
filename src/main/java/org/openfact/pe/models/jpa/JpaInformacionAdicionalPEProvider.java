package org.openfact.pe.models.jpa;

import org.openfact.core.models.jpa.entities.OrganizacionEntity;
import org.openfact.pe.models.InformacionAdicionalPEModel;
import org.openfact.pe.models.InformacionAdicionalPEProvider;
import org.openfact.pe.models.jpa.entities.InformacionAdicionalPEEntity;

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
public class JpaInformacionAdicionalPEProvider implements InformacionAdicionalPEProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<InformacionAdicionalPEModel> getOrganizacionInformacionAdicional(String id) {
        OrganizacionEntity companyEntity = em.find(OrganizacionEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.InformacionAdicionalOrganizacion");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        InformacionAdicionalPEEntity additionalInfoEntity = em.find(InformacionAdicionalPEEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            InformacionAdicionalPEEntity newAdditionalInfo = new InformacionAdicionalPEEntity();
            newAdditionalInfo.setOrganizacion(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new InformacionAdicionalPEAdapter(em, additionalInfoEntity));
    }

}
