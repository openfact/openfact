package org.openfact.pe.models.utils;

import org.openfact.pe.idm.*;
import org.openfact.pe.models.AbstractInvoiceModel;
import org.openfact.pe.models.ClienteModel;

public class RepresentationToModel {

    private RepresentationToModel() {
        // just
    }

    public static void modelToRepresentation(AbstractInvoiceModel model, AbstractInvoiceRepresentation rep) {
        FechaRepresentation fechaRepresentation = rep.getFecha();
        if (fechaRepresentation != null) {
            if (fechaRepresentation.getFechaDeEmision() != null) {
                model.setFechaEmision(fechaRepresentation.getFechaDeEmision());
            }
            if (fechaRepresentation.getFechaDeVencimiento() != null) {
                model.setFechaVencimiento(fechaRepresentation.getFechaDeVencimiento());
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
                model.setTotalPagar(totalRepresentation.getPagar());
            }
            if (totalRepresentation.getDescuentoGlobal() != null) {
                model.setDescuentoGlobal(totalRepresentation.getDescuentoGlobal());
            }
            if (totalRepresentation.getOtrosCargos() != null) {
                model.setOtrosCargos(totalRepresentation.getOtrosCargos());
            }
        }

        MonedaRepresentation monedaRepresentation = rep.getMoneda();
        if (monedaRepresentation != null) {
            if (monedaRepresentation.getCodigo() != null) {
                model.setMoneda(monedaRepresentation.getCodigo());
            }
            if (monedaRepresentation.getTipoCambio() != null) {
                model.setTipoCambio(monedaRepresentation.getTipoCambio());
            }
        }

        TotalImpuestosRepresentation totalImpuestosRepresentation = rep.getTotalImpuestos();
        if (totalImpuestosRepresentation != null) {
            if (totalImpuestosRepresentation.getIGV() != null) {
                model.setTotalIGV(totalImpuestosRepresentation.getIGV());
            }
            if (totalImpuestosRepresentation.getISC() != null) {
                model.setTotalISC(totalImpuestosRepresentation.getISC());
            }
        }

        TotalInformacionAdicionalRepresentation totalInformacionAdicionalRepresentation = rep.getTotalInformacionAdicional();
        if (totalInformacionAdicionalRepresentation != null) {
            if (totalInformacionAdicionalRepresentation.getTotalExonerada() != null) {
                model.setTotalExonerada(totalInformacionAdicionalRepresentation.getTotalExonerada());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGratuita() != null) {
                model.setTotalGratuita(totalInformacionAdicionalRepresentation.getTotalGratuita());
            }
            if (totalInformacionAdicionalRepresentation.getTotalGravada() != null) {
                model.setTotalGravada(totalInformacionAdicionalRepresentation.getTotalGravada());
            }
            if (totalInformacionAdicionalRepresentation.getTotalInafecta() != null) {
                model.setTotalInafecta(totalInformacionAdicionalRepresentation.getTotalInafecta());
            }
        }
    }


}
