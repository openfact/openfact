package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.MonedaEntity;

import java.math.BigDecimal;

public class ReadOnlyMonedaAdapter extends MonedaAdapter {

    public ReadOnlyMonedaAdapter(MonedaEntity monedaEntity) {
        super(monedaEntity);
    }

    @Override
    public void setMoneda(String moneda) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTipoCambio(BigDecimal tipoCambio) {
        ReadOnlyUtils.throwException();
    }
}
