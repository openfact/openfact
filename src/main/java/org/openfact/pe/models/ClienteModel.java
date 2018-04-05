package org.openfact.pe.models;

import org.openfact.pe.models.types.TipoDocumentoEntidad;

public interface ClienteModel {

    TipoDocumentoEntidad getTipoDocumento();
    void setTipoDocumento(TipoDocumentoEntidad tipoDocumento);

    String getNumeroDocumento();
    void setNumeroDocumento(String numeroDocumento);

    String getNombre();
    void setNombre(String nombre);

    String getEmail();
    void setEmail(String email);

    String getDireccion();
    void setDireccion(String direccion);

}
