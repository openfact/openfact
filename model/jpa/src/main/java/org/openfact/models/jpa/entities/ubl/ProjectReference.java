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
    private LocalDate issueDate;
    /**
     * A universally unique identifier for the referenced project.
     */
    private String UUID;
    private WorkPhaseReference m_WorkPhaseReference;

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the m_WorkPhaseReference
     */
    public WorkPhaseReference getM_WorkPhaseReference() {
        return m_WorkPhaseReference;
    }

    /**
     * @param m_WorkPhaseReference
     *            the m_WorkPhaseReference to set
     */
    public void setM_WorkPhaseReference(WorkPhaseReference m_WorkPhaseReference) {
        this.m_WorkPhaseReference = m_WorkPhaseReference;
    }

}