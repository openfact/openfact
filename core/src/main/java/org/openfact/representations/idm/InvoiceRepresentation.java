
package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceRepresentation {

    private String id;

    // Tipo BOLETA, FACTURA, NOTA
    private String type;

    // Fecha Emision
    private LocalDate issueDate;

    // Serie y numero
    private int invoiceSet;
    private int invoiceNumber;

    // Codigo de moneda
    private String currencyCode;

    // Receptor
    private CustomerRepresentation customer;

    // Additional information
    private BigDecimal totalGravado;
    private BigDecimal totalInafecto;
    private BigDecimal totalExonerado;
    private BigDecimal totalGratuito;
    private BigDecimal totalDescuento;

    // Additional information
    private BigDecimal importeTotal;
    private BigDecimal descuentoTotal;

}
