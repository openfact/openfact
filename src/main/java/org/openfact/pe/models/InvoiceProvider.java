package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.types.TipoInvoice;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InvoiceProvider {

    /**
     * Crear Invoice
     */
    InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice);
    InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice, String serie);
    InvoiceModel createInvoice(OrganizationModel organization, TipoInvoice tipoInvoice, String serie, int numero);

    /**
     * Buscar invoice por id
     */
    Optional<InvoiceModel> getInvoice(String id);

    /**
     * Buscar invoice dentro de una organización
     */
    Optional<InvoiceModel> getInvoice(OrganizationModel organization, String id);

    /**
     * Buscar invoice dentro de una organización a partir de su serie y número
     */
    Optional<InvoiceModel> getInvoiceBySerieYNumero(OrganizationModel organization, String serie, int numero);

    /**
     * Buscar invoices por estado
     */
    List<InvoiceModel> buscarInvoice(OrganizationModel organization, String filterText);
    List<InvoiceModel> buscarInvoice(OrganizationModel organization, String filterText, int offset, int limit);

    /**
     * Obtener el total de invoices por estado
     */
    long getInvoicesCount(OrganizationModel organization);

}
