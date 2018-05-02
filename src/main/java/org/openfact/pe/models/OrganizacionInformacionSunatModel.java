package org.openfact.pe.models;

public interface OrganizacionInformacionSunatModel {
    String getId();

    boolean isUseCustomConfig();
    void setUseCustomConfig(boolean useCustomConfig);

    String getUsuario();
    void setUsuario(String usuario);

    String getPassword();
    void setPassword(String password);

    String getBoletaFacturaEndpoint();
    void setBoletaFacturaEndpoint(String boletaFacturaEndpoint);

    String getGuiaRemisionEndpoint();
    void setGuiaRemisionEndpoint(String guiaRemisionEndpoint);

    String getRetencionPercepcionEndpoint();
    void setRetencionPercepcionEndpoint(String retencionPercepcionEndpoint);

    String getConsultaFacturaEndpoint();
    void setConsultaFacturaEndpoint(String consultaCdrEndpoint);

    String getConsultaCdrEndpoint();
    void setConsultaCdrEndpoint(String consultaCdrEndpoint);
}
