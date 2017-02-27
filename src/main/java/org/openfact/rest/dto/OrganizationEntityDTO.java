package org.openfact.rest.dto;

import java.io.Serializable;
import org.openfact.model.entities.OrganizationEntity;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrganizationEntityDTO implements Serializable {

	private Long id;
	private int version;

	public OrganizationEntityDTO() {
	}

	public OrganizationEntityDTO(final OrganizationEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.version = entity.getVersion();
		}
	}

	public OrganizationEntity fromDTO(OrganizationEntity entity,
			EntityManager em) {
		if (entity == null) {
			entity = new OrganizationEntity();
		}
		entity.setVersion(this.version);
		entity = em.merge(entity);
		return entity;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}
}