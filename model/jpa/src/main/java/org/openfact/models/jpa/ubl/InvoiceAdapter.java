package org.openfact.models.jpa.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentMeansModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected InvoiceEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            InvoiceEntity invoice) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.invoice = invoice;
    }

    @Override
    public InvoiceEntity getEntity() {
        return invoice;
    }

    @Override
    public UBLExtensionsModel getUBLExtensions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUBLExtensions(UBLExtensionsModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getUBLVersionID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUBLVersionID(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getCustomizationID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCustomizationID(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getProfileID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setProfileID(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setID(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean getCopyIndicator() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setCopyIndicator(boolean value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getUUID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUUID(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LocalDate getIssueDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIssueDate(LocalDate value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LocalTime getIssueTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIssueTime(LocalTime value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getInvoiceModelCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInvoiceCodeModel(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<String> getNote() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNote(List<String> note) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LocalDate getTaxPointDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getDocumentCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDocumentCurrencyCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getTaxCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxCurrencyCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getPricingCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPricingCurrencyCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getPaymentCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentCurrencyCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getPaymentAlternativeCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentAlternativeCurrencyCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getAccountingCostCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCostCode(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getAccountingCost() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCost(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BigDecimal getLineCountNumeric() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLineCountNumeric(BigDecimal value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PeriodModel> getInvoicePeriod() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInvoicePeriod(List<PeriodModel> invoicePeriod) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public OrderReferenceModel getOrderReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOrderReference(OrderReferenceModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBillingReference(List<BillingReferenceModel> billingReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DocumentReferenceModel> getDespatchDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DocumentReferenceModel> getReceiptDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DocumentReferenceModel> getOriginatorDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOriginatorDocumentReference(List<DocumentReferenceModel> originatorDocumentReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DocumentReferenceModel> getContractDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DocumentReferenceModel> getAdditionalDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<SignatureModel> getSignature() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSignature(List<SignatureModel> signature) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SupplierPartyModel getAccountingSupplierParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingSupplierParty(SupplierPartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CustomerPartyModel getAccountingCustomerParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCustomerParty(CustomerPartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public PartyModel getPayeeParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPayeeParty(PartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CustomerPartyModel getBuyerCustomerParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBuyerCustomerParty(CustomerPartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SupplierPartyModel getSellerSupplierParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSellerSupplierParty(SupplierPartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public PartyModel getTaxRepresentativeParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxRepresentativeParty(PartyModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDelivery(List<DeliveryModel> delivery) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public DeliveryTermsModel getDeliveryTerms() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDeliveryTerms(DeliveryTermsModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PaymentMeansModel> getPaymentMeans() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentMeans(List<PaymentMeansModel> paymentMeans) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PaymentTermsModel> getPaymentTerms() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentTerms(List<PaymentTermsModel> paymentTerms) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PaymentModel> getPrepaidPayment() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPrepaidPayment(List<PaymentModel> prepaidPayment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ExchangeRateModel getTaxExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ExchangeRateModel getPricingExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPricingExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ExchangeRateModel getPaymentExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ExchangeRateModel getPaymentAlternativeExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentAlternativeExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxTotal(List<TaxTotalModel> taxTotal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public MonetaryTotalModel getLegalMonetaryTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLegalMonetaryTotal(MonetaryTotalModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<InvoiceLineModel> getInvoiceLine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInvoiceLine(List<InvoiceLineModel> invoiceLine) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public InvoiceLineModel addInvoiceLine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        // TODO Auto-generated method stub
        return null;
    }

}
