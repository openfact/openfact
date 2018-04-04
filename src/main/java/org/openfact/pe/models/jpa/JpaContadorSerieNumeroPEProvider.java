package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.ContadorSerieNumeroPEModel;
import org.openfact.pe.models.ContadorSerieNumeroPEProvider;
import org.openfact.pe.models.jpa.entities.ContadorSerieNumeroPEEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaContadorSerieNumeroPEProvider implements ContadorSerieNumeroPEProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ContadorSerieNumeroPEModel getNext(OrganizationModel organization, String tipoDocumento) {
        return getNext(organization, tipoDocumento);
    }

    @Override
    public ContadorSerieNumeroPEModel getNext(OrganizationModel organization, String tipoDocumento, String serie) {
        return null;
    }

    @Override
    public ContadorSerieNumeroPEModel getNextAndBlock(OrganizationModel organization, String tipoDocumento) {
        return null;
    }

    @Override
    public ContadorSerieNumeroPEModel getNextAndBlock(OrganizationModel organization, String tipoDocumento, String serie) {
        return null;
    }

    @Override
    public Optional<ContadorSerieNumeroPEModel> getCurrent(OrganizationModel organization, String tipoDocumento) {
        TypedQuery<ContadorSerieNumeroPEEntity> q = em.createNamedQuery("getContadorSerieNumeroByOrganizacionIdAndTipoDocumento", ContadorSerieNumeroPEEntity.class);
        q.setParameter("organizacionId", organization.getId());
        q.setParameter("tipoDocumento", tipoDocumento);
        List<ContadorSerieNumeroPEEntity> resultList = q.getResultList();
        if (resultList.size() == 1) {
            return Optional.of(new ContadorSerieNumeroPEAdapter(em, resultList.get(0)));
        } else if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Más de un resultado para la empresa, serie, numero");
        }
    }

    @Override
    public Optional<ContadorSerieNumeroPEModel> getCurrent(OrganizationModel organization, String tipoDocumento, String serie) {
        return null;
    }

}
