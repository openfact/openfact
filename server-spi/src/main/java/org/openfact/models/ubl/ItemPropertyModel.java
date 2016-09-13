package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a specific property of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemPropertyModel {

    /**
     * An identifier for this property of an item.
     */
    private IdentifierModel ID;
    /**
     * A code signifying the importance of this property in using it to describe
     * a related Item.
     */
    private CodeModel importanceCode;
    /**
     * The value expressed as a text in case the property is a value in a list.
     * For example, a colour.
     */
    private TextModel listValue;
    /**
     * The name of this item property.
     */
    private NameModel name;
    /**
     * The name of this item property, expressed as a code.
     */
    private CodeModel nameCode;
    /**
     * The method of testing the value of this item property.
     */
    private TextModel testMethod;
    /**
     * The value of this item property, expressed as text.
     */
    private TextModel value;
    /**
     * Text qualifying the value of the property.
     */
    private TextModel valueQualifier;
    /**
     * The value of this item property, expressed as a quantity.
     */
    private QuantityModel valueQuantity;
    private DimensionModel rangeDimension;
    private List<ItemPropertyModel> groupItemPropertyGroups = new ArrayList<>();
    private List<ItemPropertyModel> rangeItemPropertyRanges = new ArrayList<>();
    private PeriodModel usabilityPeriod;

}
