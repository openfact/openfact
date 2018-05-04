package org.openfact.pe.models;

import java.util.Date;

public interface BajaModel {

    String getId();
    String getSerie();
    int getNumero();

    Date getFechaEmision();

    String getMotivoBaja();
    void setMotivoBaja(String motivoBaja);

    EstadoComprobantePago getEstado();
    InvoiceModel getInvoiceAfectado();

    String getFileId();
    void setFileId(String fileId);

    boolean getEnviarSunat();
    void setEnviarSunat(boolean enviarSunat);

    boolean getEnviarCliente();
    void setEnviarCliente(boolean enviarCliente);

    CdrModel getCdr();
    EstadoSunatModel getEstadoSunat();
}
