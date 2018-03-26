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
import java.util.List;
import java.util.Optional;

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
    public List<CompanyRepresentation> getCompanies() {
        throw new ForbiddenException();
    }

}
