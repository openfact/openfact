package org.openfact.pe.models;

public class SendSunatException extends Exception {

    public final String codigo;
    public final String descripcion;

    public SendSunatException(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

}
