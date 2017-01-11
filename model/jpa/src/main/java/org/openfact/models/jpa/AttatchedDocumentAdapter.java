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
package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.AttatchedDocumentModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.AttatchedDocumentAttributeEntity;
import org.openfact.models.jpa.entities.AttatchedDocumentEntity;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AttatchedDocumentAdapter implements AttatchedDocumentModel, JpaModel<AttatchedDocumentEntity> {

	protected static final Logger logger = Logger.getLogger(AttatchedDocumentAdapter.class);
	protected OrganizationModel organization;
	protected AttatchedDocumentEntity attatchedDocument;
	protected EntityManager em;
	protected OpenfactSession session;

	public AttatchedDocumentAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, AttatchedDocumentEntity attatchedDocument) {
		this.session = session;
		this.em = em;
		this.organization = organization;
		this.attatchedDocument = attatchedDocument;
	}

	public static AttatchedDocumentEntity toEntity(AttatchedDocumentModel model, EntityManager em) {
		if (model instanceof AttatchedDocumentAdapter) {
			return ((AttatchedDocumentAdapter) model).getEntity();
		}
		return em.getReference(AttatchedDocumentEntity.class, model.getId());
	}

	@Override
	public AttatchedDocumentEntity getEntity() {
		return attatchedDocument;
	}

	@Override
	public String getId() {
		return attatchedDocument.getId();
	}

	@Override
	public DocumentType getDocumentType() {
		return attatchedDocument.getDocumentType();
	}

	@Override
	public String getDocumentId() {
		return attatchedDocument.getDocumentId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<AttatchedDocumentAttributeEntity> toRemove = new ArrayList<>();
		for (AttatchedDocumentAttributeEntity attr : attatchedDocument.getAttributes()) {
			if (attr.getName().equals(name)) {
				if (firstExistingAttrId == null) {
					attr.setValue(value);
					firstExistingAttrId = attr.getId();
				} else {
					toRemove.add(attr);
				}
			}
		}

		if (firstExistingAttrId != null) {
			// Remove attributes through HQL to avoid StaleUpdateException
			Query query = em.createNamedQuery("deleteAttatchedDocumentAttributesByNameAndAttatchedDocumentOtherThan");
			query.setParameter("name", name);
			query.setParameter("attatchedDocumentId", attatchedDocument.getId());
			query.setParameter("attrId", firstExistingAttrId);
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			attatchedDocument.getAttributes().removeAll(toRemove);
		} else {

			persistAttributeValue(name, value);
		}
	}

	@Override
	public void setAttribute(String name, List<String> values) {
		// Remove all existing
		removeAttribute(name);

		// Put all new
		for (String value : values) {
			persistAttributeValue(name, value);
		}
	}

	private void persistAttributeValue(String name, String value) {
		AttatchedDocumentAttributeEntity attr = new AttatchedDocumentAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setAttatchedDocument(attatchedDocument);
		em.persist(attr);
		attatchedDocument.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// Remove attribute through HQL to avoid StaleUpdateException
		Query query = em.createNamedQuery("deleteAttatchedDocumentAttributesByNameAndAttatchedDocument");
		query.setParameter("name", name);
		query.setParameter("attatchedDocumentId", attatchedDocument.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local user entity
		List<AttatchedDocumentAttributeEntity> toRemove = new ArrayList<>();
		for (AttatchedDocumentAttributeEntity attr : attatchedDocument.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		attatchedDocument.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (AttatchedDocumentAttributeEntity attr : attatchedDocument.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (AttatchedDocumentAttributeEntity attr : attatchedDocument.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (AttatchedDocumentAttributeEntity attr : attatchedDocument.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || !(o instanceof AttatchedDocumentModel)) return false;

		AttatchedDocumentModel that = (AttatchedDocumentModel) o;
		return that.getId().equals(getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}
