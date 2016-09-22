package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface UblTemplateProvider extends Provider {

	//String IDENTITY_PROVIDER_BROKER_CONTEXT = "identityProviderBrokerCtx";

	public UblTemplateProvider setOrganization(OrganizationModel organization);

	public UblTemplateProvider setInvoice(InvoiceModel invoice);

	public UblTemplateProvider setDebitNote(DebitNoteModel debitNote);

	public UblTemplateProvider setCreditNote(CreditNoteModel creditNote);

	/**
	 * send document to sunat
	 * 
	 */
	public void sendAsynchronous();

	public void sendSynchronous();

}
