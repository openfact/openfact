package org.openfact.representations.idm.ubl.common;

import java.util.ArrayList;
import java.util.List;

public class UBLExtensionsRepresentation {
    private List<UBLExtensionRepresentation> UBLExtension;
    private String id;

    /**/
    public void addUBLExtension(UBLExtensionRepresentation representation) {
        if (UBLExtension == null) {
            UBLExtension = new ArrayList<>();
        }
        UBLExtension.add(representation);
    }
    /**/

    public List<UBLExtensionRepresentation> getUBLExtension() {
        return this.UBLExtension;
    }

    public void setUBLExtension(List<UBLExtensionRepresentation> UBLExtension) {
        this.UBLExtension = UBLExtension;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}