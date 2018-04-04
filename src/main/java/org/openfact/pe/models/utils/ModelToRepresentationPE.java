package org.openfact.pe.models.utils;

import org.openfact.pe.idm.BoletaFacturaPERepresentation;
import org.openfact.pe.idm.OrganizacionPERepresentation;
import org.openfact.pe.models.BoletaFacturaPEModel;
import org.openfact.pe.models.InformacionAdicionalPEModel;

public class ModelToRepresentationPE {

    private ModelToRepresentationPE() {
        // Util Class
    }

    public static OrganizacionPERepresentation toRepresentation(InformacionAdicionalPEModel model, boolean fullInfo) {
        OrganizacionPERepresentation rep = new OrganizacionPERepresentation();

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

    public static BoletaFacturaPERepresentation toRepresentation(BoletaFacturaPEModel model, boolean fullInfo) {
        BoletaFacturaPERepresentation rep = new BoletaFacturaPERepresentation();

        rep.setId(model.getId());

        if (fullInfo) {

        }

        return rep;
    }

}
