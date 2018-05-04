package org.openfact.pe.models;

public interface EstadoSunatModel {

    String getId();

    boolean getEstado();
    void setEstado(boolean estado);

    String getCodigo();
    void setCodigo(String codigo);

    String getDescripcion();
    void setDescripcion(String descripcion);

}
