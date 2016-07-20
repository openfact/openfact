package org.openfact.models.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.RepeidSession;
import org.openfact.models.jpa.entities.OrganizationEntity;

public class JpaOrganizationProvider implements OrganizationProvider {

	protected static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);
	private final RepeidSession session;
	protected EntityManager em;

	public JpaOrganizationProvider(RepeidSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public MigrationModel getMigrationModel() {
		return new MigrationModelAdapter(em);
	}

	@Override
	public OrganizationModel createOrganization(String name) {
		return createOrganization(null, name);
	}

	@Override
	public OrganizationModel createOrganization(String id, String name) {
		OrganizationEntity organization = new OrganizationEntity();
		organization.setName(name);
		organization.setId(id);
		em.persist(organization);
		em.flush();
		final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
		session.getRepeidSessionFactory().publish(new OrganizationModel.OrganizationCreationEvent() {
			@Override
			public OrganizationModel getCreatedOrganization() {
				return adapter;
			}
		});
		return adapter;
	}

	@Override
	public OrganizationModel getOrganization(String id) {
		OrganizationEntity organization = em.find(OrganizationEntity.class, id);
		if (organization == null)
			return null;
		OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
		return adapter;
	}

	@Override
	public OrganizationModel getOrganizationByName(String name) {
		TypedQuery<String> query = em.createNamedQuery("getOrganizationIdByName", String.class);
		query.setParameter("name", name);
		List<String> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		if (entities.size() > 1)
			throw new IllegalStateException("Should not be more than one organization with same name");
		String id = query.getResultList().get(0);

		return session.organizations().getOrganization(id);
	}

	@Override
	public boolean removeOrganization(String id) {
		return false;
	}

	@Override
	public List<OrganizationModel> getOrganizations() {
		TypedQuery<String> query = em.createNamedQuery("getAllOrganizationIds", String.class);
		List<String> entities = query.getResultList();
		List<OrganizationModel> organizations = new ArrayList<>();
		for (String id : entities) {
			OrganizationModel organization = session.organizations().getOrganization(id);
			if (organization != null)
				organizations.add(organization);
		}
		return organizations;
	}

}
