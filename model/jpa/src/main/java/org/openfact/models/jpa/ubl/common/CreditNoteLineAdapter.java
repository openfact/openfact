package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.CreditNoteLineEntity;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class CreditNoteLineAdapter implements CreditNoteLineModel, JpaModel<CreditNoteLineEntity> {

    protected static final Logger logger = Logger.getLogger(CreditNoteLineAdapter.class);
    protected CreditNoteLineEntity creditNoteLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditNoteLineAdapter(OpenfactSession session, EntityManager em,
            CreditNoteLineEntity creditNoteLine) {
        this.session = session;
        this.em = em;
        this.creditNoteLine = creditNoteLine;
    }

    @Override
    public String getID() {
        return this.creditNoteLine.getID();
    }

    @Override
    public void setID(String value) {
        this.creditNoteLine.setID(value);
    }

    @Override
    public String getUUID() {
        return this.creditNoteLine.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.creditNoteLine.setUUID(value);
    }

    @Override
    public String getNote() {
        return this.creditNoteLine.getNote();
    }

    @Override
    public void setNote(String value) {
        this.creditNoteLine.setNote(value);
    }

    @Override
    public QuantityModel getCreditedQuantity() {
        return this.creditNoteLine.getCreditedQuantity();
    }

    @Override
    public void setCreditedQuantity(QuantityAdapter value) {
        this.creditNoteLine.setCreditedQuantity(value);
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.creditNoteLine.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.creditNoteLine.setLineExtensionAmount(value);
    }

    @Override
    public LocalDate getTaxPointDate() {
        return this.creditNoteLine.getTaxPointDate();
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        this.creditNoteLine.setTaxPointDate(value);
    }

    @Override
    public String getAccountingCostCode() {
        return this.creditNoteLine.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        this.creditNoteLine.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return this.creditNoteLine.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        this.creditNoteLine.setAccountingCost(value);
    }

    @Override
    public List<ResponseModel> getDiscrepancyResponse() {
        return this.creditNoteLine.getDiscrepancyResponse();
    }

    @Override
    public void setDiscrepancyResponse(List<ResponseAdapter> discrepancyResponse) {
        this.creditNoteLine.setDiscrepancyResponse(discrepancyResponse);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return this.creditNoteLine.getDespatchLineReference();
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.creditNoteLine.setDespatchLineReference(despatchLineReference);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return this.creditNoteLine.getReceiptLineReference();
    }

    @Override
    public void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.creditNoteLine.setReceiptLineReference(receiptLineReference);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return this.creditNoteLine.getBillingReference();
    }

    @Override
    public void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.creditNoteLine.setBillingReference(billingReference);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.creditNoteLine.getDocumentReference();
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.creditNoteLine.setDocumentReference(documentReference);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return this.creditNoteLine.getPricingReference();
    }

    @Override
    public void setPricingReference(PricingReferenceAdapter value) {
        this.creditNoteLine.setPricingReference(value);
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return this.creditNoteLine.getDelivery();
    }

    @Override
    public void setDelivery(List<DeliveryAdapter> delivery) {
        this.creditNoteLine.setDelivery(delivery);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return this.creditNoteLine.getTaxTotal();
    }

    @Override
    public void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.creditNoteLine.setTaxTotal(taxTotal);
    }

    @Override
    public ItemModel getItem() {
        return this.creditNoteLine.getItem();
    }

    @Override
    public void setItem(ItemAdapter value) {
        this.creditNoteLine.setItem(value);
    }

    @Override
    public PriceModel getPrice() {
        return this.creditNoteLine.getPrice();
    }

    @Override
    public void setPrice(PriceAdapter value) {
        this.creditNoteLine.setPrice(value);
    }

    @Override
    public String getId() {
        return this.creditNoteLine.getId();
    }

    @Override
    public void setId(String value) {
        this.creditNoteLine.setId(value);
    }

    /*
     * **/
    TaxTotalAdapter addTaxTotal();

}
