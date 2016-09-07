package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe directions for preparing a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparation {

    /**
     * Text describing the tender envelope.
     */
    private String Description;
    /**
     * An identifier for the open tender associated with this tender
     * preparation.
     */
    private String OpenTenderID;
    /**
     * An identifier for the tender envelope to be used with the tender.
     */
    private String TenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope (economical or objective
     * criteria versus technical or subjective criteria).
     */
    private String TenderEnvelopeTypeCode;
    private ProcurementProjectLot m_ProcurementProjectLot;
    private Tender RequirementDocumentTenderRequirement;

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the openTenderID
     */
    public String getOpenTenderID() {
        return OpenTenderID;
    }

    /**
     * @param openTenderID
     *            the openTenderID to set
     */
    public void setOpenTenderID(String openTenderID) {
        OpenTenderID = openTenderID;
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
     * @return the requirementDocumentTenderRequirement
     */
    public Tender getRequirementDocumentTenderRequirement() {
        return RequirementDocumentTenderRequirement;
    }

    /**
     * @param requirementDocumentTenderRequirement
     *            the requirementDocumentTenderRequirement to set
     */
    public void setRequirementDocumentTenderRequirement(Tender requirementDocumentTenderRequirement) {
        RequirementDocumentTenderRequirement = requirementDocumentTenderRequirement;
    }

}// end TenderPreparation