package org.openfact.ubl;

import java.util.HashMap;
import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.SendEventRepresentation;

public class DefaultUblSenderResponseProvider implements UblSenderResponseProvider {
	private OpenfactSession session;

	public DefaultUblSenderResponseProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	private UblSendEventProvider getSendEventProvider(OrganizationModel organization) {
		return session.getProvider(UblSendEventProvider.class, organization.getDefaultLocale());
	}

	@Override
	public SendEventModel invoiceSenderResponse(OrganizationModel organization, InvoiceModel invoice, byte[] submitted,
			Map<String, Object> response, String... fault) throws UblSenderException {
		try {
			SendEventRepresentation rep = toRepresentation(response, fault);
			rep.setDocumentSubmitted(submitted);
			SendEventModel sendEvent = getSendEventProvider(organization).addInvoiceSendEvent(organization, invoice,
					rep.isAccepted());
			RepresentationToModel.toModel(rep, sendEvent);
			return sendEvent;
		} catch (Exception e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public SendEventModel creditNoteSenderResponse(OrganizationModel organization, CreditNoteModel creditNote,
			byte[] submitted, Map<String, Object> response, String... fault) throws UblSenderException {
		try {
			SendEventRepresentation rep = toRepresentation(response, fault);
			rep.setDocumentSubmitted(submitted);
			SendEventModel sendEvent = getSendEventProvider(organization).addCreditNoteSendEvent(organization,
					creditNote, rep.isAccepted());
			RepresentationToModel.toModel(rep, sendEvent);
			return sendEvent;
		} catch (Exception e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public SendEventModel debitNoteSenderResponse(OrganizationModel organization, DebitNoteModel debitNote,
			byte[] submitted, Map<String, Object> response, String... fault) throws UblSenderException {
		try {
			SendEventRepresentation rep = toRepresentation(response, fault);
			rep.setDocumentSubmitted(submitted);
			SendEventModel sendEvent = getSendEventProvider(organization).addDebitNoteSendEvent(organization, debitNote,
					rep.isAccepted());
			RepresentationToModel.toModel(rep, sendEvent);
			return sendEvent;
		} catch (Exception e) {
			throw new UblSenderException(e);
		}
	}

	private SendEventRepresentation toRepresentation(Map<String, Object> response, String[] fault) {
		SendEventRepresentation rep = new SendEventRepresentation();
		Map<String, String> success, warning;
		if (response != null) {
			success = new HashMap<>();
			response.forEach((k, v) -> success.put(k, (String) v));
			rep.setSuccess(success);
			rep.setAccepted(true);
		} else if (fault.length > 0) {
			warning = new HashMap<>();
			int i = 0;
			for (String value : fault) {
				i++;
				warning.put("warning_" + i, value);
			}
			rep.setWarning(warning);
			rep.setAccepted(false);
		}
		return rep;
	}

}
