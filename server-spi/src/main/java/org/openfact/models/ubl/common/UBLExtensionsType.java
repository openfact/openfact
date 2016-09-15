package org.openfact.models.ubl.common;

import java.util.List;

public interface UBLExtensionsType {

    List<UBLExtensionType> getUBLExtension();

    void setUBLExtension(List<UBLExtensionType> ublExtension);

    String getId();

    void setId(String value);

}
