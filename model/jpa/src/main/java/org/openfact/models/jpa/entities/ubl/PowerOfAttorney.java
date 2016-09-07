package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a power of attorney.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorney {

    /**
     * Text describing this power of attorney.
     */
    private String Description;
    /**
     * An identifier for this power of attorney.
     */
    private String ID;
    /**
     * The date on which this power of attorney was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time at which this power of attorney was issued.
     */
    private LocalTime IssueTime;
    private DocumentReference MandateDocumentReference;
    private Party AgentParty;
    private Party NotaryParty;
    private Party WitnessParty;

    public PowerOfAttorney() {

    }

    public void finalize() throws Throwable {

    }

    public Party getAgentParty() {
        return AgentParty;
    }

    public String getDescription() {
        return Description;
    }

    public String getID() {
        return ID;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public LocalTime getIssueTime() {
        return IssueTime;
    }

    public DocumentReference getMandateDocumentReference() {
        return MandateDocumentReference;
    }

    public Party getNotaryParty() {
        return NotaryParty;
    }

    public Party getWitnessParty() {
        return WitnessParty;
    }

    /**
     * 
     * @param newVal
     */
    public void setAgentParty(Party newVal) {
        AgentParty = newVal;
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
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(LocalDate newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(LocalTime newVal) {
        IssueTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMandateDocumentReference(DocumentReference newVal) {
        MandateDocumentReference = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNotaryParty(Party newVal) {
        NotaryParty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setWitnessParty(Party newVal) {
        WitnessParty = newVal;
    }
}// end Power Of Attorney