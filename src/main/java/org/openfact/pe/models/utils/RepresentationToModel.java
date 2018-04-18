package org.openfact.pe.models.utils;

import org.openfact.pe.idm.*;
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

    public static void modelToRepresentation(OrganizacionInformacionSUNATModel model, OrganizacionInformacionSUNATRepresentation rep) {
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
    
    public static void modelToRepresentation(AbstractInvoiceModel model, AbstractInvoiceRepresentation rep) {
        if (rep.getEnviarSUNAT() != null) {
            model.setEnviarSUNAT(rep.getEnviarSUNAT());
        }
        if (rep.getEnviarCliente() != null) {
            model.setEnviarCliente(rep.getEnviarCliente());
        }

        FechaRepresentation fechaRepresentation = rep.getFecha();
        if (fechaRepresentation != null) {
            if (fechaRepresentation.getEmision() != null) {
                model.getFecha().setEmision(fechaRepresentation.getEmision());
            }
            if (fechaRepresentation.getVencimiento() != null) {
                model.getFecha().setVencimiento(fechaRepresentation.getVencimiento());
            }
        }

        ClienteRepresentation clienteRepresentation = rep.getCliente();
        if (clienteRepresentation != null) {
            ClienteModel clienteModel = model.getCliente();
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
                model.getTotal().setTotalPagar(totalRepresentation.getPagar());
            }
            if (totalRepresentation.getDescuentoGlobal() != null) {
                model.getTotal().setDescuentoGlobal(totalRepresentation.getDescuentoGlobal());
            }
            if (totalRepresentation.getOtrosCargos() != null) {
                model.getTotal().setOtrosCargos(totalRepresentation.getOtrosCargos());
            }
        }

        MonedaRepresentation monedaRepresentation = rep.getMoneda();
        if (monedaRepresentation != null) {
            if (monedaRepresentation.getCodigo() != null) {
                model.getMoneda().setMoneda(monedaRepresentation.getCodigo());
            }
            if (monedaRepresentation.getTipoCambio() != null) {
                model.getMoneda().setTipoCambio(monedaRepresentation.getTipoCambio());
            }
        }

        TotalImpuestosRepresentation totalImpuestosRepresentation = rep.getTotalImpuestos();
        if (totalImpuestosRepresentation != null) {
            if (totalImpuestosRepresentation.getIgv() != null) {
                model.getImpuestos().setIGV(totalImpuestosRepresentation.getIgv());
            }
            if (totalImpuestosRepresentation.getIsc() != null) {
                model.getImpuestos().setISC(totalImpuestosRepresentation.getIsc());
            }
        }

        TotalInformacionAdicionalRepresentation totalInformacionAdicionalRepresentation = rep.getTotalInformacionAdicional();
        if (totalInformacionAdicionalRepresentation != null) {
            if (totalInformacionAdicionalRepresentation.getTotalExonerado() != null) {
                model.getTotalInformacionAdicional().setTotalExonerado(totalInformacionAdicionalRepresentation.getTotalExonerado());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGratuito() != null) {
                model.getTotalInformacionAdicional().setTotalGratuito(totalInformacionAdicionalRepresentation.getTotalGratuito());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGravado() != null) {
                model.getTotalInformacionAdicional().setTotalGravado(totalInformacionAdicionalRepresentation.getTotalGravado());
            }
            if (totalInformacionAdicionalRepresentation.getTotalInafecto() != null) {
                model.getTotalInformacionAdicional().setTotalInafecto(totalInformacionAdicionalRepresentation.getTotalInafecto());
            }
        }

        List<DetalleComprobantePagoBean> detalleBeans = rep.getDetalle()
                .stream()
                .map(r -> new DetalleComprobantePagoBean.Builder()
                        .unidadMedida(r.getUnidadMedida())
                        .descripcion(r.getDescripcion())
                        .tipoIGV(r.getTipoIGV())
                        .cantidad(r.getCantidad())
                        .valorUnitario(r.getValorUnitario())
                        .precioUnitario(r.getPrecioUnitario())
                        .subtotal(r.getSubtotal())
                        .total(r.getTotal())
                        .totalIGV(r.getTotalIGV())
                        .totalISC(r.getTotalISC())
                        .build())
                .collect(Collectors.toList());
        model.setDetalle(detalleBeans);
    }


}
