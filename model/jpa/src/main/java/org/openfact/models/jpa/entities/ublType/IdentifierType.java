package org.openfact.models.jpa.entities.ublType;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * Created by lxpary on 08/09/16.
 */
@Embeddable
@Access(AccessType.FIELD)
public class IdentifierType {

    private String value;
    private String schemeID;
    private String schemeName;
    private String schemeAgencyID;
    private String schemeAgencyName;
    private String schemeVersionID;
    private String schemeDataURI;
    private String schemeURI;

    public IdentifierType() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    public void setSchemeAgencyID(String schemeAgencyID) {
        this.schemeAgencyID = schemeAgencyID;
    }

    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }

    public void setSchemeAgencyName(String schemeAgencyName) {
        this.schemeAgencyName = schemeAgencyName;
    }

    public String getSchemeVersionID() {
        return schemeVersionID;
    }

    public void setSchemeVersionID(String schemeVersionID) {
        this.schemeVersionID = schemeVersionID;
    }

    public String getSchemeDataURI() {
        return schemeDataURI;
    }

    public void setSchemeDataURI(String schemeDataURI) {
        this.schemeDataURI = schemeDataURI;
    }

    public String getSchemeURI() {
        return schemeURI;
    }

    public void setSchemeURI(String schemeURI) {
        this.schemeURI = schemeURI;
    }
}
