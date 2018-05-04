package org.openfact.pe.models.jpa;

import org.openfact.pe.models.CdrModel;
import org.openfact.pe.models.EstadoSunatModel;
import org.openfact.pe.models.ResumenDiarioModel;
import org.openfact.pe.models.jpa.entities.ResumenDiarioEntity;

import java.util.Date;

public class ResumenDiarioAdapter implements ResumenDiarioModel {

    private final ResumenDiarioEntity resumenDiario;

    public ResumenDiarioAdapter(ResumenDiarioEntity resumenDiario) {
        this.resumenDiario = resumenDiario;
    }

    @Override
    public String getId() {
        return resumenDiario.getId();
    }

    @Override
    public Date getFechaEmision() {
        return null;
    }

    @Override
    public Date getFechaEmisionDocumentosAsociados() {
        return null;
    }

    @Override
    public CdrModel getCdr() {
        return new CdrAdapter(resumenDiario.getCdr());
    }

    @Override
    public EstadoSunatModel getEstadoSunat() {
        return new EstadoSunatAdapter(resumenDiario.getEstadoSunat());
    }

}
