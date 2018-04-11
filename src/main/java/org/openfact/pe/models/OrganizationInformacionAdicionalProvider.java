package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface OrganizationInformacionAdicionalProvider {

    Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(String id);

    Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(OrganizationModel organization);

}
