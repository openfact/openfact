package org.openfact.pe.models;

import java.util.Date;

public interface AbstractInvoiceModel {

    String getId();

    String getSerie();

    Integer getNumero();

    EstadoComprobantePago getEstado();

    Date getFechaEmision();

    void setFechaEmision(Date fechaEmision);

    Date getFechaVencimiento();

    void setFechaVencimiento(Date fechaVencimiento);

    String getObservaciones();

    ClienteModel getCliente();

    // Totales

    Long getTotalPagar();

    void setTotalPagar(Long pagar);

    Long getDescuentoGlobal();

    void setDescuentoGlobal(Long descuentoGlobal);

    Long getOtrosCargos();

    void setOtrosCargos(Long otrosCargos);

    // Moneda

    String getMoneda();

    void setMoneda(String moneda);

    Long getTipoCambio();

    void setTipoCambio(Long tipoCambio);

    // Impuestos

    Long getTotalIGV();

    void setTotalIGV(Long IGV);

    Long getTotalISC();

    void setTotalISC(Long ISC);

    // Información adicional de totales

    Long getTotalGravada();

    void setTotalGravada(Long totalGravada);

    Long getTotalGratuito();

    void setTotalGratuito(Long totalGratuito);

    Long getTotalInafecto();

    void setTotalInafecto(Long totalInafecto);

    Long getTotalExonerado();

    void setTotalExonerado(Long totalExonerado);

    // Enviar

    boolean getEnviarSUNAT();

    void setEnviarSUNAT(boolean enviarSUNAT);

    boolean getEnviarCliente();

    void setEnviarCliente(boolean enviarSUNAT);
}
