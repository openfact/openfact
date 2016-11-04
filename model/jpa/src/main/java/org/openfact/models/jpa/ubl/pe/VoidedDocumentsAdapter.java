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
package org.openfact.models.jpa.ubl.pe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.VoidedDocumentsLineEntity;
import org.openfact.models.jpa.entities.ubl.pe.VoidedDocumentsAttributeEntity;
import org.openfact.models.jpa.entities.ubl.pe.VoidedDocumentsEntity;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.jpa.ubl.common.VoidedDocumentsLineAdapter;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.VoidedDocumentsLineModel;
import org.openfact.models.ubl.pe.VoidedDocumentsModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class VoidedDocumentsAdapter implements VoidedDocumentsModel, JpaModel<VoidedDocumentsEntity> {

	protected static final Logger logger = Logger.getLogger(VoidedDocumentsAdapter.class);

	protected OrganizationModel organization;
	protected VoidedDocumentsEntity voidedDocuments;
	protected EntityManager em;
	protected OpenfactSession session;

	public VoidedDocumentsAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			VoidedDocumentsEntity voidedDocuments) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.voidedDocuments = voidedDocuments;
	}

	@Override
	public VoidedDocumentsEntity getEntity() {
		return voidedDocuments;
	}

	@Override
	public String getId() {
		return voidedDocuments.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<VoidedDocumentsAttributeEntity> toRemove = new ArrayList<>();
		for (VoidedDocumentsAttributeEntity attr : voidedDocuments.getAttributes()) {
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
			Query query = em.createNamedQuery("deleteVoidedDocumentsAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("voidedDocumentsId", voidedDocuments.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			voidedDocuments.getAttributes().removeAll(toRemove);
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
		VoidedDocumentsAttributeEntity attr = new VoidedDocumentsAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setVoidedDocuments(voidedDocuments);
		em.persist(attr);
		voidedDocuments.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteVoidedDocumentsAttributesByNameAndVoidedDocuments");
		query.setParameter("name", name);
		query.setParameter("voidedDocumentsId", voidedDocuments.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local voidedDocuments entity
		List<VoidedDocumentsAttributeEntity> toRemove = new ArrayList<>();
		for (VoidedDocumentsAttributeEntity attr : voidedDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		voidedDocuments.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (VoidedDocumentsAttributeEntity attr : voidedDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (VoidedDocumentsAttributeEntity attr : voidedDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (VoidedDocumentsAttributeEntity attr : voidedDocuments.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, voidedDocuments.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		voidedDocuments.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public UBLExtensionsModel getUblExtensions() {
		return new UBLExtensionsAdapter(session, em, voidedDocuments.getUblExtensions());
	}

	@Override
	public void setUblExtensions(UBLExtensionsModel ublExtensions) {
		voidedDocuments.setUblExtensions(UBLExtensionsAdapter.toEntity(ublExtensions, em));
	}

	@Override
	public String getUblVersionID() {
		return voidedDocuments.getUblVersionID();
	}

	@Override
	public void setUblVersionID(String ublVersionID) {
		voidedDocuments.setUblVersionID(ublVersionID);
	}

	@Override
	public String getCustomizationID() {
		return voidedDocuments.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String customizationID) {
		voidedDocuments.setCustomizationID(customizationID);
	}

	@Override
	public String getID() {
		return voidedDocuments.getID();
	}

	@Override
	public void setID(String iD) {
		voidedDocuments.setID(iD);
	}

	@Override
	public LocalDateTime getReferenceDate() {
		return voidedDocuments.getReferenceDate();
	}

	@Override
	public void setReferenceDate(LocalDateTime referenceDate) {
		voidedDocuments.setReferenceDate(referenceDate);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return voidedDocuments.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		voidedDocuments.setIssueDateTime(issueDateTime);
	}

	@Override
	public List<String> getNote() {
		return voidedDocuments.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		voidedDocuments.setNote(note);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return voidedDocuments.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		voidedDocuments.setSignature(entities);
	}

	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		return new SupplierPartyAdapter(session, em, voidedDocuments.getAccountingSupplierParty());
	}

	@Override
	public void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty) {
		voidedDocuments.setAccountingSupplierParty(SupplierPartyAdapter.toEntity(accountingSupplierParty, em));
	}

	@Override
	public List<VoidedDocumentsLineModel> getVoidedDocumentsLine() {
		return voidedDocuments.getVoidedDocumentsLine().stream()
				.map(f -> new VoidedDocumentsLineAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setVoidedDocumentsLine(List<VoidedDocumentsLineModel> voidedDocumentsLine) {
		List<VoidedDocumentsLineEntity> entities = voidedDocumentsLine.stream()
				.map(f -> VoidedDocumentsLineAdapter.toEntity(f, em)).collect(Collectors.toList());
		voidedDocuments.setVoidedDocumentsLine(entities);
	}

	@Override
	public Byte[] getXmlDocument() {
		return voidedDocuments.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] xmlDocument) {
		voidedDocuments.setXmlDocument(xmlDocument);
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return voidedDocuments.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		voidedDocuments.setRequeridAction(requeridAction);
	}

	public static VoidedDocumentsEntity toEntity(VoidedDocumentsModel model, EntityManager em) {
		if (model instanceof VoidedDocumentsAdapter) {
			return ((VoidedDocumentsAdapter) model).getEntity();
		}
		return em.getReference(VoidedDocumentsEntity.class, model.getId());
	}
}
