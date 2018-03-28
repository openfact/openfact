package org.openfact.models.jpa;

import org.openfact.models.ModelType;
import org.openfact.models.PECompanyModel;
import org.openfact.models.UserModel;
import org.openfact.models.jpa.entities.PE_CompanyAdditionalInfoEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PECompanyAdapter implements PECompanyModel {

    private final EntityManager em;
    private final PE_CompanyAdditionalInfoEntity additionalInfoEntity;

    public PECompanyAdapter(EntityManager em, PE_CompanyAdditionalInfoEntity additionalInfoEntity) {
        this.em = em;
        this.additionalInfoEntity = additionalInfoEntity;
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

    @Override
    public String getName() {
        return additionalInfoEntity.getCompany().getName();
    }

    @Override
    public void setName(String name) {
        additionalInfoEntity.getCompany().setName(name);
    }

    @Override
    public String getDescription() {
        return additionalInfoEntity.getCompany().getDescription();
    }

    @Override
    public void setDescription(String description) {
        additionalInfoEntity.getCompany().setDescription(description);
    }

    @Override
    public boolean getUseCustomCertificates() {
        return additionalInfoEntity.getCompany().isUseCustomCertificates();
    }

    @Override
    public void setUseCustomCertificates(boolean useCustomCertificates) {
        additionalInfoEntity.getCompany().setUseCustomCertificates(useCustomCertificates);
    }

    @Override
    public boolean getUseCustomSmtpConfig() {
        return additionalInfoEntity.getCompany().isUseCustomSmtpConfig();
    }

    @Override
    public void setUseCustomSmtpConfig(boolean useCustomSmtpConfig) {
        additionalInfoEntity.getCompany().setUseCustomSmtpConfig(useCustomSmtpConfig);
    }

    @Override
    public Map<String, String> getSmtpConfig() {
        Map<String, String> config = new HashMap<>();
        config.putAll(additionalInfoEntity.getCompany().getSmtpConfig());
        return Collections.unmodifiableMap(config);
    }

    @Override
    public void setSmtpConfig(Map<String, String> smtpConfig) {
        additionalInfoEntity.getCompany().setSmtpConfig(smtpConfig);
    }

    @Override
    public UserModel getOwner() {
        return new UserAdapter(em, additionalInfoEntity.getCompany().getOwner());
    }

    @Override
    public String getId() {
        return additionalInfoEntity.getCompany().getId();
    }

    @Override
    public ModelType getType() {
        return ModelType.COMPANY;
    }
}
