/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import org.openfact.models.jpa.entities.ubl.pe.RetentionEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.RetentionModel;
import org.openfact.models.ubl.provider.pe.RetentionProvider;

public class JpaRetentionProvider extends AbstractHibernateStorage implements RetentionProvider{

	protected static final Logger logger = Logger.getLogger(JpaRetentionProvider.class);

	private static final String ID = "ID";
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaRetentionProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	
	@Override
	public void close() {
		
	}

	@Override
	public RetentionModel addRetention(OrganizationModel organization, String ID) {
		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.retention().getRetentionByID(organization, ID) != null) {
			throw new ModelDuplicateException("Credit note ID existed");
		}

		RetentionEntity retention = new RetentionEntity();
		retention.setID(ID);
		retention.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(retention);
		em.flush();

		final RetentionModel adapter = new RetentionAdapter(session, organization, em, retention);
		session.getOpenfactSessionFactory().publish(new RetentionModel.RetentionCreationEvent() {
			@Override
			public RetentionModel getCreatedRetention() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public RetentionModel getRetentionById(OrganizationModel organization, String id) {
		TypedQuery<RetentionEntity> query = em.createNamedQuery("getOrganizationRetentionById",
				RetentionEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<RetentionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new RetentionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public RetentionModel getRetentionByID(OrganizationModel organization, String ID) {
		TypedQuery<RetentionEntity> query = em.createNamedQuery("getOrganizationRetentionByID",
				RetentionEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<RetentionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new RetentionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeRetention(OrganizationModel organization, String id) {
		return removeRetention(organization, getRetentionById(organization, id));
	}

	@Override
	public boolean removeRetention(OrganizationModel organization, RetentionModel retention) {
		RetentionEntity retentionEntity = em.find(RetentionEntity.class, retention.getId());
		if (retentionEntity == null)
			return false;
		removeRetention(retentionEntity);
		session.getOpenfactSessionFactory().publish(new RetentionModel.RetentionRemovedEvent() {
			@Override
			public RetentionModel getRetention() {
				return retention;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removeRetention(RetentionEntity retention) {
		String id = retention.getId();
		retention = em.find(RetentionEntity.class, id);
		if (retention != null) {
			em.remove(retention);
		}

		em.flush();
	}

	@Override
	public List<RetentionModel> getRetentions(OrganizationModel organization) {
		return getRetentions(organization, -1, -1);
	}

	@Override
	public List<RetentionModel> getRetentions(OrganizationModel organization, Integer firstResult,
			Integer maxResults) {
		String queryName = "getAllRetentionsByOrganization";

		TypedQuery<RetentionEntity> query = em.createNamedQuery(queryName, RetentionEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<RetentionEntity> results = query.getResultList();
		List<RetentionModel> retentions = results.stream()
				.map(f -> new RetentionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return retentions;
	}

	@Override
	public List<RetentionModel> searchForRetention(OrganizationModel organization, String filterText) {
		return searchForRetention(organization, filterText, -1, -1);
	}

	@Override
	public List<RetentionModel> searchForRetention(OrganizationModel organization, String filterText,
			Integer firstResult, Integer maxResults) {
		TypedQuery<RetentionEntity> query = em.createNamedQuery("searchForRetention", RetentionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<RetentionEntity> results = query.getResultList();
		List<RetentionModel> retentions = results.stream()
				.map(f -> new RetentionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return retentions;
	}

	@Override
	public SearchResultsModel<RetentionModel> searchForRetention(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<RetentionEntity> entityResult = find(criteria, RetentionEntity.class);
		List<RetentionEntity> entities = entityResult.getModels();

		SearchResultsModel<RetentionModel> searchResult = new SearchResultsModel<>();
		List<RetentionModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new RetentionAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<RetentionModel> searchForRetention(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<RetentionEntity> entityResult = findFullText(criteria, RetentionEntity.class, filterText,
				ID);
		List<RetentionEntity> entities = entityResult.getModels();

		SearchResultsModel<RetentionModel> searchResult = new SearchResultsModel<>();
		List<RetentionModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new RetentionAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getRetentionsCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationRetentionCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public RetentionModel getLastRetention(OrganizationModel organization, int IDRetentionLength,
			String maskFormater) {
		TypedQuery<RetentionEntity> query = em.createNamedQuery("getLastRetentionByOrganization",
				RetentionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDRetentionLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<RetentionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new RetentionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<RetentionModel> getRetentions(OrganizationModel organization,
			List<RequeridActionDocument> requeridAction, boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from RetentionEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
		} else {
			queryName = "select i from RetentionEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
		}
		TypedQuery<RetentionEntity> query = em.createQuery(queryName, RetentionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<RetentionEntity> results = query.getResultList();
		List<RetentionModel> retentions = results.stream()
				.map(f -> new RetentionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return retentions;
	}

}
