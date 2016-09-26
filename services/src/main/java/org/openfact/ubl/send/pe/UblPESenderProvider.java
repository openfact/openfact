package org.openfact.ubl.send.pe;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.services.ServicesLogger;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;

public class UblPESenderProvider implements UblSenderProvider {

	private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

	private final OpenfactSession session;

	public UblPESenderProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(OrganizationModel orgamization, InvoiceModel invoice, byte[] document, String name)
			throws UblSenderException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(OrganizationModel orgamization, DebitNoteModel debitNote, byte[] document, String name)
			throws UblSenderException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(OrganizationModel orgamization, CreditNoteModel creditNote, byte[] document, String name)
			throws UblSenderException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(OrganizationModel orgamization, byte[] document, String name) throws UblSenderException {
		// TODO Auto-generated method stub

	}

}
