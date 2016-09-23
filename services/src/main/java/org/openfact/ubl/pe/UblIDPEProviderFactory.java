package org.openfact.ubl.pe;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblIDProvider;
import org.openfact.ubl.UblIDProviderFactory;

public class UblIDPEProviderFactory implements UblIDProviderFactory {

    @Override
    public UblIDProvider create(OpenfactSession session) {
        return new UblIDPEProvider(session);
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
        return "ublIDPE";
    }

}
