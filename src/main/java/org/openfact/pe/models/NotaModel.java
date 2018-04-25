package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaModel {

    String getId();
    String getSerie();
    int getNumero();

    String getTipoNota();
    void setTipoNota(String tipoNota);

    InvoiceModel getInvoiceAfectado();

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
