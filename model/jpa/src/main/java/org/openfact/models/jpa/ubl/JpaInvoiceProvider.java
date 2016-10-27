package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.jpa.entities.ubl.SendEventEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.provider.InvoiceProvider;

public class JpaInvoiceProvider extends AbstractHibernateStorage implements InvoiceProvider {

	protected static final Logger logger = Logger.getLogger(JpaInvoiceProvider.class);

	private static final String ID = "ID";
	private static final String INVOICE_TYPE_CODE = "invoiceTypeCode";
	private static final String ISSUE_DATETIME = "issueDateTime";

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaInvoiceProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public InvoiceModel addInvoice(OrganizationModel organization, String ID) {
		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.invoices().getInvoiceByID(organization, ID) != null) {
			throw new ModelDuplicateException("Invoice ID existed");
		}

		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setID(ID);
		invoice.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(invoice);
		em.flush();

		final InvoiceModel adapter = new InvoiceAdapter(session, organization, em, invoice);
		session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoiceCreationEvent() {
			@Override
			public InvoiceModel getCreatedInvoice() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public InvoiceModel getInvoiceById(OrganizationModel organization, String id) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceById", InvoiceEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<InvoiceEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new InvoiceAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceByID", InvoiceEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<InvoiceEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new InvoiceAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeInvoice(OrganizationModel organization, String id) {
		return removeInvoice(organization, getInvoiceById(organization, id));
	}

	@Override
	public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
		InvoiceEntity invoiceEntity = em.find(InvoiceEntity.class, invoice.getId());
		if (invoiceEntity == null)
			return false;
		removeInvoice(invoiceEntity);
		session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoiceRemovedEvent() {
			@Override
			public InvoiceModel getInvoice() {
				return invoice;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removeInvoice(InvoiceEntity invoice) {
		String id = invoice.getId();
		invoice = em.find(InvoiceEntity.class, id);
		if (invoice != null) {
			em.remove(invoice);
		}

		em.flush();
	}

	@Override
	public List<InvoiceModel> getInvoices(OrganizationModel organization) {
		return getInvoices(organization, -1, -1);
	}

	@Override
	public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults) {
		String queryName = "getAllInvoicesByOrganization";

		TypedQuery<InvoiceEntity> query = em.createNamedQuery(queryName, InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = results.stream().map(f -> new InvoiceAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return invoices;
	}

	@Override
	public List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText) {
		return searchForInvoice(organization, filterText, -1, -1);
	}

	@Override
	public List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText, Integer firstResult,
			Integer maxResults) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("searchForInvoice", InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = results.stream().map(f -> new InvoiceAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return invoices;
	}

	@Override
	public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<InvoiceEntity> entityResult = find(criteria, InvoiceEntity.class);
		List<InvoiceEntity> entities = entityResult.getModels();

		SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
		List<InvoiceModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<InvoiceEntity> entityResult = findFullText(criteria, InvoiceEntity.class, filterText,
				INVOICE_TYPE_CODE, ID);
		List<InvoiceEntity> entities = entityResult.getModels();

		SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
		List<InvoiceModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getInvoicesCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationInvoiceCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public InvoiceModel getLastInvoice(OrganizationModel organization, int IDInvoiceLength, String maskFormater) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getLastInvoiceByOrganization", InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDInvoiceLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<InvoiceEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new InvoiceAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<InvoiceModel> getInvoices(OrganizationModel organization, List<RequeridActionDocument> requeridAction,
			boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from InvoiceEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.invoiceTypeCode ";
		} else {
			queryName = "select i from InvoiceEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.invoiceTypeCode ";
			
		}
		TypedQuery<InvoiceEntity> query = em.createQuery(queryName, InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = results.stream().map(f -> new InvoiceAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return invoices;
	}

}
