package org.openfact.core.services;

import org.keycloak.common.util.PemUtils;
import org.keycloak.jose.jws.AlgorithmType;
import org.keycloak.representations.idm.KeysMetadataRepresentation;
import org.openfact.core.OrganizationsResource;
import org.openfact.core.keys.RsaKeyMetadata;
import org.openfact.core.keys.component.ComponentModel;
import org.openfact.core.keys.component.utils.ComponentUtil;
import org.openfact.core.managers.OrganizationManager;
import org.openfact.core.models.*;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.models.utils.RepresentationToModel;
import org.openfact.core.representations.idm.ComponentRepresentation;
import org.openfact.core.representations.idm.ExtendedOrganizationRepresentation;
import org.openfact.core.representations.idm.OrganizationRepresentation;
import org.openfact.core.representations.idm.OrganizationSearchQueryRepresentation;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.models.PermissionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultOrganizationsResource implements OrganizationsResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private KeyManager keystore;

    @Inject
    private UserProvider userProvider;

    @Inject
    private ComponentUtil componentUtil;

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private RoleMembershipProvider roleMembershipProvider;

    @Override
    public OrganizationRepresentation createOrganization(@Valid OrganizationRepresentation representation) {
        organizationProvider.getOrganizationByName(representation.getName()).ifPresent(organization -> {
            throw new BadRequestException("Organization Name already registered");
        });

        UserModel currentUser = userProvider.getUserByIdentityId(securityContext.getIdentityId()).orElseThrow(() -> new ForbiddenException("Could not find user session"));

        OrganizationModel organization = organizationManager.createOrganization(representation, currentUser);
        return ModelToRepresentation.toRepresentation(organization, true);
    }

    @Override
    public List<OrganizationRepresentation> getOrganizations(String organizationId, String filterText, int offset, int limit) {
        if (organizationId != null) {
            return organizationProvider.getOrganization(organizationId)
                    .map(organizationModel -> Collections.singletonList(ModelToRepresentation.toRepresentation(organizationModel, false)))
                    .orElseGet(Collections::emptyList);
        }

        if (filterText != null) {
            return organizationProvider.getOrganizations(filterText, offset, limit)
                    .stream()
                    .map(model -> ModelToRepresentation.toRepresentation(model, false))
                    .collect(Collectors.toList());
        } else {
            return organizationProvider.getOrganizations(offset, limit)
                    .stream()
                    .map(model -> ModelToRepresentation.toRepresentation(model, false))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<ExtendedOrganizationRepresentation> searchOrganizations(@Valid OrganizationSearchQueryRepresentation query) {
        if (query.getUserId() != null) {
            UserModel user = userProvider.getUser(query.getUserId()).orElseThrow(() -> new BadRequestException("User not found"));

            if (securityContext.isAdmin()) {
                int offset = query.getOffset() != null ? query.getOffset() : 0;
                int limit = query.getLimit() != null ? query.getLimit() : 100;
                return organizationProvider.getOrganizations(offset, limit)
                        .stream()
                        .map(model -> ModelToRepresentation.toExtendedRepresentation(model, ExtendedOrganizationRepresentation.UserRoleType.none, false))
                        .collect(Collectors.toList());
            } else {
                return roleMembershipProvider.getMemberships(user)
                        .stream()
                        .map(model -> {
                            RoleModel role = model.getRole();
                            ExtendedOrganizationRepresentation.UserRoleType userRole;
                            if (role.getId().equals(RoleModel.OWNER_ID)) {
                                userRole = ExtendedOrganizationRepresentation.UserRoleType.owner;
                            } else {
                                userRole = ExtendedOrganizationRepresentation.UserRoleType.collaborator;
                            }
                            return ModelToRepresentation.toExtendedRepresentation(model.getOrganization(), userRole, false);
                        })
                        .collect(Collectors.toList());
            }
        }

        throw new BadRequestException("Invalid query");
    }

    @Override
    public OrganizationRepresentation getOrganization(String organizationId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_view, organizationId)) {
            throw new ForbiddenException();
        }

        return organizationProvider.getOrganization(organizationId)
                .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, true))
                .orElseThrow(() -> new NotFoundException("Organization not found"));
    }

    @Override
    public OrganizationRepresentation updateOrganization(String organizationId, OrganizationRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_edit, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));
        RepresentationToModel.updateOrganization(rep, organization);
        return ModelToRepresentation.toRepresentation(organization, true);
    }

    @Override
    public void deleteOrganization(String organizationId) {
        throw new ForbiddenException();
    }

    @Override
    public KeysMetadataRepresentation getKeyMetadata(String organizationId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();

        Map<String, String> active = new HashMap<>();
        active.put(AlgorithmType.RSA.name(), keystore.getActiveRsaKey(organization).getKid());
        keys.setActive(active);

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (RsaKeyMetadata m : keystore.getRsaKeys(organization, true)) {
            KeysMetadataRepresentation.KeyMetadataRepresentation r = new KeysMetadataRepresentation.KeyMetadataRepresentation();
            r.setProviderId(m.getProviderId());
            r.setProviderPriority(m.getProviderPriority());
            r.setKid(m.getKid());
            r.setStatus(m.getStatus() != null ? m.getStatus().name() : null);
            r.setType(AlgorithmType.RSA.name());
            r.setPublicKey(PemUtils.encodeKey(m.getPublicKey()));
            r.setCertificate(PemUtils.encodeCertificate(m.getCertificate()));
            l.add(r);
        }

        keys.setKeys(l);

        return keys;
    }

    @Override
    public List<ComponentRepresentation> getComponents(String organizationId, String parent, String type) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        List<ComponentModel> components;
        if (parent == null && type == null) {
            components = componentProvider.getComponents(organization);
        } else if (type == null) {
            components = componentProvider.getComponents(organization, parent);
        } else if (parent == null) {
            components = componentProvider.getComponents(organization, organization.getId(), type);
        } else {
            components = componentProvider.getComponents(organization, parent, type);
        }
        List<ComponentRepresentation> reps = new LinkedList<>();
        for (ComponentModel component : components) {
            ComponentRepresentation rep = ModelToRepresentation.toRepresentation(component, false, componentUtil);
            reps.add(rep);
        }
        return reps;
    }

    @Override
    public Response createComponent(String organizationId, ComponentRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        try {
            ComponentModel model = RepresentationToModel.toModel(rep);
            if (model.getParentId() == null) model.setParentId(organization.getId());

            model = componentProvider.addComponentModel(organization, model);

            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
        } catch (ModelException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public ComponentRepresentation getComponent(String organizationId, String componentId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        ComponentModel model = componentProvider.getComponent(organization, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        return ModelToRepresentation.toRepresentation(model, false, componentUtil);
    }

    @Override
    public Response updateComponent(String organizationId, String componentId, ComponentRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        try {
            ComponentModel model = componentProvider.getComponent(organization, componentId);
            if (model == null) {
                throw new NotFoundException("Could not find component");
            }
            RepresentationToModel.updateComponent(rep, model, false, componentUtil);

            componentProvider.updateComponent(organization, model);
            return Response.noContent().build();
        } catch (ModelException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void removeComponent(String organizationId, String componentId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.component_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        ComponentModel model = componentProvider.getComponent(organization, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        componentProvider.removeComponent(organization, model);
    }

}
