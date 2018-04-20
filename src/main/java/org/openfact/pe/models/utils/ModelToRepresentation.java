package org.openfact.pe.models.utils;

import org.openfact.pe.representations.idm.*;
import org.openfact.pe.models.*;
import org.openfact.pe.representations.idm.*;

public class ModelToRepresentation {

    private ModelToRepresentation() {
        // Util Class
    }

    public static OrganizacionInformacionAdicionalRepresentation toRepresentation(OrganizacionInformacionAdicionalModel model, boolean fullInfo) {
        OrganizacionInformacionAdicionalRepresentation rep = new OrganizacionInformacionAdicionalRepresentation();

        rep.setId(model.getId());
        rep.setAssignedId(model.getAssignedId());
        rep.setAdditionalAssignedId(model.getAdditionalAssignedId());
        rep.setRazonSocial(model.getRazonSocial());
        rep.setNombreComercial(model.getNombreComercial());
        rep.setRegion(model.getRegion());
        rep.setProvincia(model.getProvincia());
        rep.setDistrito(model.getDistrito());
        rep.setCodigoPostal(model.getCodigoPostal());
        rep.setDireccion(model.getDireccion());

        return rep;
    }


    public static OrganizacionInformacionSUNATRepresentation toRepresentation(OrganizacionInformacionSunatModel model, boolean fullInfo) {
        OrganizacionInformacionSUNATRepresentation rep = new OrganizacionInformacionSUNATRepresentation();

        rep.setId(model.getId());
        rep.setUsuario(model.getUsuario());
        if (model.getPassword() != null) {
            rep.setPassword("**********");
        }

        rep.setUseCustomConfig(model.isUseCustomConfig());

        rep.setBoletaFacturaEndpoint(model.getBoletaFacturaEndpoint());
        rep.setGuiaRemisionEndpoint(model.getGuiaRemisionEndpoint());
        rep.setRetencionPercepcionEndpoint(model.getRetencionPercepcionEndpoint());
        rep.setConsultaCdrEndpoint(model.getConsultaCdrEndpoint());
        rep.setConsultaFacturaEndpoint(model.getConsultaFacturaEndpoint());

        if (fullInfo) {

        }

        return rep;
    }

    private static ClienteRepresentation toClienteRepresentation(ClienteModel model) {
        ClienteRepresentation rep = new ClienteRepresentation();

        rep.setNombre(model.getNombre());
        rep.setTipoDocumento(model.getTipoDocumento());
        rep.setNombre(model.getNombre());
        rep.setDireccion(model.getDireccion());
        rep.setEmail(model.getEmail());

        return rep;
    }

    private static FechaRepresentation toFechaRepresentation(FechaModel model) {
        FechaRepresentation rep = new FechaRepresentation();
        rep.setEmision(model.getEmision());
        rep.setVencimiento(model.getVencimiento());
        return rep;
    }

    private static TotalRepresentation toTotalRepresentation(TotalModel total) {
        TotalRepresentation rep = new TotalRepresentation();
        rep.setPagar(total.getTotalPagar());
        rep.setOtrosCargos(total.getOtrosCargos());
        rep.setDescuentoGlobal(total.getDescuentoGlobal());
        return rep;
    }

    private static MonedaRepresentation toMonedaRepresentation(MonedaModel moneda) {
        MonedaRepresentation rep = new MonedaRepresentation();
        rep.setCodigo(moneda.getMoneda());
        rep.setTipoCambio(moneda.getTipoCambio());
        return rep;
    }

    private static TotalImpuestosRepresentation toTotalImpuestosRepresentation(ImpuestosModel impuestos) {
        TotalImpuestosRepresentation rep = new TotalImpuestosRepresentation();
        rep.setIgv(impuestos.getIGV());
        rep.setIsc(impuestos.getISC());
        return rep;
    }

    private static TotalInformacionAdicionalRepresentation toTotalInformacionAdicional(TotalInformacionAdicionalModel totalInformacionAdicional) {
        TotalInformacionAdicionalRepresentation rep = new TotalInformacionAdicionalRepresentation();
        rep.setTotalGratuito(totalInformacionAdicional.getTotalGratuito());
        rep.setTotalGravado(totalInformacionAdicional.getTotalGravado());
        rep.setTotalInafecto(totalInformacionAdicional.getTotalInafecto());
        rep.setTotalExonerado(totalInformacionAdicional.getTotalExonerado());
        return rep;
    }

    public static BoletaRepresentation toRepresentation(BoletaModel model, boolean fullInfo) {
        BoletaRepresentation rep = new BoletaRepresentation();

        rep.setId(model.getId());
        rep.setSerie(model.getSerie());
        rep.setNumero(model.getNumero());
        rep.setFecha(toFechaRepresentation(model.getFecha()));
        rep.setCliente(toClienteRepresentation(model.getCliente()));
        rep.setTotal(toTotalRepresentation(model.getTotal()));
        rep.setMoneda(toMonedaRepresentation(model.getMoneda()));
        rep.setTotalImpuestos(toTotalImpuestosRepresentation(model.getImpuestos()));
        rep.setTotalInformacionAdicional(toTotalInformacionAdicional(model.getTotalInformacionAdicional()));

        if (fullInfo) {
            rep.setEnviarCliente(model.getEnviarCliente());
            rep.setEnviarSunat(model.getEnviarSUNAT());
        }

        return rep;
    }

    public static FacturaRepresentation toRepresentation(FacturaModel model, boolean fullInfo) {
        FacturaRepresentation rep = new FacturaRepresentation();

        rep.setId(model.getId());
        rep.setSerie(model.getSerie());
        rep.setNumero(model.getNumero());
        rep.setFecha(toFechaRepresentation(model.getFecha()));
        rep.setCliente(toClienteRepresentation(model.getCliente()));
        rep.setTotal(toTotalRepresentation(model.getTotal()));
        rep.setMoneda(toMonedaRepresentation(model.getMoneda()));
        rep.setTotalImpuestos(toTotalImpuestosRepresentation(model.getImpuestos()));
        rep.setTotalInformacionAdicional(toTotalInformacionAdicional(model.getTotalInformacionAdicional()));

        if (fullInfo) {
            rep.setEnviarCliente(model.getEnviarCliente());
            rep.setEnviarSunat(model.getEnviarSUNAT());
        }

        return rep;
    }

}
