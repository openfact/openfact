package org.openfact.models.utils;

import org.openfact.models.PECompanyModel;
import org.openfact.representations.idm.PECompanyRepresentation;

public class PEModelToRepresentation {

    private PEModelToRepresentation() {
        // Util Class
    }

    public static PECompanyRepresentation toRepresentation(PECompanyModel model, boolean fullInfo) {
        PECompanyRepresentation rep = new PECompanyRepresentation();

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

}
