package org.openfact.core.models.jpa;

import org.openfact.core.models.DocumentModel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DocumentFieldMapper implements Function<String, String> {

    public static final Map<String, String> mapper = createMap();

    private String prefix;

    public DocumentFieldMapper() {

    }

    public DocumentFieldMapper(String prefix) {
        this.prefix = prefix;
    }

    private static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        // Document
        map.put(DocumentModel.TYPE, "type");
        map.put(DocumentModel.ASSIGNED_ID, "assignedId");
        map.put(DocumentModel.CURRENCY, "currency");
        map.put(DocumentModel.ISSUE_DATE, "issueDate");
        map.put(DocumentModel.AMOUNT, "amount");
        map.put(DocumentModel.SUPPLIER_NAME, "supplierName");
        map.put(DocumentModel.SUPPLIER_ASSIGNED_ID, "supplierAssignedId");
        map.put(DocumentModel.CUSTOMER_NAME, "customerName");
        map.put(DocumentModel.CUSTOMER_ASSIGNED_ID, "customerAssignedId");

        return map;
    }

    @Override
    public String apply(String fieldName) {
        if (prefix == null) {
            return mapper.getOrDefault(fieldName, fieldName);
        } else {
            return prefix + "." + mapper.getOrDefault(fieldName, fieldName);
        }
    }

}
