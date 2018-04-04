package org.openfact.pe.models.jpa;

import org.openfact.pe.models.InformacionAdicionalPEModel;
import org.openfact.pe.models.jpa.entities.InformacionAdicionalPEEntity;

import javax.persistence.EntityManager;

public class InformacionAdicionalPEAdapter implements InformacionAdicionalPEModel {

    private final EntityManager em;
    private final InformacionAdicionalPEEntity additionalInfoEntity;

    public InformacionAdicionalPEAdapter(EntityManager em, InformacionAdicionalPEEntity additionalInfoEntity) {
        this.em = em;
        this.additionalInfoEntity = additionalInfoEntity;
    }

    @Override
    public String getId() {
        return additionalInfoEntity.getId();
    }

    @Override
    public String getAssignedId() {
        return additionalInfoEntity.getAssignedId();
    }

    @Override
    public void setAssignedId(String assignedId) {
        additionalInfoEntity.setAssignedId(assignedId);
    }

    @Override
    public String getAdditionalAssignedId() {
        return additionalInfoEntity.getAdditionalAssignedId();
    }

    @Override
    public void setAdditionalAssignedId(String additionalAssignedId) {
        additionalInfoEntity.setAdditionalAssignedId(additionalAssignedId);
    }

    @Override
    public String getRazonSocial() {
        return additionalInfoEntity.getRazonSocial();
    }

    @Override
    public void setRazonSocial(String razonSocial) {
        additionalInfoEntity.setRazonSocial(razonSocial);
    }

    @Override
    public String getNombreComercial() {
        return additionalInfoEntity.getNombreComercial();
    }

    @Override
    public void setNombreComercial(String nombreComercial) {
        additionalInfoEntity.setNombreComercial(nombreComercial);
    }

    @Override
    public String getRegion() {
        return additionalInfoEntity.getRegion();
    }

    @Override
    public void setRegion(String region) {
        additionalInfoEntity.setRegion(region);
    }

    @Override
    public String getProvincia() {
        return additionalInfoEntity.getProvincia();
    }

    @Override
    public void setProvincia(String provincia) {
        additionalInfoEntity.setProvincia(provincia);
    }

    @Override
    public String getDistrito() {
        return additionalInfoEntity.getDistrito();
    }

    @Override
    public void setDistrito(String distrito) {
        additionalInfoEntity.setDistrito(distrito);
    }

    @Override
    public String getCodigoPostal() {
        return additionalInfoEntity.getCodigoPostal();
    }

    @Override
    public void setCodigoPostal(String codigoPostal) {
        additionalInfoEntity.setCodigoPostal(codigoPostal);
    }

    @Override
    public String getCodigoPais() {
        return additionalInfoEntity.getCodigoPais();
    }

    @Override
    public void getCodigoPais(String codigoPais) {
        additionalInfoEntity.setCodigoPais(codigoPais);
    }

    @Override
    public String getDireccion() {
        return additionalInfoEntity.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        additionalInfoEntity.setDireccion(direccion);
    }

}
