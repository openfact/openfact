package org.openfact.services.resources.admin;

import org.openfact.models.OrganizationModel;

public class AdminAuth {

    //private final OrganizationModel organization;
   // private final AccessToken token;
    //private final UserModel user;
    //private final ClientModel client;

   /* public AdminAuth(OrganizationModel realm, AccessToken token, UserModel user, ClientModel client) {
        this.token = token;
        this.organization = realm;

        //this.user = user;
        //this.client = client;
    }*/

    /*public OrganizationModel getOrganization() {
        return organization;
    }*/

   /* public UserModel getUser() {
        return user;
    }

    public ClientModel getClient() {
        return client;
    }*/

    /*public AccessToken getToken() {
        return token;
    }*/


    public boolean hasRealmRole(String role) {
        /*if (client instanceof ClientModel) {
            RoleModel roleModel = organization.getRole(role);
            if (roleModel == null) return false;
            return user.hasRole(roleModel) && client.hasScope(roleModel);
        } else {
            AccessToken.Access access = token.getRealmAccess();
            return access != null && access.isUserInRole(role);
        }*/
    	return false;
    }

    public boolean hasOneOfRealmRole(String... roles) {
        for (String r : roles) {
            if (hasRealmRole(r)) {
                return true;
            }
        }
        return false;
    }

   /* public boolean hasAppRole(ClientModel app, String role) {
        if (client instanceof ClientModel) {
            RoleModel roleModel = app.getRole(role);
            if (roleModel == null) return false;
            return user.hasRole(roleModel) && client.hasScope(roleModel);
        } else {
            AccessToken.Access access = token.getResourceAccess(app.getClientId());
            return access != null && access.isUserInRole(role);
        }
    }

    public boolean hasOneOfAppRole(ClientModel app, String... roles) {
        for (String r : roles) {
            if (hasAppRole(app, r)) {
                return true;
            }
        }
        return false;
    }*/

}
