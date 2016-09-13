package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the condition or position of an object.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:51 a. m.
 */
public class StatusRepresentation {

    /**
     * Provides any textual information related to this status.
     */
    // private textType ;

    /**
     * Specifies the status condition of the related object.
     */
    private CodeRepresentation conditionCode;
    /**
     * Text describing this status.
     */
    private TextRepresentation description;
    /**
     * Specifies an indicator relevant to a specific status.
     */
    private boolean indicationIndicator;
    /**
     * A percentage meaningful in the context of this status.
     */
    private BigDecimal percent;
    /**
     * The reference date for this status.
     */
    private LocalDate referenceDate;
    /**
     * The reference time for this status.
     */
    private LocalTime referenceTime;
    /**
     * The reliability of this status, expressed as a percentage.
     */
    private BigDecimal reliabilityPercent;
    /**
     * A sequence identifier for this status.
     */
    private IdentifierRepresentation sequenceID;
    /**
     * The reason for this status condition or position, expressed as text.
     */
    private TextRepresentation statusReason;
    /**
     * The reason for this status condition or position, expressed as a code.
     */
    private CodeRepresentation statusReasonCode;
    private List<ConditionRepresentation> conditions = new ArrayList<>();

}
