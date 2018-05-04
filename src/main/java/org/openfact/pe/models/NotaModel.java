package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaModel {

    String getId();
    String getSerie();
    int getNumero();
    String getCodigoTipoComprobante();
    InvoiceModel getInvoiceAfectado();

    String getCodigoMotivo();
    void setCodigoMotivo(String codigoMotivo);

    EstadoComprobantePago getEstado();
    void setEstado(EstadoComprobantePago estado);

    boolean getEnviarSunat();
    void setEnviarSunat(boolean enviarSunat);

    boolean getEnviarCliente();
    void setEnviarCliente(boolean enviarCliente);

    String getFileId();
    void setFileId(String fileId);

    CdrModel getCdr();
    EstadoSunatModel getEstadoSunat();

    DatosVentaModel getDatosVenta();
    OrganizationModel getOrganization();
}
