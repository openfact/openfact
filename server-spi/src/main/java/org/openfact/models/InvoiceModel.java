package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.provider.ProviderEvent;
import org.w3c.dom.Document;

public interface InvoiceModel {

    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";
    String SERIES = "series";
    String NUMBER = "number";

    String getId();    

    LocalDate getIssueDate();

    void setIssueDate(LocalDate issueDate);

    String getCurrencyCode();

    void setCurrencyCode(String currencyCode);

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal chargeTotalAmount);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal payableAmount);

    List<InvoiceLineModel> getInvoiceLines();

    InvoiceLineModel addInvoiceLine();

    boolean removeInvoiceLine(InvoiceLineModel invoiceLine);

    OrganizationModel getOrganization();

    /**
     * Series and number
     */
    int getSeries();

    void setSeries(int series);

    int getNumber();

    void setNumber(int number);

    String getSeriesAndNumberAsId();
    
    /**
     * Additional information
     */
    Set<InvoiceAdditionalInformationModel> getAdditionalInformation();

    InvoiceAdditionalInformationModel addAdditionalInformation(String name, String id, BigDecimal amount);

    /**
     * Total taxs
     */
    Set<InvoiceTaxTotalModel> getInvoiceTaxTotal();

    InvoiceTaxTotalModel addTaxTotal(String name, String id, BigDecimal taxAmount, BigDecimal taxValue);

    /**
     * Document Type
     */
    String getTypeName();

    void setTypeName(String typeName);

    String getTypeId();

    void setTypeId(String typeId);

    /**
     * Customer
     */
    CustomerModel getCustomer();

    void setCustomer(CustomerModel customer);

    /**
     * Ubl Representation
     */
    Document getUbl();

    void setUbl(Document ubl);

    /**
     * Required actions
     */
    Set<String> getRequiredActions();

    void addRequiredAction(String action);

    void removeRequiredAction(String action);

    void addRequiredAction(RequiredAction action);

    void removeRequiredAction(RequiredAction action);

    /**
     * Attributes
     */
    void setSingleAttribute(String name, String value);

    void setAttribute(String name, List<String> values);

    void removeAttribute(String name);

    String getFirstAttribute(String name);

    List<String> getAttribute(String name);

    Map<String, List<String>> getAttributes();

    /**
     * Created time
     */
    long getCreatedTimestamp();

    /**
     * Required actions
     */
    public static enum RequiredAction {
        SEND_EMAIL_INMEDIATELLY, SEND_UBL_INMEDIATELLY
    }

    /**
     * Events interfaces
     */
    interface InvoiceCreationEvent extends ProviderEvent {
        InvoiceModel getCreatedInvoice();
    }

    interface InvoicePostCreateEvent extends ProviderEvent {
        InvoiceModel getCreatedInvoice();

        OpenfactSession getOpenfactSession();
    }

    interface InvoiceRemovedEvent extends ProviderEvent {
        InvoiceModel getInvoice();

        OpenfactSession getOpenfactSession();
    }
}
