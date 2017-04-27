package org.openfact.ubl.data.xml.mappers;

import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openfact.JSONObjectUtils;
import org.openfact.ubl.data.xml.annotations.ArrayKey;
import org.openfact.ubl.data.xml.annotations.SimpleKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectMapper {

    public static <T> List<T> objectArrayKey(Class<T> clazz, List<JSONObject> jsons) {
        return jsons.stream().map(json -> mapObjectKey(clazz, json)).collect(Collectors.toList());
    }

    public static <T> T mapObjectKey(Class<T> clazz, JSONObject json) {
        T instance = null;
        try {
            instance = clazz.newInstance();

            // Simple key
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                Annotation simpleAnnotation = field.getAnnotation(SimpleKey.class);
                if (simpleAnnotation instanceof SimpleKey) {
                    SimpleKey simpleKey = (SimpleKey) simpleAnnotation;
                    Object value = JSONObjectUtils.getObject(json, simpleKey.key());
                    field.set(instance, simpleKey.mapper().newInstance().apply(value));
                }

                Annotation arrayAnnotation = field.getAnnotation(ArrayKey.class);
                if (arrayAnnotation instanceof ArrayKey) {
                    ArrayKey arrayKey = (ArrayKey) arrayAnnotation;

                    List value = new ArrayList();
                    if (JSONObjectUtils.isJSONArray(json, arrayKey.arrayKey())) {
                        JSONArray array = JSONObjectUtils.getJSONArray(json, arrayKey.arrayKey());
                        Iterator it = array.iterator();
                        while (it.hasNext()) {
                            JSONObject current = (JSONObject) it.next();
                            value.add(JSONObjectUtils.getObject(current, arrayKey.fieldKey()));
                        }
                    } else {
                        String[] fullKey = (String[]) ArrayUtils.addAll(arrayKey.arrayKey(), arrayKey.fieldKey());
                        value.add(JSONObjectUtils.getObject(json, fullKey));
                    }

                    Function mapper = arrayKey.mapper().newInstance();
                    field.set(instance, value.stream().map(mapper).collect(Collectors.toList()));
                }
            }
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Error parsing object", e);
        }

        return instance;
    }

}
