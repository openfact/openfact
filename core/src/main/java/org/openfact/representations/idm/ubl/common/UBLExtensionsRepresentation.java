package org.openfact.representations.idm.ubl.common;

import java.util.ArrayList;
import java.util.List;

public class UBLExtensionsRepresentation {
    private List<UBLExtensionRepresentation> ublExtension;
    private String id;

    /**/
    public void addUBLExtension(UBLExtensionRepresentation representation) {
        if (ublExtension == null) {
            ublExtension = new ArrayList<>();
        }
        ublExtension.add(representation);
    }
    /**/

    public List<UBLExtensionRepresentation> getUblExtension() {
        return ublExtension;
    }

    public void setUblExtension(List<UBLExtensionRepresentation> ublExtension) {
        this.ublExtension = ublExtension;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}