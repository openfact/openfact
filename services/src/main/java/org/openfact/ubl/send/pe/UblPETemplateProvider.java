package org.openfact.ubl.send.pe;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.services.ServicesLogger;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblTemplateProvider;

public class UblPETemplateProvider implements UblTemplateProvider {

	private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

	private final OpenfactSession session;

	public UblPETemplateProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
		System.out.println("closing...");

	}

	@Override
	public UblTemplateProvider setOrganization(OrganizationModel organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UblTemplateProvider setInvoice(InvoiceModel invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UblTemplateProvider setDebitNote(DebitNoteModel debitNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UblTemplateProvider setCreditNote(CreditNoteModel creditNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendAsynchronous() throws UblSenderException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSynchronous() throws UblSenderException {
		// TODO Auto-generated method stub

	}

}
