package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:32 a. m.
 */
public class Response {

    /**
     * Text describing this response.
     */
    private String Description;
    /**
     * The date upon which this response is valid.
     */
    private LocalDate EffectiveDate;
    /**
     * The time at which this response is valid.
     */
    private LocalTime EffectiveTime;
    /**
     * An identifier for the section (or line) of the document to which this
     * response applies.
     */
    private String ReferenceID;
    /**
     * A code signifying the type of response.
     */
    private String ResponseCode;
    private List<Status> status = new ArrayList<>();

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the effectiveDate
     */
    public LocalDate getEffectiveDate() {
        return EffectiveDate;
    }

    /**
     * @param effectiveDate
     *            the effectiveDate to set
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    /**
     * @return the effectiveTime
     */
    public LocalTime getEffectiveTime() {
        return EffectiveTime;
    }

    /**
     * @param effectiveTime
     *            the effectiveTime to set
     */
    public void setEffectiveTime(LocalTime effectiveTime) {
        EffectiveTime = effectiveTime;
    }

    /**
     * @return the referenceID
     */
    public String getReferenceID() {
        return ReferenceID;
    }

    /**
     * @param referenceID
     *            the referenceID to set
     */
    public void setReferenceID(String referenceID) {
        ReferenceID = referenceID;
    }

    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return ResponseCode;
    }

    /**
     * @param responseCode
     *            the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    /**
     * @return the status
     */
    public List<Status> getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(List<Status> status) {
        this.status = status;
    }

}// end Response