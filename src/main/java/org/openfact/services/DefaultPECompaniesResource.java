package org.openfact.services;

import org.openfact.CompaniesResource;
import org.openfact.PECompaniesResource;
import org.openfact.models.*;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.PEModelToRepresentation;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.PECompanyRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultPECompaniesResource implements PECompaniesResource {

    @Inject
    private PECompanyProvider companyProvider;

    @Override
    public PECompanyRepresentation getCompany(String companyId) {
        PECompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new BadRequestException("Company not found"));
        return PEModelToRepresentation.toRepresentation(company, true);
    }

    @Override
    public PECompanyRepresentation updateCompany(String companyId, PECompanyRepresentation rep) {
        PECompanyModel company = companyProvider.getCompany(companyId).orElseThrow(() -> new BadRequestException("Company not found"));

        company.setAssignedId(rep.getAssignedId());
        company.setAdditionalAssignedId(rep.getAdditionalAssignedId());
        company.setRazonSocial(rep.getRazonSocial());
        company.setNombreComercial(rep.getNombreComercial());
        company.setRegion(rep.getRegion());
        company.setProvincia(rep.getProvincia());
        company.setDistrito(rep.getDistrito());
        company.setCodigoPostal(rep.getCodigoPostal());
        company.setDireccion(rep.getDireccion());

        return PEModelToRepresentation.toRepresentation(company, true);
    }
}
