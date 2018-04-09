package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.TotalInformacionAdicionalEntity;

import java.math.BigDecimal;

public class ReadOnlyTotalInformacionAdicionalAdapter extends TotalInformacionAdicionalAdapter {
    public ReadOnlyTotalInformacionAdicionalAdapter(TotalInformacionAdicionalEntity totalInformacionAdicional) {
        super(totalInformacionAdicional);
    }

    @Override
    public void setTotalExonerado(BigDecimal totalExonerado) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalGratuito(BigDecimal totalGratuito) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalGravado(BigDecimal totalGravado) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalInafecto(BigDecimal totalInafecto) {
        ReadOnlyUtils.throwException();
    }
}
