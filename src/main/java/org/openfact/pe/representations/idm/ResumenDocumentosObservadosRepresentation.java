package org.openfact.pe.representations.idm;

public class ResumenDocumentosObservadosRepresentation {

    private Long total;

    private Long boletas;
    private Long facturas;
    private Long notasCredito;
    private Long notasDebito;
    private Long percepciones;
    private Long retenciones;
    private Long bajas;
    private Long resumenesDiarios;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getBoletas() {
        return boletas;
    }

    public void setBoletas(Long boletas) {
        this.boletas = boletas;
    }

    public Long getFacturas() {
        return facturas;
    }

    public void setFacturas(Long facturas) {
        this.facturas = facturas;
    }

    public Long getNotasCredito() {
        return notasCredito;
    }

    public void setNotasCredito(Long notasCredito) {
        this.notasCredito = notasCredito;
    }

    public Long getNotasDebito() {
        return notasDebito;
    }

    public void setNotasDebito(Long notasDebito) {
        this.notasDebito = notasDebito;
    }

    public Long getPercepciones() {
        return percepciones;
    }

    public void setPercepciones(Long percepciones) {
        this.percepciones = percepciones;
    }

    public Long getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(Long retenciones) {
        this.retenciones = retenciones;
    }

    public Long getBajas() {
        return bajas;
    }

    public void setBajas(Long bajas) {
        this.bajas = bajas;
    }

    public Long getResumenesDiarios() {
        return resumenesDiarios;
    }

    public void setResumenesDiarios(Long resumenesDiarios) {
        this.resumenesDiarios = resumenesDiarios;
    }
}
