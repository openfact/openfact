package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CountryCatalogProvider;

public class JpaCountryCatalogProvider implements CountryCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaCountryCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCountryCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

}
