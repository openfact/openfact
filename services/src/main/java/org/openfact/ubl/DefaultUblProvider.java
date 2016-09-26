package org.openfact.ubl;

import javax.xml.datatype.DatatypeConfigurationException;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToType;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class DefaultUblProvider implements UblProvider {

	protected OpenfactSession session;

	public DefaultUblProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
		System.out.println("close...");
	}

	@Override
	public Document getDocument(OrganizationModel organization, InvoiceModel invoice) {
		try {
			InvoiceType invoiceType = ModelToType.toType(invoice);
			return UBL21Writer.invoice().getAsDocument(invoiceType);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
		try {
			CreditNoteType creditNoteType = ModelToType.toType(creditNote);
			return UBL21Writer.creditNote().getAsDocument(creditNoteType);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
		try {
			DebitNoteType debitNoteType = ModelToType.toType(debitNote);
			return UBL21Writer.debitNote().getAsDocument(debitNoteType);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

}
