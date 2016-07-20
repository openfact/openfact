package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;

public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ApplianceBootstrap.class);
    private final OpenfactSession session;

    public ApplianceBootstrap(OpenfactSession session) {
        this.session = session;
    }

    public boolean isNewInstall() {
        return false;
    }

    public boolean isNoMasterUser() {
        return false;
    }

    public boolean createMasterRealm(String contextPath) {
        return true;
    }

    public void createMasterRealmUser(String username, String password) {

    }

}
