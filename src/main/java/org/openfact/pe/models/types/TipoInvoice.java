package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoInvoice {

    FACTURA("01", "FACTURA", "FACTURA ELECTRONICA", "^[F]{1}\\d{1,3}[-]\\d{1,8}$", "[F]{1}[A-Z]{1,}[0-9]{1,}", "F"),
    BOLETA("03", "BOLETA", "BOLETA ELECTRONICA", "^[B]{1}\\d{1,3}[-]\\d{1,8}$", "[B]{1}[A-Z]{1,}[0-9]{1,}", "B");

    private final String codigo;
    private final String abreviatura;
    private final String denominacion;
    private final String documentIdPattern;
    private final String seriePattern;
    private final String prefijo;

    public String getCodigo() {
        return codigo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDocumentIdPattern() {
        return documentIdPattern;
    }

    TipoInvoice(String codigo, String abreviatura, String denominacion, String documentIdPattern, String seriePattern, String prefijo) {
        this.codigo = codigo;
        this.abreviatura = abreviatura;
        this.denominacion = denominacion;
        this.documentIdPattern = documentIdPattern;
        this.seriePattern = seriePattern;
        this.prefijo = prefijo;
    }

    public static Optional<TipoInvoice> getByCodigo(String codigo) {
        return Stream.of(TipoInvoice.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public String getSeriePattern() {
        return seriePattern;
    }

    public String getPrefijo() {
        return prefijo;
    }
}
