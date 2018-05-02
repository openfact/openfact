package org.openfact.pe.services;

import org.openfact.core.security.ISecurityContext;
import org.openfact.core.models.PermissionType;
import org.openfact.pe.OrganizacionesResource;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.OrganizationInformacionAdicionalProvider;
import org.openfact.pe.models.OrganizationInformacionSunatProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;
import org.openfact.pe.representations.idm.OrganizacionInformacionAdicionalRepresentation;
import org.openfact.pe.representations.idm.OrganizacionInformacionSunatRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;

@Transactional
@ApplicationScoped
public class DefaultOrganizacionesResource implements OrganizacionesResource {

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private OrganizationInformacionAdicionalProvider organizationInformacionAdicionalProvider;

    @Inject
    private OrganizationInformacionSunatProvider organizationInformacionSUNATProvider;

    @Override
    public OrganizacionInformacionAdicionalRepresentation getOrganization(String organizationId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizacionInformacionAdicionalModel informacionAdicional = organizationInformacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Organization not found"));
        return ModelToRepresentation.toRepresentation(informacionAdicional, true);
    }

    @Override
    public OrganizacionInformacionAdicionalRepresentation updateOrganizationInformacionAdicional(String organizationId, OrganizacionInformacionAdicionalRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_edit, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizacionInformacionAdicionalModel informacionAdicional = organizationInformacionAdicionalProvider.getOrganizacionInformacionAdicional(organizationId).orElseThrow(() -> new BadRequestException("Company not found"));
        RepresentationToModel.modelToRepresentation(informacionAdicional, rep);

        return ModelToRepresentation.toRepresentation(informacionAdicional, true);
    }

    @Override
    public OrganizacionInformacionSunatRepresentation getOrganizationInformacionSUNAT(String organizationId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizacionInformacionSunatModel informacionSUNAT = organizationInformacionSUNATProvider.getOrganizacionInformacionSUNAT(organizationId).orElseThrow(() -> new BadRequestException("Organization not found"));
        return ModelToRepresentation.toRepresentation(informacionSUNAT, true);
    }

    @Override
    public OrganizacionInformacionSunatRepresentation updateOrganizationInformacionSUNAT(String organizationId, OrganizacionInformacionSunatRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.organization_edit, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizacionInformacionSunatModel sunatInformacion = organizationInformacionSUNATProvider.getOrganizacionInformacionSUNAT(organizationId).orElseThrow(() -> new BadRequestException("Organization not found"));
        RepresentationToModel.modelToRepresentation(sunatInformacion, rep);

        return ModelToRepresentation.toRepresentation(sunatInformacion, true);
    }
}
