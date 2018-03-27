package org.openfact.models.jpa;

import org.openfact.models.*;
import org.openfact.models.jpa.entities.CompanyEntity;
import org.openfact.models.jpa.entities.PE_CompanyAdditionalInfoEntity;
import org.openfact.models.utils.ModelUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class PEJpaCompanyProvider implements PECompanyProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<PECompanyModel> getCompany(String id) {
        CompanyEntity companyEntity = em.find(CompanyEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.PEAdditionalInfoCompany");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        PE_CompanyAdditionalInfoEntity additionalInfoEntity = em.find(PE_CompanyAdditionalInfoEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            PE_CompanyAdditionalInfoEntity newAdditionalInfo = new PE_CompanyAdditionalInfoEntity();
            newAdditionalInfo.setCompany(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new PECompanyAdapter(em, additionalInfoEntity));
    }

}
