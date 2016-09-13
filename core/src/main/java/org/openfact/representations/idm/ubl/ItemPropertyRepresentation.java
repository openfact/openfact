package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private IdentifierRepresentation ID;
    /**
     * A code signifying the importance of this property in using it to describe
     * a related Item.
     */
    private CodeRepresentation importanceCode;
    /**
     * The value expressed as a text in case the property is a value in a list.
     * For example, a colour.
     */
    private TextRepresentation listValue;
    /**
     * The name of this item property.
     */
    private NameRepresentation name;
    /**
     * The name of this item property, expressed as a code.
     */
    private CodeRepresentation nameCode;
    /**
     * The method of testing the value of this item property.
     */
    private TextRepresentation testMethod;
    /**
     * The value of this item property, expressed as text.
     */
    private TextRepresentation value;
    /**
     * Text qualifying the value of the property.
     */
    private TextRepresentation valueQualifier;
    /**
     * The value of this item property, expressed as a quantity.
     */
    private QuantityRepresentation valueQuantity;
    private DimensionRepresentation rangeDimension;
    private List<ItemPropertyRepresentation> groupItemPropertyGroups = new ArrayList<>();
    private List<ItemPropertyRepresentation> rangeItemPropertyRanges = new ArrayList<>();
    private PeriodRepresentation usabilityPeriod;

}
