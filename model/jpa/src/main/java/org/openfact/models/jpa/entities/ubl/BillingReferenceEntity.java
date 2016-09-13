package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * A class to define a reference to a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
@Entity
@Table(name = "BILLING_REFERENCE")
public class BillingReferenceEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	@Transient
	private List<BillingReferenceLineEntity> billingReferenceLines = new ArrayList<>();

	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity selfBilledInvoiceDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity selfBilledCreditNoteDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity reminderDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity creditNoteDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity debitNoteDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity invoiceDocumentReference;
	@OneToOne(mappedBy = "billingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private BillingReferenceDocumentReferenceMappingEntity additionalDocumentReference;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the billingReferenceLines
	 */
	public List<BillingReferenceLineEntity> getBillingReferenceLines() {
		return billingReferenceLines;
	}

	/**
	 * @param billingReferenceLines
	 *            the billingReferenceLines to set
	 */
	public void setBillingReferenceLines(List<BillingReferenceLineEntity> billingReferenceLines) {
		this.billingReferenceLines = billingReferenceLines;
	}

	/**
	 * @return the selfBilledInvoiceDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getSelfBilledInvoiceDocumentReference() {
		return selfBilledInvoiceDocumentReference;
	}

	/**
	 * @param selfBilledInvoiceDocumentReference
	 *            the selfBilledInvoiceDocumentReference to set
	 */
	public void setSelfBilledInvoiceDocumentReference(
			BillingReferenceDocumentReferenceMappingEntity selfBilledInvoiceDocumentReference) {
		this.selfBilledInvoiceDocumentReference = selfBilledInvoiceDocumentReference;
	}

	/**
	 * @return the selfBilledCreditNoteDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getSelfBilledCreditNoteDocumentReference() {
		return selfBilledCreditNoteDocumentReference;
	}

	/**
	 * @param selfBilledCreditNoteDocumentReference
	 *            the selfBilledCreditNoteDocumentReference to set
	 */
	public void setSelfBilledCreditNoteDocumentReference(
			BillingReferenceDocumentReferenceMappingEntity selfBilledCreditNoteDocumentReference) {
		this.selfBilledCreditNoteDocumentReference = selfBilledCreditNoteDocumentReference;
	}

	/**
	 * @return the reminderDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getReminderDocumentReference() {
		return reminderDocumentReference;
	}

	/**
	 * @param reminderDocumentReference
	 *            the reminderDocumentReference to set
	 */
	public void setReminderDocumentReference(BillingReferenceDocumentReferenceMappingEntity reminderDocumentReference) {
		this.reminderDocumentReference = reminderDocumentReference;
	}

	/**
	 * @return the creditNoteDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getCreditNoteDocumentReference() {
		return creditNoteDocumentReference;
	}

	/**
	 * @param creditNoteDocumentReference
	 *            the creditNoteDocumentReference to set
	 */
	public void setCreditNoteDocumentReference(
			BillingReferenceDocumentReferenceMappingEntity creditNoteDocumentReference) {
		this.creditNoteDocumentReference = creditNoteDocumentReference;
	}

	/**
	 * @return the debitNoteDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getDebitNoteDocumentReference() {
		return debitNoteDocumentReference;
	}

	/**
	 * @param debitNoteDocumentReference
	 *            the debitNoteDocumentReference to set
	 */
	public void setDebitNoteDocumentReference(
			BillingReferenceDocumentReferenceMappingEntity debitNoteDocumentReference) {
		this.debitNoteDocumentReference = debitNoteDocumentReference;
	}

	/**
	 * @return the invoiceDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getInvoiceDocumentReference() {
		return invoiceDocumentReference;
	}

	/**
	 * @param invoiceDocumentReference
	 *            the invoiceDocumentReference to set
	 */
	public void setInvoiceDocumentReference(BillingReferenceDocumentReferenceMappingEntity invoiceDocumentReference) {
		this.invoiceDocumentReference = invoiceDocumentReference;
	}

	/**
	 * @return the additionalDocumentReference
	 */
	public BillingReferenceDocumentReferenceMappingEntity getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	/**
	 * @param additionalDocumentReference
	 *            the additionalDocumentReference to set
	 */
	public void setAdditionalDocumentReference(
			BillingReferenceDocumentReferenceMappingEntity additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

}
