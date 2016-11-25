package org.openfact.ubl;

import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang.ArrayUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;

public class DefaultUblTemplateProvider implements UblTemplateProvider {
	private OpenfactSession session;

	public DefaultUblTemplateProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	private UblSenderProvider getUblSenderProvider(OrganizationModel organization) {
		return session.getProvider(UblSenderProvider.class, organization.getDefaultLocale());
	}

	private UblSenderResponseProvider getUblSenderResponseProvider(OrganizationModel organization) {
		return session.getProvider(UblSenderResponseProvider.class, organization.getDefaultLocale());
	}

	@Override
	public SendEventModel sendInvoice(OrganizationModel organization, InvoiceModel invoice) throws UblSenderException {
		SendEventModel model = null;
		byte[] file = null;
		try {
			String fileName = invoice.getID();
			file = ArrayUtils.toPrimitive(invoice.getXmlDocument());
			// sender
			Map<String, Object> response = getUblSenderProvider(organization).sendDocument(organization, file, fileName,
					InternetMediaType.XML);
			// sender response
			model = getUblSenderResponseProvider(organization).invoiceSenderResponse(organization, invoice, file,
					response);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			model = getUblSenderResponseProvider(organization).invoiceSenderResponse(organization, invoice, file, null,
					new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
		}
		return model;
	}

	@Override
	public SendEventModel sendInvoices(OrganizationModel organization, List<InvoiceModel> invoices)
			throws UblSenderException {
		throw new UblSenderException("method not implemented", new Throwable());
	}

	@Override
	public SendEventModel sendCreditNote(OrganizationModel organization, CreditNoteModel creditNote)
			throws UblSenderException {
		SendEventModel model = null;
		byte[] file = null;
		try {
			String fileName = creditNote.getID();
			file = ArrayUtils.toPrimitive(creditNote.getXmlDocument());
			// sender
			Map<String, Object> response = getUblSenderProvider(organization).sendDocument(organization, file, fileName,
					InternetMediaType.XML);
			// sender response
			model = getUblSenderResponseProvider(organization).creditNoteSenderResponse(organization, creditNote, file,
					response);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			model = getUblSenderResponseProvider(organization).creditNoteSenderResponse(organization, creditNote, file,
					null, new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
		}
		return model;
	}

	@Override
	public SendEventModel sendDebitNote(OrganizationModel organization, DebitNoteModel debitNote)
			throws UblSenderException {
		SendEventModel model = null;
		byte[] file = null;
		try {
			String fileName = debitNote.getID();
			file = ArrayUtils.toPrimitive(debitNote.getXmlDocument());
			// sender
			Map<String, Object> response = getUblSenderProvider(organization).sendDocument(organization, file, fileName,
					InternetMediaType.XML);
			// sender response
			model = getUblSenderResponseProvider(organization).debitNoteSenderResponse(organization, debitNote, file,
					response);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			model = getUblSenderResponseProvider(organization).debitNoteSenderResponse(organization, debitNote, file,
					null, new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
		}
		return model;
	}

}
