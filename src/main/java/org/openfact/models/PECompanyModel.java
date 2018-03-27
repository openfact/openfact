package org.openfact.models;

public interface PECompanyModel extends CompanyModel {

    String getAssignedId();
    void setAssignedId(String assignedId);

    String getAdditionalAssignedId();
    void setAdditionalAssignedId(String additionalAssignedId);


    String getRazonSocial();
    void setRazonSocial(String razonSocial);

    String getNombreComercial();
    void setNombreComercial(String nombreComercial);

    String getRegion();
    void setRegion(String region);

    String getProvincia();
    void setProvincia(String provincia);

    String getDistrito();
    void setDistrito(String distrito);

    String getCodigoPostal();
    void setCodigoPostal(String codigoPostal);

    String getCodigoPais();
    void getCodigoPais(String codigoPais);

    String getDireccion();
    void setDireccion(String direccion);

}
