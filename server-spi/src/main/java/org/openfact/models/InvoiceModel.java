package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InvoiceModel {

    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";

    String getId();

    DocumentSnapshotModel getType();

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

    OrganizationSnapshotModel getOrganizationSaved();

    List<InvoiceLineModel> getInvoiceLines();

    InvoiceLineModel addInvoiceLine();

    boolean removeInvoiceLine(InvoiceLineModel invoiceLine);

    OrganizationModel getOrganization();
    
    /**
     * Required acctions*/
    Set<String> getRequiredActions();
    void addRequiredAction(String action);
    void removeRequiredAction(String action);
    void addRequiredAction(RequiredAction action);
    void removeRequiredAction(RequiredAction action);
    
    /**
     * Set single value of specified attribute. Remove all other existing values
     *
     * @param name
     * @param value
     */
    void setSingleAttribute(String name, String value);

    void setAttribute(String name, List<String> values);

    void removeAttribute(String name);

    /**
     * @param name
     * @return null if there is not any value of specified attribute or first value otherwise. Don't throw exception if there are more values of the attribute
     */
    String getFirstAttribute(String name);

    /**
     * @param name
     * @return list of all attribute values or empty list if there are not any values. Never return null
     */
    List<String> getAttribute(String name);

    Map<String, List<String>> getAttributes();

    public static enum RequiredAction {
        VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD
    }

	long getCreatedTimestamp();
}
