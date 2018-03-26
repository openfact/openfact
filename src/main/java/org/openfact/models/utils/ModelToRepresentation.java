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

    public static CompanyRepresentation toRepresentation(CompanyModel model, boolean fullInfo) {
        CompanyRepresentation rep = new CompanyRepresentation();
        rep.setId(model.getId());
        rep.setName(model.getName());

        CompanyRepresentation.CompanyOwnerRepresentation ownerRepresentation = new CompanyRepresentation.CompanyOwnerRepresentation();
        rep.setOwner(ownerRepresentation);
        ownerRepresentation.setId(model.getOwner().getId());
        ownerRepresentation.setIdentityId(model.getOwner().getIdentityId());

        if (fullInfo) {
            rep.setDescription(model.getDescription());
        }

        return rep;
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
