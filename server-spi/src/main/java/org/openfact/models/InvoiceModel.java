package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.provider.ProviderEvent;

public interface InvoiceModel {

    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";
    String SERIES = "series";
    String NUMBER = "number";

	String TYPE = "type";
	String CURRENCY_CODE = "currencyCode";

	String getId();

	int getSeries();

    void setSeries(int series);

    int getNumber();

    void setNumber(int number);

    DocumentSnapshotModel getType();
	void setNumber(int number);

	byte[] getContent();

	void setContent(byte[] content);

	DocumentSnapshotModel getType();

    void setType(String documentName, String documentId);

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
     * Required acctions
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
	/**
	 * @param name
	 * @return null if there is not any value of specified attribute or first
	 *         value otherwise. Don't throw exception if there are more values
	 *         of the attribute
	 */
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
