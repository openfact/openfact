package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the consumption of a utility product.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:56 a. m.
 */
public class UtilityItemModel {

    /**
     * The type of product consumed, expressed as text.
     */
    private TextModel consumptionType;
    /**
     * The type of product consumed, expressed as a code.
     */
    private CodeModel consumptionTypeCode;
    /**
     * Information of the actual payments type for the utility Item
     */
    private TextModel currentChargeType;
    /**
     * Information of the actual payments type code expressed as a code
     */
    private CodeModel currentChargeTypeCode;
    /**
     * Text describing the consumption product.
     */
    private TextModel description;
    /**
     * An identifier for this utility item.
     */
    private IdentifierModel ID;
    /**
     * Information about the one-time payment type in case everything is paid
     * One time
     */
    private TextModel oneTimeChargeType;
    /**
     * Information about the one-time payment type code
     */
    private CodeModel oneTimeChargeTypeCode;
    /**
     * The unit packaging quantity.
     */
    private QuantityModel packQuantity;
    /**
     * The number of items in a pack.
     */
    private BigDecimal packSizeNumeric;
    /**
     * An identifier for the subscriber to the utility.
     */
    private IdentifierModel subscriberID;
    /**
     * Identification of the subscriber type, expressed as text..
     */
    private TextModel subscriberType;
    /**
     * The code identifying for the service type.
     */
    private CodeModel subscriberTypeCode;
    private List<ContractModel> contracts = new ArrayList<>();
    private List<TaxCategoryModel> taxCategories = new ArrayList<>();

}
