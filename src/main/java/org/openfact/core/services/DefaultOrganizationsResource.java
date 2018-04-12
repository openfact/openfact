package org.openfact.core.services;

import org.keycloak.common.util.PemUtils;
import org.keycloak.jose.jws.AlgorithmType;
import org.keycloak.representations.idm.KeysMetadataRepresentation;
import org.openfact.core.OrganizationsResource;
import org.openfact.core.bootstrap.ApplianceBootstrap;
import org.openfact.core.idm.ComponentRepresentation;
import org.openfact.core.idm.OrganizationRepresentation;
import org.openfact.core.idm.OrganizationSearchQueryRepresentation;
import org.openfact.core.idm.OrganizationSearchResultRepresentation;
import org.openfact.core.keys.KeyProvider;
import org.openfact.core.keys.RsaKeyMetadata;
import org.openfact.core.keys.component.ComponentModel;
import org.openfact.core.keys.component.utils.ComponentUtil;
import org.openfact.core.models.*;
import org.openfact.core.models.utils.DefaultKeyProviders;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.models.utils.RepresentationToModel;
import org.openfact.core.security.ISecurityContext;

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
    private UserProvider userProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private KeyManager keystore;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private ComponentUtil componentUtil;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    @Inject
    private ISecurityContext securityContext;

    @Override
    public OrganizationRepresentation createOrganization(@Valid OrganizationRepresentation organizationRepresentation) {
        OrganizationRepresentation.OrganizationOwnerRepresentation ownerRepresentation = organizationRepresentation.getOwner();

        Optional<UserModel> ownerModel = userProvider.getUser(ownerRepresentation.getId());
        if (!ownerModel.isPresent()) {
            throw new BadRequestException("Owner does not exist");
        }

        OrganizationModel organizationModel = organizationProvider.addOrganization(organizationRepresentation.getName(), ownerModel.get());
        organizationModel.setDescription(organizationRepresentation.getDescription());

        // Certificate
        if (componentProvider.getComponents(organizationModel, organizationModel.getId(), KeyProvider.class.getName()).isEmpty()) {
            try {
                defaultKeyProviders.createProviders(organizationModel);
            } catch (ModelException e) {
                throw new RuntimeException("Could not create certificates", e);
            }
        }

        return ModelToRepresentation.toRepresentation(organizationModel, true);
    }

    @Override
    public List<OrganizationRepresentation> getOrganizations(String organizationId, String userId, String role) {
        if (organizationId != null) {
            return organizationProvider.getOrganization(organizationId)
                    .map(organizationModel -> Collections.singletonList(ModelToRepresentation.toRepresentation(organizationModel, false)))
                    .orElseGet(Collections::emptyList);
        }

        if (userId != null && role != null) {
            UserModel user = userProvider.getUser(userId).orElseThrow(() -> new BadRequestException("User not found"));

            if (role.toLowerCase().equals("owner")) {
                return user.getOwnedOrganizations()
                        .stream()
                        .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, false))
                        .collect(Collectors.toList());
            } else if (role.toLowerCase().equals("collaborator")) {
                return user.getCollaboratedOrganizations()
                        .stream()
                        .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, false))
                        .collect(Collectors.toList());
            } else {
                throw new BadRequestException("Invalid mode value. Accepted values are [owner, collaborator]");
            }
        }

        throw new BadRequestException("Invalid parameters");
    }

    @Override
    public OrganizationSearchResultRepresentation searchOrganizations(OrganizationSearchQueryRepresentation organizationQuery) {
        if (organizationQuery.getUserId() != null) {
            UserModel user = userProvider.getUser(organizationQuery.getUserId()).orElseThrow(() -> new BadRequestException("User not found"));

            OrganizationSearchResultRepresentation result = new OrganizationSearchResultRepresentation();

            List<OrganizationRepresentation> owned = user.getOwnedOrganizations()
                    .stream()
                    .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, false))
                    .collect(Collectors.toList());
            List<OrganizationRepresentation> collaborated = user.getCollaboratedOrganizations()
                    .stream()
                    .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, false))
                    .collect(Collectors.toList());

            result.setOwned(owned);
            result.setCollaborated(collaborated);

            if (securityContext.isAdmin()) {
                organizationProvider.getOrganization(ApplianceBootstrap.MASTER_ORGANIZACION_NAME).ifPresent(masterOrganization ->  {
                    result.setMaster(ModelToRepresentation.toRepresentation(masterOrganization, false));
                });
            }

            return result;
        }

        throw new BadRequestException("Invalid parameters");
    }

    @Override
    public OrganizationRepresentation getOrganization(String organizationId) {
        return organizationProvider.getOrganization(organizationId)
                .map(organizationModel -> ModelToRepresentation.toRepresentation(organizationModel, true))
                .orElseThrow(() -> new NotFoundException("Organization not found"));
    }

    @Override
    public OrganizationRepresentation updateOrganization(String organizationId, OrganizationRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        if (rep.getName() != null) {
            organization.setName(rep.getName());
        }

        if (rep.getDescription() != null) {
            organization.setDescription(rep.getDescription());
        }

        if (rep.getUseCustomSmtpConfig() != null) {
            organization.setUseCustomSmtpConfig(rep.getUseCustomSmtpConfig());
        }

        if (rep.getUseCustomCertificates() != null) {
            organization.setUseCustomCertificates(rep.getUseCustomCertificates());
        }

        if (rep.getSmtpServer() != null) {
            organization.setSmtpConfig(new HashMap<>(rep.getSmtpServer()));
        }

        return ModelToRepresentation.toRepresentation(organization, true);
    }

    @Override
    public void deleteOrganization(String organizationId) {
        throw new ForbiddenException();
    }

    @Override
    public KeysMetadataRepresentation getKeyMetadata(String organizationId) {
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
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        ComponentModel model = componentProvider.getComponent(organization, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        return ModelToRepresentation.toRepresentation(model, false, componentUtil);
    }

    @Override
    public Response updateComponent(String organizationId, String componentId, ComponentRepresentation rep) {
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
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organization not found"));

        ComponentModel model = componentProvider.getComponent(organization, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        componentProvider.removeComponent(organization, model);
    }

}
