package org.openfact.pe.models;

public interface ClienteModel {

    String getTipoDocumento();
    void setTipoDocumento(String tipoDocumento);

    String getNumeroDocumento();
    void setNumeroDocumento(String numeroDocumento);

    String getNombre();
    void setNombre(String nombre);

    String getEmail();
    void setEmail(String email);

    String getDireccion();
    void setDireccion(String direccion);

}
