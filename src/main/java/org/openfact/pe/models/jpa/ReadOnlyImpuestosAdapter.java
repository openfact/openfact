package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.ImpuestosEntity;

import java.math.BigDecimal;

public class ReadOnlyImpuestosAdapter extends ImpuestosAdapter {
    public ReadOnlyImpuestosAdapter(ImpuestosEntity impuestos) {
        super(impuestos);
    }

    @Override
    public void setIGV(BigDecimal IGV) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setISC(BigDecimal ISC) {
        ReadOnlyUtils.throwException();
    }
}
