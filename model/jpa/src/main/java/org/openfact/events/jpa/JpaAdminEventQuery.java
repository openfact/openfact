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

package org.openfact.events.jpa;

import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:giriraj.sharma27@gmail.com">Giriraj Sharma</a>
 */
public class JpaAdminEventQuery implements AdminEventQuery {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<AdminEventEntity> cq;
    private final Root<AdminEventEntity> root;
    private final ArrayList<Predicate> predicates;
    private Integer firstResult;
    private Integer maxResults;

    public JpaAdminEventQuery(EntityManager em) {
        this.em = em;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(AdminEventEntity.class);
        root = cq.from(AdminEventEntity.class);
        predicates = new ArrayList<Predicate>();
    }

    @Override
    public AdminEventQuery organization(String organizationId) {
        predicates.add(cb.equal(root.get("organizationId"), organizationId));
        return this;
    }

    @Override
    public AdminEventQuery operation(OperationType... operations) {
        List<String> operationStrings = new LinkedList<String>();
        for (OperationType e : operations) {
            operationStrings.add(e.toString());
        }
        predicates.add(root.get("operationType").in(operationStrings));
        return this;
    }

    @Override
    public AdminEventQuery resourceType(ResourceType... resourceTypes) {

        List<String> resourceTypeStrings = new LinkedList<String>();
        for (ResourceType e : resourceTypes) {
            resourceTypeStrings.add(e.toString());
        }
        predicates.add(root.get("resourceType").in(resourceTypeStrings));

        return this;
    }

    @Override
    public AdminEventQuery authOrganization(String authOrganizationId) {
        predicates.add(cb.equal(root.get("authOrganizationId"), authOrganizationId));
        return this;
    }

    @Override
    public AdminEventQuery authUser(String authUserId) {
        predicates.add(cb.equal(root.get("authUserId"), authUserId));
        return this;
    }

    @Override
    public AdminEventQuery authIpAddress(String ipAddress) {
        predicates.add(cb.equal(root.get("authIpAddress"), ipAddress));
        return this;
    }

    @Override
    public AdminEventQuery resourcePath(String resourcePath) {
        Expression<String> rPath = root.get("resourcePath");
        predicates.add(cb.like(rPath, "%" + resourcePath + "%"));
        return this;
    }

    @Override
    public AdminEventQuery fromTime(Date fromTime) {
        predicates.add(cb.greaterThanOrEqualTo(root.<Long>get("time"), fromTime.getTime()));
        return this;
    }

    @Override
    public AdminEventQuery toTime(Date toTime) {
        predicates.add(cb.lessThanOrEqualTo(root.<Long>get("time"), toTime.getTime()));
        return this;
    }

    @Override
    public AdminEventQuery firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    @Override
    public AdminEventQuery maxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @Override
    public List<AdminEvent> getResultList() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        cq.orderBy(cb.desc(root.get("time")));

        TypedQuery<AdminEventEntity> query = em.createQuery(cq);

        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }

        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }

        List<AdminEvent> events = new LinkedList<AdminEvent>();
        for (AdminEventEntity e : query.getResultList()) {
            events.add(JpaEventStoreProvider.convertAdminEvent(e));
        }

        return events;
    }

}
