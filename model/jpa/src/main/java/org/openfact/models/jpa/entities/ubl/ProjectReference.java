package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;

/**
 * A class to define a reference to a procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class ProjectReference {

    /**
     * An identifier for the referenced project.
     */
    private String ID;
    /**
     * The date on which the referenced project was issued.
     */
    private LocalDate IssueDate;
    /**
     * A universally unique identifier for the referenced project.
     */
    private String UUID;
    private WorkPhaseReference m_WorkPhaseReference;

    public ProjectReference() {

    }

    public void finalize() throws Throwable {

    }

    public String getID() {
        return ID;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public String getUUID() {
        return UUID;
    }

    public WorkPhaseReference getWorkPhaseReference() {
        return m_WorkPhaseReference;
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
    public void setUUID(String newVal) {
        UUID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setWorkPhaseReference(WorkPhaseReference newVal) {
        m_WorkPhaseReference = newVal;
    }
}// end Project Reference