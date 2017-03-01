package org.openfact;

import java.util.Arrays;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectUtils {

    public JSONObject clone(JSONObject jsonObject) {
        return new JSONObject(jsonObject.toString());
    }

    public static JSONObject renameKey(JSONObject json, String regex, String replacement) {
        return renameKey(json, new JSONObject(), regex, replacement);
    }

    public static JSONObject renameKey(JSONObject json, JSONObject copy, String regex, String replacement) {
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String newKey = key.replaceAll(regex, replacement);

            Object value = json.get(key);
            if (value instanceof JSONObject) {
                value = renameKey((JSONObject) value, new JSONObject(), regex, replacement);
            } else if (value instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) value;
                JSONArray jsonArrayCopy = new JSONArray();

                Iterator<Object> jsonArrayIterator = jsonArray.iterator();
                while (jsonArrayIterator.hasNext()) {
                    Object element = jsonArrayIterator.next();
                    if (element instanceof JSONObject) {
                        jsonArrayCopy.put(jsonArrayCopy.length(), renameKey((JSONObject) element, new JSONObject(), regex, replacement));
                    }
                }
                value = jsonArrayCopy;
            }
            copy.put(newKey, value);
        }
        return copy;
    }

    /**
     * @return Object object from json[key]
     */
    public static Object getObject(JSONObject json, String... key) {
        if (key.length == 0) {
            return json;
        }
        if (key.length == 1) {
            return json.has(key[0]) ? json.get(key[0]) : null;
        }

        json = getJSONObject(json, Arrays.copyOfRange(key, 0, key.length - 1));
        if (json != null && json.has(key[key.length - 1])) {
            return json.get(key[key.length - 1]);
        }
        return null;
    }

    /**
     * @return JSONObject object from json[key]
     */
    public static JSONObject getJSONObject(JSONObject json, String... key) {
        if (key.length == 0) {
            return json;
        }

        for (int i = 0; i < key.length; i++) {
            if (!json.has(key[i])) return null;
            json = json.getJSONObject(key[i]);
        }
        return json;
    }

    /**
     * @return JSONArray object from json[key]
     */
    public static JSONArray getJSONArray(JSONObject json, String... key) {
        if (key.length == 0) {
            throw new JSONException("Key length could not be empty");
        }

        json = getJSONObject(json, Arrays.copyOfRange(key, 0, key.length - 1));
        if (json != null && json.has(key[key.length - 1])) {
            return (JSONArray) json.get(key[key.length - 1]);
        }
        return null;
    }

    /**
     * @return true if json[key]is not instance of JSONObject or JSONArray, otherwise return false;
     */
    public static boolean isObject(JSONObject json, String... key) {
        if (key.length == 0) {
            return false;
        }

        Object object = getObject(json, key);
        return object != null && !(object instanceof JSONObject || object instanceof JSONArray);
    }

    /**
     * @return true if json[key]is instance of JSONObject, otherwise return false;
     */
    public static boolean isJSONObject(JSONObject json, String... key) {
        if (key.length == 0) {
            return true;
        }

        Object object = getObject(json, key);
        return object != null && (object instanceof JSONObject);
    }

    /**
     * @return true if json[key]is instance of JSONArray, otherwise return false;
     */
    public static boolean isJSONArray(JSONObject json, String... key) {
        if (key.length == 0) return false;
        Object object = getObject(json, key);
        return object != null && (object instanceof JSONArray);
    }

}
