package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a specific property of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemPropertyEntity {

    /**
     * An identifier for this property of an item.
     */
    private IdentifierType ID;
    /**
     * A code signifying the importance of this property in using it to describe
     * a related Item.
     */
    private CodeType ImportanceCode;
    /**
     * The value expressed as a text in case the property is a value in a list.
     * For example, a colour.
     */
    private TextType ListValue;
    /**
     * The name of this item property.
     */
    private NameType Name;
    /**
     * The name of this item property, expressed as a code.
     */
    private CodeType NameCode;
    /**
     * The method of testing the value of this item property.
     */
    private TextType TestMethod;
    /**
     * The value of this item property, expressed as text.
     */
    private TextType Value;
    /**
     * Text qualifying the value of the property.
     */
    private TextType ValueQualifier;
    /**
     * The value of this item property, expressed as a quantity.
     */
    private QuantityType ValueQuantity;
    private DimensionEntity RangeDimension;
    private List<ItemPropertyEntity> GroupItemPropertyGroups = new ArrayList<>();
    private List<ItemPropertyEntity> RangeItemPropertyRanges = new ArrayList<>();
    private PeriodEntity UsabilityPeriod;

}
