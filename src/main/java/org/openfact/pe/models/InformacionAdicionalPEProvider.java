package org.openfact.pe.models;

import java.util.Optional;

public interface InformacionAdicionalPEProvider {

    Optional<InformacionAdicionalPEModel> getOrganizacionInformacionAdicional(String id);

}
