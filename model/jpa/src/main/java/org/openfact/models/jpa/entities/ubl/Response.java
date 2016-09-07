package org.openfact.models.jpa.entities.ubl;

import org.apache.bcel.classfile.Code;

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
    private Text.Type Description;
    /**
     * The date upon which this response is valid.
     */
    private Date.Type EffectiveDate;
    /**
     * The time at which this response is valid.
     */
    private Time.Type EffectiveTime;
    /**
     * An identifier for the section (or line) of the document to which this
     * response applies.
     */
    private Identifier.Type ReferenceID;
    /**
     * A code signifying the type of response.
     */
    private Code.Type ResponseCode;
    private Status m_Status;

    public Response() {

    }

    public void finalize() throws Throwable {

    }

    public Text.Type getDescription() {
        return Description;
    }

    public Date.Type getEffectiveDate() {
        return EffectiveDate;
    }

    public Time.Type getEffectiveTime() {
        return EffectiveTime;
    }

    public Identifier.Type getReferenceID() {
        return ReferenceID;
    }

    public Code.Type getResponseCode() {
        return ResponseCode;
    }

    public Status getStatus() {
        return m_Status;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(Text.Type newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEffectiveDate(Date.Type newVal) {
        EffectiveDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEffectiveTime(Time.Type newVal) {
        EffectiveTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReferenceID(Identifier.Type newVal) {
        ReferenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setResponseCode(Code.Type newVal) {
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