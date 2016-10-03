package org.openfact.models.ubl.common;

import java.util.List;

public interface UBLExtensionsModel {

    List<UBLExtensionModel> getUBLExtension();

    void setUBLExtension(List<UBLExtensionModel> ublExtension);

    String getId();

    void setId(String value);

	UBLExtensionModel addUblExtension();

}
