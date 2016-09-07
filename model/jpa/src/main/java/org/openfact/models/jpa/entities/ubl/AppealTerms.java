package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the terms and conditions, set by the contracting
 * authority, under which an appeal can be lodged for a tender award.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:45 a. m.
 */
public class AppealTerms {

    /**
     * Text describing the terms of an appeal.
     */
    private String description;
    private Party appealInformationParty;
    private Party mediationParty;
    private Party appealReceiverParty;
    private Period presentationPeriod;

    public AppealTerms() {

    }

    public void finalize() throws Throwable {

    }

    public Party getAppealInformationParty() {
        return appealInformationParty;
    }

    public Party getAppealReceiverParty() {
        return appealReceiverParty;
    }

    public String getDescription() {
        return description;
    }

    public Party getMediationParty() {
        return mediationParty;
    }

    public Period getPresentationPeriod() {
        return presentationPeriod;
    }

    /**
     * 
     * @param newVal
     */
    public void setAppealInformationParty(Party newVal) {
        appealInformationParty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAppealReceiverParty(Party newVal) {
        appealReceiverParty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMediationParty(Party newVal) {
        mediationParty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPresentationPeriod(Period newVal) {
        presentationPeriod = newVal;
    }
}// end AppealTerms