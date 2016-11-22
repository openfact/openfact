package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
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
import org.openfact.models.jpa.entities.ubl.CreditNoteSendEventEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteSendEventEntity;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.ubl.UblSendEventProvider;
import org.openfact.ubl.UblSenderException;

public class JpaDebitNoteSendEventProvider extends AbstractHibernateStorage implements UblSendEventProvider {

	protected static final Logger logger = Logger.getLogger(JpaDebitNoteSendEventProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaDebitNoteSendEventProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public SendEventModel addEvent(OrganizationModel organization, Object model, byte[] xmlSubmitted, byte[] response,
			boolean isAccepted) throws UblSenderException {
		DebitNoteModel debitNote = (DebitNoteModel) model;
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
	public List<SendEventModel> getEvents(OrganizationModel organization, Object model) throws UblSenderException {
		DebitNoteModel debitNote = (DebitNoteModel) model;
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
