package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the consumption of a utility product.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:56 a. m.
 */
public class UtilityItemRepresentation {

    /**
     * The type of product consumed, expressed as text.
     */
    private TextRepresentation consumptionType;
    /**
     * The type of product consumed, expressed as a code.
     */
    private CodeRepresentation consumptionTypeCode;
    /**
     * Information of the actual payments type for the utility Item
     */
    private TextRepresentation currentChargeType;
    /**
     * Information of the actual payments type code expressed as a code
     */
    private CodeRepresentation currentChargeTypeCode;
    /**
     * Text describing the consumption product.
     */
    private TextRepresentation description;
    /**
     * An identifier for this utility item.
     */
    private IdentifierRepresentation ID;
    /**
     * Information about the one-time payment type in case everything is paid
     * One time
     */
    private TextRepresentation oneTimeChargeType;
    /**
     * Information about the one-time payment type code
     */
    private CodeRepresentation oneTimeChargeTypeCode;
    /**
     * The unit packaging quantity.
     */
    private QuantityRepresentation packQuantity;
    /**
     * The number of items in a pack.
     */
    private BigDecimal packSizeNumeric;
    /**
     * An identifier for the subscriber to the utility.
     */
    private IdentifierRepresentation subscriberID;
    /**
     * Identification of the subscriber type, expressed as text..
     */
    private TextRepresentation subscriberType;
    /**
     * The code identifying for the service type.
     */
    private CodeRepresentation subscriberTypeCode;
    private List<ContractRepresentation> contracts = new ArrayList<>();
    private List<TaxCategoryRepresentation> taxCategories = new ArrayList<>();

}
