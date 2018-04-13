package org.openfact.core.bootstrap;

import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.utils.DefaultKeyProviders;
import org.openfact.core.security.PermissionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ServerBootstrap.class);

    public final static String MASTER_ORGANIZACION_NAME = "master";

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private RoleProvider roleProvider;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    public void bootstrap() {
        Optional<OrganizationModel> organization = organizationProvider.getOrganization(MASTER_ORGANIZACION_NAME);
        if (!organization.isPresent()) {
            createDefaultRoles();
            createMasterOrganization();
        }
    }

    private void createDefaultRoles() {
        logger.info("Initializing Default Roles");
        roleProvider.addRole("Organization Owner", new HashSet<>(Collections.singletonList(PermissionType.organization_admin)), true);
        roleProvider.addRole("Organization Collaborator", new HashSet<>(Collections.singletonList(PermissionType.organization_edit)), true);
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
