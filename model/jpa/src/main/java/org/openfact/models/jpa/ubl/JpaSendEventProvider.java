package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.entities.ubl.CreditNoteSendEventEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteSendEventEntity;
import org.openfact.models.jpa.entities.ubl.InvoiceSendEventEntity;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.ubl.UblSendEventProvider;
import org.openfact.ubl.UblSenderException;

public class JpaSendEventProvider extends AbstractHibernateStorage implements UblSendEventProvider {

	protected static final Logger logger = Logger.getLogger(JpaSendEventProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaSendEventProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public SendEventModel addInvoiceSendEvent(OrganizationModel organization, InvoiceModel invoice, byte[] xmlSubmitted,
			byte[] response, boolean isAccepted) throws UblSenderException {
		InvoiceSendEventEntity sendEventEntity = new InvoiceSendEventEntity();
		sendEventEntity.setInvoices(Arrays.asList(InvoiceAdapter.toEntity(invoice, em)));
		sendEventEntity.setXmlDoument(xmlSubmitted);
		if (response != null) {
			sendEventEntity.setDocumentResponse(response);
		}
		sendEventEntity.setID(invoice.getID());
		sendEventEntity.setAccepted(isAccepted);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new InvoiceSendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public SendEventModel addCreditNoteSendEvent(OrganizationModel organization, CreditNoteModel creditNote,
			byte[] xmlSubmitted, byte[] response, boolean isAccepted) throws UblSenderException {
		CreditNoteSendEventEntity sendEventEntity = new CreditNoteSendEventEntity();
		sendEventEntity.setCreditNotes(Arrays.asList(CreditNoteAdapter.toEntity(creditNote, em)));
		sendEventEntity.setXmlDoument(xmlSubmitted);
		if (response != null) {
			sendEventEntity.setDocumentResponse(response);
		}
		sendEventEntity.setID(creditNote.getID());
		sendEventEntity.setAccepted(isAccepted);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new CreditNoteSendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public SendEventModel addDebitNoteSendEvent(OrganizationModel organization, DebitNoteModel debitNote,
			byte[] xmlSubmitted, byte[] response, boolean isAccepted) throws UblSenderException {
		DebitNoteSendEventEntity sendEventEntity = new DebitNoteSendEventEntity();
		sendEventEntity.setDebitNotes(Arrays.asList(DebitNoteAdapter.toEntity(debitNote, em)));
		sendEventEntity.setXmlDoument(xmlSubmitted);
		if (response != null) {
			sendEventEntity.setDocumentResponse(response);
		}
		sendEventEntity.setID(debitNote.getID());
		sendEventEntity.setAccepted(isAccepted);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new DebitNoteSendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public List<SendEventModel> getInvoiceSendEvents(OrganizationModel organization, InvoiceModel invoice)
			throws UblSenderException {
		String queryName = "getAllSendEventsByInvoice";
		TypedQuery<InvoiceSendEventEntity> query = em.createNamedQuery(queryName, InvoiceSendEventEntity.class);
		query.setParameter("invoiceId", invoice.getId());

		List<InvoiceSendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream()
				.map(f -> new InvoiceSendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	public List<SendEventModel> getCreditNoteSendEvents(OrganizationModel organization, CreditNoteModel creditNote)
			throws UblSenderException {
		String queryName = "getAllSendEventsByCreditNote";
		TypedQuery<CreditNoteSendEventEntity> query = em.createNamedQuery(queryName, CreditNoteSendEventEntity.class);
		query.setParameter("creditNoteId", creditNote.getId());

		List<CreditNoteSendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream()
				.map(f -> new CreditNoteSendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	public List<SendEventModel> getDebitNoteSendEvents(OrganizationModel organization, DebitNoteModel debitNote)
			throws UblSenderException {
		String queryName = "getAllSendEventsByDebitNote";
		TypedQuery<DebitNoteSendEventEntity> query = em.createNamedQuery(queryName, DebitNoteSendEventEntity.class);
		query.setParameter("debitNoteId", debitNote.getId());

		List<DebitNoteSendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream()
				.map(f -> new DebitNoteSendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
