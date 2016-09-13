package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a promotional event as a set of item locations that share
 * a set of promotional tactics.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:11 a. m.
 */
public class PromotionalSpecificationModel {

    /**
     * An identifier for this promotional specification.
     */
    private IdentifierModel specificationID;
    private List<EventTacticModel> eventTactics = new ArrayList<>();
    private List<PromotionalEventModel> lineItemPromotionalEventLineItems = new ArrayList<>();

}
