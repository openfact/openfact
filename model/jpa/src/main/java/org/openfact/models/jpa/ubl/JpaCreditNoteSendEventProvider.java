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
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.ubl.UblSendEventProvider;
import org.openfact.ubl.UblSenderException;

public class JpaCreditNoteSendEventProvider extends AbstractHibernateStorage implements UblSendEventProvider {

	protected static final Logger logger = Logger.getLogger(JpaCreditNoteSendEventProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaCreditNoteSendEventProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public SendEventModel addEvent(OrganizationModel organization, Object model, byte[] xmlSubmitted, byte[] response,
			boolean isAccepted) throws UblSenderException {
		CreditNoteModel creditNote = (CreditNoteModel) model;
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
	public List<SendEventModel> getEvents(OrganizationModel organization, Object model) throws UblSenderException {
		CreditNoteModel creditNote = (CreditNoteModel) model;
		String queryName = "getAllSendEventsByCreditNote";
		TypedQuery<CreditNoteSendEventEntity> query = em.createNamedQuery(queryName, CreditNoteSendEventEntity.class);
		query.setParameter("creditNoteId", creditNote.getId());

		List<CreditNoteSendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream()
				.map(f -> new CreditNoteSendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
