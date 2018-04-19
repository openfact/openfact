package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface OrganizationInformacionSunatProvider {

    Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSUNAT(String id);

    Optional<OrganizacionInformacionSunatModel> getOrganizacionInformacionSunat(OrganizationModel organization);

}
