package org.openfact.ubl;

import org.json.JSONObject;

public interface JSONObjectToObjectConverter {

    Object asObject(JSONObject json);

}
