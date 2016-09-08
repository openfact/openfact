package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private String description;
    /**
     * An identifier for the open tender associated with this tender
     * preparation.
     */
    private String openTenderID;
    /**
     * An identifier for the tender envelope to be used with the tender.
     */
    private String tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope (economical or objective
     * criteria versus technical or subjective criteria).
     */
    private String tenderEnvelopeTypeCode;
    private List<ProcurementProjectLot> procurementProjectLots = new ArrayList<>();
    private Tender requirementDocumentTenderRequirement;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenTenderID() {
        return openTenderID;
    }

    public void setOpenTenderID(String openTenderID) {
        this.openTenderID = openTenderID;
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

    public List<ProcurementProjectLot> getProcurementProjectLots() {
        return procurementProjectLots;
    }

    public void setProcurementProjectLots(List<ProcurementProjectLot> procurementProjectLots) {
        this.procurementProjectLots = procurementProjectLots;
    }

    public Tender getRequirementDocumentTenderRequirement() {
        return requirementDocumentTenderRequirement;
    }

    public void setRequirementDocumentTenderRequirement(Tender requirementDocumentTenderRequirement) {
        this.requirementDocumentTenderRequirement = requirementDocumentTenderRequirement;
    }
}// end TenderPreparation