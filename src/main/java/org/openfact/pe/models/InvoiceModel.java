package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface InvoiceModel {

    String CODIGO_TIPO_COMPROBANTE = "codigoComprobante";
    String ESTADO_COMPROBANTE = "estadoComprobante";

    String getId();
    String getSerie();
    int getNumero();
    String getCodigoTipoComprobante();

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
    Optional<ResumenDiarioModel> getResumenDiario();

}
