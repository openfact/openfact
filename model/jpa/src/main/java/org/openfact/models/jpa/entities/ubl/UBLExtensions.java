package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxpary on 08/09/16.
 */
public class UBLExtensions {
 private List<UBLExtension> ublExtensions=new ArrayList<>();

    public List<UBLExtension> getUblExtensions() {
        return ublExtensions;
    }

    public void setUblExtensions(List<UBLExtension> ublExtensions) {
        this.ublExtensions = ublExtensions;
    }
}
