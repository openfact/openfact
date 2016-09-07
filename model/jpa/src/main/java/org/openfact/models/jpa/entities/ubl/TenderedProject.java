package org.openfact.models.jpa.entities.ubl;

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
    private AwardingCriterionResponse m_AwardingCriterionResponse;
    private DocumentReference EvidenceDocumentReference;
    private MonetaryTotal LegalMonetaryTotal;
    private ProcurementProjectLot m_ProcurementProjectLot;
    private TaxTotal m_TaxTotal;
    private TenderLine m_TenderLine;

    /**
     * @return the feeAmount
     */
    public BigDecimal getFeeAmount() {
        return FeeAmount;
    }

    /**
     * @param feeAmount
     *            the feeAmount to set
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
     * @param feeDescription
     *            the feeDescription to set
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
     * @param tenderEnvelopeID
     *            the tenderEnvelopeID to set
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
     * @param tenderEnvelopeTypeCode
     *            the tenderEnvelopeTypeCode to set
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
     * @param variantID
     *            the variantID to set
     */
    public void setVariantID(String variantID) {
        VariantID = variantID;
    }

    /**
     * @return the m_AwardingCriterionResponse
     */
    public AwardingCriterionResponse getM_AwardingCriterionResponse() {
        return m_AwardingCriterionResponse;
    }

    /**
     * @param m_AwardingCriterionResponse
     *            the m_AwardingCriterionResponse to set
     */
    public void setM_AwardingCriterionResponse(AwardingCriterionResponse m_AwardingCriterionResponse) {
        this.m_AwardingCriterionResponse = m_AwardingCriterionResponse;
    }

    /**
     * @return the evidenceDocumentReference
     */
    public DocumentReference getEvidenceDocumentReference() {
        return EvidenceDocumentReference;
    }

    /**
     * @param evidenceDocumentReference
     *            the evidenceDocumentReference to set
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
     * @param legalMonetaryTotal
     *            the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
        LegalMonetaryTotal = legalMonetaryTotal;
    }

    /**
     * @return the m_ProcurementProjectLot
     */
    public ProcurementProjectLot getM_ProcurementProjectLot() {
        return m_ProcurementProjectLot;
    }

    /**
     * @param m_ProcurementProjectLot
     *            the m_ProcurementProjectLot to set
     */
    public void setM_ProcurementProjectLot(ProcurementProjectLot m_ProcurementProjectLot) {
        this.m_ProcurementProjectLot = m_ProcurementProjectLot;
    }

    /**
     * @return the m_TaxTotal
     */
    public TaxTotal getM_TaxTotal() {
        return m_TaxTotal;
    }

    /**
     * @param m_TaxTotal
     *            the m_TaxTotal to set
     */
    public void setM_TaxTotal(TaxTotal m_TaxTotal) {
        this.m_TaxTotal = m_TaxTotal;
    }

    /**
     * @return the m_TenderLine
     */
    public TenderLine getM_TenderLine() {
        return m_TenderLine;
    }

    /**
     * @param m_TenderLine
     *            the m_TenderLine to set
     */
    public void setM_TenderLine(TenderLine m_TenderLine) {
        this.m_TenderLine = m_TenderLine;
    }

}// end TenderedProject