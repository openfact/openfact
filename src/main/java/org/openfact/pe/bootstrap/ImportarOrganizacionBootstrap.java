package org.openfact.pe.bootstrap;

import org.jboss.logging.Logger;
import org.keycloak.util.JsonSerialization;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.utils.RepresentationToModel;
import org.openfact.pe.idm.OrganizacionImportadaRepresentation;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.OrganizationInformacionAdicionalProvider;
import org.openfact.pe.models.OrganizationInformacionSunatProvider;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Startup
@Singleton
@DependsOn("ServerBootstrap")
public class ImportarOrganizacionBootstrap {

    private static final Logger logger = Logger.getLogger(ImportarOrganizacionBootstrap.class);

    @Inject
    @ConfigurationValue("openfact.pe.import")
    private Optional<String> organizationPath;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private OrganizationInformacionAdicionalProvider organizationInformacionAdicionalProvider;

    @Inject
    private OrganizationInformacionSunatProvider organizationInformacionSUNATProvider;

    @PostConstruct
    private void bootstrap() {
        logger.info("Trying to import peru configuration");

        organizationPath.ifPresent(organizationPath -> {
            try {
                InputStream is = new FileInputStream(organizationPath);
                OrganizacionImportadaRepresentation rep = loadJson(is, OrganizacionImportadaRepresentation.class);
                importOrganization(rep);
            } catch (FileNotFoundException e) {
                throw new ModelRuntimeException("Could not Import organizacion");
            }
        });
    }

    private static <T> T loadJson(InputStream is, Class<T> type) {
        try {
            return JsonSerialization.readValue(is, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse json", e);
        }
    }

    private void importOrganization(OrganizacionImportadaRepresentation rep) {
        logger.info("Importing Organization " + rep.getName());

        OrganizationModel organization = organizationProvider.getOrganization(rep.getId()).orElseThrow(() -> new ModelRuntimeException("Organization not found"));

        RepresentationToModel.updateOrganization(rep, organization);

        OrganizacionInformacionAdicionalModel informacionAdicional = organizationInformacionAdicionalProvider.getOrganizacionInformacionAdicional(organization.getId()).orElseThrow(() -> new ModelRuntimeException("Organization not found"));
        org.openfact.pe.models.utils.RepresentationToModel.modelToRepresentation(informacionAdicional, rep.getInformacionAdicional());

        OrganizacionInformacionSunatModel sunatInformacion = organizationInformacionSUNATProvider.getOrganizacionInformacionSUNAT(organization.getId()).orElseThrow(() -> new ModelRuntimeException("Organization not found"));
        org.openfact.pe.models.utils.RepresentationToModel.modelToRepresentation(sunatInformacion, rep.getInformacionSunat());
    }

}
