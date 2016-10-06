package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.InvoiceLineEntity;
import org.openfact.models.jpa.entities.ubl.common.LineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderLineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentTermsEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class InvoiceLineAdapter implements InvoiceLineModel, JpaModel<InvoiceLineEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceLineAdapter.class);
    protected InvoiceLineEntity invoiceLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceLineAdapter(OpenfactSession session, EntityManager em, InvoiceLineEntity invoiceLine) {
        this.session = session;
        this.em = em;
        this.invoiceLine = invoiceLine;
    }

    @Override
    public String getID() {
        return this.invoiceLine.getID();
    }

    @Override
    public void setID(String value) {
        this.invoiceLine.setID(value);
    }

    @Override
    public String getUUID() {
        return this.invoiceLine.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.invoiceLine.setUuid(value);
    }

    @Override
    public String getNote() {
        return this.invoiceLine.getNote();
    }

    @Override
    public void setNote(String value) {
        this.invoiceLine.setNote(value);
    }

    @Override
    public QuantityModel getInvoicedQuantity() {
        return new QuantityAdapter(session, em, invoiceLine.getInvoicedQuantity());
    }

    @Override
    public void setInvoicedQuantity(QuantityModel value) {
        this.invoiceLine.setInvoicedQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.invoiceLine.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.invoiceLine.setLineExtensionAmount(value);
    }

    @Override
    public LocalDate getTaxPointDate() {
        return this.invoiceLine.getTaxPointDate();
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        this.invoiceLine.setTaxPointDate(value);
    }

    @Override
    public String getAccountingCostCode() {
        return this.invoiceLine.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        this.invoiceLine.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return this.invoiceLine.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        this.invoiceLine.setAccountingCost(value);
    }

    @Override
    public boolean getFreeOfChargeIndicator() {
        return this.invoiceLine.isFreeOfChargeIndicator();
    }

    @Override
    public void setFreeOfChargeIndicator(boolean value) {
        this.invoiceLine.setFreeOfChargeIndicator(value);
    }

    @Override
    public List<OrderLineReferenceModel> getOrderLineReference() {
        return invoiceLine.getOrderLineReference().stream()
                .map(f -> new OrderLineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference) {
        List<OrderLineReferenceEntity> entities = orderLineReference.stream()
                .map(f -> OrderLineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setOrderLineReference(entities);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return invoiceLine.getDespatchLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceModel> despatchLineReference) {
        List<LineReferenceEntity> entities = despatchLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setDespatchLineReference(entities);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return invoiceLine.getReceiptLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());

    }

    @Override
    public void setReceiptLineReference(List<LineReferenceModel> receiptLineReference) {
        List<LineReferenceEntity> entities = receiptLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setReceiptLineReference(entities);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return invoiceLine.getBillingReference().stream()
                .map(f -> new BillingReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setBillingReference(List<BillingReferenceModel> billingReference) {
        List<BillingReferenceEntity> entities = billingReference.stream()
                .map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setBillingReference(entities);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return invoiceLine.getDocumentReference().stream()
                .map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
        List<DocumentReferenceEntity> entities = documentReference.stream()
                .map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setDocumentReference(entities);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return new PricingReferenceAdapter(session, em, invoiceLine.getPricingReference());
    }

    @Override
    public void setPricingReference(PricingReferenceModel value) {
        this.invoiceLine.setPricingReference(PricingReferenceAdapter.toEntity(value, em));
    }

    @Override
    public PartyModel getOriginatorParty() {
        return new PartyAdapter(session, em, invoiceLine.getOriginatorParty());
    }

    @Override
    public void setOriginatorParty(PartyModel value) {
        this.invoiceLine.setOriginatorParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return invoiceLine.getDelivery().stream().map(f -> new DeliveryAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setDelivery(List<DeliveryModel> delivery) {
        List<DeliveryEntity> entities = delivery.stream().map(f -> DeliveryAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.invoiceLine.setDelivery(entities);
    }

    @Override
    public List<PaymentTermsModel> getPaymentTerms() {
        return invoiceLine.getPaymentTerms().stream().map(f -> new PaymentTermsAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setPaymentTerms(List<PaymentTermsModel> paymentTerms) {
        List<PaymentTermsEntity> entities = paymentTerms.stream()
                .map(f -> PaymentTermsAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setPaymentTerms(entities);
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return invoiceLine.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
        List<AllowanceChargeEntity> entities = allowanceCharge.stream()
                .map(f -> AllowanceChargeAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.invoiceLine.setAllowanceCharge(entities);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return invoiceLine.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setTaxTotal(List<TaxTotalModel> taxTotal) {
        List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.invoiceLine.setTaxTotal(entities);
    }

    @Override
    public ItemModel getItem() {
        return new ItemAdapter(session, em, invoiceLine.getItem());
    }

    @Override
    public void setItem(ItemModel value) {
        this.invoiceLine.setItem(ItemAdapter.toEntity(value, em));
    }

    @Override
    public PriceModel getPrice() {
        return new PriceAdapter(session, em, invoiceLine.getPrice());
    }

    @Override
    public void setPrice(PriceModel value) {
        this.invoiceLine.setPrice(PriceAdapter.toEntity(value, em));
    }

    @Override
    public DeliveryTermsModel getDeliveryTerms() {
        return new DeliveryTermsAdapter(session, em, invoiceLine.getDeliveryTerms());
    }

    @Override
    public void setDeliveryTerms(DeliveryTermsModel value) {
        this.invoiceLine.setDeliveryTerms(DeliveryTermsAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.invoiceLine.getId();
    }

    @Override
    public InvoiceLineEntity getEntity() {
        return invoiceLine;
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> taxTotalEntities = invoiceLine.getTaxTotal();
        TaxTotalEntity taxTotalEntity = new TaxTotalEntity();
        taxTotalEntities.add(taxTotalEntity);
        return new TaxTotalAdapter(session, em, taxTotalEntity);
    }

    @Override
    public AllowanceChargeModel addAllowanceCharge() {
        List<AllowanceChargeEntity> allowanceChargeEntities = invoiceLine.getAllowanceCharge();
        AllowanceChargeEntity allowanceChargeEntity = new AllowanceChargeEntity();
        allowanceChargeEntities.add(allowanceChargeEntity);
        return new AllowanceChargeAdapter(session, em, allowanceChargeEntity);
    }

    public static InvoiceLineEntity toEntity(InvoiceLineModel model, EntityManager em) {
        if (model instanceof InvoiceLineAdapter) {
            return ((InvoiceLineAdapter) model).getEntity();
        }
        return em.getReference(InvoiceLineEntity.class, model.getId());
    }

}
