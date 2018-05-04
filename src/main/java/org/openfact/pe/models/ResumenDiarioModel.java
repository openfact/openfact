package org.openfact.pe.models;

import java.util.Date;

public interface ResumenDiarioModel {

    String getId();
    Date getFechaEmision();
    Date getFechaEmisionDocumentosAsociados();

    CdrModel getCdr();
    EstadoSunatModel getEstadoSunat();

}
