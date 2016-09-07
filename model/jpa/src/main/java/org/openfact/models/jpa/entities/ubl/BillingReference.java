package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a reference to a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReference {

	private List<BillingReferenceLine>  billingReferenceLines = new ArrayList<>();
	private DocumentReference selfBilledInvoiceDocumentReference;
	private DocumentReference selfBilledCreditNoteDocumentReference;
	private DocumentReference ReminderDocumentReference;
	private DocumentReference creditNoteDocumentReference;
	private DocumentReference debitNoteDocumentReference;
	private DocumentReference invoiceDocumentReference;
	private DocumentReference additionalDocumentReference;

	public List<BillingReferenceLine> getBillingReferenceLines() {
		return billingReferenceLines;
	}

	public void setBillingReferenceLines(List<BillingReferenceLine> billingReferenceLines) {
		billingReferenceLines = billingReferenceLines;
	}

	public DocumentReference getSelfBilledInvoiceDocumentReference() {
		return selfBilledInvoiceDocumentReference;
	}

	public void setSelfBilledInvoiceDocumentReference(DocumentReference selfBilledInvoiceDocumentReference) {
		this.selfBilledInvoiceDocumentReference = selfBilledInvoiceDocumentReference;
	}

	public DocumentReference getSelfBilledCreditNoteDocumentReference() {
		return selfBilledCreditNoteDocumentReference;
	}

	public void setSelfBilledCreditNoteDocumentReference(DocumentReference selfBilledCreditNoteDocumentReference) {
		this.selfBilledCreditNoteDocumentReference = selfBilledCreditNoteDocumentReference;
	}

	public DocumentReference getReminderDocumentReference() {
		return ReminderDocumentReference;
	}

	public void setReminderDocumentReference(DocumentReference reminderDocumentReference) {
		ReminderDocumentReference = reminderDocumentReference;
	}

	public DocumentReference getCreditNoteDocumentReference() {
		return creditNoteDocumentReference;
	}

	public void setCreditNoteDocumentReference(DocumentReference creditNoteDocumentReference) {
		this.creditNoteDocumentReference = creditNoteDocumentReference;
	}

	public DocumentReference getDebitNoteDocumentReference() {
		return debitNoteDocumentReference;
	}

	public void setDebitNoteDocumentReference(DocumentReference debitNoteDocumentReference) {
		this.debitNoteDocumentReference = debitNoteDocumentReference;
	}

	public DocumentReference getInvoiceDocumentReference() {
		return invoiceDocumentReference;
	}

	public void setInvoiceDocumentReference(DocumentReference invoiceDocumentReference) {
		this.invoiceDocumentReference = invoiceDocumentReference;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}
}// end BillingReference