package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.jpa.entities.ubl.SendEventEntity;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.models.ubl.provider.SendEventProvider;

public class JpaSendEventProvider extends AbstractHibernateStorage implements SendEventProvider {

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
	public SendEventModel addEvent(OrganizationModel organization, List<InvoiceModel> invoices, byte[] xmlDocument,
			byte[] eventDocument, boolean isError, Map<String, String> sendWarning) {

		SendEventEntity sendEventEntity = new SendEventEntity();
		List<InvoiceEntity> entities = new ArrayList<>();
		for (InvoiceModel invoice : invoices) {
			entities.add(InvoiceAdapter.toEntity(invoice, em));
		}
		sendEventEntity.setInvoices(entities);
		sendEventEntity.setXmlDocument(xmlDocument);
		if (eventDocument != null) {
			sendEventEntity.setEventDocument(eventDocument);
		}
		sendEventEntity.setError(isError);
		sendEventEntity.setSendWarning(sendWarning);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new SendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public SendEventModel addEvent(OrganizationModel organization, DebitNoteModel debitNote, byte[] xmlDocument,
			byte[] eventDocument, boolean isError, Map<String, String> sendWarning) {
		SendEventEntity sendEventEntity = new SendEventEntity();
		sendEventEntity.setDebitNotes(Arrays.asList(DebitNoteAdapter.toEntity(debitNote, em)));
		sendEventEntity.setXmlDocument(xmlDocument);
		if (eventDocument != null) {
			sendEventEntity.setEventDocument(eventDocument);
		}
		sendEventEntity.setError(isError);
		sendEventEntity.setSendWarning(sendWarning);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new SendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public SendEventModel addEvent(OrganizationModel organization, CreditNoteModel creditNote, byte[] xmlDocument,
			byte[] eventDocument, boolean isError, Map<String, String> sendWarning) {
		SendEventEntity sendEventEntity = new SendEventEntity();
		sendEventEntity.setCreditNotes(Arrays.asList(CreditNoteAdapter.toEntity(creditNote, em)));
		sendEventEntity.setXmlDocument(xmlDocument);
		if (eventDocument != null) {
			sendEventEntity.setEventDocument(eventDocument);
		}
		sendEventEntity.setError(isError);
		sendEventEntity.setSendWarning(sendWarning);
		sendEventEntity.setCreatedTimestamp(LocalDateTime.now());
		em.persist(sendEventEntity);
		em.flush();
		final SendEventModel adapter = new SendEventAdapter(session, organization, em, sendEventEntity);
		return adapter;
	}

	@Override
	public List<SendEventModel> getEvents(OrganizationModel organization, InvoiceModel invoice) {
		String queryName = "getAllSendEventsByInvoice";
		TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
		query.setParameter("invoiceId", invoice.getId());

		List<SendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream().map(f -> new SendEventAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	public List<SendEventModel> getEvents(OrganizationModel organization, DebitNoteModel debitNote) {
		String queryName = "getAllSendEventsByDebitNote";
		TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
		query.setParameter("debitNoteId", debitNote.getId());

		List<SendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream().map(f -> new SendEventAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	public List<SendEventModel> getEvents(OrganizationModel organization, CreditNoteModel creditNote) {
		String queryName = "getAllSendEventsByCreditNote";
		TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
		query.setParameter("creditNoteId", creditNote.getId());

		List<SendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream().map(f -> new SendEventAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
