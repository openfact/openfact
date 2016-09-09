package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;

/**
 * Agree can be renamed as PromotionalEvents
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:08 a. m.
 */
public class PromotionalEventEntity {

    /**
     * The first day that products will be available to ship from buyer to
     * seller if the proposal for this promotional event is accepted.
     */
    private DateType firstShipmentAvailibilityDate;
    /**
     * The deadline for acceptance of this promotional event.
     */
    private DateType latestProposalAcceptanceDate;
    /**
     * A code signifying the type of this promotional event. Examples can be:
     * Holiday, Seasonal Event, Store Closing, Trade ItemEntity Introduction
     */
    private CodeType promotionalEventTypeCode;
    /**
     * The date on which a proposal for this promotional event was submitted.
     */
    private DateType submissionDate;
    private List<PromotionalSpecificationEntity> promotionalSpecifications = new ArrayList<>();

}
