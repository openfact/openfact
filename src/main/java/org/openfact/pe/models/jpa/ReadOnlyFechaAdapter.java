package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.FechaEntity;

import java.util.Date;

public class ReadOnlyFechaAdapter extends FechaAdapter {

    public ReadOnlyFechaAdapter(FechaEntity fecha) {
        super(fecha);
    }

    @Override
    public void setEmision(Date emision) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setVencimiento(Date vencimiento) {
        ReadOnlyUtils.throwException();
    }

}
