package org.openfact.core.models;

import java.util.Date;

public interface DocumentBean {

    String getType();

    String getAssignedId();

    Double getAmount();

    Double getTax();

    String getCurrency();

    Date getIssueDate();

    String getSupplierName();

    String getSupplierAssignedId();

    String getSupplierStreetAddress();

    String getSupplierCity();

    String getSupplierCountry();

    String getCustomerName();

    String getCustomerAssignedId();

    String getCustomerStreetAddress();

    String getCustomerCity();

    String getCustomerCountry();
}
