package org.openfact.pe.models.jpa;

import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.EstadoComprobantePago;

import java.util.Date;

public class ReadOnlyBoletaAdapter extends AbstractBoletaAdapter {

    @Override
    public void setFechaEmision(Date fechaEmision) {
        throw new IllegalStateException("");
    }

    @Override
    public Date getFechaVencimiento() {
        return null;
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {

    }

    @Override
    public String getObservacion() {
        return null;
    }

    @Override
    public ClienteModel getCliente() {
        return null;
    }

    @Override
    public Long getTotalPagar() {
        return null;
    }

    @Override
    public void setTotalPagar(Long pagar) {

    }

    @Override
    public Long getDescuentoGlobal() {
        return null;
    }

    @Override
    public void setDescuentoGlobal(Long descuentoGlobal) {

    }

    @Override
    public Long getOtrosCargos() {
        return null;
    }

    @Override
    public void setOtrosCargos(Long otrosCargos) {

    }

    @Override
    public String getMoneda() {
        return null;
    }

    @Override
    public void setMoneda(String codigo) {

    }

    @Override
    public Long getTipoCambio() {
        return null;
    }

    @Override
    public void setTipoCambio(Long tipoCambio) {

    }

    @Override
    public Long getTotalIGV() {
        return null;
    }

    @Override
    public void setTotalIGV(Long IGV) {

    }

    @Override
    public Long getTotalISC() {
        return null;
    }

    @Override
    public void setTotalISC(Long ISC) {

    }

    @Override
    public Long getTotalGravada() {
        return null;
    }

    @Override
    public void setTotalGravada(Long totalGravada) {

    }

    @Override
    public Long getTotalGratuita() {
        return null;
    }

    @Override
    public void setTotalGratuita(Long totalGratuita) {

    }

    @Override
    public Long getTotalInafecta() {
        return null;
    }

    @Override
    public void setTotalInafecta(Long totalInafecta) {

    }

    @Override
    public Long getTotalExonerada() {
        return null;
    }

    @Override
    public void setTotalExonerada(Long totalExonerada) {

    }

    @Override
    public boolean getEnviarSUNAT() {
        return false;
    }

    @Override
    public void setEnviarSUNAT(Boolean enviarSUNAT) {

    }

    @Override
    public boolean getEnviarCliente() {
        return false;
    }

    @Override
    public void setEnviarCliente(Boolean enviarSUNAT) {

    }

}
