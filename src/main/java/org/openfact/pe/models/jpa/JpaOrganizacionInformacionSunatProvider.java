package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.OrganizationInformacionSunatProvider;
import org.openfact.pe.models.jpa.entities.OrganizacionInformacionSunatEntity;

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
public class JpaOrganizacionInformacionSunatProvider implements OrganizationInformacionSunatProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSUNAT(String id) {
        OrganizationEntity companyEntity = em.find(OrganizationEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.InformacionSUNATOrganizacion");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        OrganizacionInformacionSunatEntity additionalInfoEntity = em.find(OrganizacionInformacionSunatEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            OrganizacionInformacionSunatEntity newAdditionalInfo = new OrganizacionInformacionSunatEntity();
            newAdditionalInfo.setOrganizacion(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new OrganizacionInformacionSunatAdapter(em, additionalInfoEntity));
    }

    @Override
    public Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSunat(OrganizationModel organization) {
        return getOrganizacionInformacionSUNAT(organization.getId());
    }
}
