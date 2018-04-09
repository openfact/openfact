package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ImpuestosModel;
import org.openfact.pe.models.jpa.entities.ImpuestosEntity;

import java.math.BigDecimal;

public class ImpuestosAdapter implements ImpuestosModel {

    private final ImpuestosEntity impuestos;

    public ImpuestosAdapter(ImpuestosEntity impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public BigDecimal getIGV() {
        return impuestos.getIgv();
    }

    @Override
    public void setIGV(BigDecimal IGV) {
        impuestos.setIgv(IGV);
    }

    @Override
    public BigDecimal getISC() {
        return impuestos.getIsc();
    }

    @Override
    public void setISC(BigDecimal ISC) {
        impuestos.setIsc(ISC);
    }
}
