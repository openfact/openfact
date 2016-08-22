package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.CertifiedEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 10/08/2016.
 */
public class JpaCertifiedProvider extends AbstractHibernateStorage implements CertifiedProvider {
	protected static final Logger logger = Logger.getLogger(JpaCertifiedProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaCertifiedProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public CertifiedModel addCertified(OrganizationModel organization, String alias, String password,
			LocalDate validity, boolean hasCertificate) {
		return addCertified(organization, OpenfactModelUtils.generateId(), alias, password, validity, hasCertificate);
	}

	private CertifiedModel addCertified(OrganizationModel organization, String id, String alias, String password,
			LocalDate validity, boolean hasCertificate) {
		if (id == null) {
			id = OpenfactModelUtils.generateId();
		}
		CertifiedEntity entity = new CertifiedEntity();
		entity.setAlias(alias);
		entity.setPassword(password);
		entity.setEnabled(true);
		entity.setLocal(false);
		entity.setValidity(validity);
		entity.setHasCertificate(hasCertificate);
		entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(entity);
		em.flush();
		return new CertifiedAdapter(organization, entity, em, session);
	}

	private List<CertifiedEntity> getCertifiedsEnabled(OrganizationModel organization) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("getEnabledCertifiedByOrganization",
				CertifiedEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("enabled", true);
		List<CertifiedEntity> results = query.getResultList();
		return results;

	}

	@Override
	public CertifiedModel getCertifiedById(String id, OrganizationModel organization) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("getOrganizationCertifiedById", CertifiedEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<CertifiedEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new CertifiedAdapter(organization, entities.get(0), em, session);
	}

	@Override
	public CertifiedModel getCertifiedByAliasAndValidity(String alias, LocalDate validity,
			OrganizationModel organization) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("getOrganizationCertifiedByAliasAndValidity",
				CertifiedEntity.class);
		query.setParameter("alias", alias);
		query.setParameter("validity", validity);
		query.setParameter("organizationId", organization.getId());
		List<CertifiedEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new CertifiedAdapter(organization, entities.get(0), em, session);
	}

	private void removeCertified(CertifiedEntity certifiedEntity) {
		String id = certifiedEntity.getId();
		certifiedEntity = em.find(CertifiedEntity.class, id);
		if (certifiedEntity != null) {
			em.remove(certifiedEntity);
		}
		em.flush();
	}

	@Override
	public boolean removeCertified(OrganizationModel organization, CertifiedModel certified) {
		CertifiedEntity certifiedEntity = em.find(CertifiedEntity.class, certified.getId());
		if (certifiedEntity == null) {
			return false;
		}
		removeCertified(certifiedEntity);
		return true;
	}

	@Override
	public List<CertifiedModel> getCertifieds(OrganizationModel organization, Integer firstResult, Integer maxResults) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("getAllCertifiedsByOrganization",
				CertifiedEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<CertifiedEntity> results = query.getResultList();
		List<CertifiedModel> certified = new ArrayList<>();
		results.forEach(f -> certified.add(new CertifiedAdapter(organization, f, em, session)));
		return certified;
	}

	@Override
	public List<CertifiedModel> searchForCertified(String filterText, OrganizationModel organization,
			Integer firstResult, Integer maxResults) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("searchForCertified", CertifiedEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("filterText", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<CertifiedEntity> results = query.getResultList();
		List<CertifiedModel> certified = new ArrayList<>();
		results.forEach(f -> certified.add(new CertifiedAdapter(organization, f, em, session)));
		return certified;
	}

	@Override
	public List<CertifiedModel> searchForCertifiedByAttributes(Map<String, String> attributes,
			OrganizationModel organization) {
		return searchForCertifiedByAttributes(attributes, organization, -1, -1);
	}

	@Override
	public List<CertifiedModel> searchForCertifiedByAttributes(Map<String, String> attributes,
			OrganizationModel organization, Integer firstResult, Integer maxResults) {
		StringBuilder builder = new StringBuilder(
				"select i from CertifiedEntity i where u.organizationId = :organizationId");
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			String attribute = null;
			String parameterName = null;
			/*
			 * implementation
			 */

			if (attribute == null)
				continue;
			builder.append(" and ");
			builder.append(attribute).append(" like :").append(parameterName);
		}
		builder.append(" order by i.id");
		String q = builder.toString();
		TypedQuery<CertifiedEntity> query = em.createQuery(q, CertifiedEntity.class);
		query.setParameter("organizationId", organization.getId());
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			String parameterName = null;
			/*
			 * implementation
			 */

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
		List<CertifiedEntity> results = query.getResultList();
		List<CertifiedModel> invoices = new ArrayList<>();
		results.forEach(f -> invoices.add(new CertifiedAdapter(organization, f, em, session)));
		return invoices;
	}

	@Override
	public SearchResultsModel<CertifiedModel> search(OrganizationModel organization, SearchCriteriaModel criteria) {
		SearchResultsModel<CertifiedEntity> entityResult = find(criteria, CertifiedEntity.class);
		List<CertifiedEntity> entities = entityResult.getModels();

		SearchResultsModel<CertifiedModel> searchResult = new SearchResultsModel<>();
		List<CertifiedModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new CertifiedAdapter(organization, f, em, session)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<CertifiedModel> search(OrganizationModel organization, SearchCriteriaModel criteria,
			String filterText) {
		SearchResultsModel<CertifiedEntity> entityResult = findFullText(criteria, CertifiedEntity.class, filterText);
		List<CertifiedEntity> entities = entityResult.getModels();

		SearchResultsModel<CertifiedModel> searchResult = new SearchResultsModel<>();
		List<CertifiedModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new CertifiedAdapter(organization, f, em, session)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public void close() {
		System.out.printf("End operation on JpaCertifiedProvider");
	}

	@Override
	public CertifiedModel getCertifiedEnabled(OrganizationModel organization) {
		TypedQuery<CertifiedEntity> query = em.createNamedQuery("getEnabledCertifiedByOrganization",
				CertifiedEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("enabled", true);
		List<CertifiedEntity> results = query.getResultList();
		if (results.size() > 1) {
			throw new ModelDuplicateException("Exists more than one enable certfieds");
		} else if (!results.isEmpty()) {
			return new CertifiedAdapter(organization, results.get(0), em, session);
		} else {
			return null;
		}
	}
}
