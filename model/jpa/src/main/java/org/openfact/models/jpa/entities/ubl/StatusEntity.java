package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.percentType;
import org.openfact.models.jpa.entities.ublType.textType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe the condition or position of an object.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:51 a. m.
 */
public class StatusEntity {

    /**
     * Provides any textual information related to this status.
     */
    // private textType ;

    /**
     * Specifies the status condition of the related object.
     */
    private CodeType conditionCode;
    /**
     * Text describing this status.
     */
    private textType description;
    /**
     * Specifies an indicator relevant to a specific status.
     */
    private IndicatorType indicationIndicator;
    /**
     * A percentage meaningful in the context of this status.
     */
    private percentType percent;
    /**
     * The reference date for this status.
     */
    private DateType referenceDate;
    /**
     * The reference time for this status.
     */
    private TimeType referenceTime;
    /**
     * The reliability of this status, expressed as a percentage.
     */
    private percentType Reliabilitypercent;
    /**
     * A sequence identifier for this status.
     */
    private IdentifierType sequenceID;
    /**
     * The reason for this status condition or position, expressed as text.
     */
    private textType statusReason;
    /**
     * The reason for this status condition or position, expressed as a code.
     */
    private CodeType statusReasonCode;
    private List<ConditionEntity> conditions = new ArrayList<>();

}
