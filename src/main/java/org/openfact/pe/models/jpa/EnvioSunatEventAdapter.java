package org.openfact.pe.models.jpa;

import org.openfact.pe.models.EnvioSunatEventModel;
import org.openfact.pe.models.jpa.entities.EnvioSunatEventEntity;

import java.util.Date;

public class EnvioSunatEventAdapter implements EnvioSunatEventModel {

    private final EnvioSunatEventEntity event;

    public EnvioSunatEventAdapter(EnvioSunatEventEntity event) {
        this.event = event;
    }

    @Override
    public String getId() {
        return event.getId();
    }

    @Override
    public Date getFechaEnvio() {
        return event.getFechaEnvio();
    }

    @Override
    public String getCodigoRespuesta() {
        return event.getCodigoRespuesta();
    }

    @Override
    public String getDescripcion() {
        return event.getDescripcion();
    }

}
