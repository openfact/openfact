package org.openfact.pe.models;

public interface ValidacionModel {

    String getId();

    boolean getEstado();
    void setEstado(boolean estado);

    ErrorType getError();
    void setError(ErrorType error);

    String getErrorDescripcion();
    void setErrorDescripcion(String descripcion);

}
