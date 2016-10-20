package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.jpa.entities.ubl.SendEventEntity;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;

public class SendEventAdapter implements SendEventModel, JpaModel<SendEventEntity> {

	protected static final Logger logger = Logger.getLogger(SendEventAdapter.class);

	protected OrganizationModel organization;
	protected SendEventEntity sendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public SendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			SendEventEntity sendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.sendEvent = sendEvent;
	}

	@Override
	public SendEventEntity getEntity() {
		return sendEvent;
	}

	@Override
	public String getId() {
		return sendEvent.getId();
	}

	@Override
	public byte[] getXmlDoument() {
		return sendEvent.getXmlDocument();
	}

	@Override
	public void setXmlDocument(byte[] xmlDocument) {
		sendEvent.setXmlDocument(xmlDocument);
	}

	@Override
	public byte[] getEventDoument() {
		return sendEvent.getEventDocument();
	}

	@Override
	public void setEventDocument(byte[] eventDocument) {
		sendEvent.setEventDocument(eventDocument);
	}

	@Override
	public Map<String, String> getSendWarning() {
		return sendEvent.getSendWarning();
	}

	@Override
	public void setSendWarning(Map<String, String> sendWarning) {
		sendEvent.setSendWarning(sendWarning);
	}

	@Override
	public LocalDateTime getCreatedTimestamp() {
		return sendEvent.getCreatedTimestamp();
	}

	@Override
	public List<InvoiceModel> getInvoices() {
		return sendEvent.getInvoices().stream().map(f -> new InvoiceAdapter(session, organization, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoices(List<InvoiceModel> invoices) {
		List<InvoiceEntity> entities = invoices.stream().map(f -> InvoiceAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		sendEvent.setInvoices(entities);

	}

	@Override
	public List<CreditNoteModel> getCreditNotes() {
		return sendEvent.getCreditNotes().stream().map(f -> new CreditNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setCreditNotes(List<CreditNoteModel> creditNotes) {
		List<CreditNoteEntity> entities = creditNotes.stream().map(f -> CreditNoteAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		sendEvent.setCreditNotes(entities);
	}

	@Override
	public List<DebitNoteModel> getDebitNotes() {
		return sendEvent.getDebitNotes().stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDebitNotes(List<DebitNoteModel> debitNotes) {
		List<DebitNoteEntity> entities = debitNotes.stream().map(f -> DebitNoteAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		sendEvent.setDebitNotes(entities);

	}

	@Override
	public void setCreatedTimestamp(LocalDateTime localDateTime) {
		sendEvent.setCreatedTimestamp(localDateTime);
	}

}
