package org.openfact.pe.idm;

import javax.validation.constraints.NotNull;

public class OrganizacionInformacionSUNATRepresentation {

    private String id;

    private Boolean useCustomConfig;

    @NotNull
    private String usuario;

    @NotNull
    private String password;

    private String boletaFacturaEndpoint;
    private String guiaRemisionEndpoint;
    private String retencionPercepcionEndpoint;
    private String consultaFacturaEndpoint;
    private String consultaCdrEndpoint;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBoletaFacturaEndpoint() {
        return boletaFacturaEndpoint;
    }

    public void setBoletaFacturaEndpoint(String boletaFacturaEndpoint) {
        this.boletaFacturaEndpoint = boletaFacturaEndpoint;
    }

    public String getGuiaRemisionEndpoint() {
        return guiaRemisionEndpoint;
    }

    public void setGuiaRemisionEndpoint(String guiaRemisionEndpoint) {
        this.guiaRemisionEndpoint = guiaRemisionEndpoint;
    }

    public String getRetencionPercepcionEndpoint() {
        return retencionPercepcionEndpoint;
    }

    public void setRetencionPercepcionEndpoint(String retencionPercepcionEndpoint) {
        this.retencionPercepcionEndpoint = retencionPercepcionEndpoint;
    }

    public String getConsultaFacturaEndpoint() {
        return consultaFacturaEndpoint;
    }

    public void setConsultaFacturaEndpoint(String consultaFacturaEndpoint) {
        this.consultaFacturaEndpoint = consultaFacturaEndpoint;
    }

    public String getConsultaCdrEndpoint() {
        return consultaCdrEndpoint;
    }

    public void setConsultaCdrEndpoint(String consultaCdrEndpoint) {
        this.consultaCdrEndpoint = consultaCdrEndpoint;
    }

    public Boolean getUseCustomConfig() {
        return useCustomConfig;
    }

    public void setUseCustomConfig(Boolean useCustomConfig) {
        this.useCustomConfig = useCustomConfig;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
