package org.openfact.services.managers;

import org.openfact.models.*;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedManager {
    protected OpenfactSession session;
    protected CertifiedProvider model;

    public CertifiedManager(OpenfactSession session) {
        this.session = session;
        this.model = session.certifieds();
    }

    public OpenfactSession getSession() {
        return session;
    }

    public boolean disabledCertified(OrganizationModel organization, CertifiedModel certified) {
        boolean disabled = model.disabledCertified(organization, certified);
        return disabled;
    }
}
