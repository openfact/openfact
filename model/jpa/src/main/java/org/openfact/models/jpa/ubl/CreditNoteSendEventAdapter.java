package org.openfact.models.jpa.ubl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CreditNoteSendEventModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.CreditNoteSendEventEntity;
import org.openfact.models.ubl.CreditNoteModel;

public class CreditNoteSendEventAdapter implements CreditNoteSendEventModel, JpaModel<CreditNoteSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(CreditNoteSendEventAdapter.class);

	protected OrganizationModel organization;
	protected CreditNoteSendEventEntity sendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public CreditNoteSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			CreditNoteSendEventEntity sendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.sendEvent = sendEvent;
	}

	@Override
	public List<CreditNoteModel> getCreditNotes() {
		return sendEvent.getCreditNotes().stream().map(f -> new CreditNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoices(List<CreditNoteModel> creditNotes) {
		List<CreditNoteEntity> entities = creditNotes.stream().map(f -> CreditNoteAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		sendEvent.setCreditNotes(entities);

	}

	@Override
	public String getId() {
		return sendEvent.getId();
	}

	@Override
	public String getDocumentId() {
		return sendEvent.getDocumentId();
	}

	@Override
	public boolean getAccepted() {
		return sendEvent.isAccepted();
	}

	@Override
	public String getDescription() {
		return sendEvent.getDescription();
	}

	@Override
	public String getNote() {
		return sendEvent.getNote();
	}

	@Override
	public String getResponseCode() {
		return sendEvent.getResponseCode();
	}

	@Override
	public String getErrorMessage() {
		return sendEvent.getErrorMessage();
	}

	@Override
	public String getDigestValue() {
		return sendEvent.getDigestValue();
	}

	@Override
	public String getBarCode() {
		return sendEvent.getBarCode();
	}

	@Override
	public byte[] getDocumentSubmitted() {
		return sendEvent.getDocumentSubmitted();
	}

	@Override
	public byte[] getDocumentResponse() {
		return sendEvent.getDocumentResponse();
	}

	@Override
	public byte[] getCustomerDocument() {
		return sendEvent.getCustomerDocument();
	}

	@Override
	public Map<String, String> getWarning() {
		return sendEvent.getWarning();
	}

	@Override
	public Map<String, String> getSuccess() {
		return sendEvent.getSuccess();
	}

	@Override
	public void setDocumentId(String documentId) {
		sendEvent.setDocumentId(documentId);
	}

	@Override
	public void setAccepted(boolean accepted) {
		sendEvent.setAccepted(accepted);
	}

	@Override
	public void setDescription(String description) {
		sendEvent.setDescription(description);
	}

	@Override
	public void setNote(String note) {
		sendEvent.setNote(note);
	}

	@Override
	public void setResponseCode(String responseCode) {
		sendEvent.setResponseCode(responseCode);
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		sendEvent.setErrorMessage(errorMessage);
	}

	@Override
	public void setDigestValue(String digestValue) {
		sendEvent.setDigestValue(digestValue);
	}

	@Override
	public void setBarCode(String barCode) {
		sendEvent.setBarCode(barCode);
	}

	@Override
	public void setDocumentSubmitted(byte[] documentSubmitted) {
		sendEvent.setDocumentSubmitted(documentSubmitted);
	}

	@Override
	public void setDocumentResponse(byte[] documentResponse) {
		sendEvent.setDocumentResponse(documentResponse);
	}

	@Override
	public void setCustomerDocument(byte[] customerDocument) {
		sendEvent.setCustomerDocument(customerDocument);
	}

	@Override
	public void setWarning(Map<String, String> warning) {
		sendEvent.setWarning(warning);
	}

	@Override
	public void setSuccess(Map<String, String> success) {
		sendEvent.setSuccess(success);
	}

	@Override
	public CreditNoteSendEventEntity getEntity() {
		return sendEvent;
	}
}
