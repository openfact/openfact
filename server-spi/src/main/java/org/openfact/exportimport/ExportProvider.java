package org.openfact.exportimport;

import org.openfact.models.OpenfactSessionFactory;
import org.openfact.provider.Provider;

import java.io.IOException;

public interface ExportProvider extends Provider {

    void exportModel(OpenfactSessionFactory factory) throws IOException;

    void exportRealm(OpenfactSessionFactory factory, String realmName) throws IOException;

}
