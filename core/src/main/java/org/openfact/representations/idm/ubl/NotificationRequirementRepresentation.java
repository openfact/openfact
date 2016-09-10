package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.MeasureType;

/**
 * A class to describe a notification requirement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:13 a. m.
 */
public class NotificationRequirementRepresentation {

    /**
     * A code signifying the type of notification (e.g., pickup status).
     */
    private CodeType notificationTypeCode;
    /**
     * The length of time between the occurrence of a given event and the
     * issuance of a notification.
     */
    private MeasureType postEventNotificationDurationMeasure;
    /**
     * The length of time to elapse between the issuance of a notification and
     * the occurrence of the event it relates to.
     */
    private MeasureType preEventNotificationDurationMeasure;
    private LocationRepresentation notificationLocation;
    private PeriodRepresentation notificationPeriod;
    private PartyRepresentation notifyParty;

}
