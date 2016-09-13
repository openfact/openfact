package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe directions for preparing a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparationModel {

    /**
     * Text describing the tender envelope.
     */
    private TextModel description;
    /**
     * An identifier for the open tender associated with this tender
     * preparation.
     */
    private IdentifierModel openTenderID;
    /**
     * An identifier for the tender envelope to be used with the tender.
     */
    private IdentifierModel tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope (economical or objective
     * criteria versus technical or subjective criteria).
     */
    private CodeModel tenderEnvelopeTypeCode;
    private List<ProcurementProjectLotModel> procurementProjectLots = new ArrayList<>();
    private TenderRequirementModel documentTenderRequirement;

}
