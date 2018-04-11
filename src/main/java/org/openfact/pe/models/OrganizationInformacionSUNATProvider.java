package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface OrganizationInformacionSUNATProvider {

    Optional<OrganizacionInformacionSUNATModel> getOrganizacionInformacionSUNAT(String id);

    Optional<OrganizacionInformacionSUNATModel> getOrganizacionInformacionSUNAT(OrganizationModel organization);

}
