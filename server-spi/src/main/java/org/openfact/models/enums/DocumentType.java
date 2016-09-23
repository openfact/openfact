package org.openfact.models.enums;

public enum DocumentType {

	/** BOLETA, FACTURA */
	INVOICE_TYPE(null),

	/** GUIA DE REMISIÓN REMITENTE,TICKET DE MAQUINA REGISTRADORA */
	OTHER_INVOICE_TYPE(null),

	/** RUC, DNI */
	ADDITIONAL_IDENTIFICATION_ID(null),

	/** GRAVADO, EXONERADO */
	ADDITIONAL_INFORMATION(null),

	/** OPERACION ONEROSA, RETIRO POR PREMIO, ETC */
	ADDITIONAL_INFORMATION_CHILDREN(ADDITIONAL_INFORMATION),

	/**
	 * Total valor de venta - operaciones gravadas, Total valor de venta -
	 * operaciones inafectas
	 */
	ADDITIONAL_INFORMATION_CODE(ADDITIONAL_INFORMATION),

	/** IGV, ISC, OTHER */
	TOTAL_TAX(null),

	/** Sistema al valor (Apéndice IV, lit. A – T.U.O IGV e ISC) */
	TOTAL_TAX_CHILDREN(TOTAL_TAX),

	/** Anulación de la operación, Anulación por error en el RUC */
	RESPONSE_CODE_CREDIT_NOTE(null),

	/** Intereses por mora, Aumento en el valor, Penalidades/ otros conceptos */
	RESPONSE_CODE_DEBIT_NOTE(null),

	/** Ticket de Salida - ENAPU, Código SCOP, Otros */
	PREPAID_PAYMENT(null);

	private DocumentType catalog;

	private DocumentType(DocumentType catalog) {
		this.catalog = catalog;
	}

	public DocumentType getCatalog() {
		return this.catalog;
	}

}
