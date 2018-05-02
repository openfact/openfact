package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.types.TipoNota;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NotaProvider {

    /**
     * Crear Nota de crédito o débito
     */
    NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado);
    NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado, String serie);
    NotaModel createNota(OrganizationModel organization, TipoNota tipoNota, InvoiceModel invoiceAfectado, String serie, int numero);

    /**
     * Buscar invoice por id
     */
    Optional<NotaModel> getNota(String id);

    /**
     * Buscar invoice dentro de una organización
     */
    Optional<NotaModel> getNota(OrganizationModel organization, String id);

    /**
     * Buscar invoice dentro de una organización a partir de su serie y número
     */
    Optional<NotaModel> getNotaBySerieYNumero(OrganizationModel organization, String serie, int numero);

    /**
     * Buscar invoices por estado
     */
    List<NotaModel> buscarNota(OrganizationModel organization, String filterText);
    List<NotaModel> buscarNota(OrganizationModel organization, String filterText, int offset, int limit);

    /**
     * Obtener el total de invoices por estado
     */
    long getNotasCount(OrganizationModel organization);

}
