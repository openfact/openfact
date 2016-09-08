package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a tendered project or project lot.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:21 a. m.
 */
public class TenderedProject {

    /**
     * The fee amount for tendered projects.
     */
    private BigDecimal feeAmount;
    /**
     * Text describing the fee amount for tendered projects.
     */
    private String feeDescription;
    /**
     * An identifier for the tender envelope this tendered project belongs to.
     */
    private String tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope this tendered project
     * belongs to.
     */
    private String tenderEnvelopeTypeCode;
    /**
     * An identifier for this variant of a tendered project.
     */
    private String variantID;
    private List<AwardingCriterionResponse> awardingCriterionResponses = new ArrayList<>();
    private DocumentReference evidenceDocumentReference;
    private MonetaryTotal legalMonetaryTotal;
    private List<ProcurementProjectLot> procurementProjectLots = new ArrayList<>();    
    private List<TaxTotal> taxTotals = new ArrayList<>();
    private List<TenderLine> tenderLines = new ArrayList<>();

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }

    public String getTenderEnvelopeID() {
        return tenderEnvelopeID;
    }

    public void setTenderEnvelopeID(String tenderEnvelopeID) {
        this.tenderEnvelopeID = tenderEnvelopeID;
    }

    public String getTenderEnvelopeTypeCode() {
        return tenderEnvelopeTypeCode;
    }

    public void setTenderEnvelopeTypeCode(String tenderEnvelopeTypeCode) {
        this.tenderEnvelopeTypeCode = tenderEnvelopeTypeCode;
    }

    public String getVariantID() {
        return variantID;
    }

    public void setVariantID(String variantID) {
        this.variantID = variantID;
    }

    public List<AwardingCriterionResponse> getAwardingCriterionResponses() {
        return awardingCriterionResponses;
    }

    public void setAwardingCriterionResponses(List<AwardingCriterionResponse> awardingCriterionResponses) {
        this.awardingCriterionResponses = awardingCriterionResponses;
    }

    public DocumentReference getEvidenceDocumentReference() {
        return evidenceDocumentReference;
    }

    public void setEvidenceDocumentReference(DocumentReference evidenceDocumentReference) {
        this.evidenceDocumentReference = evidenceDocumentReference;
    }

    public MonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<ProcurementProjectLot> getProcurementProjectLots() {
        return procurementProjectLots;
    }

    public void setProcurementProjectLots(List<ProcurementProjectLot> procurementProjectLots) {
        this.procurementProjectLots = procurementProjectLots;
    }

    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

    public List<TenderLine> getTenderLines() {
        return tenderLines;
    }

    public void setTenderLines(List<TenderLine> tenderLines) {
        this.tenderLines = tenderLines;
    }
}// end TenderedProject