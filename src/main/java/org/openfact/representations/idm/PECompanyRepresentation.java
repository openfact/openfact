package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;

public class PECompanyRepresentation {

    private String id;

    @NotNull
    private String assignedId;

    @NotNull
    private String additionalAssignedId;

    @NotNull
    private String razonSocial;

    @NotNull
    private String nombreComercial;

    @NotNull
    private String region;

    @NotNull
    private String provincia;

    @NotNull
    private String distrito;

    @NotNull
    private String codigoPostal;

    @NotNull
    private String codigoPais;

    @NotNull
    private String direccion;

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public String getAdditionalAssignedId() {
        return additionalAssignedId;
    }

    public void setAdditionalAssignedId(String additionalAssignedId) {
        this.additionalAssignedId = additionalAssignedId;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
