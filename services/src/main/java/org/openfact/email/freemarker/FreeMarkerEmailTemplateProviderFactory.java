package org.openfact.email.freemarker;

import org.openfact.Config;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.EmailTemplateProviderFactory;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class FreeMarkerEmailTemplateProviderFactory implements EmailTemplateProviderFactory {

    private FreeMarkerUtil freeMarker;

    @Override
    public EmailTemplateProvider create(OpenfactSession session) {
        return new FreeMarkerEmailTemplateProvider(session, freeMarker);
    }

    @Override
    public void init(Config.Scope config) {
        freeMarker = new FreeMarkerUtil();
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
        freeMarker = null;
    }

    @Override
    public String getId() {
        return "freemarker";
    }

}
