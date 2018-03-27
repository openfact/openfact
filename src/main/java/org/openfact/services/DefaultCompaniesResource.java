package org.openfact.services;

import org.openfact.CompaniesResource;
import org.openfact.ErrorResponse;
import org.openfact.models.CompanyModel;
import org.openfact.models.CompanyProvider;
import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.CompanyRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultCompaniesResource implements CompaniesResource {

    @Inject
    private UserProvider userProvider;

    @Inject
    private CompanyProvider companyProvider;

    @Override
    public CompanyRepresentation createCompany(@Valid CompanyRepresentation companyRepresentation) {
        CompanyRepresentation.CompanyOwnerRepresentation ownerRepresentation = companyRepresentation.getOwner();

        Optional<UserModel> ownerModel = userProvider.getUser(ownerRepresentation.getId());
        if (!ownerModel.isPresent()) {
            throw new BadRequestException("Owner does not exist");
        }

        CompanyModel companyModel = companyProvider.addCompany(companyRepresentation.getName(), ownerModel.get());
        companyModel.setDescription(companyRepresentation.getDescription());

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

        if (rep.getSmtpServer() != null) {
            company.setSmtpConfig(new HashMap<>(rep.getSmtpServer()));
        }

        return ModelToRepresentation.toRepresentation(company, true);
    }

    @Override
    public void deleteCompany(String companyId) {
        throw new ForbiddenException();
    }

}
