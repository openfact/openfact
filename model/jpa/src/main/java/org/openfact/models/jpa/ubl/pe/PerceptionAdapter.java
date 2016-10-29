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
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionDocumentReferenceEntity;
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
