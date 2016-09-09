package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a StockAvailabilityReportEntity describing the
 * availability of an item of sale.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:52 a. m.
 */
public class StockAvailabilityReportLineEntity {

    /**
     * The date from which the item will be available. A date identical to or
     * earlier than the IssueDate of the StockAvailabilityReportEntity means
     * that the item is available now
     */
    private DateType AvailabilityDate;
    /**
     * A code signifying the level of availability of the item.
     */
    private CodeType AvailabilityStatusCode;
    /**
     * An identifier for this stock availability line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Note;
    /**
     * The quantity of the item currently in stock.
     */
    private QuantityType Quantity;
    /**
     * The monetary value of the quantity of the item currently in stock.
     */
    private AmountType ValueAmount;
    private List<ItemEntity> Items = new ArrayList<>();

}
