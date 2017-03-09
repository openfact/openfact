package org.openfact.ubl.data.xml;

import org.json.JSONObject;

public interface XmlConverter {

    Object asObject(JSONObject json);

}
