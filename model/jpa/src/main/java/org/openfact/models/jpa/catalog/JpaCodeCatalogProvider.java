package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.catalog.CodeCatalogProvider;
import org.openfact.models.jpa.entities.catalog.CodeCatalogEntity;

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

    @Override
    public CodeCatalogModel addCodeCatalog(String locale, String type, String code, String description) {
        CodeCatalogEntity catalog = new CodeCatalogEntity();
        catalog.setLocale(locale);
        catalog.setType(type);
        catalog.setCode(code);
        catalog.setDescription(description);
        em.persist(catalog);
        em.flush();

        return new CodeCatalogAdapter(session, em, catalog);
    }

    @Override
    public int getCodesCatalogCount() {
        Query query = em.createNamedQuery("getCodesCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
