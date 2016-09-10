package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a specific property of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemPropertyRepresentation {

    /**
     * An identifier for this property of an item.
     */
    private IdentifierType ID;
    /**
     * A code signifying the importance of this property in using it to describe
     * a related Item.
     */
    private CodeType importanceCode;
    /**
     * The value expressed as a text in case the property is a value in a list.
     * For example, a colour.
     */
    private TextType listValue;
    /**
     * The name of this item property.
     */
    private NameType name;
    /**
     * The name of this item property, expressed as a code.
     */
    private CodeType nameCode;
    /**
     * The method of testing the value of this item property.
     */
    private TextType testMethod;
    /**
     * The value of this item property, expressed as text.
     */
    private TextType value;
    /**
     * Text qualifying the value of the property.
     */
    private TextType valueQualifier;
    /**
     * The value of this item property, expressed as a quantity.
     */
    private QuantityType valueQuantity;
    private DimensionRepresentation rangeDimension;
    private List<ItemPropertyRepresentation> groupItemPropertyGroups = new ArrayList<>();
    private List<ItemPropertyRepresentation> rangeItemPropertyRanges = new ArrayList<>();
    private PeriodRepresentation usabilityPeriod;

}
