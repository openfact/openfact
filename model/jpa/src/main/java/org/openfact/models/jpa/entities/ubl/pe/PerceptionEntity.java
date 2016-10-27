package org.openfact.models.jpa.entities.ubl.pe;

import java.math.BigDecimal;
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
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionDocumentReferenceEntity;

@Entity
@Table(name = "PERCEPTION", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
public class PerceptionEntity {
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
	@JoinColumn(name = "UBLEXTENSIONS_PERCEPTION_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;

	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_PERCEPTION")
	protected List<SignatureEntity> signature = new ArrayList<>();

	@Column(name = "ID_UBL")
	protected String ID;
	
	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;
	
	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "PERCEPTION_NOTE", joinColumns = { @JoinColumn(name = "PERCEPTION_ID") })
	protected List<String> note = new ArrayList<>();

	@Column(name = "PERCEPTION_SYSTEM_CODE")
	protected String SUNATPerceptionSystemCode;

	@Column(name = "PERCEPTION_PERCENT")
	protected BigDecimal SUNATPerceptionPercent;
	
	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "AGENTPARTY_PERCEPTION_ID")
	protected PartyEntity agentParty = new PartyEntity();
	
	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RECEIVERPARTY_PERCEPTION_ID")
	protected PartyEntity receiverParty = new PartyEntity();
	
	@Column(name = "TOTAL_INVOICE_AMOUNT")
	protected BigDecimal totalInvoiceAmount;

	@Column(name = "TOTAL_CASHED")
	protected BigDecimal SUNATTotalCashed;
	
	@OneToMany(targetEntity = PerceptionDocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PERCEPTIONDOCUMENTREFERECE_PERCEPTION_ID")
	public List<PerceptionDocumentReferenceEntity> SUNATPerceptionDocumentReference = new ArrayList<>();

	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@ElementCollection
	@Column(name = "REQUERID_ACTION")
	@CollectionTable(name = "RETENTION_REQUERID_ACTION", joinColumns = { @JoinColumn(name = "RETENTION_ID") })
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

	public List<String> getNote() {
		return note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public String getSUNATPerceptionSystemCode() {
		return SUNATPerceptionSystemCode;
	}

	public void setSUNATPerceptionSystemCode(String sUNATPerceptionSystemCode) {
		SUNATPerceptionSystemCode = sUNATPerceptionSystemCode;
	}

	public BigDecimal getSUNATPerceptionPercent() {
		return SUNATPerceptionPercent;
	}

	public void setSUNATPerceptionPercent(BigDecimal sUNATPerceptionPercent) {
		SUNATPerceptionPercent = sUNATPerceptionPercent;
	}

	public PartyEntity getAgentParty() {
		return agentParty;
	}

	public void setAgentParty(PartyEntity agentParty) {
		this.agentParty = agentParty;
	}

	public PartyEntity getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(PartyEntity receiverParty) {
		this.receiverParty = receiverParty;
	}

	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public BigDecimal getSUNATTotalCashed() {
		return SUNATTotalCashed;
	}

	public void setSUNATTotalCashed(BigDecimal sUNATTotalCashed) {
		SUNATTotalCashed = sUNATTotalCashed;
	}

	public List<PerceptionDocumentReferenceEntity> getSUNATPerceptionDocumentReference() {
		return SUNATPerceptionDocumentReference;
	}

	public void setSUNATPerceptionDocumentReference(
			List<PerceptionDocumentReferenceEntity> sUNATPerceptionDocumentReference) {
		SUNATPerceptionDocumentReference = sUNATPerceptionDocumentReference;
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
