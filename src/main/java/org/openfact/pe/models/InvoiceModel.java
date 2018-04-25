package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface InvoiceModel {

    String getId();
    String getSerie();
    int getNumero();

    EstadoComprobantePago getEstado();
    void setEstado(EstadoComprobantePago estado);

    String getEstadoDescripcion();
    void setEstadoDescripcion(String estadoDescripcion);

    boolean getEnviarSunat();
    void setEnviarSunat(boolean enviarSunat);

    boolean getEnviarCliente();
    void setEnviarCliente(boolean enviarCliente);

    String getFileId();
    void setFileId(String fileId);

    String getCdrFileId();
    void setCdrFileId(String fileId);

    ValidacionModel getValidacion();
    DatosVentaModel getDatosVenta();
    OrganizationModel getOrganization();

}
