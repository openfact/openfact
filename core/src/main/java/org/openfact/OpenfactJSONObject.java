package org.openfact;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class OpenfactJSONObject {

    private String regex;
    private String replacement;

    private JSONObject jsonObject;

    public OpenfactJSONObject(JSONObject jsonObject) {
        this(jsonObject, null, null);
    }

    public OpenfactJSONObject(JSONObject jsonObject, String regex, String replacement) {
        this.regex = regex;
        this.replacement = replacement;
        this.jsonObject = jsonObject;
        this.init();
    }

    private void init() {
        if (getRegex() != null && getReplacement() != null) {
            this.jsonObject = initRegex(jsonObject, new JSONObject());
        }
    }

    private JSONObject initRegex(JSONObject jsonOrigin, JSONObject jsonCopy) {
        Iterator<String> keys = jsonOrigin.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String newKey = key.replaceAll(this.getRegex(), this.getReplacement());

            Object value = jsonOrigin.get(key);
            if (value instanceof JSONObject) {
                value = initRegex((JSONObject) value, new JSONObject());
            } else if (value instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) value;
                JSONArray jsonArrayCopy = new JSONArray();

                Iterator<Object> jsonArrayIterator = jsonArray.iterator();
                while (jsonArrayIterator.hasNext()) {
                    Object element = jsonArrayIterator.next();
                    if (element instanceof JSONObject) {
                        jsonArrayCopy.put(jsonArrayCopy.length(), this.initRegex((JSONObject) element, new JSONObject()));
                    }
                }
                value = jsonArrayCopy;
            }

            jsonCopy.put(newKey, value);
        }
        return jsonCopy;
    }

    public OpenfactJSONObject navigate(String key) {
        this.jsonObject = jsonObject.getJSONObject(key);
        return this;
    }

    public Object get(String... key) {
        Object result = jsonObject;
        for (int i = 0; i < key.length; i++) {
            result = ((JSONObject) result).get(key[i]);
        }
        return result;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getRegex() {
        return regex;
    }

    public String getReplacement() {
        return replacement;
    }

}
