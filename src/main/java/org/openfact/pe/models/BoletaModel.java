package org.openfact.pe.models;

import java.util.Optional;

public interface BoletaModel extends InvoiceModel {

    Optional<ResumenDiarioModel> getResumenDiario();

}
