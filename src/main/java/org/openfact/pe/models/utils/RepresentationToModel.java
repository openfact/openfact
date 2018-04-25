package org.openfact.pe.models.utils;

import org.openfact.pe.representations.idm.*;
import org.openfact.pe.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class RepresentationToModel {

    private RepresentationToModel() {
        // just
    }

    public static void modelToRepresentation(OrganizacionInformacionAdicionalModel model, OrganizacionInformacionAdicionalRepresentation rep) {
        if (rep.getAssignedId() != null) {
            model.setAssignedId(rep.getAssignedId());
        }
        if (rep.getAdditionalAssignedId() != null) {
            model.setAdditionalAssignedId(rep.getAdditionalAssignedId());
        }
        if (rep.getRazonSocial() != null) {
            model.setRazonSocial(rep.getRazonSocial());
        }
        if (rep.getNombreComercial() != null) {
            model.setNombreComercial(rep.getNombreComercial());
        }
        if (rep.getRegion() != null) {
            model.setRegion(rep.getRegion());
        }
        if (rep.getProvincia() != null) {
            model.setProvincia(rep.getProvincia());
        }
        if (rep.getDistrito() != null) {
            model.setDistrito(rep.getDistrito());
        }
        if (rep.getCodigoPostal() != null) {
            model.setCodigoPostal(rep.getCodigoPostal());
        }
        if (rep.getDireccion() != null) {
            model.setDireccion(rep.getDireccion());
        }
    }

    public static void modelToRepresentation(OrganizacionInformacionSunatModel model, OrganizacionInformacionSunatRepresentation rep) {
        if (rep.getUseCustomConfig() != null) {
            model.setUseCustomConfig(rep.getUseCustomConfig());
        }
        if (rep.getUsuario() != null) {
            model.setUsuario(rep.getUsuario());
        }
        if (rep.getPassword() != null) {
            model.setPassword(rep.getPassword());
        }
        if (rep.getBoletaFacturaEndpoint() != null) {
            model.setBoletaFacturaEndpoint(rep.getBoletaFacturaEndpoint());
        }
        if (rep.getGuiaRemisionEndpoint() != null) {
            model.setGuiaRemisionEndpoint(rep.getGuiaRemisionEndpoint());
        }
        if (rep.getRetencionPercepcionEndpoint() != null) {
            model.setRetencionPercepcionEndpoint(rep.getRetencionPercepcionEndpoint());
        }
        if (rep.getConsultaFacturaEndpoint() != null) {
            model.setConsultaFacturaEndpoint(rep.getConsultaFacturaEndpoint());
        }
        if (rep.getConsultaCdrEndpoint() != null) {
            model.setConsultaCdrEndpoint(rep.getConsultaCdrEndpoint());
        }
    }

    public static void modelToRepresentation(BoletaModel model, BoletaRepresentation rep) {
        toInvoiceModel(model, rep);
    }

    public static void modelToRepresentation(FacturaModel model, FacturaRepresentation rep) {
        toInvoiceModel(model, rep);
    }

    private static void toInvoiceModel(InvoiceModel model, AbstractDocumentoRepresentation rep) {
        DatosVentaModel datosVentaModel = model.getDatosVenta();

        if (rep.getEnviarSunat() != null) {
            model.setEnviarSunat(rep.getEnviarSunat());
        }
        if (rep.getEnviarCliente() != null) {
            model.setEnviarCliente(rep.getEnviarCliente());
        }

        FechaRepresentation fechaRepresentation = rep.getFecha();
        if (fechaRepresentation != null) {
            if (fechaRepresentation.getEmision() != null) {
                datosVentaModel.getFecha().setEmision(fechaRepresentation.getEmision());
            }
            if (fechaRepresentation.getVencimiento() != null) {
                datosVentaModel.getFecha().setVencimiento(fechaRepresentation.getVencimiento());
            }
        }

        ClienteRepresentation clienteRepresentation = rep.getCliente();
        if (clienteRepresentation != null) {
            ClienteModel clienteModel = datosVentaModel.getCliente();
            if (clienteRepresentation.getNumeroDocumento() != null) {
                clienteModel.setNumeroDocumento(clienteRepresentation.getNumeroDocumento());
            }
            if (clienteRepresentation.getTipoDocumento() != null) {
                clienteModel.setTipoDocumento(clienteRepresentation.getTipoDocumento());
            }
            if (clienteRepresentation.getNombre() != null) {
                clienteModel.setNombre(clienteRepresentation.getNombre());
            }
            if (clienteRepresentation.getEmail() != null) {
                clienteModel.setEmail(clienteRepresentation.getEmail());
            }
            if (clienteRepresentation.getDireccion() != null) {
                clienteModel.setDireccion(clienteRepresentation.getDireccion());
            }
        }

        TotalRepresentation totalRepresentation = rep.getTotal();
        if (totalRepresentation != null) {
            if (totalRepresentation.getPagar() != null) {
                datosVentaModel.getTotal().setTotalPagar(totalRepresentation.getPagar());
            }
            if (totalRepresentation.getDescuentoGlobal() != null) {
                datosVentaModel.getTotal().setDescuentoGlobal(totalRepresentation.getDescuentoGlobal());
            }
            if (totalRepresentation.getOtrosCargos() != null) {
                datosVentaModel.getTotal().setOtrosCargos(totalRepresentation.getOtrosCargos());
            }
        }

        MonedaRepresentation monedaRepresentation = rep.getMoneda();
        if (monedaRepresentation != null) {
            if (monedaRepresentation.getCodigo() != null) {
                datosVentaModel.getMoneda().setMoneda(monedaRepresentation.getCodigo());
            }
            if (monedaRepresentation.getTipoCambio() != null) {
                datosVentaModel.getMoneda().setTipoCambio(monedaRepresentation.getTipoCambio());
            }
        }

        TotalImpuestosRepresentation totalImpuestosRepresentation = rep.getTotalImpuestos();
        if (totalImpuestosRepresentation != null) {
            if (totalImpuestosRepresentation.getIgv() != null) {
                datosVentaModel.getImpuestos().setIgv(totalImpuestosRepresentation.getIgv());
            }
            if (totalImpuestosRepresentation.getIsc() != null) {
                datosVentaModel.getImpuestos().setIsc(totalImpuestosRepresentation.getIsc());
            }
        }

        TotalInformacionAdicionalRepresentation totalInformacionAdicionalRepresentation = rep.getTotalInformacionAdicional();
        if (totalInformacionAdicionalRepresentation != null) {
            if (totalInformacionAdicionalRepresentation.getTotalExonerado() != null) {
                datosVentaModel.getTotalInformacionAdicional().setTotalExonerado(totalInformacionAdicionalRepresentation.getTotalExonerado());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGratuito() != null) {
                datosVentaModel.getTotalInformacionAdicional().setTotalGratuito(totalInformacionAdicionalRepresentation.getTotalGratuito());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGravado() != null) {
                datosVentaModel.getTotalInformacionAdicional().setTotalGravado(totalInformacionAdicionalRepresentation.getTotalGravado());
            }
            if (totalInformacionAdicionalRepresentation.getTotalInafecto() != null) {
                datosVentaModel.getTotalInformacionAdicional().setTotalInafecto(totalInformacionAdicionalRepresentation.getTotalInafecto());
            }
        }

        List<DatosVentaDetalleBean> detalleBeans = rep.getDetalle()
                .stream()
                .map(r -> new DatosVentaDetalleBean.Builder()
                        .unidadMedida(r.getUnidadMedida())
                        .descripcion(r.getDescripcion())
                        .tipoIgv(r.getTipoIgv())
                        .cantidad(r.getCantidad())
                        .valorUnitario(r.getValorUnitario())
                        .precioUnitario(r.getPrecioUnitario())
                        .subtotal(r.getSubtotal())
                        .total(r.getTotal())
                        .totalIgv(r.getTotalIgv())
                        .totalIsc(r.getTotalIsc())
                        .build())
                .collect(Collectors.toList());
        datosVentaModel.setDetalle(detalleBeans);
    }

    public static void modelToRepresentation(NotaCreditoModel model, NotaCreditoRepresentation rep) {

    }

    public static void modelToRepresentation(NotaDebitoModel model, NotaDebitoRepresentation rep) {

    }

//
//    public static void modelToRepresentation(NotaCreditoModel notaCredito, NotaCreditoRepresentation rep) {
//
//    }
}
