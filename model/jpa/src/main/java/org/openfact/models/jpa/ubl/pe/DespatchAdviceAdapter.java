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
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.pe.DespatchAdviceLineEntity;
import org.openfact.models.jpa.entities.ubl.pe.DespatchAdviceEntity;
import org.openfact.models.jpa.ubl.common.CustomerPartyAdapter;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.OrderReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ShipmentAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.jpa.ubl.common.pe.DespatchAdviceLineAdapter;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.ShipmentModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.pe.DespatchAdviceLineModel;
import org.openfact.models.ubl.pe.DespatchAdviceModel;

public class DespatchAdviceAdapter implements DespatchAdviceModel, JpaModel<DespatchAdviceEntity> {

	protected static final Logger logger = Logger.getLogger(DespatchAdviceAdapter.class);

	protected OrganizationModel organization;
	protected DespatchAdviceEntity despatchAdvice;
	protected EntityManager em;
	protected OpenfactSession session;

	public DespatchAdviceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			DespatchAdviceEntity despatchAdvice) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.despatchAdvice = despatchAdvice;
	}

	@Override
	public DespatchAdviceEntity getEntity() {
		return despatchAdvice;
	}

	@Override
	public String getId() {
		return despatchAdvice.getId();
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, despatchAdvice.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		despatchAdvice.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public UBLExtensionsModel getUblExtensions() {
		return new UBLExtensionsAdapter(session, em, despatchAdvice.getUblExtensions());
	}

	@Override
	public void setUblExtensions(UBLExtensionsModel ublExtensions) {
		despatchAdvice.setUblExtensions(UBLExtensionsAdapter.toEntity(ublExtensions, em));
	}

	@Override
	public String getUblVersionID() {
		return despatchAdvice.getUblVersionID();
	}

	@Override
	public void setUblVersionID(String ublVersionID) {
		despatchAdvice.setUblVersionID(ublVersionID);
	}

	@Override
	public String getCustomizationID() {
		return despatchAdvice.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String customizationID) {
		despatchAdvice.setCustomizationID(customizationID);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return despatchAdvice.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		despatchAdvice.setSignature(entities);
	}

	@Override
	public String getID() {
		return despatchAdvice.getID();
	}

	@Override
	public void setID(String iD) {
		despatchAdvice.setID(iD);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return despatchAdvice.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		despatchAdvice.setIssueDateTime(issueDateTime);
	}

	@Override
	public String getDespatchAdviceTypeCode() {
		return despatchAdvice.getDespatchAdviceTypeCode();
	}

	@Override
	public void setDespatchAdviceTypeCode(String despatchAdviceTypeCode) {
		despatchAdvice.setDespatchAdviceTypeCode(despatchAdviceTypeCode);
	}

	@Override
	public List<String> getNote() {
		return despatchAdvice.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		despatchAdvice.setNote(note);
	}

	@Override
	public OrderReferenceModel getOrderReference() {
		return new OrderReferenceAdapter(session, em, despatchAdvice.getOrderReference());
	}

	@Override
	public void setOrderReference(OrderReferenceModel orderReference) {
		despatchAdvice.setOrderReference(OrderReferenceAdapter.toEntity(orderReference, em));
	}

	@Override
	public List<DocumentReferenceModel> getAdditionalDocumentReference() {
		return despatchAdvice.getAdditionalDocumentReference().stream()
				.map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
		List<DocumentReferenceEntity> entities = additionalDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchAdvice.setAdditionalDocumentReference(entities);
	}

	@Override
	public SupplierPartyModel getDespatchSupplierParty() {
		return new SupplierPartyAdapter(session, em, despatchAdvice.getDespatchSupplierParty());
	}

	@Override
	public void setDespatchSupplierParty(SupplierPartyModel despatchSupplierParty) {
		despatchAdvice.setDespatchSupplierParty(SupplierPartyAdapter.toEntity(despatchSupplierParty, em));
	}

	@Override
	public CustomerPartyModel getDeliveryCustomerParty() {
		return new CustomerPartyAdapter(session, em, despatchAdvice.getDeliveryCustomerParty());
	}

	@Override
	public void setDeliveryCustomerParty(CustomerPartyModel deliveryCustomerParty) {
		despatchAdvice.setDeliveryCustomerParty(CustomerPartyAdapter.toEntity(deliveryCustomerParty, em));
	}

	@Override
	public SupplierPartyModel getSellerSupplierParty() {
		return new SupplierPartyAdapter(session, em, despatchAdvice.getDespatchSupplierParty());
	}

	@Override
	public void setSellerSupplierParty(SupplierPartyModel sellerSupplierParty) {
		despatchAdvice.setSellerSupplierParty(SupplierPartyAdapter.toEntity(sellerSupplierParty, em));
	}

	@Override
	public List<ShipmentModel> getShipment() {
		return despatchAdvice.getShipment().stream().map(f -> new ShipmentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setShipment(List<ShipmentModel> shipment) {
		List<ShipmentEntity> entities = shipment.stream().map(f -> ShipmentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		despatchAdvice.setShipment(entities);
	}

	@Override
	public List<DespatchAdviceLineModel> getDespatchAdviceLine() {
		return despatchAdvice.getDespatchAdviceLine().stream().map(f -> new DespatchAdviceLineAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoiceLine(List<DespatchAdviceLineModel> despatchAdviceLine) {
		List<DespatchAdviceLineEntity> entities = despatchAdviceLine.stream()
				.map(f -> DespatchAdviceLineAdapter.toEntity(f, em)).collect(Collectors.toList());
		despatchAdvice.setDespatchAdviceLine(entities);
	}

	@Override
	public Byte[] getXmlDocument() {
		return despatchAdvice.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] xmlDocument) {
		despatchAdvice.setXmlDocument(xmlDocument);
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return despatchAdvice.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		despatchAdvice.setRequeridAction(requeridAction);
	}

	public static DespatchAdviceEntity toEntity(DespatchAdviceModel model, EntityManager em) {
		if (model instanceof DespatchAdviceAdapter) {
			return ((DespatchAdviceAdapter) model).getEntity();
		}
		return em.getReference(DespatchAdviceEntity.class, model.getId());
	}
}
