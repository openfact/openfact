package org.openfact.pe.models.utils;

import org.openfact.pe.idm.AbstractInvoiceRepresentation;
import org.openfact.pe.idm.BoletaRepresentation;
import org.openfact.pe.idm.FacturaRepresentation;
import org.openfact.pe.idm.OrganizacionRepresentation;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.InformacionAdicionalModel;

public class ModelToRepresentation {

    private ModelToRepresentation() {
        // Util Class
    }

    public static OrganizacionRepresentation toRepresentation(InformacionAdicionalModel model, boolean fullInfo) {
        OrganizacionRepresentation rep = new OrganizacionRepresentation();

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

    public static BoletaRepresentation toRepresentation(BoletaModel model, boolean fullInfo) {
        BoletaRepresentation rep = new BoletaRepresentation();

        rep.setId(model.getId());

        if (fullInfo) {

        }

        return rep;
    }

    public static FacturaRepresentation toRepresentation(FacturaModel model, boolean fullInfo) {
        FacturaRepresentation rep = new FacturaRepresentation();

        rep.setId(model.getId());

        if (fullInfo) {

        }

        return rep;
    }

}
