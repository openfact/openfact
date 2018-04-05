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

    String getObservacion();

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
    void setMoneda(String codigo);

    Long getTipoCambio();
    void setTipoCambio(Long tipoCambio);

    // Impuestos

    Long getTotalIGV();
    void setTotalIGV(Long IGV);

    Long getTotalISC();
    void setTotalISC(Long ISC);

    // Informacion adicional de totales

    Long getTotalGravada();
    void setTotalGravada(Long totalGravada);

    Long getTotalGratuita();
    void setTotalGratuita(Long totalGratuita);

    Long getTotalInafecta();
    void setTotalInafecta(Long totalInafecta);

    Long getTotalExonerada();
    void setTotalExonerada(Long totalExonerada);

    // Enviar

    boolean getEnviarSUNAT();
    void setEnviarSUNAT(Boolean enviarSUNAT);

    boolean getEnviarCliente();
    void setEnviarCliente(Boolean enviarSUNAT);
}
