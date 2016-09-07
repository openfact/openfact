package org.openfact.models.jpa.entities.ubl;

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
    private Status m_Status;

    public Response() {

    }

    public void finalize() throws Throwable {

    }

    public String getDescription() {
        return Description;
    }

    public LocalDate getEffectiveDate() {
        return EffectiveDate;
    }

    public LocalTime getEffectiveTime() {
        return EffectiveTime;
    }

    public String getReferenceID() {
        return ReferenceID;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public Status getStatus() {
        return m_Status;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEffectiveDate(LocalDate newVal) {
        EffectiveDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEffectiveTime(LocalTime newVal) {
        EffectiveTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReferenceID(String newVal) {
        ReferenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setResponseCode(String newVal) {
        ResponseCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStatus(Status newVal) {
        m_Status = newVal;
    }
}// end Response