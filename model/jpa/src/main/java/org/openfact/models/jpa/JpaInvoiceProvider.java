package org.openfact.models.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceModel.RequiredAction;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.InvoiceAttributeEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.InvoiceRequiredActionEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaInvoiceProvider extends AbstractHibernateStorage implements InvoiceProvider {

	protected static final Logger logger = Logger.getLogger(JpaInvoiceProvider.class);

	private static final String TYPE = "type";
	private static final String CURRENCY_CODE = "currencyCode";

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
	protected EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public InvoiceModel addInvoice(OrganizationModel organization) {
		return addInvoice(organization, -1, -1);
	}

	@Override
	public InvoiceModel addInvoice(OrganizationModel organization, int series, int number) {
		if (series == -1 && number == -1) {
			Query querySet = em.createNamedQuery("getLastInvoiceIdSeriesByOrganization");
			querySet.setParameter("organizationId", organization.getId());
			Number lastSeries = (Number) querySet.getSingleResult();
			series = lastSeries != null ? lastSeries.intValue() : 0;

			Query queryNumber = em.createNamedQuery("getLastInvoiceIdNumberOfSeriesByOrganization");
			queryNumber.setParameter("organizationId", organization.getId());
			queryNumber.setParameter("series", lastSeries);
			Number lastNumber = (Number) queryNumber.getSingleResult();
			number = lastNumber != null ? lastNumber.intValue() : 0;

			if (series == 0) {
				series++;
			}
			if (number < organization.getMaxInvoiceNumber()) {
				number++;
			} else {
				number = 1;
				series++;
			}
		}

		if (session.invoices().getInvoiceBySeriesAndNumber(series, number, organization) != null) {
			throw new ModelDuplicateException("Invoice series and number existed");
		}

		// Create invoice
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setSeries(series);
		invoiceEntity.setNumber(number);	
		invoiceEntity.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(invoiceEntity);		
		em.flush();
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setInvoice(invoiceEntity);
		em.persist(customerEntity);
		em.flush();
		
		invoiceEntity.setCustomer(customerEntity);

		InvoiceAdapter invoice = new InvoiceAdapter(session, organization, em, invoiceEntity);
		
        session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoiceCreationEvent() {
            @Override
            public InvoiceModel getCreatedInvoice() {
                return invoice;
            }
        });
        return invoice;
	}

	@Override
	public InvoiceModel getInvoiceById(String id, OrganizationModel organization) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceById", InvoiceEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<InvoiceEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new InvoiceAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
		InvoiceEntity invoiceEntity = em.find(InvoiceEntity.class, invoice.getId());
		if (invoiceEntity == null) {
			return false;
		}
		em.remove(invoiceEntity);
		
		em.flush();
		em.clear();
		
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

	@Override
	public InvoiceModel getInvoiceBySeriesAndNumber(int series, int number, OrganizationModel organization) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceBySetAndNumber", InvoiceEntity.class);
		query.setParameter("series", series);
		query.setParameter("number", number);
		query.setParameter("organizationId", organization.getId());
		List<InvoiceEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new InvoiceAdapter(session, organization, em, entities.get(0));
	}
	
	@Override
    public List<InvoiceModel> searchForInvoiceByRequiredAction(String action) {
	    TypedQuery<InvoiceRequiredActionEntity> query = em.createNamedQuery("getInvoiceRequiredActionsByActionName", InvoiceRequiredActionEntity.class);
        query.setParameter("actionName", action);
        List<InvoiceRequiredActionEntity> results = query.getResultList();

        List<InvoiceModel> invoices = new ArrayList<>();
        for (InvoiceRequiredActionEntity entity : results) {
            InvoiceEntity invoice = entity.getInvoice();
            OrganizationModel organization = new OrganizationAdapter(session, em, invoice.getOrganization());
            invoices.add(new InvoiceAdapter(session, organization, em, invoice));
        }
        return invoices;
    }
	
    @Override
    public List<InvoiceModel> searchForInvoiceByRequiredAction(RequiredAction action) {
        return searchForInvoiceByRequiredAction(action.toString());
    }
    
    @Override
    public List<InvoiceModel> searchForInvoiceByRequiredAction(String action, OrganizationModel organization) {
        TypedQuery<InvoiceRequiredActionEntity> query = em.createNamedQuery("getInvoiceRequiredActionsByActionNameAndOrganization", InvoiceRequiredActionEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("actionName", action);
        List<InvoiceRequiredActionEntity> results = query.getResultList();

        List<InvoiceModel> invoices = new ArrayList<>();
        for (InvoiceRequiredActionEntity entity : results) {
            InvoiceEntity invoice = entity.getInvoice();
            invoices.add(new InvoiceAdapter(session, organization, em, invoice));
        }
        return invoices;
    }
    
    @Override
    public List<InvoiceModel> searchForInvoiceByRequiredAction(RequiredAction action, OrganizationModel organization) {
        return searchForInvoiceByRequiredAction(action.toString(), organization);
    }

	@Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization) {
        return getInvoices(organization, -1, -1);
    }
	
	@Override
	public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("getAllInvoicesByOrganization", InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = new ArrayList<>();
		results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
		return invoices;
	}
	
	@Override
    public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization) {
	    return searchForInvoice(filterText, organization, -1, -1);
    }
	
	@Override
	public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults) {
		TypedQuery<InvoiceEntity> query = em.createNamedQuery("searchForInvoice", InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("filterText", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = new ArrayList<>();
		results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
		return invoices;
	}

	@Override
    public List<InvoiceModel> searchForInvoiceByAttribute(String key, String value, OrganizationModel organization) {
	    TypedQuery<InvoiceAttributeEntity> query = em.createNamedQuery("getAttributesByNameAndValue", InvoiceAttributeEntity.class);
        query.setParameter("name", key);
        query.setParameter("value", value);
        List<InvoiceAttributeEntity> results = query.getResultList();

        List<InvoiceModel> users = new ArrayList<InvoiceModel>();
        for (InvoiceAttributeEntity attr : results) {
            InvoiceEntity invoice = attr.getInvoice();
            users.add(new InvoiceAdapter(session, organization, em, invoice));
        }
        return users;
    }
	
	@Override
	public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization) {
		return searchForInvoiceByAttributes(attributes, organization, -1, -1);
	}

	@Override
	public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults) {
		StringBuilder builder = new StringBuilder("select i from InvoiceEntity i where u.organizationId = :organizationId");
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			String attribute = null;
			String parameterName = null;
			if (entry.getKey().equals(InvoiceModel.TYPE)) {
				attribute = "lower(i.type)";
				parameterName = JpaInvoiceProvider.TYPE;
			} else if (entry.getKey().equalsIgnoreCase(InvoiceModel.CURRENCY_CODE)) {
				attribute = "lower(i.currencyCode)";
				parameterName = JpaInvoiceProvider.CURRENCY_CODE;
			}
			if (attribute == null)
				continue;
			builder.append(" and ");
			builder.append(attribute).append(" like :").append(parameterName);
		}
		builder.append(" order by i.id");
		String q = builder.toString();
		TypedQuery<InvoiceEntity> query = em.createQuery(q, InvoiceEntity.class);
		query.setParameter("organizationId", organization.getId());
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			String parameterName = null;
			if (entry.getKey().equals(InvoiceModel.TYPE)) {
				parameterName = JpaInvoiceProvider.TYPE;
			} else if (entry.getKey().equalsIgnoreCase(InvoiceModel.CURRENCY_CODE)) {
				parameterName = JpaInvoiceProvider.CURRENCY_CODE;
			}
			if (parameterName == null)
				continue;
			query.setParameter(parameterName, "%" + entry.getValue().toLowerCase() + "%");
		}
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<InvoiceEntity> results = query.getResultList();
		List<InvoiceModel> invoices = new ArrayList<>();
		results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
		return invoices;
	}

	@Override
	public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria) {
		SearchResultsModel<InvoiceEntity> entityResult = find(criteria, InvoiceEntity.class);
		List<InvoiceEntity> entities = entityResult.getModels();

		SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
		List<InvoiceModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<InvoiceEntity> entityResult = findFullText(criteria, InvoiceEntity.class, filterText, TYPE, CURRENCY_CODE);
		List<InvoiceEntity> entities = entityResult.getModels();

		SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
		List<InvoiceModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

    @Override
    public int getInvoicesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

}
