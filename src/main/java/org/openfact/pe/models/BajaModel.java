package org.openfact.pe.models;

import java.util.Date;

public interface BajaModel {

    String getId();
    String getSerie();
    int getNumero();

    Date getFechaGeneracionBaja();

    String getMotivoBaja();
    void setMotivoBaja(String motivoBaja);

    EstadoComprobantePago getEstado();
    InvoiceModel getInvoiceAfectado();

}
