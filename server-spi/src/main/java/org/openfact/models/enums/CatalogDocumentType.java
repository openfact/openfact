package org.openfact.models.enums;

public enum CatalogDocumentType {

    /** BOLETA, FACTURA */
    INVOICE_TYPE,

    /** GUIA DE REMISIÓN REMITENTE,TICKET DE MAQUINA REGISTRADORA */
    OTHER_INVOICE_TYPE,

    /** RUC, DNI */
    ADDITIONAL_IDENTIFICATION_ID,

    /** GRAVADO, EXONERADO */
    ADDITIONAL_INFORMATION,

    /** OPERACION ONEROSA, RETIRO POR PREMIO, ETC */
    ADDITIONAL_INFORMATION_CHILDREN,

    /**
     * Total valor de venta - operaciones gravadas, Total valor de venta -
     * operaciones inafectas
     */
    ADDITIONAL_INFORMATION_CODE,

    /** IGV, ISC, OTHER */
    TOTAL_TAX,

    /** Sistema al valor (Apéndice IV, lit. A – T.U.O IGV e ISC) */
    TOTAL_TAX_CHILDREN,

    /** Anulación de la operación, Anulación por error en el RUC */
    RESPONSE_CODE_CREDIT_NOTE,

    /** Intereses por mora, Aumento en el valor, Penalidades/ otros conceptos */
    RESPONSE_CODE_DEBIT_NOTE,

    /** Ticket de Salida - ENAPU, Código SCOP, Otros */
    PREPAID_PAYMENT;

}
