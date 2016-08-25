package org.openfact.email;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultEmailSenderProviderFactory implements EmailSenderProviderFactory {

    @Override
    public EmailSenderProvider create(OpenfactSession session) {
        return new DefaultEmailSenderProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "default";
    }

}
