package org.openfact.pe.models.jpa;

import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.jpa.entities.OrganizacionInformacionSunatEntity;

import javax.persistence.EntityManager;

public class OrganizacionInformacionSunatAdapter implements OrganizacionInformacionSunatModel {

    private final EntityManager em;
    private final OrganizacionInformacionSunatEntity entity;

    public OrganizacionInformacionSunatAdapter(EntityManager em, OrganizacionInformacionSunatEntity entity) {
        this.em = em;
        this.entity = entity;
    }

    @Override
    public String getId() {
        return entity.getId();
    }

    @Override
    public boolean isUseCustomConfig() {
        return entity.isUseCustomConfig();
    }

    @Override
    public void setUseCustomConfig(boolean useCustomConfig) {
        entity.setUseCustomConfig(useCustomConfig);
    }

    @Override
    public String getUsuario() {
        return entity.getUsuario();
    }

    @Override
    public void setUsuario(String usuario) {
        entity.setUsuario(usuario);
    }

    @Override
    public String getPassword() {
        return entity.getPassword();
    }

    @Override
    public void setPassword(String password) {
        entity.setPassword(password);
    }

    @Override
    public String getBoletaFacturaEndpoint() {
        return entity.getBoletaFacturaEndpoint();
    }

    @Override
    public void setBoletaFacturaEndpoint(String boletaFacturaEndpoint) {
        entity.setBoletaFacturaEndpoint(boletaFacturaEndpoint);
    }

    @Override
    public String getGuiaRemisionEndpoint() {
        return entity.getGuiaRemisionEndpoint();
    }

    @Override
    public void setGuiaRemisionEndpoint(String guiaRemisionEndpoint) {
        entity.setGuiaRemisionEndpoint(guiaRemisionEndpoint);
    }

    @Override
    public String getRetencionPercepcionEndpoint() {
        return entity.getRetencionPercepcionEndpoint();
    }

    @Override
    public void setRetencionPercepcionEndpoint(String retencionPercepcionEndpoint) {
        entity.setRetencionPercepcionEndpoint(retencionPercepcionEndpoint);
    }

    @Override
    public String getConsultaFacturaEndpoint() {
        return entity.getConsultaFacturaEndpoint();
    }

    @Override
    public void setConsultaFacturaEndpoint(String consultaCdrEndpoint) {
        entity.setConsultaFacturaEndpoint(consultaCdrEndpoint);
    }

    @Override
    public String getConsultaCdrEndpoint() {
        return entity.getConsultaCdrEndpoint();
    }

    @Override
    public void setConsultaCdrEndpoint(String consultaCdrEndpoint) {
        entity.setConsultaCdrEndpoint(consultaCdrEndpoint);
    }
}
