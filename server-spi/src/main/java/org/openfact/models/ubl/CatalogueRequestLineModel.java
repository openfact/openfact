package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line describing a request for a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLineModel {

    /**
     * A subdivision of a contract or tender covering the line being requested.
     */
    private TextType contractSubdivision;
    /**
     * An identifier for the requested catalogue line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    private List<ItemModel> items = new ArrayList<>();
    private ItemLocationQuantityModel requiredItemLocationQuantity;
    private PeriodModel lineValidityPeriod;

}
