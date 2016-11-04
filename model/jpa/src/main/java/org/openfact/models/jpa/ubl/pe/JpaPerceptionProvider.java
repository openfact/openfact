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
import org.openfact.models.jpa.entities.ubl.pe.PerceptionEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.PerceptionModel;
import org.openfact.models.ubl.provider.pe.PerceptionProvider;

public class JpaPerceptionProvider extends AbstractHibernateStorage implements PerceptionProvider {
	protected static final Logger logger = Logger.getLogger(JpaPerceptionProvider.class);

	private static final String ID = "ID";
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaPerceptionProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}
	

	@Override
	public PerceptionModel addPerception(OrganizationModel organization, String ID) {

		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.perception().getPerceptionByID(organization, ID) != null) {
			throw new ModelDuplicateException("Credit note ID existed");
		}

		PerceptionEntity perception = new PerceptionEntity();
		perception.setID(ID);
		perception.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(perception);
		em.flush();

		final PerceptionModel adapter = new PerceptionAdapter(session, organization, em, perception);
		session.getOpenfactSessionFactory().publish(new PerceptionModel.PerceptionCreationEvent() {
			@Override
			public PerceptionModel getCreatedPerception() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public PerceptionModel getPerceptionById(OrganizationModel organization, String id) {
		TypedQuery<PerceptionEntity> query = em.createNamedQuery("getOrganizationPerceptionById",
				PerceptionEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<PerceptionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new PerceptionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public PerceptionModel getPerceptionByID(OrganizationModel organization, String ID) {
		TypedQuery<PerceptionEntity> query = em.createNamedQuery("getOrganizationPerceptionByID",
				PerceptionEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<PerceptionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new PerceptionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removePerception(OrganizationModel organization, String id) {
		return removePerception(organization, getPerceptionById(organization, id));
	}

	@Override
	public boolean removePerception(OrganizationModel organization, PerceptionModel perception) {
		PerceptionEntity perceptionEntity = em.find(PerceptionEntity.class, perception.getId());
		if (perceptionEntity == null)
			return false;
		removePerception(perceptionEntity);
		session.getOpenfactSessionFactory().publish(new PerceptionModel.PerceptionRemovedEvent() {
			@Override
			public PerceptionModel getPerception() {
				return perception;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removePerception(PerceptionEntity perception) {
		String id = perception.getId();
		perception = em.find(PerceptionEntity.class, id);
		if (perception != null) {
			em.remove(perception);
		}

		em.flush();
	}

	@Override
	public List<PerceptionModel> getPerceptions(OrganizationModel organization) {
		return getPerceptions(organization, -1, -1);
	}

	@Override
	public List<PerceptionModel> getPerceptions(OrganizationModel organization, Integer firstResult,
			Integer maxResults) {
		String queryName = "getAllPerceptionsByOrganization";

		TypedQuery<PerceptionEntity> query = em.createNamedQuery(queryName, PerceptionEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<PerceptionEntity> results = query.getResultList();
		List<PerceptionModel> perceptions = results.stream()
				.map(f -> new PerceptionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return perceptions;
	}

	@Override
	public List<PerceptionModel> searchForPerception(OrganizationModel organization, String filterText) {
		return searchForPerception(organization, filterText, -1, -1);
	}

	@Override
	public List<PerceptionModel> searchForPerception(OrganizationModel organization, String filterText,
			Integer firstResult, Integer maxResults) {
		TypedQuery<PerceptionEntity> query = em.createNamedQuery("searchForPerception", PerceptionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<PerceptionEntity> results = query.getResultList();
		List<PerceptionModel> perceptions = results.stream()
				.map(f -> new PerceptionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return perceptions;
	}

	@Override
	public SearchResultsModel<PerceptionModel> searchForPerception(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<PerceptionEntity> entityResult = find(criteria, PerceptionEntity.class);
		List<PerceptionEntity> entities = entityResult.getModels();

		SearchResultsModel<PerceptionModel> searchResult = new SearchResultsModel<>();
		List<PerceptionModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new PerceptionAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<PerceptionModel> searchForPerception(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<PerceptionEntity> entityResult = findFullText(criteria, PerceptionEntity.class, filterText,
				ID);
		List<PerceptionEntity> entities = entityResult.getModels();

		SearchResultsModel<PerceptionModel> searchResult = new SearchResultsModel<>();
		List<PerceptionModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new PerceptionAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getPerceptionsCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationPerceptionCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public PerceptionModel getLastPerception(OrganizationModel organization, int IDPerceptionLength,
			String maskFormater) {
		TypedQuery<PerceptionEntity> query = em.createNamedQuery("getLastPerceptionByOrganization",
				PerceptionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDPerceptionLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<PerceptionEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new PerceptionAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<PerceptionModel> getPerceptions(OrganizationModel organization,
			List<RequeridActionDocument> requeridAction, boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from PerceptionEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
		} else {
			queryName = "select i from PerceptionEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
		}
		TypedQuery<PerceptionEntity> query = em.createQuery(queryName, PerceptionEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<PerceptionEntity> results = query.getResultList();
		List<PerceptionModel> perceptions = results.stream()
				.map(f -> new PerceptionAdapter(session, organization, em, f)).collect(Collectors.toList());
		return perceptions;
	}
}
