package org.openfact.pe.models;

import org.openfact.pe.models.types.TipoDocumentoEntidad;

public interface ClienteModel {

    TipoDocumentoEntidad getTipoDocumento();

    String getNumeroDocumento();

    String getNombre();

    String getEmail();

    String getDireccion();

}
