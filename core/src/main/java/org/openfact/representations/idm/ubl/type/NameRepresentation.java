package org.openfact.representations.idm.ubl.type;

public class NameRepresentation {
    protected String value;
    protected String languageID;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguageID() {
        return languageID;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }
}
