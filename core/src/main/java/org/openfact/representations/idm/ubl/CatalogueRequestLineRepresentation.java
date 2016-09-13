package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line describing a request for a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLineRepresentation {

    /**
     * A subdivision of a contract or tender covering the line being requested.
     */
    private TextRepresentation contractSubdivision;
    /**
     * An identifier for the requested catalogue line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    private List<ItemRepresentation> items = new ArrayList<>();
    private ItemLocationQuantityRepresentation requiredItemLocationQuantity;
    private PeriodRepresentation lineValidityPeriod;

}
