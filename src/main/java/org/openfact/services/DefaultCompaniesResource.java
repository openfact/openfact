package org.openfact.services;

import org.keycloak.common.util.PemUtils;
import org.keycloak.jose.jws.AlgorithmType;
import org.keycloak.representations.idm.KeysMetadataRepresentation;
import org.openfact.CompaniesResource;
import org.openfact.ErrorResponse;
import org.openfact.keys.KeyProvider;
import org.openfact.keys.RsaKeyMetadata;
import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.component.ComponentValidationException;
import org.openfact.keys.component.utils.ComponentUtil;
import org.openfact.models.*;
import org.openfact.models.utils.DefaultKeyProviders;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.ComponentRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultCompaniesResource implements CompaniesResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserProvider userProvider;

    @Inject
    private CompanyProvider companyProvider;

    @Inject
    private KeyManager keystore;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private ComponentUtil componentUtil;

    @Inject
    private DefaultKeyProviders defaultKeyProviders;

    @Override
    public CompanyRepresentation createCompany(@Valid CompanyRepresentation companyRepresentation) {
        CompanyRepresentation.CompanyOwnerRepresentation ownerRepresentation = companyRepresentation.getOwner();

        Optional<UserModel> ownerModel = userProvider.getUser(ownerRepresentation.getId());
        if (!ownerModel.isPresent()) {
            throw new BadRequestException("Owner does not exist");
        }

        CompanyModel companyModel = companyProvider.addCompany(companyRepresentation.getName(), ownerModel.get());
        companyModel.setDescription(companyRepresentation.getDescription());

        // Certificate
        if (componentProvider.getComponents(companyModel, companyModel.getId(), KeyProvider.class.getName()).isEmpty()) {
            try {
                defaultKeyProviders.createProviders(companyModel);
            } catch (ModelException e) {
                throw new RuntimeException("Could not create certificates", e);
            }
        }

        return ModelToRepresentation.toRepresentation(companyModel, true);
    }

    @Override
    public List<CompanyRepresentation> getCompanies(String companyId, String userId, String role) {
        if (companyId != null) {
            return companyProvider.getCompany(companyId)
                    .map(companyModel -> Collections.singletonList(ModelToRepresentation.toRepresentation(companyModel, false)))
                    .orElseGet(Collections::emptyList);
        }

        if (userId != null && role != null) {
            UserModel user = userProvider.getUser(userId).orElseThrow(() -> new BadRequestException("User not found"));

            if (role.toLowerCase().equals("owner")) {
                return user.getOwnedCompanies()
                        .stream()
                        .map(companyModel -> ModelToRepresentation.toRepresentation(companyModel, false))
                        .collect(Collectors.toList());
            } else if (role.toLowerCase().equals("collaborator")) {
                return user.getCollaboratedCompanies()
                        .stream()
                        .map(companyModel -> ModelToRepresentation.toRepresentation(companyModel, false))
                        .collect(Collectors.toList());
            } else {
                throw new BadRequestException("Invalid mode value. Accepted values are [owner, collaborator]");
            }
        }

        throw new BadRequestException("Invalid parameters");
    }

    @Override
    public CompanyRepresentation getCompany(String companyId) {
        return companyProvider.getCompany(companyId)
                .map(companyModel -> ModelToRepresentation.toRepresentation(companyModel, true))
                .orElseThrow(() -> new NotFoundException("Company not found"));
    }

    @Override
    public CompanyRepresentation updateCompany(String companyId, CompanyRepresentation rep) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        if (rep.getName() != null) {
            company.setName(rep.getName());
        }

        if (rep.getDescription() != null) {
            company.setDescription(rep.getDescription());
        }

        if (rep.getUseCustomSmtpConfig() != null) {
            company.setUseCustomSmtpConfig(rep.getUseCustomSmtpConfig());
        }

        if (rep.getSmtpServer() != null) {
            company.setSmtpConfig(new HashMap<>(rep.getSmtpServer()));
        }

        return ModelToRepresentation.toRepresentation(company, true);
    }

    @Override
    public void deleteCompany(String companyId) {
        throw new ForbiddenException();
    }

    @Override
    public KeysMetadataRepresentation getKeyMetadata(String companyId) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();

        Map<String, String> active = new HashMap<>();
        active.put(AlgorithmType.RSA.name(), keystore.getActiveRsaKey(company).getKid());
        keys.setActive(active);

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (RsaKeyMetadata m : keystore.getRsaKeys(company, true)) {
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
    public List<ComponentRepresentation> getComponents(String companyId, String parent, String type) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        List<ComponentModel> components;
        if (parent == null && type == null) {
            components = componentProvider.getComponents(company);
        } else if (type == null) {
            components = componentProvider.getComponents(company, parent);
        } else if (parent == null) {
            components = componentProvider.getComponents(company, company.getId(), type);
        } else {
            components = componentProvider.getComponents(company, parent, type);
        }
        List<ComponentRepresentation> reps = new LinkedList<>();
        for (ComponentModel component : components) {
            ComponentRepresentation rep = ModelToRepresentation.toRepresentation(component, false, componentUtil);
            reps.add(rep);
        }
        return reps;
    }

    @Override
    public Response createComponent(String companyId, ComponentRepresentation rep) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        try {
            ComponentModel model = RepresentationToModel.toModel(rep);
            if (model.getParentId() == null) model.setParentId(company.getId());

            model = componentProvider.addComponentModel(company, model);

            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
        } catch (ModelException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public ComponentRepresentation getComponent(String companyId, String componentId) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        ComponentModel model = componentProvider.getComponent(company, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        return ModelToRepresentation.toRepresentation(model, false, componentUtil);
    }

    @Override
    public Response updateComponent(String companyId, String componentId, ComponentRepresentation rep) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        try {
            ComponentModel model = componentProvider.getComponent(company, componentId);
            if (model == null) {
                throw new NotFoundException("Could not find component");
            }
            RepresentationToModel.updateComponent(rep, model, false, componentUtil);

            componentProvider.updateComponent(company, model);
            return Response.noContent().build();
        } catch (ModelException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void removeComponent(String companyId, String componentId) {
        CompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new NotFoundException("Company not found"));

        ComponentModel model = componentProvider.getComponent(company, componentId);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        componentProvider.removeComponent(company, model);
    }

}
