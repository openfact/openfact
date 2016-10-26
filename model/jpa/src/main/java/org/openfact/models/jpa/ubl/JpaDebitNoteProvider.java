package org.openfact.models.jpa.ubl;

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
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.provider.DebitNoteProvider;

public class JpaDebitNoteProvider extends AbstractHibernateStorage implements DebitNoteProvider {

	protected static final Logger logger = Logger.getLogger(JpaDebitNoteProvider.class);

	private static final String ID = "ID";
	private static final String ISSUE_DATETIME = "issueDateTime";

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaDebitNoteProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public DebitNoteModel addDebitNote(OrganizationModel organization, String ID) {
		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.debitNotes().getDebitNoteByID(organization, ID) != null) {
			throw new ModelDuplicateException("Debit note ID existed");
		}

		DebitNoteEntity creditNote = new DebitNoteEntity();
		creditNote.setID(ID);
		creditNote.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(creditNote);
		em.flush();

		final DebitNoteModel adapter = new DebitNoteAdapter(session, organization, em, creditNote);
		session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNoteCreationEvent() {
			@Override
			public DebitNoteModel getCreatedDebitNote() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public DebitNoteModel getDebitNoteById(OrganizationModel organization, String id) {
		TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getOrganizationDebitNoteById", DebitNoteEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<DebitNoteEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new DebitNoteAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
		TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getOrganizationDebitNoteByID", DebitNoteEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<DebitNoteEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new DebitNoteAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeDebitNote(OrganizationModel organization, String id) {
		return removeDebitNote(organization, getDebitNoteById(organization, id));
	}

	@Override
	public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel creditNote) {
		DebitNoteEntity creditNoteEntity = em.find(DebitNoteEntity.class, creditNote.getId());
		if (creditNoteEntity == null)
			return false;
		removeDebitNote(creditNoteEntity);
		session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNoteRemovedEvent() {
			@Override
			public DebitNoteModel getDebitNote() {
				return creditNote;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removeDebitNote(DebitNoteEntity creditNote) {
		String id = creditNote.getId();
		creditNote = em.find(DebitNoteEntity.class, id);
		if (creditNote != null) {
			em.remove(creditNote);
		}

		em.flush();
	}

	@Override
	public List<DebitNoteModel> getDebitNotes(OrganizationModel organization) {
		return getDebitNotes(organization, -1, -1);
	}

	@Override
	public List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult, Integer maxResults) {
		String queryName = "getAllDebitNotesByOrganization";

		TypedQuery<DebitNoteEntity> query = em.createNamedQuery(queryName, DebitNoteEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<DebitNoteEntity> results = query.getResultList();
		List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return creditNotes;
	}

	@Override
	public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText) {
		return searchForDebitNote(organization, filterText, -1, -1);
	}

	@Override
	public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText,
			Integer firstResult, Integer maxResults) {
		TypedQuery<DebitNoteEntity> query = em.createNamedQuery("searchForDebitNote", DebitNoteEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<DebitNoteEntity> results = query.getResultList();
		List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return creditNotes;
	}

	@Override
	public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<DebitNoteEntity> entityResult = find(criteria, DebitNoteEntity.class);
		List<DebitNoteEntity> entities = entityResult.getModels();

		SearchResultsModel<DebitNoteModel> searchResult = new SearchResultsModel<>();
		List<DebitNoteModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new DebitNoteAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<DebitNoteEntity> entityResult = findFullText(criteria, DebitNoteEntity.class, filterText,
				ID);
		List<DebitNoteEntity> entities = entityResult.getModels();

		SearchResultsModel<DebitNoteModel> searchResult = new SearchResultsModel<>();
		List<DebitNoteModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new DebitNoteAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getDebitNotesCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationDebitNoteCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public DebitNoteModel getLastDebitNote(OrganizationModel organization, int IDDebitNoteLength, String maskFormater) {
		TypedQuery<DebitNoteEntity> query = em.createNamedQuery("getLastDebitNoteByOrganization",
				DebitNoteEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDDebitNoteLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<DebitNoteEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new DebitNoteAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<DebitNoteModel> getDebitNotes(OrganizationModel organization,
			List<RequeridActionDocument> requeridAction, boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from DebitNoteEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
		} else {
			queryName = "select i from DebitNoteEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
		}
		TypedQuery<DebitNoteEntity> query = em.createQuery(queryName, DebitNoteEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<DebitNoteEntity> results = query.getResultList();
		List<DebitNoteModel> creditNotes = results.stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
		return creditNotes;
	}

}
