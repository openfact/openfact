package org.openfact.models.jpa.ubl.pe;

import java.math.BigDecimal;
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
import org.openfact.models.jpa.entities.ubl.common.pe.RetentionDocumentReferenceEntity;
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
