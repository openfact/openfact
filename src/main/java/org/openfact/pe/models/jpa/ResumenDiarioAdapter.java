package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ResumenDiarioModel;
import org.openfact.pe.models.jpa.entities.ResumenDiarioEntity;

public class ResumenDiarioAdapter implements ResumenDiarioModel {

    private final ResumenDiarioEntity resumenDiario;

    public ResumenDiarioAdapter(ResumenDiarioEntity resumenDiario) {
        this.resumenDiario = resumenDiario;
    }

    @Override
    public String getId() {
        return resumenDiario.getId();
    }

}
