package org.openfact.core.models;

import java.util.Date;

public interface DocumentModel {

    String[] FILTER_TEXT_FIELDS = {
            DocumentModel.ASSIGNED_ID,
            DocumentModel.CUSTOMER_NAME,
            DocumentModel.CUSTOMER_ASSIGNED_ID
    };

    String ASSIGNED_ID = "assignedId";

    String SUPPLIER_NAME = "supplierName";
    String SUPPLIER_ASSIGNED_ID = "supplierAssignedId";
    String CUSTOMER_ASSIGNED_ID = "customerAssignedId";
    String CUSTOMER_NAME = "customerName";

    String TYPE = "type";
    String CURRENCY = "currency";
    String ISSUE_DATE = "issueDate";
    String AMOUNT = "amount";

    String getId();

    String getType();

    String getAssignedId();

    String getSupplierAssignedId();

    String getCustomerAssignedId();

    Date getIssueDate();

    String getCurrency();

    Double getAmount();

    Double getTax();

    String getSupplierName();

    String getCustomerName();


    interface DocumentCreationEvent {
        DocumentModel getCreatedDocument();
    }

    interface DocumentRemovedEvent {
        DocumentModel getDocument();
    }

}
