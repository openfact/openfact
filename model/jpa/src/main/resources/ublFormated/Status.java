package org.openfact.models.jpa.entities.ubl;

import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe the condition or position of an object.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:51 a. m.
 */
public class Status {

    /**
     * Provides any textual information related to this status.
     */
    // private TextType ;

    /**
     * Specifies the status condition of the related object.
     */
    private CodeType ConditionCode;
    /**
     * Text describing this status.
     */
    private TextType Description;
    /**
     * Specifies an indicator relevant to a specific status.
     */
    private IndicatorType IndicationIndicator;
    /**
     * A percentage meaningful in the context of this status.
     */
    private PercentType Percent;
    /**
     * The reference date for this status.
     */
    private DateType ReferenceDate;
    /**
     * The reference time for this status.
     */
    private TimeType ReferenceTime;
    /**
     * The reliability of this status, expressed as a percentage.
     */
    private PercentType ReliabilityPercent;
    /**
     * A sequence identifier for this status.
     */
    private IdentifierType SequenceID;
    /**
     * The reason for this status condition or position, expressed as text.
     */
    private TextType StatusReason;
    /**
     * The reason for this status condition or position, expressed as a code.
     */
    private CodeType StatusReasonCode;
    private List<Condition> Conditions = new ArrayList<>();

}
