package org.openfact.pe.services;

import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.RepresentationToModel;
import org.openfact.pe.representations.idm.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ResourceManager {

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private NotaDebitoProvider notaDebitoProvider;

    @Inject
    private NotaCreditoProvider notaCreditoProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public BoletaModel crearBoleta(String organizationId, BoletaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        BoletaModel boleta;
        if (serie == null) {
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organization);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organization, serie);
            } else {
                boleta = boletaProvider.createBoleta(organization, serie, numero);
            }
        }

        DatosVentaModel datosVentaModel = boleta.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVentaModel.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            boleta.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            boleta.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(boleta, rep);
        return boleta;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public BoletaModel actualizarBoleta(String organizationId, String idDocumento, BoletaRepresentation rep) {
        BoletaModel boleta = boletaProvider.getBoleta(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (boleta.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante CERRADO o ya fue declarado a la SUNAT, no se puede actualizar");
        }

        RepresentationToModel.modelToRepresentation(boleta, rep);
        return boleta;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public FacturaModel crearFactura(String organizationId, FacturaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        FacturaModel factura;
        if (serie == null) {
            if (numero == null) {
                factura = facturaProvider.createFactura(organization);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                factura = facturaProvider.createFactura(organization, serie);
            } else {
                factura = facturaProvider.createFactura(organization, serie, numero);
            }
        }

        DatosVentaModel datosVentaModel = factura.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVentaModel.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            factura.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            factura.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(factura, rep);
        return factura;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public FacturaModel actualizarFactura(String organizationId, String idDocumento, FacturaRepresentation rep) {
        FacturaModel factura = facturaProvider.getFactura(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (factura.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante CERRADO o ya fue declarado a la SUNAT, no se puede actualizar");
        }

        RepresentationToModel.modelToRepresentation(factura, rep);
        return factura;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaCreditoModel crearNotaCredito(String organizationId, NotaCreditoRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        InvoiceModel invoiceAfectado = getInvoiceAsociado(organization, rep).orElseThrow(() -> new ModelRuntimeException("Nota de crédito no tiene un invoice asociado"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        NotaCreditoModel notaCredito;
        if (serie == null) {
            if (numero == null) {
                notaCredito = notaCreditoProvider.createNotaCredito(organization, invoiceAfectado, rep.getTipo());
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                notaCredito = notaCreditoProvider.createNotaCredito(organization, invoiceAfectado, rep.getTipo(), serie);
            } else {
                notaCredito = notaCreditoProvider.createNotaCredito(organization, invoiceAfectado, rep.getTipo(), serie, numero);
            }
        }

        DatosVentaModel datosVenta = notaCredito.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVenta.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            notaCredito.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            notaCredito.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(notaCredito, rep);
        return notaCredito;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaCreditoModel actualizarNotaCredito(String organizationId, String idDocumento, NotaCreditoRepresentation rep) {
        NotaCreditoModel notaCredito = notaCreditoProvider.getNotaCredito(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Nota de crédito no encontrada"));

        if (notaCredito.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante CERRADO o ya fue declarado a la SUNAT, no se puede actualizar");
        }

        RepresentationToModel.modelToRepresentation(notaCredito, rep);
        return notaCredito;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaDebitoModel crearNotaDebito(String organizationId, NotaDebitoRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        InvoiceModel invoiceAfectado = getInvoiceAsociado(organization, rep).orElseThrow(() -> new ModelRuntimeException("Nota de débito no tiene un invoice asociado"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        NotaDebitoModel notaDebito;
        if (serie == null) {
            if (numero == null) {
                notaDebito = notaDebitoProvider.createNotaDebito(organization, invoiceAfectado, rep.getTipo());
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                notaDebito = notaDebitoProvider.createNotaDebito(organization, invoiceAfectado, rep.getTipo(), serie);
            } else {
                notaDebito = notaDebitoProvider.createNotaDebito(organization, invoiceAfectado, rep.getTipo(), serie, numero);
            }
        }

        DatosVentaModel datosVenta = notaDebito.getDatosVenta();

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            FechaModel fecha = datosVenta.getFecha();
            fecha.setEmision(Calendar.getInstance().getTime());
            fecha.setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            notaDebito.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            notaDebito.setEnviarCliente(true);
        }

        RepresentationToModel.modelToRepresentation(notaDebito, rep);
        return notaDebito;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public NotaDebitoModel actualizarNotaDebito(String organizationId, String idDocumento, NotaDebitoRepresentation rep) {
        NotaDebitoModel notaDebito = notaDebitoProvider.getNotaDebito(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Nota de débito no encontrada"));

        if (notaDebito.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante CERRADO o ya fue declarado a la SUNAT, no se puede actualizar");
        }

        RepresentationToModel.modelToRepresentation(notaDebito, rep);
        return notaDebito;
    }

    private Optional<? extends InvoiceModel> getInvoiceAsociado(OrganizationModel organization, NotaRepresentation rep) {
        Optional<? extends InvoiceModel> invoiceAfectadoModel = Optional.empty();
        AbstractDocumentoRepresentation.TipoDocumentoAsociado tipoDocumentoAsociado = rep.getTipoDocumentoAsociado();
        switch (tipoDocumentoAsociado) {
            case boleta:
                if (rep.getDocumentoAsociadoId() != null) {
                    invoiceAfectadoModel = boletaProvider.getBoleta(rep.getDocumentoAsociadoId());
                } else if (rep.getDocumentoAsociado() != null) {
                    String[] split = rep.getDocumentoAsociado().split("-");
                    invoiceAfectadoModel = boletaProvider.getBoletaBySerieYNumero(split[0], Integer.parseInt(split[1]), organization);
                }
                break;
            case factura:
                if (rep.getDocumentoAsociadoId() != null) {
                    invoiceAfectadoModel = facturaProvider.getFactura(rep.getDocumentoAsociadoId());
                } else if (rep.getDocumentoAsociado() != null) {
                    String[] split = rep.getDocumentoAsociado().split("-");
                    invoiceAfectadoModel = facturaProvider.getFacturaBySerieYNumero(split[0], Integer.parseInt(split[1]), organization);
                }
                break;
            default:
                throw new IllegalStateException("Tipo de documento asociado no válido");
        }
        return invoiceAfectadoModel;
    }

}
