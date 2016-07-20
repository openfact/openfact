package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.models.RepeidSession;
import org.openfact.models.jpa.entities.OrganizationEntity;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

	protected static final Logger logger = Logger.getLogger(OrganizationAdapter.class);
	protected OrganizationEntity organization;
	protected EntityManager em;
	protected RepeidSession session;

	public OrganizationAdapter(RepeidSession session, EntityManager em, OrganizationEntity organization) {
		this.session = session;
		this.em = em;
		this.organization = organization;
	}

	@Override
	public OrganizationEntity getEntity() {
		return organization;
	}

	public static OrganizationEntity toEntity(OrganizationModel model, EntityManager em) {
		if (model instanceof OrganizationAdapter) {
			return ((OrganizationAdapter)model).getEntity();
		}
		return em.getReference(OrganizationEntity.class, model.getId());
	}

	@Override
	public String getId() {
		return organization.getId();
	}

	@Override
	public String getName() {
		return organization.getName();
	}

	@Override
	public void setName(String name) {
		organization.setName(name);
		em.flush();
	}

	@Override
	public boolean isEnabled() {
		return organization.isEnabled();
	}

	@Override
	public void setEnabled(boolean enabled) {
		organization.setEnabled(enabled);
	}	

}
