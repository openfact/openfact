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
import org.openfact.models.jpa.entities.ubl.common.SummaryDocumentsLineEntity;
import org.openfact.models.jpa.entities.ubl.pe.SummaryDocumentsAttributeEntity;
import org.openfact.models.jpa.entities.ubl.pe.SummaryDocumentsEntity;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SummaryDocumentsLineAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SummaryDocumentsLineModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.pe.SummaryDocumentsModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class SummaryDocumentsAdapter implements SummaryDocumentsModel, JpaModel<SummaryDocumentsEntity> {

	protected static final Logger logger = Logger.getLogger(SummaryDocumentsAdapter.class);

	protected OrganizationModel organization;
	protected SummaryDocumentsEntity summaryDocuments;
	protected EntityManager em;
	protected OpenfactSession session;

	public SummaryDocumentsAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			SummaryDocumentsEntity summaryDocuments) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.summaryDocuments = summaryDocuments;
	}

	@Override
	public SummaryDocumentsEntity getEntity() {
		return summaryDocuments;
	}

	@Override
	public String getId() {
		return summaryDocuments.getId();
	}
	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<SummaryDocumentsAttributeEntity> toRemove = new ArrayList<>();
		for (SummaryDocumentsAttributeEntity attr : summaryDocuments.getAttributes()) {
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
			Query query = em.createNamedQuery("deleteSummaryDocumentsAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("summaryDocumentsId", summaryDocuments.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			summaryDocuments.getAttributes().removeAll(toRemove);
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
		SummaryDocumentsAttributeEntity attr = new SummaryDocumentsAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setSummaryDocuments(summaryDocuments);
		em.persist(attr);
		summaryDocuments.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteSummaryDocumentsAttributesByNameAndSummaryDocuments");
		query.setParameter("name", name);
		query.setParameter("summaryDocumentsId", summaryDocuments.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local summaryDocuments entity
		List<SummaryDocumentsAttributeEntity> toRemove = new ArrayList<>();
		for (SummaryDocumentsAttributeEntity attr : summaryDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		summaryDocuments.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (SummaryDocumentsAttributeEntity attr : summaryDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (SummaryDocumentsAttributeEntity attr : summaryDocuments.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (SummaryDocumentsAttributeEntity attr : summaryDocuments.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}
	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, summaryDocuments.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		summaryDocuments.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public UBLExtensionsModel getUblExtensions() {
		return new UBLExtensionsAdapter(session, em, summaryDocuments.getUblExtensions());
	}

	@Override
	public void setUblExtensions(UBLExtensionsModel ublExtensions) {
		summaryDocuments.setUblExtensions(UBLExtensionsAdapter.toEntity(ublExtensions, em));
	}

	@Override
	public String getUblVersionID() {
		return summaryDocuments.getUblVersionID();
	}

	@Override
	public void setUblVersionID(String ublVersionID) {
		summaryDocuments.setUblVersionID(ublVersionID);
	}

	@Override
	public String getCustomizationID() {
		return summaryDocuments.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String customizationID) {
		summaryDocuments.setCustomizationID(customizationID);
	}

	@Override
	public String getID() {
		return summaryDocuments.getID();
	}

	@Override
	public void setID(String iD) {
		summaryDocuments.setID(iD);
	}

	@Override
	public LocalDateTime getReferenceDateTime() {
		return summaryDocuments.getReferenceDateTime();
	}

	@Override
	public void setReferenceDateTime(LocalDateTime referenceDateTime) {
		summaryDocuments.setReferenceDateTime(referenceDateTime);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return summaryDocuments.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		summaryDocuments.setIssueDateTime(issueDateTime);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return summaryDocuments.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		summaryDocuments.setSignature(entities);
	}

	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		return new SupplierPartyAdapter(session, em, summaryDocuments.getAccountingSupplierParty());
	}

	@Override
	public void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty) {
		summaryDocuments.setAccountingSupplierParty(SupplierPartyAdapter.toEntity(accountingSupplierParty, em));
	}

	@Override
	public List<SummaryDocumentsLineModel> getSummaryDocumentsLines() {
		return summaryDocuments.getSummaryDocumentsLines().stream()
				.map(f -> new SummaryDocumentsLineAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setSummaryDocumentsLines(List<SummaryDocumentsLineModel> summaryDocumentsLines) {
		List<SummaryDocumentsLineEntity> entities = summaryDocumentsLines.stream()
				.map(f -> SummaryDocumentsLineAdapter.toEntity(f, em)).collect(Collectors.toList());
		summaryDocuments.setSummaryDocumentsLines(entities);
	}

	@Override
	public Byte[] getXmlDocument() {
		return summaryDocuments.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] xmlDocument) {
		summaryDocuments.setXmlDocument(xmlDocument);
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return summaryDocuments.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		summaryDocuments.setRequeridAction(requeridAction);
	}

	public static SummaryDocumentsEntity toEntity(SummaryDocumentsModel model, EntityManager em) {
		if (model instanceof SummaryDocumentsAdapter) {
			return ((SummaryDocumentsAdapter) model).getEntity();
		}
		return em.getReference(SummaryDocumentsEntity.class, model.getId());
	}
}
