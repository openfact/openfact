package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a tendered project or project lot.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:21 a. m.
 */
public class TenderedProjectRepresentation {

    /**
     * The fee amount for tendered projects.
     */
    private BigDecimal feeAmount;
    /**
     * Text describing the fee amount for tendered projects.
     */
    private TextRepresentation feeDescription;
    /**
     * An identifier for the tender envelope this tendered project belongs to.
     */
    private IdentifierRepresentation tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope this tendered project
     * belongs to.
     */
    private CodeRepresentation tenderEnvelopeTypeCode;
    /**
     * An identifier for this variant of a tendered project.
     */
    private IdentifierRepresentation variantID;
    private List<AwardingCriterionResponseRepresentation> awardingCriterionResponses = new ArrayList<>();
    private DocumentReferenceRepresentation evidenceDocumentReference;
    private MonetaryTotalRepresentation legalMonetaryTotal;
    private List<ProcurementProjectLotRepresentation> procurementProjectLots = new ArrayList<>();
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();
    private List<TenderLineRepresentation> tenderLines = new ArrayList<>();

}
