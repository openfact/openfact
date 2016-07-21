package org.openfact.exportimport;

import org.openfact.models.OpenfactSessionFactory;
import org.openfact.provider.Provider;

import java.io.IOException;

public interface ImportProvider extends Provider {

    void importModel(OpenfactSessionFactory factory, Strategy strategy) throws IOException;

    void importRealm(OpenfactSessionFactory factory, String realmName, Strategy strategy) throws IOException;

    /**
     * @return true if master realm was previously exported and is available in the data to be imported
     * @throws IOException
     */
    boolean isMasterRealmExported() throws IOException;
}
