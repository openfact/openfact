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

import java.math.BigDecimal;
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
import org.openfact.models.jpa.entities.ubl.common.pe.RetentionDocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.pe.RetentionAttributeEntity;
import org.openfact.models.jpa.entities.ubl.pe.RetentionEntity;
import org.openfact.models.jpa.ubl.common.PartyAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.jpa.ubl.common.pe.RetentionDocumentReferenceAdapter;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.pe.RetentionDocumentReferenceModel;
import org.openfact.models.ubl.pe.RetentionModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class RetentionAdapter implements RetentionModel, JpaModel<RetentionEntity> {

	protected static final Logger logger = Logger.getLogger(RetentionAdapter.class);

	protected OrganizationModel organization;
	protected RetentionEntity retention;
	protected EntityManager em;
	protected OpenfactSession session;

	public RetentionAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			RetentionEntity retention) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.retention = retention;
	}

	@Override
	public RetentionEntity getEntity() {
		return retention;
	}

	@Override
	public String getId() {
		return retention.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<RetentionAttributeEntity> toRemove = new ArrayList<>();
		for (RetentionAttributeEntity attr : retention.getAttributes()) {
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
			Query query = em.createNamedQuery("deleteRetentionAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("retentionId", retention.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			retention.getAttributes().removeAll(toRemove);
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
		RetentionAttributeEntity attr = new RetentionAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setRetention(retention);
		em.persist(attr);
		retention.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteRetentionAttributesByNameAndRetention");
		query.setParameter("name", name);
		query.setParameter("retentionId", retention.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local retention entity
		List<RetentionAttributeEntity> toRemove = new ArrayList<>();
		for (RetentionAttributeEntity attr : retention.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		retention.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (RetentionAttributeEntity attr : retention.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (RetentionAttributeEntity attr : retention.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (RetentionAttributeEntity attr : retention.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, retention.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		retention.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public UBLExtensionsModel getUblExtensions() {
		return new UBLExtensionsAdapter(session, em, retention.getUblExtensions());
	}

	@Override
	public void setUblExtensions(UBLExtensionsModel ublExtensions) {
		retention.setUblExtensions(UBLExtensionsAdapter.toEntity(ublExtensions, em));
	}

	@Override
	public String getUblVersionID() {
		return retention.getUblVersionID();
	}

	@Override
	public void setUblVersionID(String ublVersionID) {
		retention.setUblVersionID(ublVersionID);
	}

	@Override
	public String getCustomizationID() {
		return retention.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String customizationID) {
		retention.setCustomizationID(customizationID);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return retention.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		retention.setSignature(entities);
	}

	@Override
	public String getID() {
		return retention.getID();
	}

	@Override
	public void setID(String iD) {
		retention.setID(iD);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return retention.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		retention.setIssueDateTime(issueDateTime);
	}

	@Override
	public List<String> getNote() {
		return retention.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		retention.setNote(note);
	}

	@Override
	public String getSUNATRetentionSystemCode() {
		return retention.getSUNATRetentionSystemCode();
	}

	@Override
	public void setSUNATRetentionSystemCode(String sUNATRetentionSystemCode) {
		retention.setSUNATRetentionSystemCode(sUNATRetentionSystemCode);
	}

	@Override
	public BigDecimal getSUNATRetentionPercent() {
		return retention.getSUNATRetentionPercent();
	}

	@Override
	public void setSUNATRetentionPercent(BigDecimal sUNATRetentionPercent) {
		retention.setSUNATRetentionPercent(sUNATRetentionPercent);
	}

	@Override
	public PartyModel getAgentParty() {
		return new PartyAdapter(session, em, retention.getAgentParty());
	}

	@Override
	public void setAgentParty(PartyModel agentParty) {
		retention.setAgentParty(PartyAdapter.toEntity(agentParty, em));
	}

	@Override
	public PartyModel getReceiverParty() {
		return new PartyAdapter(session, em, retention.getReceiverParty());
	}

	@Override
	public void setReceiverParty(PartyModel receiverParty) {
		retention.setAgentParty(PartyAdapter.toEntity(receiverParty, em));
	}

	@Override
	public BigDecimal getTotalInvoiceAmount() {
		return retention.getTotalInvoiceAmount();
	}

	@Override
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		retention.setTotalInvoiceAmount(totalInvoiceAmount);
	}

	@Override
	public BigDecimal getSUNATTotalPaid() {
		return retention.getSUNATTotalPaid();
	}

	@Override
	public void setSUNATTotalPaid(BigDecimal sUNATTotalPaid) {
		retention.setSUNATTotalPaid(sUNATTotalPaid);
	}

	@Override
	public List<RetentionDocumentReferenceModel> getSUNATRetentionDocumentReference() {
		return retention.getSUNATRetentionDocumentReference().stream()
				.map(f -> new RetentionDocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setSUNATRetentionDocumentReference(
			List<RetentionDocumentReferenceModel> sUNATRetentionDocumentReference) {
		List<RetentionDocumentReferenceEntity> entities = sUNATRetentionDocumentReference.stream()
				.map(f -> RetentionDocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		retention.setSUNATRetentionDocumentReference(entities);
	}

	@Override
	public Byte[] getXmlDocument() {
		return retention.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] xmlDocument) {
		retention.setXmlDocument(xmlDocument);
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return retention.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		retention.setRequeridAction(requeridAction);
	}

	public static RetentionEntity toEntity(RetentionModel model, EntityManager em) {
		if (model instanceof RetentionAdapter) {
			return ((RetentionAdapter) model).getEntity();
		}
		return em.getReference(RetentionEntity.class, model.getId());
	}
}
