package org.openfact.pe.models.jpa;

import org.openfact.pe.models.TotalInformacionAdicionalModel;
import org.openfact.pe.models.jpa.entities.TotalInformacionAdicionalEntity;

import java.math.BigDecimal;

public class TotalInformacionAdicionalAdapter implements TotalInformacionAdicionalModel {

    private final TotalInformacionAdicionalEntity totalInformacionAdicional;

    public TotalInformacionAdicionalAdapter(TotalInformacionAdicionalEntity totalInformacionAdicional) {
        this.totalInformacionAdicional = totalInformacionAdicional;
    }

    @Override
    public BigDecimal getTotalGravado() {
        return totalInformacionAdicional.getGravado();
    }

    @Override
    public void setTotalGravado(BigDecimal totalGravado) {
        totalInformacionAdicional.setGravado(totalGravado);
    }

    @Override
    public BigDecimal getTotalGratuito() {
        return totalInformacionAdicional.getGratuito();
    }

    @Override
    public void setTotalGratuito(BigDecimal totalGratuito) {
        totalInformacionAdicional.setGratuito(totalGratuito);
    }

    @Override
    public BigDecimal getTotalInafecto() {
        return totalInformacionAdicional.getInafecto();
    }

    @Override
    public void setTotalInafecto(BigDecimal totalInafecto) {
        totalInformacionAdicional.setInafecto(totalInafecto);
    }

    @Override
    public BigDecimal getTotalExonerado() {
        return totalInformacionAdicional.getExonerado();
    }

    @Override
    public void setTotalExonerado(BigDecimal totalExonerado) {
        totalInformacionAdicional.setExonerado(totalExonerado);
    }

}
