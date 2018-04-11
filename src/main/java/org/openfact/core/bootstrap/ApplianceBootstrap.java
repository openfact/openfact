package org.openfact.core.bootstrap;

import org.jboss.logging.Logger;
import org.openfact.core.models.ModelException;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.utils.DefaultKeyProviders;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ServerBootstrap.class);

    public final static String MASTER_ORGANIZACION_NAME = "master";

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    public void bootstrap() {
        Optional<OrganizationModel> organization = organizationProvider.getOrganization(MASTER_ORGANIZACION_NAME);
        if (!organization.isPresent()) {
            createMasterOrganization();
        }
    }

    private void createMasterOrganization() {
        logger.info("Initializing Admin Organization " + MASTER_ORGANIZACION_NAME);

        try {
            OrganizationModel organization = organizationProvider.addOrganization(MASTER_ORGANIZACION_NAME, MASTER_ORGANIZACION_NAME);
            defaultKeyProviders.createProviders(organization);
        } catch (ModelException e) {
            throw new ModelRuntimeException("Could not configure admin organization", e);
        }
    }

}
