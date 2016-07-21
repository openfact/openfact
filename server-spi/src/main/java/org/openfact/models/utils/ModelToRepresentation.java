package org.openfact.models.utils;

import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.OrganizationRepresentation;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization,
            boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setName(organization.getName());
        if (internal) {
            // TODO Add private information like security cert or another one
        }
        return rep;
    }

}
