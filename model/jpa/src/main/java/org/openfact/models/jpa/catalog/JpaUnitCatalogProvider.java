package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.catalog.UnitCatalogProvider;
import org.openfact.models.jpa.entities.catalog.UnitCatalogEntity;

public class JpaUnitCatalogProvider implements UnitCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaUnitCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaUnitCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    public UnitCatalogModel addUnitCatalog(String name, String symbol, String description) {
        UnitCatalogEntity entity = new UnitCatalogEntity();
        entity.setName(name);
        entity.setSymbol(symbol);
        entity.setDescription(description);
        em.persist(entity);
        em.flush();

        return new UnitCatalogAdapter(session, em, entity);
    }

    @Override
    public int getUnitsCatalogCount() {
        Query query = em.createNamedQuery("getUnitsCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
