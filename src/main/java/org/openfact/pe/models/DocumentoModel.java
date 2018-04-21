package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface DocumentoModel {

    String getId();

    boolean getEnviarSUNAT();
    void setEnviarSunat(boolean enviarSUNAT);

    boolean getEnviarCliente();
    void setEnviarCliente(boolean enviarCliente);

    EstadoComprobantePago getEstado();
    void setEstado(EstadoComprobantePago estado);

    String getEstadoDescripcion();
    void setEstadoDescripcion(String estadoDescripcion);

    String getFileId();
    void setFileId(String fileId);

    String getCdrFileId();
    void setCdrFileId(String fileId);

    ValidacionModel getValidacion();

    OrganizationModel getOrganization();
}
