package org.openfact.representations.idm.ubl;

import java.util.List;
import java.util.Map;

public class SendEventRepresentation {

	protected String id;

	//protected List<InvoiceRepresentation> invoices;
	
	protected InvoiceRepresentation invoice;

	protected DebitNoteRepresentation debitNote;

	protected CreditNoteRepresentation creditNote;

	protected byte[] xmlDocument;

	protected byte[] eventDocument;

	protected Map<String, String> sendWarning;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public InvoiceRepresentation getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceRepresentation invoice) {
		this.invoice = invoice;
	}

	public DebitNoteRepresentation getDebitNote() {
		return debitNote;
	}

	public void setDebitNote(DebitNoteRepresentation debitNote) {
		this.debitNote = debitNote;
	}

	public CreditNoteRepresentation getCreditNote() {
		return creditNote;
	}

	public void setCreditNote(CreditNoteRepresentation creditNote) {
		this.creditNote = creditNote;
	}

	public byte[] getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(byte[] xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

	public byte[] getEventDocument() {
		return eventDocument;
	}

	public void setEventDocument(byte[] eventDocument) {
		this.eventDocument = eventDocument;
	}

	public Map<String, String> getSendWarning() {
		return sendWarning;
	}

	public void setSendWarning(Map<String, String> sendWarning) {
		this.sendWarning = sendWarning;
	}

}
