package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to define a line in an InventoryReport.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:35 a. m.
 */
public class InventoryReportLineRepresentation {

    /**
     * The date from which the goods will be available. If not present, the
     * goods are available now.
     */
    private LocalDate availabilityDate;
    /**
     * A code signifying the item's level of availability.
     */
    private CodeType availabilityStatusCode;
    /**
     * An identifier for this inventory report line.
     */
    private IdentifierType ID;
    /**
     * The value of the quantity of the item reported that is currently in
     * stock.
     */
    private BigDecimal inventoryValueAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The quantity of the item reported that is currently in stock.
     */
    private QuantityType quantity;
    private List<ItemRepresentation> items = new ArrayList<>();
    private LocationRepresentation inventoryLocation;

}
