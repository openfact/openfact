package org.openfact.models.jpa.entities.ubl.pe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.ubl.common.CustomerPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.jpa.entities.ubl.common.pe.DespatchAdviceLineEntity;

@Entity
@Table(name = "DESPATCH_ADVICE", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
public class DespatchAdviceEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;

	@ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "UBLEXTENSIONS_RETENTION_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;

	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_RETENTION")
	protected List<SignatureEntity> signature = new ArrayList<>();

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;

	@Column(name = "DESPATCH_ADVICE_TYPE_CODE")
	protected String despatchAdviceTypeCode;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "DESPATCHADVICE_NOTE", joinColumns = { @JoinColumn(name = "DESPATCH_ADVICE_ID") })
	protected List<String> note = new ArrayList<>();

	@ManyToOne(targetEntity = OrderReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDERREFERENCE_DESPATCHADVICE")
	protected OrderReferenceEntity orderReference = new OrderReferenceEntity();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE_DESPATCHADVICE")
	protected List<DocumentReferenceEntity> additionalDocumentReference = new ArrayList<>();

	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DESPATCHSUPPLIERPARTY_DESPATCHADVICE")
	protected SupplierPartyEntity despatchSupplierParty = new SupplierPartyEntity();

	@ManyToOne(targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYCUSTOMERPARTY_INVOICE")
	protected CustomerPartyEntity deliveryCustomerParty = new CustomerPartyEntity();

	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SELLERSUPPLIERPARTY_INVOICE")
	protected SupplierPartyEntity sellerSupplierParty = new SupplierPartyEntity();

	@OneToMany(targetEntity = ShipmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SHIPMENT_DESPATCHADVICE")
	protected List<ShipmentEntity> shipment = new ArrayList<>();

	@OneToMany(targetEntity = DespatchAdviceLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DESPATCHLINE_DESPATCHADVICE_ID")
	protected List<DespatchAdviceLineEntity> despatchAdviceLine = new ArrayList<>();
	
	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@ElementCollection
	@Column(name = "REQUERID_ACTION")
	@CollectionTable(name = "INVOICE_REQUERID_ACTION", joinColumns = { @JoinColumn(name = "INVOICE_ID") })
	@Enumerated(EnumType.STRING)
	protected List<RequeridActionDocument> requeridAction = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public UBLExtensionsEntity getUblExtensions() {
		return ublExtensions;
	}

	public void setUblExtensions(UBLExtensionsEntity ublExtensions) {
		this.ublExtensions = ublExtensions;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public List<SignatureEntity> getSignature() {
		return signature;
	}

	public void setSignature(List<SignatureEntity> signature) {
		this.signature = signature;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public String getDespatchAdviceTypeCode() {
		return despatchAdviceTypeCode;
	}

	public void setDespatchAdviceTypeCode(String despatchAdviceTypeCode) {
		this.despatchAdviceTypeCode = despatchAdviceTypeCode;
	}

	public List<String> getNote() {
		return note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public OrderReferenceEntity getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(OrderReferenceEntity orderReference) {
		this.orderReference = orderReference;
	}

	public List<DocumentReferenceEntity> getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(List<DocumentReferenceEntity> additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public SupplierPartyEntity getDespatchSupplierParty() {
		return despatchSupplierParty;
	}

	public void setDespatchSupplierParty(SupplierPartyEntity despatchSupplierParty) {
		this.despatchSupplierParty = despatchSupplierParty;
	}

	public CustomerPartyEntity getDeliveryCustomerParty() {
		return deliveryCustomerParty;
	}

	public void setDeliveryCustomerParty(CustomerPartyEntity deliveryCustomerParty) {
		this.deliveryCustomerParty = deliveryCustomerParty;
	}

	public SupplierPartyEntity getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierPartyEntity sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public List<ShipmentEntity> getShipment() {
		return shipment;
	}

	public void setShipment(List<ShipmentEntity> shipment) {
		this.shipment = shipment;
	}	

	public List<DespatchAdviceLineEntity> getDespatchAdviceLine() {
		return despatchAdviceLine;
	}

	public void setDespatchAdviceLine(List<DespatchAdviceLineEntity> despatchAdviceLine) {
		this.despatchAdviceLine = despatchAdviceLine;
	}

	public Byte[] getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(Byte[] xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

	public List<RequeridActionDocument> getRequeridAction() {
		return requeridAction;
	}

	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		this.requeridAction = requeridAction;
	}

}
