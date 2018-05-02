package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BajaProvider {

    /**
     * Crear Invoice
     */
    BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado);
    BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado, Date fechaGeneracion);
    BajaModel createBaja(OrganizationModel organization, InvoiceModel invoiceAfectado, Date fechaGeneracion, int numero);

    /**
     * Buscar invoice por id
     */
    Optional<BajaModel> getBaja(String id);

    /**
     * Buscar invoice dentro de una organización
     */
    Optional<BajaModel> getBaja(OrganizationModel organization, String id);

    /**
     * Buscar invoices por estado
     */
    List<BajaModel> buscarBajas(OrganizationModel organization, String filterText);
    List<BajaModel> buscarBajas(OrganizationModel organization, String filterText, int offset, int limit);

    /**
     * Obtener el total de invoices por estado
     */
    long getBajasCount(OrganizationModel organization);

}
