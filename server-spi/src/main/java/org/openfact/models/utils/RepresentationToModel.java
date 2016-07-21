package org.openfact.models.utils;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.OrganizationRepresentation;

public class RepresentationToModel {

    private static Logger logger = Logger.getLogger(RepresentationToModel.class);

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getName() != null) organization.setName(rep.getName());
    }

}
