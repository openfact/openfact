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
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionDocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.pe.PerceptionAttributeEntity;
import org.openfact.models.jpa.entities.ubl.pe.PerceptionEntity;
import org.openfact.models.jpa.ubl.common.PartyAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.jpa.ubl.common.pe.PerceptionDocumentReferenceAdapter;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.pe.PerceptionDocumentReferenceModel;
import org.openfact.models.ubl.pe.PerceptionModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class PerceptionAdapter implements PerceptionModel, JpaModel<PerceptionEntity> {

	protected static final Logger logger = Logger.getLogger(PerceptionAdapter.class);

	protected OrganizationModel organization;
	protected PerceptionEntity perception;
	protected EntityManager em;
	protected OpenfactSession session;

	public PerceptionAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			PerceptionEntity perception) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.perception = perception;
	}

	@Override
	public PerceptionEntity getEntity() {
		return perception;
	}

	@Override
	public String getId() {
		return perception.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<PerceptionAttributeEntity> toRemove = new ArrayList<>();
		for (PerceptionAttributeEntity attr : perception.getAttributes()) {
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
			Query query = em.createNamedQuery("deletePerceptionAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("perceptionId", perception.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			perception.getAttributes().removeAll(toRemove);
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
		PerceptionAttributeEntity attr = new PerceptionAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setPerception(perception);
		em.persist(attr);
		perception.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deletePerceptionAttributesByNameAndPerception");
		query.setParameter("name", name);
		query.setParameter("perceptionId", perception.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local perception entity
		List<PerceptionAttributeEntity> toRemove = new ArrayList<>();
		for (PerceptionAttributeEntity attr : perception.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		perception.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (PerceptionAttributeEntity attr : perception.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (PerceptionAttributeEntity attr : perception.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (PerceptionAttributeEntity attr : perception.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, perception.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		perception.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public UBLExtensionsModel getUblExtensions() {
		return new UBLExtensionsAdapter(session, em, perception.getUblExtensions());
	}

	@Override
	public void setUblExtensions(UBLExtensionsModel ublExtensions) {
		perception.setUblExtensions(UBLExtensionsAdapter.toEntity(ublExtensions, em));
	}

	@Override
	public String getUblVersionID() {
		return perception.getUblVersionID();
	}

	@Override
	public void setUblVersionID(String ublVersionID) {
		perception.setUblVersionID(ublVersionID);
	}

	@Override
	public String getCustomizationID() {
		return perception.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String customizationID) {
		perception.setCustomizationID(customizationID);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return perception.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		perception.setSignature(entities);
	}

	@Override
	public String getID() {
		return perception.getID();
	}

	@Override
	public void setID(String iD) {
		perception.setID(iD);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return perception.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		perception.setIssueDateTime(issueDateTime);
	}

	@Override
	public List<String> getNote() {
		return perception.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		perception.setNote(note);
	}

	@Override
	public String getSUNATPerceptionSystemCode() {
		return perception.getSUNATPerceptionSystemCode();
	}

	@Override
	public void setSUNATPerceptionSystemCode(String sUNATPerceptionSystemCode) {
		perception.setSUNATPerceptionSystemCode(sUNATPerceptionSystemCode);
	}

	@Override
	public BigDecimal getSUNATPerceptionPercent() {
		return perception.getSUNATPerceptionPercent();
	}

	@Override
	public void setSUNATPerceptionPercent(BigDecimal sUNATPerceptionPercent) {
		perception.setSUNATPerceptionPercent(sUNATPerceptionPercent);
	}

	@Override
	public PartyModel getAgentParty() {
		return new PartyAdapter(session, em, perception.getAgentParty());
	}

	@Override
	public void setAgentParty(PartyModel agentParty) {
		perception.setAgentParty(PartyAdapter.toEntity(agentParty, em));
	}

	@Override
	public PartyModel getReceiverParty() {
		return new PartyAdapter(session, em, perception.getReceiverParty());
	}

	@Override
	public void setReceiverParty(PartyModel receiverParty) {
		perception.setAgentParty(PartyAdapter.toEntity(receiverParty, em));
	}

	@Override
	public BigDecimal getTotalInvoiceAmount() {
		return perception.getTotalInvoiceAmount();
	}

	@Override
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		perception.setTotalInvoiceAmount(totalInvoiceAmount);
	}

	@Override
	public BigDecimal getSUNATTotalCashed() {
		return perception.getSUNATTotalCashed();
	}

	@Override
	public void setSUNATTotalCashed(BigDecimal sUNATTotalCashed) {
		perception.setSUNATTotalCashed(sUNATTotalCashed);
	}

	@Override
	public List<PerceptionDocumentReferenceModel> getSUNATPerceptionDocumentReference() {
		return perception.getSUNATPerceptionDocumentReference().stream()
				.map(f -> new PerceptionDocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setSUNATPerceptionDocumentReference(
			List<PerceptionDocumentReferenceModel> sUNATPerceptionDocumentReference) {
		List<PerceptionDocumentReferenceEntity> entities = sUNATPerceptionDocumentReference.stream()
				.map(f -> PerceptionDocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		perception.setSUNATPerceptionDocumentReference(entities);
	}

	@Override
	public Byte[] getXmlDocument() {
		return perception.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] xmlDocument) {
		perception.setXmlDocument(xmlDocument);
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return perception.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		perception.setRequeridAction(requeridAction);
	}

	public static PerceptionEntity toEntity(PerceptionModel model, EntityManager em) {
		if (model instanceof PerceptionAdapter) {
			return ((PerceptionAdapter) model).getEntity();
		}
		return em.getReference(PerceptionEntity.class, model.getId());
	}
}
