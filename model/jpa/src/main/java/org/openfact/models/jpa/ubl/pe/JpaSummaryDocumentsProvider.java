package org.openfact.models.jpa.ubl.pe;

import java.util.List;
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
import org.openfact.models.jpa.entities.ubl.pe.SummaryDocumentsEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.SummaryDocumentsModel;
import org.openfact.models.ubl.provider.pe.SummaryDocumentsProvider;

public class JpaSummaryDocumentsProvider extends AbstractHibernateStorage implements SummaryDocumentsProvider {

	protected static final Logger logger = Logger.getLogger(JpaSummaryDocumentsProvider.class);

	private static final String ID = "ID";
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaSummaryDocumentsProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public SummaryDocumentsModel addSummaryDocuments(OrganizationModel organization, String ID) {
		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.summaryDocuments().getSummaryDocumentsByID(organization, ID) != null) {
			throw new ModelDuplicateException("Credit note ID existed");
		}

		SummaryDocumentsEntity summaryDocuments = new SummaryDocumentsEntity();
		summaryDocuments.setID(ID);
		summaryDocuments.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(summaryDocuments);
		em.flush();

		final SummaryDocumentsModel adapter = new SummaryDocumentsAdapter(session, organization, em, summaryDocuments);
		session.getOpenfactSessionFactory().publish(new SummaryDocumentsModel.SummaryDocumentsCreationEvent() {
			@Override
			public SummaryDocumentsModel getCreatedSummaryDocuments() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public SummaryDocumentsModel getSummaryDocumentsById(OrganizationModel organization, String id) {
		TypedQuery<SummaryDocumentsEntity> query = em.createNamedQuery("getOrganizationSummaryDocumentsById",
				SummaryDocumentsEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<SummaryDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new SummaryDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public SummaryDocumentsModel getSummaryDocumentsByID(OrganizationModel organization, String ID) {
		TypedQuery<SummaryDocumentsEntity> query = em.createNamedQuery("getOrganizationSummaryDocumentsByID",
				SummaryDocumentsEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<SummaryDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new SummaryDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeSummaryDocuments(OrganizationModel organization, String id) {
		return removeSummaryDocuments(organization, getSummaryDocumentsById(organization, id));
	}

	@Override
	public boolean removeSummaryDocuments(OrganizationModel organization, SummaryDocumentsModel summaryDocuments) {
		SummaryDocumentsEntity summaryDocumentsEntity = em.find(SummaryDocumentsEntity.class, summaryDocuments.getId());
		if (summaryDocumentsEntity == null)
			return false;
		removeSummaryDocuments(summaryDocumentsEntity);
		session.getOpenfactSessionFactory().publish(new SummaryDocumentsModel.SummaryDocumentsRemovedEvent() {
			@Override
			public SummaryDocumentsModel getSummaryDocuments() {
				return summaryDocuments;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removeSummaryDocuments(SummaryDocumentsEntity summaryDocuments) {
		String id = summaryDocuments.getId();
		summaryDocuments = em.find(SummaryDocumentsEntity.class, id);
		if (summaryDocuments != null) {
			em.remove(summaryDocuments);
		}

		em.flush();
	}

	@Override
	public List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization) {
		return getSummaryDocumentss(organization, -1, -1);
	}

	@Override
	public List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization, Integer firstResult,
			Integer maxResults) {
		String queryName = "getAllSummaryDocumentsByOrganization";

		TypedQuery<SummaryDocumentsEntity> query = em.createNamedQuery(queryName, SummaryDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<SummaryDocumentsEntity> results = query.getResultList();
		List<SummaryDocumentsModel> summaryDocumentss = results.stream()
				.map(f -> new SummaryDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return summaryDocumentss;
	}

	@Override
	public List<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization, String filterText) {
		return searchForSummaryDocuments(organization, filterText, -1, -1);
	}

	@Override
	public List<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization, String filterText,
			Integer firstResult, Integer maxResults) {
		TypedQuery<SummaryDocumentsEntity> query = em.createNamedQuery("searchForSummaryDocuments", SummaryDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<SummaryDocumentsEntity> results = query.getResultList();
		List<SummaryDocumentsModel> summaryDocumentss = results.stream()
				.map(f -> new SummaryDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return summaryDocumentss;
	}

	@Override
	public SearchResultsModel<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<SummaryDocumentsEntity> entityResult = find(criteria, SummaryDocumentsEntity.class);
		List<SummaryDocumentsEntity> entities = entityResult.getModels();

		SearchResultsModel<SummaryDocumentsModel> searchResult = new SearchResultsModel<>();
		List<SummaryDocumentsModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new SummaryDocumentsAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<SummaryDocumentsEntity> entityResult = findFullText(criteria, SummaryDocumentsEntity.class, filterText,
				ID);
		List<SummaryDocumentsEntity> entities = entityResult.getModels();

		SearchResultsModel<SummaryDocumentsModel> searchResult = new SearchResultsModel<>();
		List<SummaryDocumentsModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new SummaryDocumentsAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getSummaryDocumentssCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationSummaryDocumentsCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public SummaryDocumentsModel getLastSummaryDocuments(OrganizationModel organization, int IDSummaryDocumentsLength,
			String maskFormater) {
		TypedQuery<SummaryDocumentsEntity> query = em.createNamedQuery("getLastSummaryDocumentsByOrganization",
				SummaryDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDSummaryDocumentsLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<SummaryDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new SummaryDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization,
			List<RequeridActionDocument> requeridAction, boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from SummaryDocumentsEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
		} else {
			queryName = "select i from SummaryDocumentsEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
		}
		TypedQuery<SummaryDocumentsEntity> query = em.createQuery(queryName, SummaryDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<SummaryDocumentsEntity> results = query.getResultList();
		List<SummaryDocumentsModel> summaryDocumentss = results.stream()
				.map(f -> new SummaryDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return summaryDocumentss;
	}

}
