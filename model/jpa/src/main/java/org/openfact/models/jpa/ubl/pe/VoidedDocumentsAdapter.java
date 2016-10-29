package org.openfact.models.jpa.ubl.pe;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.VoidedDocumentsLineEntity;
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
