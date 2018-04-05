package org.openfact.pe.services;

import org.openfact.pe.OrganizacionesResource;
import org.openfact.pe.idm.OrganizacionRepresentation;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.InformacionAdicionalProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

@Transactional
@ApplicationScoped
public class DefaultOrganizacionesResource implements OrganizacionesResource {

    @Inject
    private InformacionAdicionalProvider informacionAdicionalProvider;

    @Override
    public OrganizacionRepresentation getCompany(String organizationId) {
        InformacionAdicionalModel informacionAdicional = informacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));
        return ModelToRepresentation.toRepresentation(informacionAdicional, true);
    }

    @Override
    public OrganizacionRepresentation updateCompany(String organizationId, OrganizacionRepresentation rep) {
        InformacionAdicionalModel informacionAdicional = informacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));

        informacionAdicional.setAssignedId(rep.getAssignedId());
        informacionAdicional.setAdditionalAssignedId(rep.getAdditionalAssignedId());
        informacionAdicional.setRazonSocial(rep.getRazonSocial());
        informacionAdicional.setNombreComercial(rep.getNombreComercial());
        informacionAdicional.setRegion(rep.getRegion());
        informacionAdicional.setProvincia(rep.getProvincia());
        informacionAdicional.setDistrito(rep.getDistrito());
        informacionAdicional.setCodigoPostal(rep.getCodigoPostal());
        informacionAdicional.setDireccion(rep.getDireccion());

        return ModelToRepresentation.toRepresentation(informacionAdicional, true);
    }
}
