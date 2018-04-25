package org.openfact.pe.representations.idm;

import javax.validation.constraints.Pattern;

public class NotaRepresentation extends AbstractDocumentoRepresentation {

    @Pattern(regexp = "[B|F][A-Z]+[0-9]+")
    private String serie;

    private String tipo;

    private String documentoAsociado;
    private String documentoAsociadoId;
    private AbstractDocumentoRepresentation.TipoDocumentoAsociado tipoDocumentoAsociado;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumentoAsociado() {
        return documentoAsociado;
    }

    public void setDocumentoAsociado(String documentoAsociado) {
        this.documentoAsociado = documentoAsociado;
    }

    public String getDocumentoAsociadoId() {
        return documentoAsociadoId;
    }

    public void setDocumentoAsociadoId(String documentoAsociadoId) {
        this.documentoAsociadoId = documentoAsociadoId;
    }

    public TipoDocumentoAsociado getTipoDocumentoAsociado() {
        return tipoDocumentoAsociado;
    }

    public void setTipoDocumentoAsociado(TipoDocumentoAsociado tipoDocumentoAsociado) {
        this.tipoDocumentoAsociado = tipoDocumentoAsociado;
    }
}
