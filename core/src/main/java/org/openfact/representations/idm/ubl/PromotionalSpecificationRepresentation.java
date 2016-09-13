package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to describe a promotional event as a set of item locations that share
 * a set of promotional tactics.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:11 a. m.
 */
public class PromotionalSpecificationRepresentation {

    /**
     * An identifier for this promotional specification.
     */
    private IdentifierRepresentation specificationID;
    private List<EventTacticRepresentation> eventTactics = new ArrayList<>();
    private List<PromotionalEventRepresentation> lineItemPromotionalEventLineItems = new ArrayList<>();

}
