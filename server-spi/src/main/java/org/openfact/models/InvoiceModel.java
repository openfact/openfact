package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface InvoiceModel {

    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";

    String getId();

    DocumentSavedModel getType();

    void setType(String documentName, String documentId);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate issueDate);

    String getCurrencyCode();

    void setCurrencyCode(String currencyCode);

    InvoiceIdModel getInvoiceId();

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal chargeTotalAmount);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal payableAmount);

    CustomerModel getCustomer();

    CustomerModel setCustomer(String registrationName);

    Set<InvoiceAdditionalInformationModel> getAdditionalInformation();

    InvoiceAdditionalInformationModel addAdditionalInformation(String name, String documentId, BigDecimal ammount);

    Set<InvoiceTaxTotalModel> getInvoiceTaxTotal();

    InvoiceTaxTotalModel addTaxTotal(String name, String documentId, BigDecimal ammount);

    OrganizationSavedModel getOrganizationSaved();

    List<InvoiceLineModel> getInvoiceLines();

    InvoiceLineModel addInvoiceLine();

    boolean removeInvoiceLine(InvoiceLineModel invoiceLine);

    OrganizationModel getOrganization();

}
