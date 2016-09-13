package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a Request for Quotation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLineModel {

    /**
     * An identifier for this line in the request for quotation.
     */
    private IdentifierModel ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * An indication whether this line is optional (true) or not (false) for
     * purposes of this request for quotation.
     */
    private boolean optionalLineItemIndicator;
    /**
     * A code signifying the level of confidentiality of this request for
     * quotation line.
     */
    private CodeModel privacyCode;
    /**
     * A code signifying the security classification of this request for
     * quotation line.
     */
    private CodeModel securityClassificationCode;
    /**
     * A universally unique identifier for this line in the request for
     * quotation.
     */
    private IdentifierModel UUID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<LineItemModel> lineItems = new ArrayList<>();

}
