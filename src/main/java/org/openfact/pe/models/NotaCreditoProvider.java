package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.List;
import java.util.Optional;

public interface NotaCreditoProvider {

    NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota);
    NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie);
    NotaCreditoModel createNotaCredito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie, int numero);

    Optional<NotaCreditoModel> getNotaCredito(String id);
    Optional<NotaCreditoModel> getNotaCredito(String id, OrganizationModel organization);
    Optional<NotaCreditoModel> getNotaCredito(String id, String organizationId);

    List<NotaCreditoModel> getNotasCredito(String organizationId, EstadoComprobantePago estado);
    List<NotaCreditoModel> getNotasCredito(String organizationId, EstadoComprobantePago estado, int offset, int limit);

    List<NotaCreditoModel> getNotasCredito(OrganizationModel organization, EstadoComprobantePago estado);
    List<NotaCreditoModel> getNotasCredito(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit);

    long getTotalNotasCreditoPorEstado(OrganizationModel organization, EstadoComprobantePago estado);

}
