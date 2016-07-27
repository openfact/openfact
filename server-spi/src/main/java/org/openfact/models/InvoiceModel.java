package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;

public interface InvoiceModel {
    
    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";

    String getId();

    LocalDate getIssueDate();

    String getCurrencyCode();

    InvoiceType getInvoiceType();

    InvoiceIdModel getInvoiceId();
    
    void setInvoiceId(InvoiceIdModel invoiceId);

    CustomerModel getCustomer();

    void setCustomer(CustomerModel customer);

    Map<AdditionalInformationType, BigDecimal> getAdditionalInformation();
    
    void addAdditionalInformation(AdditionalInformationType type, BigDecimal ammount);

    Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal();
    
    void addLegalMonetaryTotal(MonetaryTotalType type, BigDecimal ammount);

    OrganizationModel getOrganization();

}
