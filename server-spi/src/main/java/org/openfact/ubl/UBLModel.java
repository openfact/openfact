package org.openfact.ubl;

import org.json.JSONObject;

public interface UBLModel {

    String getTemplateName();

    String getDocumentId();

    JSONObject getXmlAsJSONObject();

}
