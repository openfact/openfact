package org.openfact.models.utils;

import org.openfact.models.CompanyModel;
import org.openfact.models.UserModel;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;

public class ModelToRepresentation {

    private ModelToRepresentation() {
        // Util Class
    }

    public static CompanyRepresentation toRepresentation(CompanyModel companyModel, boolean fullInfo) {
        CompanyRepresentation rep = new CompanyRepresentation();
        rep.setId(companyModel.getId());
        rep.setName(companyModel.getName());
        rep.setOwner(toRepresentation(companyModel.getOwner(), fullInfo));

        if (fullInfo) {
            rep.setDescription(companyModel.getDescription());
        }

        return null;
    }

    public static UserRepresentation toRepresentation(UserModel model, boolean fullInfo) {
        UserRepresentation rep = new UserRepresentation();

        rep.setId(model.getId());
        rep.setUsername(model.getUsername());
        rep.setEmail(model.getEmail());

        if (fullInfo) {

        }

        return rep;
    }

}
