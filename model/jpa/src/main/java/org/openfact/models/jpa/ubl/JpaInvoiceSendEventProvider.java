package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.jpa.entities.ubl.InvoiceSendEventEntity;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.ubl.UblSendEventProvider;
import org.openfact.ubl.UblSenderException;

public class JpaInvoiceSendEventProvider extends AbstractHibernateStorage implements UblSendEventProvider {

	protected static final Logger logger = Logger.getLogger(JpaInvoiceSendEventProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaInvoiceSendEventProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public SendEventModel addEvent(OrganizationModel organization, Object model, byte[] xmlSubmitted, byte[] response,
			boolean isAccepted) throws UblSenderException {
		InvoiceSendEventEntity sendEventEntity = new InvoiceSendEventEntity();		
		InvoiceModel invoice = (InvoiceModel) model;
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
	public List<SendEventModel> getEvents(OrganizationModel organization, Object model) throws UblSenderException {
		InvoiceModel invoice = (InvoiceModel) model;
		String queryName = "getAllSendEventsByInvoice";
		TypedQuery<InvoiceSendEventEntity> query = em.createNamedQuery(queryName, InvoiceSendEventEntity.class);
		query.setParameter("invoiceId", invoice.getId());

		List<InvoiceSendEventEntity> results = query.getResultList();
		List<SendEventModel> sendEvents = results.stream()
				.map(f -> new InvoiceSendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
		return sendEvents;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
