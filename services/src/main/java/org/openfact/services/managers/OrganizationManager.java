package org.openfact.services.managers;

import java.util.Collections;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.OrganizationImporter;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;

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
        organization.setDescription(rep.getDescription());
        
        // setup defaults
        setupOrganizationDefaults(organization);
        
        RepresentationToModel.importOrganization(session, rep, organization);
        
        fireOrganizationPostCreate(organization);
        //setupScheduledTasks(session.getOpenfactSessionFactory(), organization);
        
        return organization;
    }

    public boolean removeOrganization(OrganizationModel organization) {
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

    /*private void setupScheduledTasks(final OpenfactSessionFactory sessionFactory, final OrganizationModel organization) {
        OpenfactSession session = sessionFactory.create();
        try {
            TimerProvider timer = session.getProvider(TimerProvider.class);
            timer.schedule(new ClusterAwareScheduledTaskRunner(sessionFactory, new OrganizationScheduledTask(organization), 100), 100, organization.getName() + "SendEMail");
        } finally {
            session.close();
        }        
    }*/
    
}
