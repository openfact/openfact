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
package org.openfact.services.managers;

import java.util.Collections;
import java.util.HashSet;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.OrganizationImporter;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.timer.TimerDelayProvider;

public class OrganizationManager implements OrganizationImporter {

    protected OpenfactSession session;
    protected OrganizationProvider model;
    protected String contextPath = "";

    public OrganizationManager(OpenfactSession session) {
        this.session = session;
        this.model = session.organizations();
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public OpenfactSession getSession() {
        return session;
    }

    public OrganizationModel getOpenfactAdminstrationOrganization() {
        return getOrganization(Config.getAdminOrganization());
    }

    public OrganizationModel getOrganization(String id) {
        return model.getOrganization(id);
    }

    public OrganizationModel getOrganizationByName(String name) {
        return model.getOrganizationByName(name);
    }

    public OrganizationModel createOrganization(String name) {
        return createOrganization(name, name);
    }

    public OrganizationModel createOrganization(String id, String name) {
        if (id == null)
            id = OpenfactModelUtils.generateId();
        OrganizationModel organization = model.createOrganization(id, name);
        organization.setName(name);

        // setup defaults
        setupOrganizationDefaults(organization);

        fireOrganizationPostCreate(organization);
        return organization;
    }

    public OrganizationModel importOrganization(OrganizationRepresentation rep) {
        String id = rep.getId();
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }

        OrganizationModel organization = model.createOrganization(id, rep.getOrganization());
        organization.setName(rep.getOrganization());

        // setup defaults
        setupOrganizationDefaults(organization);

        RepresentationToModel.importOrganization(session, rep, organization);

        // Create periodic tasks for send documents
        schedulePeriodicTask(organization);

        fireOrganizationPostCreate(organization);
        return organization;
    }

    public boolean removeOrganization(OrganizationModel organization) {
        cancelPeriodicTask(organization);

        boolean removed = model.removeOrganization(organization);
        return removed;
    }

    protected void setupOrganizationDefaults(OrganizationModel organization) {
        organization.setEventsListeners(Collections.singleton("jboss-logging"));
    }

    private void fireOrganizationPostCreate(OrganizationModel organization) {
        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationPostCreateEvent() {
            @Override
            public OrganizationModel getCreatedOrganization() {
                return organization;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public void updateOrganizationEventsConfig(OrganizationEventsConfigRepresentation rep,
            OrganizationModel organization) {
        organization.setEventsEnabled(rep.isEventsEnabled());
        organization.setEventsExpiration(rep.getEventsExpiration() != null ? rep.getEventsExpiration() : 0);
        if (rep.getEventsListeners() != null) {
            organization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
        }
        if (rep.getEnabledEventTypes() != null) {
            organization.setEnabledEventTypes(new HashSet<>(rep.getEnabledEventTypes()));
        }
        if (rep.isAdminEventsEnabled() != null) {
            organization.setAdminEventsEnabled(rep.isAdminEventsEnabled());
        }
        if (rep.isAdminEventsDetailsEnabled() != null) {
            organization.setAdminEventsDetailsEnabled(rep.isAdminEventsDetailsEnabled());
        }
    }

    public void schedulePeriodicTask(OrganizationModel organization) {
        if (organization.isTasksEnabled()) {
            TimerDelayProvider timer = session.getProvider(TimerDelayProvider.class);
            timer.scheduleTask(new OrganizationScheduledTaskRunner(organization), organization.getTaskFirstTime(), organization.getTaskDelay(), getTaskName(organization));
        }
    }

    public void reschedulePeriodicTask(OrganizationModel organization) {
        TimerDelayProvider timer = session.getProvider(TimerDelayProvider.class);
        timer.cancelTask(getTaskName(organization));

        if (organization.isTasksEnabled()) {
            timer.scheduleTask(new OrganizationScheduledTaskRunner(organization), organization.getTaskFirstTime(), organization.getTaskDelay(), getTaskName(organization));
        }
    }

    public void cancelPeriodicTask(OrganizationModel organization) {
        TimerDelayProvider timer = session.getProvider(TimerDelayProvider.class);
        timer.cancelTask(getTaskName(organization));
    }

    protected String getTaskName(OrganizationModel organization) {
        return organization.getId();
    }

}
