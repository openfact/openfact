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
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.SummaryDocumentsLineEntity;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;

@Entity
@Table(name = "SUMMARY_DOCUMENTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
public class SummaryDocumentsEntity {

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
	@JoinColumn(name = "UBLEXTENSIONS_SUMMARYDOCUMENTS_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;
	
	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "REFERENCE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime referenceDateTime;
	
	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;
	
	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_SUMMARYDOCUMENTS")
	protected List<SignatureEntity> signature = new ArrayList<>();
   
	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_SUMMARYDOCUMENTS_ID")
	protected SupplierPartyEntity accountingSupplierParty = new SupplierPartyEntity();

	@OneToMany(targetEntity = SummaryDocumentsLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SUMMARYLINE_SUMMARYDOCUMENTS")
    public List<SummaryDocumentsLineEntity> SummaryDocumentsLines =new ArrayList<>();
	
	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@ElementCollection
	@Column(name = "REQUERID_ACTION")
	@CollectionTable(name = "SUMMARY_REQUERID_ACTION", joinColumns = { @JoinColumn(name = "SUMMARY_DOCUMENTS_ID") })
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getReferenceDateTime() {
		return referenceDateTime;
	}

	public void setReferenceDateTime(LocalDateTime referenceDateTime) {
		this.referenceDateTime = referenceDateTime;
	}

	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public List<SignatureEntity> getSignature() {
		return signature;
	}

	public void setSignature(List<SignatureEntity> signature) {
		this.signature = signature;
	}

	public SupplierPartyEntity getAccountingSupplierParty() {
		return accountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
	}

	public List<SummaryDocumentsLineEntity> getSummaryDocumentsLines() {
		return SummaryDocumentsLines;
	}

	public void setSummaryDocumentsLines(List<SummaryDocumentsLineEntity> summaryDocumentsLines) {
		SummaryDocumentsLines = summaryDocumentsLines;
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
