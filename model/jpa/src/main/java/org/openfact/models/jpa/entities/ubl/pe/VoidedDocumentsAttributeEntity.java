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
@Table(name = "VOIDED_DOCUMENTS_ATTRIBUTE")
@NamedQueries({
        @NamedQuery(name = "getVoidedDocumentsAttributesByNameAndValue", query = "select attr from VoidedDocumentsAttributeEntity attr where attr.name = :name and attr.value = :value"),
        @NamedQuery(name = "deleteVoidedDocumentsAttributesByOrganization", query = "delete from  VoidedDocumentsAttributeEntity attr where attr.voidedDocuments IN (select u from VoidedDocumentsEntity u where u.organization.id=:organizationId)"),
        @NamedQuery(name = "deleteVoidedDocumentsAttributesByNameAndVoidedDocuments", query = "delete from  VoidedDocumentsAttributeEntity attr where attr.voidedDocuments.id = :voidedDocumentsId and attr.name = :name"),
        @NamedQuery(name = "deleteVoidedDocumentsAttributesOtherThan", query = "delete from  VoidedDocumentsAttributeEntity attr where attr.voidedDocuments.id = :voidedDocumentsId and attr.id <> :attrId") })
public class VoidedDocumentsAttributeEntity {
    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected VoidedDocumentsEntity voidedDocuments;

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

	public VoidedDocumentsEntity getVoidedDocuments() {
		return voidedDocuments;
	}

	public void setVoidedDocuments(VoidedDocumentsEntity voidedDocuments) {
		this.voidedDocuments = voidedDocuments;
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
	        if (!(o instanceof VoidedDocumentsAttributeEntity))
	            return false;

	        VoidedDocumentsAttributeEntity that = (VoidedDocumentsAttributeEntity) o;

	        if (!id.equals(that.getId()))
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        return id.hashCode();
	    }
}
