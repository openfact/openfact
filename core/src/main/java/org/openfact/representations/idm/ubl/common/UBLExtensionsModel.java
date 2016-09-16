package org.openfact.representations.idm.ubl.common;

import java.util.List;

public interface UBLExtensionsModel {

    List<UBLExtensionModel> getUBLExtension();

    void setUBLExtension(List<UBLExtensionModel> ublExtension);

    String getId();

    void setId(String value);

}
