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
    private BigDecimal FeeAmount;
    /**
     * Text describing the fee amount for tendered projects.
     */
    private String FeeDescription;
    /**
     * An identifier for the tender envelope this tendered project belongs to.
     */
    private String TenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope this tendered project
     * belongs to.
     */
    private String TenderEnvelopeTypeCode;
    /**
     * An identifier for this variant of a tendered project.
     */
    private String VariantID;
    private List<AwardingCriterionResponse> awardingCriterionResponses = new ArrayList<>();
    private DocumentReference EvidenceDocumentReference;
    private MonetaryTotal LegalMonetaryTotal;
    private List<ProcurementProjectLot> procurementProjectLots = new ArrayList<>();    
    private List<TaxTotal> taxTotals = new ArrayList<>();
    private List<TenderLine> tenderLines = new ArrayList<>();
    /**
     * @return the feeAmount
     */
    public BigDecimal getFeeAmount() {
        return FeeAmount;
    }
    /**
     * @param feeAmount the feeAmount to set
     */
    public void setFeeAmount(BigDecimal feeAmount) {
        FeeAmount = feeAmount;
    }
    /**
     * @return the feeDescription
     */
    public String getFeeDescription() {
        return FeeDescription;
    }
    /**
     * @param feeDescription the feeDescription to set
     */
    public void setFeeDescription(String feeDescription) {
        FeeDescription = feeDescription;
    }
    /**
     * @return the tenderEnvelopeID
     */
    public String getTenderEnvelopeID() {
        return TenderEnvelopeID;
    }
    /**
     * @param tenderEnvelopeID the tenderEnvelopeID to set
     */
    public void setTenderEnvelopeID(String tenderEnvelopeID) {
        TenderEnvelopeID = tenderEnvelopeID;
    }
    /**
     * @return the tenderEnvelopeTypeCode
     */
    public String getTenderEnvelopeTypeCode() {
        return TenderEnvelopeTypeCode;
    }
    /**
     * @param tenderEnvelopeTypeCode the tenderEnvelopeTypeCode to set
     */
    public void setTenderEnvelopeTypeCode(String tenderEnvelopeTypeCode) {
        TenderEnvelopeTypeCode = tenderEnvelopeTypeCode;
    }
    /**
     * @return the variantID
     */
    public String getVariantID() {
        return VariantID;
    }
    /**
     * @param variantID the variantID to set
     */
    public void setVariantID(String variantID) {
        VariantID = variantID;
    }
    /**
     * @return the awardingCriterionResponses
     */
    public List<AwardingCriterionResponse> getAwardingCriterionResponses() {
        return awardingCriterionResponses;
    }
    /**
     * @param awardingCriterionResponses the awardingCriterionResponses to set
     */
    public void setAwardingCriterionResponses(List<AwardingCriterionResponse> awardingCriterionResponses) {
        this.awardingCriterionResponses = awardingCriterionResponses;
    }
    /**
     * @return the evidenceDocumentReference
     */
    public DocumentReference getEvidenceDocumentReference() {
        return EvidenceDocumentReference;
    }
    /**
     * @param evidenceDocumentReference the evidenceDocumentReference to set
     */
    public void setEvidenceDocumentReference(DocumentReference evidenceDocumentReference) {
        EvidenceDocumentReference = evidenceDocumentReference;
    }
    /**
     * @return the legalMonetaryTotal
     */
    public MonetaryTotal getLegalMonetaryTotal() {
        return LegalMonetaryTotal;
    }
    /**
     * @param legalMonetaryTotal the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
        LegalMonetaryTotal = legalMonetaryTotal;
    }
    /**
     * @return the procurementProjectLots
     */
    public List<ProcurementProjectLot> getProcurementProjectLots() {
        return procurementProjectLots;
    }
    /**
     * @param procurementProjectLots the procurementProjectLots to set
     */
    public void setProcurementProjectLots(List<ProcurementProjectLot> procurementProjectLots) {
        this.procurementProjectLots = procurementProjectLots;
    }
    /**
     * @return the taxTotals
     */
    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }
    /**
     * @param taxTotals the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }
    /**
     * @return the tenderLines
     */
    public List<TenderLine> getTenderLines() {
        return tenderLines;
    }
    /**
     * @param tenderLines the tenderLines to set
     */
    public void setTenderLines(List<TenderLine> tenderLines) {
        this.tenderLines = tenderLines;
    }


}// end TenderedProject