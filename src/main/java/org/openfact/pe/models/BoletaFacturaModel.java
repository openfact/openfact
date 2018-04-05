package org.openfact.pe.models;

import java.util.Date;

public interface BoletaFacturaModel {

    String getId();

    TipoInvoice getTipoInvoice();

    String getIdAsignado();

    Date getFechaEmision();

    Date getFechaVencimiento();

    String getMoneda();

    String getObservacion();

    ClienteModel getCliente();
}
