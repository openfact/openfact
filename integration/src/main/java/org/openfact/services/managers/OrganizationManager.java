package org.openfact.services.managers;

import org.openfact.Config;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.provider.ProviderEvent;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationEventsConfigRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Stateless
public class OrganizationManager {

    @Resource
    private ManagedScheduledExecutorService managedScheduledExecutorService;

    @Inject
    private OrganizationProvider model;

    @Inject
    private javax.enterprise.event.Event<ProviderEvent> event;

    @Inject
    private RepresentationToModel representationToModel;

    public OrganizationModel getOpenfactAdminstrationOrganization() {
        return getOrganization(Config.getAdminOrganization());
    }

    public List<OrganizationModel> getOrganizations() {
        return model.getOrganizations();
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

        schedulePeriodicTask(organization);

        //fireOrganizationPostCreate(organization);
        event.fire((OrganizationModel.OrganizationPostCreateEvent) () -> organization);
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

        representationToModel.importOrganization(rep, organization);

        // Create periodic tasks for send documents
        schedulePeriodicTask(organization);

        //fireOrganizationPostCreate(organization);
        return organization;
    }

    public boolean removeOrganization(OrganizationModel organization) {
        //cancelPeriodicTask(organization);

        boolean removed = model.removeOrganization(organization);
        return removed;
    }

    protected void setupOrganizationDefaults(OrganizationModel organization) {
        organization.setEventsListeners(Collections.singleton("jboss-logging"));
    }

    public void updateOrganizationEventsConfig(OrganizationEventsConfigRepresentation rep, OrganizationModel organization) {
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

    public static long numero = 5L;

    public void schedulePeriodicTask(OrganizationModel organization) {
        /*managedScheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(organization.getName() + " " + System.currentTimeMillis());
        }, 0L, numero++, TimeUnit.SECONDS);*/
    }

    public void reschedulePeriodicTask(OrganizationModel organization) {

    }

//    public void cancelPeriodicTask(OrganizationModel organization) {
//        TimerDelayProvider timer = session.getProvider(TimerDelayProvider.class);
//        timer.cancelTask(getTaskName(organization));
//    }

    protected String getTaskName(OrganizationModel organization) {
        return organization.getId();
    }

}
