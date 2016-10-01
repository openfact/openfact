package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CurrencyCatalogProvider;

public class JpaCurrencyCatalogProvider implements CurrencyCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaCurrencyCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCurrencyCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

}
