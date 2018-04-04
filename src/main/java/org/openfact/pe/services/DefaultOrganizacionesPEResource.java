package org.openfact.pe.services;

import org.openfact.pe.OrganizacionesPEResource;
import org.openfact.pe.idm.OrganizacionPERepresentation;
import org.openfact.pe.models.InformacionAdicionalPEModel;
import org.openfact.pe.models.InformacionAdicionalPEProvider;
import org.openfact.pe.models.utils.ModelToRepresentationPE;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

@Transactional
@ApplicationScoped
public class DefaultOrganizacionesPEResource implements OrganizacionesPEResource {

    @Inject
    private InformacionAdicionalPEProvider companyProvider;

    @Override
    public OrganizacionPERepresentation getCompany(String companyId) {
        InformacionAdicionalPEModel company = companyProvider.getOrganizacionInformacionAdicional(companyId).orElseThrow(() -> new BadRequestException("Company not found"));
        return ModelToRepresentationPE.toRepresentation(company, true);
    }

    @Override
    public OrganizacionPERepresentation updateCompany(String companyId, OrganizacionPERepresentation rep) {
        InformacionAdicionalPEModel company = companyProvider.getOrganizacionInformacionAdicional(companyId).orElseThrow(() -> new BadRequestException("Company not found"));

        company.setAssignedId(rep.getAssignedId());
        company.setAdditionalAssignedId(rep.getAdditionalAssignedId());
        company.setRazonSocial(rep.getRazonSocial());
        company.setNombreComercial(rep.getNombreComercial());
        company.setRegion(rep.getRegion());
        company.setProvincia(rep.getProvincia());
        company.setDistrito(rep.getDistrito());
        company.setCodigoPostal(rep.getCodigoPostal());
        company.setDireccion(rep.getDireccion());

        return ModelToRepresentationPE.toRepresentation(company, true);
    }
}
