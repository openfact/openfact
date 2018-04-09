package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.TotalEntity;

import java.math.BigDecimal;

public class ReadOnlyTotalAdapter extends TotalAdapter {
    public ReadOnlyTotalAdapter(TotalEntity total) {
        super(total);
    }

    @Override
    public void setDescuentoGlobal(BigDecimal descuentoGlobal) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setOtrosCargos(BigDecimal otrosCargos) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalPagar(BigDecimal pagar) {
        ReadOnlyUtils.throwException();
    }
}
