package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a tendered project or project lot.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:21 a. m.
 */
public class TenderedProjectModel {

    /**
     * The fee amount for tendered projects.
     */
    private BigDecimal feeAmount;
    /**
     * Text describing the fee amount for tendered projects.
     */
    private TextModel feeDescription;
    /**
     * An identifier for the tender envelope this tendered project belongs to.
     */
    private IdentifierModel tenderEnvelopeID;
    /**
     * A code signifying the type of tender envelope this tendered project
     * belongs to.
     */
    private CodeModel tenderEnvelopeTypeCode;
    /**
     * An identifier for this variant of a tendered project.
     */
    private IdentifierModel variantID;
    private List<AwardingCriterionResponseModel> awardingCriterionResponses = new ArrayList<>();
    private DocumentReferenceModel evidenceDocumentReference;
    private MonetaryTotalModel legalMonetaryTotal;
    private List<ProcurementProjectLotModel> procurementProjectLots = new ArrayList<>();
    private List<TaxTotalModel> taxTotals = new ArrayList<>();
    private List<TenderLineModel> tenderLines = new ArrayList<>();

}
