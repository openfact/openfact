package org.openfact.ubl.ar;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.ubl.UblIDProvider;
import org.openfact.ubl.UblIDProviderFactory;

public class UblIDARProviderFactory implements UblIDProviderFactory {

    @Override
    public UblIDProvider create(OpenfactSession session) {
        return new UblIDARProvider(session);
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
        return "ublIDAR";
    }

}
