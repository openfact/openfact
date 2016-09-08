package org.openfact.models.jpa.entities.ubl;

/**
 * Created by lxpary on 08/09/16.
 */
public class AdditionalProperty {
    /**
     * An identifier for this document.
     */
    private String id;
    /**
     * The value of the Additional property.
     */
    private String value;

    public AdditionalProperty() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
