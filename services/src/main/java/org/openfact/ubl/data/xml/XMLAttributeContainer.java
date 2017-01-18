package org.openfact.ubl.data.xml;

import jodd.util.ArraysUtil;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openfact.JSONObjectUtils;
import org.openfact.ubl.data.xml.annotations.ArrayKey;
import org.openfact.ubl.data.xml.annotations.JsonWrapper;
import org.openfact.ubl.data.xml.annotations.SimpleKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

    public static <T> XmlConverter objectKey(Class<T> clazz) {
        return json -> {

           /* try {

                T t = clazz.newInstance();

                // Apply class annotations
                Annotation classAnnotation = clazz.getAnnotation(JsonWrapper.class);
                if(classAnnotation instanceof JsonWrapper){
                    JsonWrapper xmlClass = (JsonWrapper) classAnnotation;
                    json = JSONObjectUtils.getJSONObject(json, xmlClass.key());
                }
                if (json == null) return null;

                // Apply simple fieldKey annotation
                for (Field field : clazz.getFields()) {
                    Annotation fieldAnnotation = field.getAnnotation(SimpleKey.class);
                    if (fieldAnnotation instanceof SimpleKey) {
                        SimpleKey xmlField = (SimpleKey) fieldAnnotation;
                        Object value = JSONObjectUtils.getObject(json, xmlField.key());
                        field.set(t, xmlField.mapper().newInstance().apply(value));
                    }
                }

                // Apply array fieldKey annotation
                for (Field field : clazz.getFields()) {
                    Annotation fieldAnnotation = field.getAnnotation(ArrayKey.class);
                    if (fieldAnnotation instanceof ArrayKey) {
                        ArrayKey xmlField = (ArrayKey) fieldAnnotation;

                        List result = new ArrayList();
                        if (JSONObjectUtils.isJSONArray(json, (String[]) ArrayUtils.addAll(xmlField.arrayKey(), xmlField.fieldKey()))) {
                            JSONArray array = JSONObjectUtils.getJSONArray(json, (String[]) ArrayUtils.addAll(xmlField.arrayKey(), xmlField.fieldKey()));
                            Iterator it = array.iterator();
                            while (it.hasNext()) {
                                JSONObject current = (JSONObject) it.next();
                                result.add(JSONObjectUtils.getObject(current, xmlField.fieldKey()));
                            }
                        } else {
                            result.add(JSONObjectUtils.getObject(json, xmlField.arrayKey()));
                        }
                        field.set(t, result.stream().map(xmlField.mapper().newInstance()).collect(Collectors.toList()));
                    }
                }

            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Error creating constructor on " + clazz.getName(), e);
            }*/

            return null;
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

            return jsonObjects.stream().map(jsonObject -> {
                T instance = null;
                try {
                    instance = clazz.newInstance();

                    // Simple key
                    for (Field field : clazz.getFields()) {
                        Annotation annotation = field.getAnnotation(SimpleKey.class);
                        if (annotation instanceof SimpleKey) {
                            SimpleKey simpleKey = (SimpleKey) annotation;
                            Object value = JSONObjectUtils.getObject(jsonObject, simpleKey.key());
                            field.set(instance, simpleKey.mapper().newInstance().apply(value));
                        } else if (annotation instanceof ArrayKey) {
                            ArrayKey arrayKey = (ArrayKey) annotation;

                            List value = new ArrayList();
                            String[] fullKey = (String[]) ArrayUtils.addAll(arrayKey.arrayKey(), arrayKey.fieldKey());
                            if (JSONObjectUtils.isJSONArray(jsonObject, fullKey)) {
                                JSONArray array = JSONObjectUtils.getJSONArray(jsonObject, arrayKey.arrayKey());
                                Iterator it = array.iterator();
                                while (it.hasNext()) {
                                    JSONObject current = (JSONObject) it.next();
                                    value.add(JSONObjectUtils.getObject(current, arrayKey.fieldKey()));
                                }
                            } else {
                                value.add(JSONObjectUtils.getObject(jsonObject, fullKey));
                            }

                            Function mapper = arrayKey.mapper().newInstance();
                            field.set(instance, value.stream().map(mapper).collect(Collectors.toList()));
                        } else {
                            throw new RuntimeException("All fields have to be annotated" + clazz.getName());
                        }
                    }
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException("Could not reflect class:" + clazz.getName());
                }
                return instance;
            }).collect(Collectors.toList());
        };
    }

}
