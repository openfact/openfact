package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a notification requirement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:13 a. m.
 */
public class NotificationRequirement {

    /**
     * A code signifying the type of notification (e.g., pickup status).
     */
    private String notificationTypeCode;
    /**
     * The length of time between the occurrence of a given event and the
     * issuance of a notification.
     */
    private BigDecimal postEventNotificationDurationMeasure;
    /**
     * The length of time to elapse between the issuance of a notification and
     * the occurrence of the event it relates to.
     */
    private BigDecimal preEventNotificationDurationMeasure;
    private Location notificationLocation;
    private Period notificationPeriod;
    private Party notifyParty;

    public NotificationRequirement() {

    }

    public void finalize() throws Throwable {

    }

    public String getNotificationTypeCode() {
        return notificationTypeCode;
    }

    public void setNotificationTypeCode(String notificationTypeCode) {
        this.notificationTypeCode = notificationTypeCode;
    }

    public BigDecimal getPostEventNotificationDurationMeasure() {
        return postEventNotificationDurationMeasure;
    }

    public void setPostEventNotificationDurationMeasure(BigDecimal postEventNotificationDurationMeasure) {
        this.postEventNotificationDurationMeasure = postEventNotificationDurationMeasure;
    }

    public BigDecimal getPreEventNotificationDurationMeasure() {
        return preEventNotificationDurationMeasure;
    }

    public void setPreEventNotificationDurationMeasure(BigDecimal preEventNotificationDurationMeasure) {
        this.preEventNotificationDurationMeasure = preEventNotificationDurationMeasure;
    }

    public Location getNotificationLocation() {
        return notificationLocation;
    }

    public void setNotificationLocation(Location notificationLocation) {
        this.notificationLocation = notificationLocation;
    }

    public Period getNotificationPeriod() {
        return notificationPeriod;
    }

    public void setNotificationPeriod(Period notificationPeriod) {
        this.notificationPeriod = notificationPeriod;
    }

    public Party getNotifyParty() {
        return notifyParty;
    }

    public void setNotifyParty(Party notifyParty) {
        this.notifyParty = notifyParty;
    }
}// end NotificationRequirement