package org.openfact.models.jpa.entities.ublType;

/**
 * Created by lxpary on 08/09/16.
 */
public class TextTypeUnqDat {
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
