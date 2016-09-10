package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to define a line in a Quotation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class QuotationLineRepresentation {

    /**
     * An identifier for this quotation line.
     */
    private IdentifierType ID;
    /**
     * The total amount for this quotation line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The quantity of the item quoted.
     */
    private QuantityType quantity;
    /**
     * An identifier for the line in the Request for QuotationRepresentation to
     * which this line is a response.
     */
    private IdentifierType requestForQuotationLineID;
    /**
     * The total tax amount for this quotation line.
     */
    private BigDecimal totalTaxAmount;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<LineItemRepresentation> lineItems = new ArrayList<>();
    private List<LineItemRepresentation> sellerProposedSubstituteLineItem = new ArrayList<>();
    private List<LineItemRepresentation> alternativeLineItem = new ArrayList<>();
    private LineReferenceRepresentation requestLineReference;

}
