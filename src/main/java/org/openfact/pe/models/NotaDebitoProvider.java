package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.List;
import java.util.Optional;

public interface NotaDebitoProvider {

    NotaDebitoModel createNotaDebito(OrganizationModel organization, InvoiceModel invoice, String tipoNota);
    NotaDebitoModel createNotaDebito(OrganizationModel organization,  InvoiceModel invoice, String tipoNota, String serie);
    NotaDebitoModel createNotaDebito(OrganizationModel organization, InvoiceModel invoice, String tipoNota, String serie, int numero);

    Optional<NotaDebitoModel> getNotaDebito(String id);
    Optional<NotaDebitoModel> getNotaDebito(String id, OrganizationModel organization);
    Optional<NotaDebitoModel> getNotaDebito(String id, String organizationId);

    List<NotaDebitoModel> getNotasDebito(String organizationId, EstadoComprobantePago estado);
    List<NotaDebitoModel> getNotasDebito(String organizationId, EstadoComprobantePago estado, int offset, int limit);

    List<NotaDebitoModel> getNotasDebito(OrganizationModel organization, EstadoComprobantePago estado);
    List<NotaDebitoModel> getNotasDebito(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit);

    long getTotalNotasDebitoPorEstado(OrganizationModel organization, EstadoComprobantePago estado);

}
