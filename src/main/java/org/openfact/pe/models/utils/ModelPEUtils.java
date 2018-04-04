package org.openfact.pe.models.utils;

import org.openfact.pe.models.TipoInvoice;

import java.util.Optional;

public class ModelPEUtils {

    private ModelPEUtils() {
        // Just a util class
    }

    public static String getIdAsignadoBoletaFactura(TipoInvoice tipoInvoice, Optional<String> prefijo, int serie, int numero) {
        StringBuilder sb = new StringBuilder();

        switch (tipoInvoice) {
            case BOLETA:
                sb.append("B");
                break;
            case FACTURA:
                sb.append("F");
                break;
            default:
                throw new IllegalStateException("Tipo invoice invalido:" + tipoInvoice);
        }

        sb.append(prefijo.orElse(""))
                .append(serie)
                .append("-")
                .append(numero);
        return sb.toString();
    }
}
