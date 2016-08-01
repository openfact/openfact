package org.openfact.models.storage;

import java.io.PrintStream;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.storage.StorageInvoiceProvider;
import org.openfact.storage.StorageInvoiceProviderFactory;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class LocalStorageInvoiceProviderFactory implements StorageInvoiceProviderFactory {
    @Override
    public StorageInvoiceProvider create(OpenfactSession session) {
        return null;
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
        System.out.println("__---___");
    }

    @Override
    public String getId() {
        return "Local";
    }


}
