package org.openfact.ubl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openfact.JSONObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XMLAttributeContainer {

    public static JSONObjectToObjectConverter simpleKey(Function<Object, Object> caster, String... keys) {
        return json -> caster.apply(JSONObjectUtils.getObject(json, keys));
    }

    public static JSONObjectToObjectConverter arrayKey(Function<Object, Object> caster, String... keys) {
        return json -> {
            List result = new ArrayList();
            if (JSONObjectUtils.isJSONArray(json, keys)) {
                JSONArray array = JSONObjectUtils.getJSONArray(json, keys);
                Iterator it = array.iterator();
                while (it.hasNext()) {
                    result.add(it.next());
                }
            } else {
                result.add(JSONObjectUtils.getObject(json, keys));
            }
            return result.stream().map(caster).collect(Collectors.toList());
        };
    }

    public static JSONObjectToObjectConverter arrayKey(Function<String, Object> caster, int arrayIndex, String... keys) {
        return json -> {
            List result = new ArrayList();
            if (JSONObjectUtils.isJSONArray(json, Arrays.copyOfRange(keys, 0, arrayIndex + 1))) {
                JSONArray array = JSONObjectUtils.getJSONArray(json, keys);
                Iterator it = array.iterator();
                while (it.hasNext()) {
                    JSONObject current = (JSONObject) it.next();
                    result.add(JSONObjectUtils.getObject(current, Arrays.copyOfRange(keys, arrayIndex + 1, keys.length)));
                }
            } else {
                result.add(JSONObjectUtils.getObject(json, keys));
            }
            return result.stream().map(caster).collect(Collectors.toList());
        };
    }

}
