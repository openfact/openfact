package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogProvider;

public class JpaCodeCatalogProvider implements CodeCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaCodeCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCodeCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

}
