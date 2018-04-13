package org.openfact.core.bootstrap;

import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.utils.DefaultKeyProviders;
import org.openfact.core.security.PermissionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@ApplicationScoped
public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ServerBootstrap.class);

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private RoleProvider roleProvider;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    public void bootstrap() {
        Optional<OrganizationModel> organization = organizationProvider.getOrganization(OrganizationModel.MASTER_ID);
        if (!organization.isPresent()) {
            createDefaultRoles();
            createMasterOrganization();
        }
    }

    private void createDefaultRoles() {
        logger.info("Initializing Default Roles");

        Set<PermissionType> ownerPermissions = new HashSet<>();
        ownerPermissions.add(PermissionType.organization_admin);
        ownerPermissions.add(PermissionType.organization_edit);
        ownerPermissions.add(PermissionType.organization_view);
        ownerPermissions.add(PermissionType.component_manage);
        ownerPermissions.add(PermissionType.component_view);

        Set<PermissionType> collaboratorPermissions = new HashSet<>();
        collaboratorPermissions.add(PermissionType.organization_view);

        roleProvider.addRole(RoleModel.OWNER_ID, "Organization Owner", ownerPermissions, true);
        roleProvider.addRole(RoleModel.COLLABORATOR_ID, "Organization Collaborator", collaboratorPermissions, false);
    }

    private void createMasterOrganization() {
        logger.info("Initializing Admin Organization " + OrganizationModel.MASTER_ID);

        try {
            OrganizationModel organization = organizationProvider.addOrganization(OrganizationModel.MASTER_ID, OrganizationModel.MASTER_ID, OrganizationType.admin);
            defaultKeyProviders.createProviders(organization);
        } catch (ModelException e) {
            throw new ModelRuntimeException("Could not configure admin organization", e);
        }
    }

}
