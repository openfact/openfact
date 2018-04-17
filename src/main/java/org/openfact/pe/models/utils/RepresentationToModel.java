package org.openfact.pe.models.utils;

import org.openfact.pe.idm.*;
import org.openfact.pe.models.AbstractInvoiceModel;
import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.DetalleComprobantePagoBean;

import java.util.List;
import java.util.stream.Collectors;

public class RepresentationToModel {

    private RepresentationToModel() {
        // just
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
            if (totalImpuestosRepresentation.getIGV() != null) {
                model.getImpuestos().setIGV(totalImpuestosRepresentation.getIGV());
            }
            if (totalImpuestosRepresentation.getISC() != null) {
                model.getImpuestos().setISC(totalImpuestosRepresentation.getISC());
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
