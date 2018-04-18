package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.entities.OrganizationEntity;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.OrganizationInformacionSunatProvider;
import org.openfact.pe.models.jpa.entities.OrganizacionInformacionSUNATEntity;

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
public class JpaOrganizacionInformacionSUNATProvider implements OrganizationInformacionSunatProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSUNAT(String id) {
        OrganizationEntity companyEntity = em.find(OrganizationEntity.class, id);
        if (companyEntity == null) return Optional.empty();

        EntityGraph<?> graph = em.getEntityGraph("graph.InformacionSUNATOrganizacion");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        OrganizacionInformacionSUNATEntity additionalInfoEntity = em.find(OrganizacionInformacionSUNATEntity.class, id, hints);
        if (additionalInfoEntity == null) {
            OrganizacionInformacionSUNATEntity newAdditionalInfo = new OrganizacionInformacionSUNATEntity();
            newAdditionalInfo.setOrganizacion(companyEntity);
            em.persist(newAdditionalInfo);

            additionalInfoEntity = newAdditionalInfo;
        }

        return Optional.of(new OrganizacionInformacionSUNATAdapter(em, additionalInfoEntity));
    }

    @Override
    public Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSUNAT(OrganizationModel organization) {
        return getOrganizacionInformacionSUNAT(organization.getId());
    }
}
