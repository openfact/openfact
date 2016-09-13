package org.openfact.models.ubl.type;

public interface IdentifierModel {

    String getValue();

    void setValue(String value);

    String getSchemeID();

    void setSchemeID(String schemeID);

    String getSchemeName();

    void setSchemeName(String schemeName);

    String getSchemeAgencyID();

    void setSchemeAgencyID(String schemeAgencyID);

    String getSchemeAgencyName();

    void setSchemeAgencyName(String schemeAgencyName);

    String getSchemeVersionID();

    void setSchemeVersionID(String schemeVersionID);

    String getSchemeDataURI();

    void setSchemeDataURI(String schemeDataURI);

    String getSchemeURI();

    void setSchemeURI(String schemeURI);

}
