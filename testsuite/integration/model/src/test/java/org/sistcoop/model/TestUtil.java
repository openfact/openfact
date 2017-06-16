package org.sistcoop.model;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.openfact.connections.jpa.PersistenceEntityProducer;
import org.openfact.connections.jpa.PersistenceExceptionConverter;
import org.openfact.models.*;
import org.openfact.models.jpa.*;
import org.openfact.models.jpa.entities.OrganizationEntity;

public class TestUtil {

    public static JavaArchive[] getLibraries() {
        return Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-core")
                .withTransitivity()
                .as(JavaArchive.class);
    }

    public static Package getEntitiesPackage() {
        return OrganizationEntity.class.getPackage();
    }

    public static Class<?>[] getBasicClasses() {
        return new Class<?>[]{
                PersistenceEntityProducer.class,
                PersistenceExceptionConverter.class,
                ModelException.class,
                ModelDuplicateException.class,
                JpaModel.class
        };
    }

    public static Class<?>[] getOrganizationClasses() {
        return new Class<?>[]{
                OrganizationModel.class,
                OrganizationAdapter.class,
                OrganizationProvider.class,
                JpaOrganizationProvider.class
        };
    }

    public static Class<?>[] getDocumentClasses() {
        return new Class<?>[]{
                DocumentModel.class,
                DocumentAdapter.class,
                DocumentProvider.class,
                JpaDocumentProvider.class
        };
    }

}
