package org.openfact.ubl.pe;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.w3c.dom.Element;

public class UblExtensionContentGeneratorProvider_PE implements UblExtensionContentGeneratorProvider {

	private static final Logger log = Logger.getLogger(UblExtensionContentGeneratorProvider_PE.class);

	protected OpenfactSession session;

	public UblExtensionContentGeneratorProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {		

	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, InvoiceModel invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, CreditNoteModel creditNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, DebitNoteModel debitNote) {
		// TODO Auto-generated method stub
		return null;
	}

}
