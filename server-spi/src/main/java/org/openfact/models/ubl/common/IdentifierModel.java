package org.openfact.models.ubl.common;

public interface IdentifierModel {

    String getValue();

    void setValue(String value);

    String getSchemeID();

    void setSchemeID(String value);

    String getSchemeName();

    void setSchemeName(String value);

    String getSchemeAgencyID();

    void setSchemeAgencyID(String value);

    String getSchemeAgencyName();

    void setSchemeAgencyName(String value);

    String getSchemeVersionID();

    void setSchemeVersionID(String value);

    String getSchemeDataURI();

    void setSchemeDataURI(String value);

    String getSchemeURI();

    void setSchemeURI(String value);

    String getId();

    void setId(String value);

}
