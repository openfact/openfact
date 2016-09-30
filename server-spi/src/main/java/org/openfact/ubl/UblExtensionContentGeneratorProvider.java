package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Element;

public interface UblExtensionContentGeneratorProvider extends Provider {

	public Element getExtensionContentType(OrganizationModel organization, InvoiceModel invoice);

	public Element getExtensionContentType(OrganizationModel organization, CreditNoteModel creditNote);

	public Element getExtensionContentType(OrganizationModel organization, DebitNoteModel debitNote);

}
