package org.openfact.services.managers;

import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.Config;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.representations.idm.OrganizationRepresentation;

public class OrganizationManager {

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
        OrganizationModel realm = model.createOrganization(id, name);
        realm.setName(name);

        return realm;
    }

    public OrganizationModel importOrganization(OrganizationRepresentation rep) {
        OrganizationModel organization = model.createOrganization(null, rep.getName());
        return organization;
    }

    public boolean removeOrganization(OrganizationModel organization) {
        boolean removed = model.removeOrganization(organization);
        return removed;
    }

}
