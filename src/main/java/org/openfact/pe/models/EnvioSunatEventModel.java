package org.openfact.pe.models;

import java.util.Date;

public interface EnvioSunatEventModel {
    String getId();
    Date getFechaEnvio();
    String getCodigoRespuesta();
    String getDescripcion();
}
