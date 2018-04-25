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
    public BigDecimal getIgv() {
        return impuestos.getIgv();
    }

    @Override
    public void setIgv(BigDecimal igv) {
        impuestos.setIgv(igv);
    }

    @Override
    public BigDecimal getIsc() {
        return impuestos.getIsc();
    }

    @Override
    public void setIsc(BigDecimal isc) {
        impuestos.setIsc(isc);
    }

}
