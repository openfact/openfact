package org.openfact.pe.models;

import java.util.Date;

public interface FechaModel {

    Date getEmision();
    void setEmision(Date emision);

    Date getVencimiento();
    void setVencimiento(Date vencimiento);

}
