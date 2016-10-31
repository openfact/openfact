package org.openfact.models.jpa.entities.ubl.pe;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "RETENTION_ATTRIBUTE")
@NamedQueries({
		@NamedQuery(name = "getRetentionAttributesByNameAndValue", query = "select attr from RetentionAttributeEntity attr where attr.name = :name and attr.value = :value"),
		@NamedQuery(name = "deleteRetentionAttributesByOrganization", query = "delete from  RetentionAttributeEntity attr where attr.retention IN (select u from RetentionEntity u where u.organization.id=:organizationId)"),
		@NamedQuery(name = "deleteRetentionAttributesByNameAndRetention", query = "delete from  RetentionAttributeEntity attr where attr.retention.id = :retentionId and attr.name = :name"),
		@NamedQuery(name = "deleteRetentionAttributesOtherThan", query = "delete from  RetentionAttributeEntity attr where attr.retention.id = :retentionId and attr.id <> :attrId") })
public class RetentionAttributeEntity {
	@Id
	@Column(name = "ID", length = 36)
	@Access(AccessType.PROPERTY)
	protected String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	protected RetentionEntity retention;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "VALUE")
	protected String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RetentionEntity getRetention() {
		return retention;
	}

	public void setRetention(RetentionEntity retention) {
		this.retention = retention;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof RetentionAttributeEntity))
			return false;

		RetentionAttributeEntity that = (RetentionAttributeEntity) o;

		if (!id.equals(that.getId()))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
