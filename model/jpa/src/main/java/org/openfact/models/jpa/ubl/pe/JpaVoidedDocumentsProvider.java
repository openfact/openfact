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
import org.openfact.models.jpa.entities.ubl.pe.VoidedDocumentsEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.VoidedDocumentsModel;
import org.openfact.models.ubl.provider.pe.VoidedDocumentsProvider;

public class JpaVoidedDocumentsProvider extends AbstractHibernateStorage implements VoidedDocumentsProvider {

	protected static final Logger logger = Logger.getLogger(JpaVoidedDocumentsProvider.class);

	private static final String ID = "ID";
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaVoidedDocumentsProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {

	}

	@Override
	public VoidedDocumentsModel addVoidedDocuments(OrganizationModel organization, String ID) {
		if (ID == null) {
			throw new ModelException("Invalid ID, Null value");
		}

		if (session.voidedDocuments().getVoidedDocumentsByID(organization, ID) != null) {
			throw new ModelDuplicateException("Credit note ID existed");
		}

		VoidedDocumentsEntity voidedDocuments = new VoidedDocumentsEntity();
		voidedDocuments.setID(ID);
		voidedDocuments.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(voidedDocuments);
		em.flush();

		final VoidedDocumentsModel adapter = new VoidedDocumentsAdapter(session, organization, em, voidedDocuments);
		session.getOpenfactSessionFactory().publish(new VoidedDocumentsModel.VoidedDocumentsCreationEvent() {
			@Override
			public VoidedDocumentsModel getCreatedVoidedDocuments() {
				return adapter;
			}
		});

		return adapter;
	}

	@Override
	public VoidedDocumentsModel getVoidedDocumentsById(OrganizationModel organization, String id) {
		TypedQuery<VoidedDocumentsEntity> query = em.createNamedQuery("getOrganizationVoidedDocumentsById",
				VoidedDocumentsEntity.class);
		query.setParameter("id", id);
		query.setParameter("organizationId", organization.getId());
		List<VoidedDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new VoidedDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public VoidedDocumentsModel getVoidedDocumentsByID(OrganizationModel organization, String ID) {
		TypedQuery<VoidedDocumentsEntity> query = em.createNamedQuery("getOrganizationVoidedDocumentsByID",
				VoidedDocumentsEntity.class);
		query.setParameter("ID", ID);
		query.setParameter("organizationId", organization.getId());
		List<VoidedDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new VoidedDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public boolean removeVoidedDocuments(OrganizationModel organization, String id) {
		return removeVoidedDocuments(organization, getVoidedDocumentsById(organization, id));
	}

	@Override
	public boolean removeVoidedDocuments(OrganizationModel organization, VoidedDocumentsModel voidedDocuments) {
		VoidedDocumentsEntity voidedDocumentsEntity = em.find(VoidedDocumentsEntity.class, voidedDocuments.getId());
		if (voidedDocumentsEntity == null)
			return false;
		removeVoidedDocuments(voidedDocumentsEntity);
		session.getOpenfactSessionFactory().publish(new VoidedDocumentsModel.VoidedDocumentsRemovedEvent() {
			@Override
			public VoidedDocumentsModel getVoidedDocuments() {
				return voidedDocuments;
			}

			@Override
			public OpenfactSession getOpenfactSession() {
				return session;
			}
		});
		return true;
	}

	private void removeVoidedDocuments(VoidedDocumentsEntity voidedDocuments) {
		String id = voidedDocuments.getId();
		voidedDocuments = em.find(VoidedDocumentsEntity.class, id);
		if (voidedDocuments != null) {
			em.remove(voidedDocuments);
		}

		em.flush();
	}

	@Override
	public List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization) {
		return getVoidedDocumentss(organization, -1, -1);
	}

	@Override
	public List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization, Integer firstResult,
			Integer maxResults) {
		String queryName = "getAllVoidedDocumentsByOrganization";

		TypedQuery<VoidedDocumentsEntity> query = em.createNamedQuery(queryName, VoidedDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<VoidedDocumentsEntity> results = query.getResultList();
		List<VoidedDocumentsModel> voidedDocuments = results.stream()
				.map(f -> new VoidedDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return voidedDocuments;
	}

	@Override
	public List<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization, String filterText) {
		return searchForVoidedDocuments(organization, filterText, -1, -1);
	}

	@Override
	public List<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization, String filterText,
			Integer firstResult, Integer maxResults) {
		TypedQuery<VoidedDocumentsEntity> query = em.createNamedQuery("searchForVoidedDocuments",
				VoidedDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("search", "%" + filterText.toLowerCase() + "%");
		if (firstResult != -1) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != -1) {
			query.setMaxResults(maxResults);
		}
		List<VoidedDocumentsEntity> results = query.getResultList();
		List<VoidedDocumentsModel> voidedDocuments = results.stream()
				.map(f -> new VoidedDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return voidedDocuments;
	}

	@Override
	public SearchResultsModel<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria) {
		SearchResultsModel<VoidedDocumentsEntity> entityResult = find(criteria, VoidedDocumentsEntity.class);
		List<VoidedDocumentsEntity> entities = entityResult.getModels();

		SearchResultsModel<VoidedDocumentsModel> searchResult = new SearchResultsModel<>();
		List<VoidedDocumentsModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new VoidedDocumentsAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public SearchResultsModel<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText) {
		SearchResultsModel<VoidedDocumentsEntity> entityResult = findFullText(criteria, VoidedDocumentsEntity.class,
				filterText, ID);
		List<VoidedDocumentsEntity> entities = entityResult.getModels();

		SearchResultsModel<VoidedDocumentsModel> searchResult = new SearchResultsModel<>();
		List<VoidedDocumentsModel> models = searchResult.getModels();

		entities.forEach(f -> models.add(new VoidedDocumentsAdapter(session, organization, em, f)));
		searchResult.setTotalSize(entityResult.getTotalSize());
		return searchResult;
	}

	@Override
	public int getVoidedDocumentssCount(OrganizationModel organization) {
		Query query = em.createNamedQuery("getOrganizationVoidedDocumentsCount");
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public VoidedDocumentsModel getLastVoidedDocuments(OrganizationModel organization, int IDVoidedDocumentsLength,
			String maskFormater) {
		TypedQuery<VoidedDocumentsEntity> query = em.createNamedQuery("getLastVoidedDocumentsByOrganization",
				VoidedDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("IDLength", IDVoidedDocumentsLength);
		query.setParameter("formatter", maskFormater);
		query.setMaxResults(1);
		List<VoidedDocumentsEntity> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		return new VoidedDocumentsAdapter(session, organization, em, entities.get(0));
	}

	@Override
	public List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization,
			List<RequeridActionDocument> requeridAction, boolean intoRequeridAction) {
		String queryName = "";
		if (intoRequeridAction) {
			queryName = "select i from VoidedDocumentsEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.issueDateTime ";
		} else {
			queryName = "select i from VoidedDocumentsEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.issueDateTime ";
		}
		TypedQuery<VoidedDocumentsEntity> query = em.createQuery(queryName, VoidedDocumentsEntity.class);
		query.setParameter("organizationId", organization.getId());
		query.setParameter("requeridAction", requeridAction);
		List<VoidedDocumentsEntity> results = query.getResultList();
		List<VoidedDocumentsModel> voidedDocuments = results.stream()
				.map(f -> new VoidedDocumentsAdapter(session, organization, em, f)).collect(Collectors.toList());
		return voidedDocuments;
	}

}
