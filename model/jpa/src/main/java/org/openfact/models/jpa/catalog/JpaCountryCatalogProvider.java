package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.catalog.CountryCatalogProvider;
import org.openfact.models.jpa.entities.catalog.CountryCatalogEntity;

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

    @Override
    public CountryCatalogModel addCountryCatalog(String name) {
        CountryCatalogEntity catalog = new CountryCatalogEntity();
        catalog.setName(name);
        em.persist(catalog);
        em.flush();

        return new CountryCatalogAdapter(session, em, catalog);
    }

    @Override
    public int getCountriesCatalogCount() {
        Query query = em.createNamedQuery("getCountriesCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
