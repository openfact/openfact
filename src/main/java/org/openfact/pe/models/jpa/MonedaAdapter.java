package org.openfact.pe.models.jpa;

import org.openfact.pe.models.MonedaModel;
import org.openfact.pe.models.jpa.entities.MonedaEntity;

import java.math.BigDecimal;

public class MonedaAdapter implements MonedaModel {

    private final MonedaEntity monedaEntity;

    public MonedaAdapter(MonedaEntity monedaEntity) {
        this.monedaEntity = monedaEntity;
    }

    @Override
    public String getMoneda() {
        return monedaEntity.getMoneda();
    }

    @Override
    public void setMoneda(String moneda) {
        monedaEntity.setMoneda(moneda);
    }

    @Override
    public BigDecimal getTipoCambio() {
        return monedaEntity.getTipoCambio();
    }

    @Override
    public void setTipoCambio(BigDecimal tipoCambio) {
        monedaEntity.setTipoCambio(tipoCambio);
    }

}
