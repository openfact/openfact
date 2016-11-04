/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
@Table(name = "PERCEPTION_ATTRIBUTE")
@NamedQueries({
		@NamedQuery(name = "getPerceptionAttributesByNameAndValue", query = "select attr from PerceptionAttributeEntity attr where attr.name = :name and attr.value = :value"),
		@NamedQuery(name = "deletePerceptionAttributesByOrganization", query = "delete from  PerceptionAttributeEntity attr where attr.perception IN (select u from PerceptionEntity u where u.organization.id=:organizationId)"),
		@NamedQuery(name = "deletePerceptionAttributesByNameAndPerception", query = "delete from  PerceptionAttributeEntity attr where attr.perception.id = :perceptionId and attr.name = :name"),
		@NamedQuery(name = "deletePerceptionAttributesOtherThan", query = "delete from  PerceptionAttributeEntity attr where attr.perception.id = :perceptionId and attr.id <> :attrId") })
public class PerceptionAttributeEntity {
	@Id
	@Column(name = "ID", length = 36)
	@Access(AccessType.PROPERTY)
	protected String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	protected PerceptionEntity perception;

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

	public PerceptionEntity getPerception() {
		return perception;
	}

	public void setPerception(PerceptionEntity perception) {
		this.perception = perception;
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
		if (!(o instanceof PerceptionAttributeEntity))
			return false;

		PerceptionAttributeEntity that = (PerceptionAttributeEntity) o;

		if (!id.equals(that.getId()))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}