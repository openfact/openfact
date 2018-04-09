package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface InformacionAdicionalProvider {

    Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(String id);

    Optional<OrganizacionInformacionAdicionalModel> getOrganizacionInformacionAdicional(OrganizationModel organization);

}
