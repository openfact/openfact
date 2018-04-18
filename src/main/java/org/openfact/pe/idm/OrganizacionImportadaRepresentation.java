package org.openfact.pe.idm;

import org.openfact.core.idm.OrganizationRepresentation;

public class OrganizacionImportadaRepresentation extends OrganizationRepresentation {

    private OrganizacionInformacionAdicionalRepresentation informacionAdicional;
    private OrganizacionInformacionSUNATRepresentation informacionSunat;

    public OrganizacionInformacionAdicionalRepresentation getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(OrganizacionInformacionAdicionalRepresentation informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public OrganizacionInformacionSUNATRepresentation getInformacionSunat() {
        return informacionSunat;
    }

    public void setInformacionSunat(OrganizacionInformacionSUNATRepresentation informacionSunat) {
        this.informacionSunat = informacionSunat;
    }

}
