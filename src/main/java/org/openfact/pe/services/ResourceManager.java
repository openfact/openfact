package org.openfact.pe.services;

import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.types.TipoNota;
import org.openfact.pe.models.types.MotivoNotaCredito;
import org.openfact.pe.models.types.MotivoNotaDebito;
import org.openfact.pe.models.utils.RepresentationToModel;
import org.openfact.pe.representations.idm.InvoiceRepresentation;
import org.openfact.pe.representations.idm.NotaRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;

@Transactional
@ApplicationScoped
public class ResourceManager {

    @Inject
    private InvoiceProvider invoiceProvider;

    @Inject
    private NotaProvider notaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public InvoiceModel crearInvoice(String organizationId, InvoiceRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        TipoInvoice tipoInvoice = TipoInvoice.getByCodigo(rep.getCodigoTipoComprobante()).orElseThrow(() -> new BadRequestException("Código de comprobante no válido"));

        InvoiceModel invoice;
        if (serie == null) {
            if (numero == null) {
                invoice = invoiceProvider.createInvoice(organization, tipoInvoice);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (!serie.startsWith(tipoInvoice.getPrefijo())) {
                throw new ModelRuntimeException("Serie y código de comprobante no coinciden");
            }

            if (numero == null) {
                invoice = invoiceProvider.createInvoice(organization, tipoInvoice, serie);
            } else {
                invoice = invoiceProvider.createInvoice(organization, tipoInvoice, serie, numero);
            }
        }

        DatosVentaModel datosVentaModel = invoice.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVentaModel.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            invoice.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            invoice.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(invoice, rep);
        return invoice;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public InvoiceModel actualizarInvoice(String organizationId, String invoiceId, InvoiceRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        InvoiceModel invoice = invoiceProvider.getInvoice(organization, invoiceId).orElseThrow(NotFoundException::new);

        if (invoice.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante no se puede modificar");
        }

        RepresentationToModel.modelToRepresentation(invoice, rep);
        return invoice;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaModel crearNota(String organizationId, NotaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        InvoiceModel invoiceAfectado = invoiceProvider.getInvoice(organization, rep.getInvoiceAfectado()).orElseThrow(() -> new BadRequestException("Nota de crédito no tiene un invoice asociado"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        TipoNota tipoNota = TipoNota.getByCodigo(rep.getCodigoTipoComprobante()).orElseThrow(() -> new BadRequestException("Código de comprobante no válido"));

        NotaModel nota;
        if (serie == null) {
            if (numero == null) {
                nota = notaProvider.createNota(organization, tipoNota, invoiceAfectado);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (!serie.startsWith(invoiceAfectado.getSerie().substring(0, 1))) {
                throw new ModelRuntimeException("Serie y código de comprobante no coinciden");
            }

            if (numero == null) {
                nota = notaProvider.createNota(organization, tipoNota, invoiceAfectado, serie);
            } else {
                nota = notaProvider.createNota(organization, tipoNota, invoiceAfectado, serie, numero);
            }
        }

        DatosVentaModel datosVenta = nota.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVenta.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            nota.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            nota.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(nota, rep);
        return nota;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaModel actualizarNota(String organizationId, String idDocumento, NotaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        NotaModel nota = notaProvider.getNota(organization, idDocumento).orElseThrow(() -> new NotFoundException("Nota de crédito no encontrada"));

        TipoNota tipoNota = TipoNota.getByCodigo(nota.getCodigoTipoComprobante()).orElseThrow(() -> new BadRequestException("Código de comprobante no válido"));

        if (nota.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante no se puede modificar");
        }

        if (rep.getCodigoMotivo() != null) {
            switch (tipoNota) {
                case NOTA_CREDITO:
                    MotivoNotaCredito.buscarPorCodigo(rep.getCodigoMotivo()).orElseThrow(() -> new BadRequestException("Código motivo no válido"));
                    break;
                case NOTA_DEBITO:
                    MotivoNotaDebito.buscarPorCodigo(rep.getCodigoMotivo()).orElseThrow(() -> new BadRequestException("Código motivo no válido"));
                    break;
            }
            nota.setCodigoMotivo(rep.getCodigoMotivo());
        }

        RepresentationToModel.modelToRepresentation(nota, rep);
        return nota;
    }

}
