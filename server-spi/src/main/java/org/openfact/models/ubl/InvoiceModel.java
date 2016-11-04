/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.ubl;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.*;
import org.openfact.provider.ProviderEvent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface InvoiceModel {

    String ID = "ID";
    String INVOICE_TYPE_CODE = "invoiceTypeCode";
    String ISSUE_DATETIME = "issueDateTime";

    String getId();

    /**
     * attributes
     */
    void setSingleAttribute(String name, String value);

    void setAttribute(String name, List<String> values);

    void removeAttribute(String name);

    String getFirstAttribute(String name);

    List<String> getAttribute(String name);

    Map<String, List<String>> getAttributes();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * */
    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    String getUBLVersionID();

    void setUBLVersionID(String value);

    String getCustomizationID();

    void setCustomizationID(String value);

    String getProfileID();

    void setProfileID(String value);

    String getID();

    void setID(String value);

    boolean getCopyIndicator();

    void setCopyIndicator(boolean value);

    String getUUID();

    void setUUID(String value);

    LocalDateTime getIssueDateTime();

    void setIssueDateTime(LocalDateTime value);

    String getInvoiceTypeCode();

    void setInvoiceTypeCode(String value);

    List<String> getNote();

    void setNote(List<String> note);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate value);

    String getDocumentCurrencyCode();

    void setDocumentCurrencyCode(String value);

    String getTaxCurrencyCode();

    void setTaxCurrencyCode(String value);

    String getPricingCurrencyCode();

    void setPricingCurrencyCode(String value);

    String getPaymentCurrencyCode();

    void setPaymentCurrencyCode(String value);

    String getPaymentAlternativeCurrencyCode();

    void setPaymentAlternativeCurrencyCode(String value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    BigDecimal getLineCountNumeric();

    void setLineCountNumeric(BigDecimal value);

    List<PeriodModel> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodModel> invoicePeriod);

    OrderReferenceModel getOrderReference();

    void setOrderReference(OrderReferenceModel value);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDespatchDocumentReference();

    void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference);

    List<DocumentReferenceModel> getReceiptDocumentReference();

    void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference);

    List<DocumentReferenceModel> getOriginatorDocumentReference();

    void setOriginatorDocumentReference(List<DocumentReferenceModel> originatorDocumentReference);

    List<DocumentReferenceModel> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference);

    List<DocumentReferenceModel> getAdditionalDocumentReference();

    void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel value);

    PartyModel getPayeeParty();

    void setPayeeParty(PartyModel value);

    CustomerPartyModel getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    PartyModel getTaxRepresentativeParty();

    void setTaxRepresentativeParty(PartyModel value);

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    List<PaymentMeansModel> getPaymentMeans();

    void setPaymentMeans(List<PaymentMeansModel> paymentMeans);

    List<PaymentTermsModel> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsModel> paymentTerms);

    List<PaymentModel> getPrepaidPayment();

    void setPrepaidPayment(List<PaymentModel> prepaidPayment);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    ExchangeRateModel getTaxExchangeRate();

    void setTaxExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentExchangeRate();

    void setPaymentExchangeRate(ExchangeRateModel value);

    ExchangeRateModel getPaymentAlternativeExchangeRate();

    void setPaymentAlternativeExchangeRate(ExchangeRateModel value);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    MonetaryTotalModel getLegalMonetaryTotal();

    void setLegalMonetaryTotal(MonetaryTotalModel value);

    List<InvoiceLineModel> getInvoiceLine();

    void setInvoiceLine(List<InvoiceLineModel> invoiceLine);

    /**
     * Other methods
     */
    InvoiceLineModel addInvoiceLine();

    TaxTotalModel addTaxTotal();

    SignatureModel addSignature();

    Byte[] getXmlDocument();

    void setXmlDocument(Byte[] value);

    List<RequeridActionDocument> getRequeridAction();

    void setRequeridAction(List<RequeridActionDocument> requeridAction);

    boolean removeRequeridAction(RequeridActionDocument requeridAction);

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
