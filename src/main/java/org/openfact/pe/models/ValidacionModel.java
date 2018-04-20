package org.openfact.pe.models;

import java.util.List;

public interface ValidacionModel {

    String getId();

    boolean getEstado();
    void setEstado(boolean estado);

    ErrorModel addError(ErrorType tipo, String descripcion);
    List<ErrorModel> getErrores();
}
