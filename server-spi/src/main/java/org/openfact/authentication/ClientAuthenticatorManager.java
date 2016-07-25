package org.openfact.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

public class ClientAuthenticatorManager {

    protected static final Logger logger = Logger.getLogger(ClientAuthenticatorManager.class);

    protected OpenfactSession session;
    protected ClientAuthenticatorProvider model;
    private final HttpHeaders headers;
    private final HttpServletRequest request;

    public ClientAuthenticatorManager(OpenfactSession session, HttpHeaders headers, HttpServletRequest request) {
        this.session = session;        
        this.headers = headers;
        this.request = request;
        this.model = session.authentications();
    }
    
    public OrganizationModel getOrganization() {        
        return model.getOrganization(headers, request);
    }
    
    public UserModel getUser() {
        return model.getUser(headers, request);
    }

}
