package org.openfact.pe.services;

import org.openfact.pe.OrganizacionesResource;
import org.openfact.pe.idm.OrganizacionInformacionAdicionalRepresentation;
import org.openfact.pe.idm.OrganizacionInformacionSUNATRepresentation;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSUNATModel;
import org.openfact.pe.models.OrganizationInformacionAdicionalProvider;
import org.openfact.pe.models.OrganizationInformacionSUNATProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

@Transactional
@ApplicationScoped
public class DefaultOrganizacionesResource implements OrganizacionesResource {

    @Inject
    private OrganizationInformacionAdicionalProvider organizationInformacionAdicionalProvider;

    @Inject
    private OrganizationInformacionSUNATProvider organizationInformacionSUNATProvider;
    @Override
    public OrganizacionInformacionAdicionalRepresentation getOrganization(String organizationId) {
        OrganizacionInformacionAdicionalModel informacionAdicional = organizationInformacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));
        return ModelToRepresentation.toRepresentation(informacionAdicional, true);
    }

    @Override
    public OrganizacionInformacionAdicionalRepresentation updateOrganizationInformacionAdicional(String organizationId, OrganizacionInformacionAdicionalRepresentation rep) {
        OrganizacionInformacionAdicionalModel informacionAdicional = organizationInformacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));

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

    @Override
    public OrganizacionInformacionSUNATRepresentation updateOrganizationInformacionSUNAT(String organizationId, OrganizacionInformacionSUNATRepresentation rep) {
        OrganizacionInformacionSUNATModel sunatInformacion = organizationInformacionSUNATProvider.getOrganizacionInformacionSUNAT(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));

        if (rep.getUsuario() != null) {
            sunatInformacion.setUsuario(rep.getUsuario());
        }

        if (rep.getPassword() != null) {
            sunatInformacion.setPassword(rep.getPassword());
        }

        if (rep.getBoletaFacturaEndpoint() != null) {
            sunatInformacion.setBoletaFacturaEndpoint(rep.getBoletaFacturaEndpoint());
        }

        if (rep.getGuiaRemisionEndpoint() != null) {
            sunatInformacion.setGuiaRemisionEndpoint(rep.getGuiaRemisionEndpoint());
        }

        if (rep.getRetencionPercepcionEndpoint() != null) {
            sunatInformacion.setRetencionPercepcionEndpoint(rep.getRetencionPercepcionEndpoint());
        }

        if (rep.getConsultaFacturaEndpoint() != null) {
            sunatInformacion.setConsultaFacturaEndpoint(rep.getConsultaFacturaEndpoint());
        }

        if (rep.getConsultaCdrEndpoint() != null) {
            sunatInformacion.setConsultaCdrEndpoint(rep.getConsultaCdrEndpoint());
        }

        return ModelToRepresentation.toRepresentation(sunatInformacion, true);
    }
}
