package org.openfact.connections.jpa.util;

import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.jpa.boot.internal.ParsedPersistenceXmlDescriptor;
import org.hibernate.jpa.boot.internal.PersistenceXmlParser;
import org.hibernate.jpa.boot.spi.Bootstrap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitTransactionType;
import java.util.List;
import java.util.Map;

public class JpaUtils {

    public static final String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";

    public static String getTableNameForNativeQuery(String tableName, EntityManager em) {
        String schema = (String) em.getEntityManagerFactory().getProperties().get(HIBERNATE_DEFAULT_SCHEMA);
        return (schema == null) ? tableName : schema + "." + tableName;
    }

    public static EntityManagerFactory createEntityManagerFactory(String unitName, Map<String, Object> properties, ClassLoader classLoader) {
        PersistenceXmlParser parser = new PersistenceXmlParser(new ClassLoaderServiceImpl(classLoader), PersistenceUnitTransactionType.RESOURCE_LOCAL);
        List<ParsedPersistenceXmlDescriptor> persistenceUnits = parser.doResolve(properties);
        for (ParsedPersistenceXmlDescriptor persistenceUnit : persistenceUnits) {
            if (persistenceUnit.getName().equals(unitName)) {
                return Bootstrap.getEntityManagerFactoryBuilder(persistenceUnit, properties, classLoader).build();
            }
        }
        throw new RuntimeException("Persistence unit '" + unitName + "' not found");
    }
}
