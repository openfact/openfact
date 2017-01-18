package org.openfact.ubl.data.xml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openfact.JSONObjectUtils;
import org.openfact.ubl.data.xml.annotations.ArrayKey;
import org.openfact.ubl.data.xml.annotations.JsonWrapper;
import org.openfact.ubl.data.xml.annotations.SimpleKey;
import org.openfact.ubl.data.xml.mappers.ObjectMapper;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XMLAttributeContainer {

    public static XmlConverter simpleKey(Function<Object, Object> caster, String... keys) {
        return json -> caster.apply(JSONObjectUtils.getObject(json, keys));
    }

    public static XmlConverter arrayKey(Function<Object, Object> caster, String... keys) {
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

    public static XmlConverter arrayKey(Function<String, Object> caster, int arrayIndex, String... keys) {
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

    public static <T> XmlConverter objectArrayKey(Class<T> clazz, String... keys) {
        return json -> {

            List<JSONObject> jsonObjects = new ArrayList<>();
            json = JSONObjectUtils.getJSONObject(json, keys);

            Annotation clazzAnnotation = clazz.getAnnotation(JsonWrapper.class);
            if (clazzAnnotation instanceof JsonWrapper) {
                JsonWrapper jsonWrapper = (JsonWrapper) clazzAnnotation;
                if (JSONObjectUtils.isJSONArray(json, jsonWrapper.key())) {
                    JSONArray array = JSONObjectUtils.getJSONArray(json, jsonWrapper.key());
                    Iterator it = array.iterator();
                    while (it.hasNext()) {
                        jsonObjects.add((JSONObject) it.next());
                    }
                } else {
                    jsonObjects.add(JSONObjectUtils.getJSONObject(json, jsonWrapper.key()));
                }
            }

            return jsonObjects.stream()
                    .map(jsonObject -> ObjectMapper.mapObjectKey(clazz, jsonObject))
                    .collect(Collectors.toList());
        };
    }



}
