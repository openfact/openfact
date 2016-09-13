package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe directions for preparing a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparationRepresentation {

    /**
     * Text describing the tender envelope.
     */
    private TextRepresentation description;
    /**
     * An identifier for the open tender associated with this tender
     * preparation.
     */
    private IdentifierRepresentation openTenderID;
    /**
     * An identifier for the tender envelope to be used with the tender.
     */
    private IdentifierRepresentation tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope (economical or objective
     * criteria versus technical or subjective criteria).
     */
    private CodeRepresentation tenderEnvelopeTypeCode;
    private List<ProcurementProjectLotRepresentation> procurementProjectLots = new ArrayList<>();
    private TenderRequirementRepresentation documentTenderRequirement;

}
