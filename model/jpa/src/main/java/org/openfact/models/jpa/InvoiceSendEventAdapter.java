package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceSendEventModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.InvoiceSendEventEntity;

public class InvoiceSendEventAdapter implements InvoiceSendEventModel, JpaModel<InvoiceSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(InvoiceSendEventAdapter.class);

	protected OrganizationModel organization;
	protected InvoiceSendEventEntity invoiceSendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public InvoiceSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			InvoiceSendEventEntity invoiceSendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.invoiceSendEvent = invoiceSendEvent;
	}

	@Override
	public String getId() {
		return invoiceSendEvent.getId();
	}

	@Override
	public boolean getResult() {
		return invoiceSendEvent.isResult();
	}

	@Override
	public void setResult(boolean result) {
		invoiceSendEvent.setResult(result);
	}

	@Override
	public String getDescription() {
		return invoiceSendEvent.getDescription();
	}

	@Override
	public void setDescription(String description) {
		invoiceSendEvent.setDescription(description);
	}

	@Override
	public OrganizationModel getOrganization() {
		if (invoiceSendEvent.getOrganization() == null) {
			return null;
		}
		return new OrganizationAdapter(session, em, invoiceSendEvent.getOrganization());
	}

	@Override
	public InvoiceSendEventEntity getEntity() {
		return invoiceSendEvent;
	}

	@Override
	public InvoiceModel getInvoice() {
		if (invoiceSendEvent.getInvoice() == null) {
			return null;
		}
		return new InvoiceAdapter(session, organization, em, invoiceSendEvent.getInvoice());
	}

	@Override
	public void setInvoice(InvoiceModel invoice) {
		invoiceSendEvent.setInvoice(InvoiceAdapter.toEntity(invoice, em));
	}

	public static InvoiceSendEventEntity toEntity(InvoiceSendEventModel model, EntityManager em) {
		if (model instanceof InvoiceSendEventAdapter) {
			return ((InvoiceSendEventAdapter) model).getEntity();
		}
		return em.getReference(InvoiceSendEventEntity.class, model.getId());
	}
}
