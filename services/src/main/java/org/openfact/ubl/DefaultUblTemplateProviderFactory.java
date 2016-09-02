package org.openfact.ubl;

import org.openfact.Config;
import org.openfact.Config.Scope;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.EmailTemplateProviderFactory;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultUblTemplateProviderFactory implements UblTemplateProviderFactory {

    @Override
    public UblTemplateProvider create(OpenfactSession session) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(Scope config) {
        // TODO Auto-generated method stub

    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getId() {
       return "templateUbl";
    }

}
