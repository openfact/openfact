package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionDocumentReferenceEntity;

@Entity
@Table(name = "SUMMARY_DOCUMENTS_LINE")
public class SummaryDocumentsLineEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "LINE_ID")
	protected String lineID;

	@Column(name = "DOCUMENT_TYPE_CODE")
	protected String documentTypeCode;

	@Column(name = "DOCUMENT_SERIAL_ID")
	protected String documentSerialID;

	@Column(name = "START_DOCUMENT_NUMBER_ID")
	protected String startDocumentNumberID;

	@Column(name = "END_DOCUMENT_NUMBER_ID")
	protected String endDocumentNumberID;

	@Column(name = "TOTAL_AMOUNT")
	protected BigDecimal totalAmount;

	@ManyToOne(targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_SUMMARY")
	protected CustomerPartyEntity accountingCustomerParty = new CustomerPartyEntity();

	@ManyToOne(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "BILLINGREFERENCE")
	protected BillingReferenceEntity billingReference = new BillingReferenceEntity();

	@ManyToOne(targetEntity = PerceptionDocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PERCEPTIONDOCUMENTREFERENCE_SUMMARY")
	protected PerceptionDocumentReferenceEntity sunatPerceptionDocumentReference;

	@ManyToOne(targetEntity = StatusEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "STATUS_SUMMARY")
	protected StatusEntity status;

	@OneToMany(targetEntity = PaymentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "BILLINGPAYMENT_SUMMARY")
	protected List<PaymentEntity> billingPayment = new ArrayList<>();

	@OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ALLOWANCECHARGE_SUMMARY")
	protected List<AllowanceChargeEntity> allowanceCharge = new ArrayList<>();

	@OneToMany(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TAXTOTAL_SUMMARY")
	protected List<TaxTotalEntity> taxTotal = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public String getDocumentSerialID() {
		return documentSerialID;
	}

	public void setDocumentSerialID(String documentSerialID) {
		this.documentSerialID = documentSerialID;
	}

	public String getStartDocumentNumberID() {
		return startDocumentNumberID;
	}

	public void setStartDocumentNumberID(String startDocumentNumberID) {
		this.startDocumentNumberID = startDocumentNumberID;
	}

	public String getEndDocumentNumberID() {
		return endDocumentNumberID;
	}

	public void setEndDocumentNumberID(String endDocumentNumberID) {
		this.endDocumentNumberID = endDocumentNumberID;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerPartyEntity getAccountingCustomerParty() {
		return accountingCustomerParty;
	}

	public void setAccountingCustomerParty(CustomerPartyEntity accountingCustomerParty) {
		this.accountingCustomerParty = accountingCustomerParty;
	}

	public BillingReferenceEntity getBillingReference() {
		return billingReference;
	}

	public void setBillingReference(BillingReferenceEntity billingReference) {
		this.billingReference = billingReference;
	}

	public PerceptionDocumentReferenceEntity getSunatPerceptionDocumentReference() {
		return sunatPerceptionDocumentReference;
	}

	public void setSunatPerceptionDocumentReference(PerceptionDocumentReferenceEntity sunatPerceptionDocumentReference) {
		this.sunatPerceptionDocumentReference = sunatPerceptionDocumentReference;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public List<PaymentEntity> getBillingPayment() {
		return billingPayment;
	}

	public void setBillingPayment(List<PaymentEntity> billingPayment) {
		this.billingPayment = billingPayment;
	}

	public List<AllowanceChargeEntity> getAllowanceCharge() {
		return allowanceCharge;
	}

	public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
		this.allowanceCharge = allowanceCharge;
	}

	public List<TaxTotalEntity> getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
		this.taxTotal = taxTotal;
	}

}
