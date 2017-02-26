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
package org.openfact.models.jpa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.openfact.models.jpa.entities.search.SearchCriteriaJoinAliasModel;
import org.openfact.models.jpa.entities.search.SearchCriteriaJoinModel;
import org.openfact.models.search.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * A base class that JPA storage impls can extend.
 *
 * @author carlosthe19916@openfact.com
 */
public abstract class AbstractHibernateStorage {

    /**
     * Constructor.
     */
    public AbstractHibernateStorage() {

    }

    protected abstract EntityManager getEntityManager();

    protected Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

    protected PagingModel getDefaultPaging() {
        PagingModel paging = new PagingModel();
        paging.setPage(1);
        paging.setPageSize(20);
        return paging;
    }

    protected <T> SearchResultsModel<T> find(SearchCriteriaModel criteria, Class<T> type) {
        SearchResultsModel<T> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = getDefaultPaging();
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(type);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, false);
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<T> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            totalSize = executeCountQuery(criteria, session, type);
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);
        return results;
    }

    protected <T> SearchResultsModel<T> find(SearchCriteriaJoinModel criteriaJoin,
                                             SearchCriteriaModel criteria, Class<T> type) {
        SearchResultsModel<T> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = getDefaultPaging();
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(type, criteriaJoin.getEntityAlias());
        applySearchCriteriaToQuery(criteriaJoin, type, criteriaQuery, false);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, false);
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<T> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            totalSize = executeCountQuery(criteriaJoin, criteria, session, type);
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);
        return results;
    }

    protected <T> SearchResultsModel<T> findFullText(SearchCriteriaModel criteria, Class<T> type,
                                                     String filterText, String... field) {
        SearchResultsModel<T> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = getDefaultPaging();
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(type);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, false);

        // filter text
        List<Criterion> disjuntions = new ArrayList<>();
        for (String fieldName : field) {
            Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
            disjuntions.add(criterion);
        }
        criteriaQuery.add(Restrictions.or(disjuntions.toArray(new Criterion[disjuntions.size()])));

        // paging
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<T> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            totalSize = executeCountQuery(criteria, session, type, filterText, field);
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);
        return results;
    }

    protected <T> SearchResultsModel<T> findFullText(SearchCriteriaJoinModel criteriaJoin,
                                                     SearchCriteriaModel criteria, Class<T> type, String filterText, String... field) {
        SearchResultsModel<T> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = getDefaultPaging();
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(type, criteriaJoin.getEntityAlias());
        applySearchCriteriaToQuery(criteriaJoin, type, criteriaQuery, false);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, false);

        // filter text
        List<Criterion> disjuntions = new ArrayList<>();
        for (String fieldName : field) {
            Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
            disjuntions.add(criterion);
        }
        criteriaQuery.add(Restrictions.or(disjuntions.toArray(new Criterion[disjuntions.size()])));

        // paging
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<T> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            totalSize = executeCountQuery(criteriaJoin, criteria, session, type, filterText, field);
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);
        return results;
    }

    protected <T> void applySearchCriteriaToQuery(SearchCriteriaModel criteria, Class<T> type,
                                                  Criteria criteriaQuery, boolean countOnly) {
        List<SearchCriteriaFilterModel> filters = criteria.getFilters();
        applySearchCriteriaFilterToQuery(filters, type, criteriaQuery);
        List<OrderByModel> orders = criteria.getOrders();
        if (orders != null && !orders.isEmpty() && !countOnly) {
            for (OrderByModel orderBy : orders) {
                if (orderBy.isAscending()) {
                    criteriaQuery.addOrder(Order.asc(orderBy.getName()));
                } else {
                    criteriaQuery.addOrder(Order.desc(orderBy.getName()));
                }
            }
        }
    }

    protected <T> void applySearchCriteriaToQuery(SearchCriteriaJoinModel criteriaJoin, Class<T> type,
                                                  Criteria criteriaQuery, boolean countOnly) {
        List<SearchCriteriaJoinAliasModel> joins = criteriaJoin.getJoins();
        List<SearchCriteriaFilterModel> filters = criteriaJoin.getFilters();

        if (joins != null && !joins.isEmpty()) {
            for (SearchCriteriaJoinAliasModel join : joins) {
                switch (join.getJoinType()) {
                    case INNER_JOIN:
                        criteriaQuery.createAlias(join.getAssociationPath(), join.getAssociationAlias(),
                                JoinType.INNER_JOIN);
                        break;
                    case LEFT_OUTER_JOIN:
                        criteriaQuery.createAlias(join.getAssociationPath(), join.getAssociationAlias(),
                                JoinType.LEFT_OUTER_JOIN);
                        break;
                    case RIGHT_OUTER_JOIN:
                        criteriaQuery.createAlias(join.getAssociationPath(), join.getAssociationAlias(),
                                JoinType.RIGHT_OUTER_JOIN);
                        break;
                    case FULL_JOIN:
                        criteriaQuery.createAlias(join.getAssociationPath(), join.getAssociationAlias(),
                                JoinType.FULL_JOIN);
                        break;
                    default:
                        criteriaQuery.createAlias(join.getAssociationPath(), join.getAssociationAlias(),
                                JoinType.NONE);
                        break;
                }
            }
        }
        applySearchCriteriaFilterToQuery(filters, type, criteriaQuery);
    }

    protected <T> void applySearchCriteriaFilterToQuery(List<SearchCriteriaFilterModel> filters,
                                                        Class<T> type, Criteria criteriaQuery) {
        if (filters != null && !filters.isEmpty()) {
            for (SearchCriteriaFilterModel filter : filters) {
                switch (filter.getOperator()) {
                    case eq:
                        criteriaQuery.add(Restrictions.eq(filter.getName(), filter.getValue()));
                        break;
                    case bool_eq:
                        criteriaQuery.add(Restrictions.eq(filter.getName(), filter.getValue()));
                        break;
                    case gt:
                        criteriaQuery.add(Restrictions.gt(filter.getName(), filter.getValue()));
                        break;
                    case gte:
                        criteriaQuery.add(Restrictions.ge(filter.getName(), filter.getValue()));
                        break;
                    case lt:
                        criteriaQuery.add(Restrictions.lt(filter.getName(), filter.getValue()));
                        break;
                    case lte:
                        criteriaQuery.add(Restrictions.le(filter.getName(), filter.getValue()));
                        break;
                    case neq:
                        criteriaQuery.add(Restrictions.ne(filter.getName(), filter.getValue()));
                        break;
                    case like:
                        criteriaQuery.add(Restrictions.like(filter.getName(), (String) filter.getValue(),
                                MatchMode.ANYWHERE));
                        break;
                    default:
                        criteriaQuery.add(Restrictions.eq(filter.getName(), filter.getValue()));
                        break;
                }
            }
        }
    }

    protected <T> int executeCountQuery(SearchCriteriaModel criteria, Session session, Class<T> type) {
        Criteria criteriaQuery = session.createCriteria(type);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, true);
        criteriaQuery.setProjection(Projections.rowCount());
        return ((Long) criteriaQuery.uniqueResult()).intValue();
    }

    protected <T> int executeCountQuery(SearchCriteriaModel criteria, Session session, Class<T> type,
                                        String filterText, String... field) {
        Criteria criteriaQuery = session.createCriteria(type);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, true);
        List<Criterion> disjuntionsCount = new ArrayList<>();
        for (String fieldName : field) {
            Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
            disjuntionsCount.add(criterion);
        }
        criteriaQuery.add(Restrictions.or(disjuntionsCount.toArray(new Criterion[disjuntionsCount.size()])));
        criteriaQuery.setProjection(Projections.rowCount());
        return ((Long) criteriaQuery.uniqueResult()).intValue();
    }

    protected <T> int executeCountQuery(SearchCriteriaJoinModel criteriaJoin, SearchCriteriaModel criteria,
                                        Session session, Class<T> type) {
        Criteria criteriaQuery = session.createCriteria(type, criteriaJoin.getEntityAlias());
        applySearchCriteriaToQuery(criteriaJoin, type, criteriaQuery, true);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, true);
        criteriaQuery.setProjection(Projections.rowCount());
        return (Integer) criteriaQuery.uniqueResult();
    }

    protected <T> int executeCountQuery(SearchCriteriaJoinModel criteriaJoin, SearchCriteriaModel criteria,
                                        Session session, Class<T> type, String filterText, String... field) {
        Criteria criteriaQuery = session.createCriteria(type, criteriaJoin.getEntityAlias());
        applySearchCriteriaToQuery(criteriaJoin, type, criteriaQuery, true);
        applySearchCriteriaToQuery(criteria, type, criteriaQuery, true);
        List<Criterion> disjuntionsCount = new ArrayList<>();
        for (String fieldName : field) {
            Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
            disjuntionsCount.add(criterion);
        }
        criteriaQuery.add(Restrictions.or(disjuntionsCount.toArray(new Criterion[disjuntionsCount.size()])));
        criteriaQuery.setProjection(Projections.rowCount());
        return ((Long) criteriaQuery.uniqueResult()).intValue();
    }

}