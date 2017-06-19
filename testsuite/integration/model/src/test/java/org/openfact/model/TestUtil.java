package org.openfact.model;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentProvider;
import org.openfact.components.utils.ComponentUtil;
import org.openfact.connections.jpa.PersistenceEntityProducer;
import org.openfact.connections.jpa.PersistenceExceptionConverter;
import org.openfact.models.*;
import org.openfact.models.jpa.*;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.provider.ConfiguredProvider;
import org.openfact.provider.ProviderFactory;

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

    public static Class<?>[] getFileClasses() {
        return new Class<?>[]{
                FileModel.class,
                FileAdapter.class,
                FileProvider.class,
                JpaFileProvider.class
        };
    }

    public static Class<?>[] getJobReportClasses() {
        return new Class<?>[]{
                JobReportModel.class,
                JobReportAdapter.class,
                JobReportProvider.class,
                JpaJobReportProvider.class
        };
    }

    public static Class<?>[] getComponentClasses() {
        return new Class<?>[]{
                ComponentModel.class,
                MultivaluedHashMap.class,
                ComponentProvider.class,
                JpaComponentProvider.class,
                ComponentUtil.class,

                ConfiguredProvider.class,
                ProviderFactory.class,
                ComponentFactory.class
        };
    }
}
