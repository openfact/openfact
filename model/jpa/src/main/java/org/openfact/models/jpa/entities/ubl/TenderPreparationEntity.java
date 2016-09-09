package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe directions for preparing a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparationEntity {

    /**
     * Text describing the tender envelope.
     */
    private TextType Description;
    /**
     * An identifier for the open tender associated with this tender
     * preparation.
     */
    private IdentifierType OpenTenderID;
    /**
     * An identifier for the tender envelope to be used with the tender.
     */
    private IdentifierType TenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope (economical or objective
     * criteria versus technical or subjective criteria).
     */
    private CodeType TenderEnvelopeTypeCode;
    private List<ProcurementProjectLotEntity> ProcurementProjectLots = new ArrayList<>();
    private TenderRequirementEntity DocumentTenderRequirement;

}
