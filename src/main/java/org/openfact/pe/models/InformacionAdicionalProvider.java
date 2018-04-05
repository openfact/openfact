package org.openfact.pe.models;

import java.util.Optional;

public interface InformacionAdicionalProvider {

    Optional<InformacionAdicionalModel> getOrganizacionInformacionAdicional(String id);

}
