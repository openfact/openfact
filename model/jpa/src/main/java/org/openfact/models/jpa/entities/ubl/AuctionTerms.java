package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the terms to be fulfilled by tenderers if an auction is
 * to be executed before the awarding of a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:49 a. m.
 */
public class AuctionTerms {

    /**
     * Indicates whether an electronic auction will be used before the awarding
     * of a contract (true) or not (false).
     */
    private boolean auctionConstraintIndicator;
    /**
     * The Uniform Resource Identifier (URI) of the electronic device used for
     * the auction.
     */
    private String auctionURIID;
    /**
     * Text describing the conditions under which the tenderers will be able to
     * bid as part of the auction.
     */
    private String conditionsDescription;
    /**
     * Text for tenderers describing terms governing the auction.
     */
    private String description;
    /**
     * Text describing an electronic device used for the auction, including
     * associated connectivity specifications.
     */
    private String electronicDeviceDescription;
    /**
     * Text describing a justification for the use of an auction in awarding the
     * tender.
     */
    private String justificationDescription;
    /**
     * Text describing the auction process.
     */
    private String processDescription;

    public AuctionTerms() {

    }

    public void finalize() throws Throwable {

    }

    public boolean getAuctionConstraintIndicator() {
        return auctionConstraintIndicator;
    }

    public String getAuctionURIID() {
        return auctionURIID;
    }

    public String getConditionsDescription() {
        return conditionsDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getElectronicDeviceDescription() {
        return electronicDeviceDescription;
    }

    public String getJustificationDescription() {
        return justificationDescription;
    }

    public String getProcessDescription() {
        return processDescription;
    }

    /**
     * 
     * @param newVal
     */
    public void setAuctionConstraintIndicator(boolean newVal) {
        auctionConstraintIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAuctionURIID(String newVal) {
        auctionURIID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConditionsDescription(String newVal) {
        conditionsDescription = newVal;
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
    public void setElectronicDeviceDescription(String newVal) {
        electronicDeviceDescription = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setJustificationDescription(String newVal) {
        justificationDescription = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProcessDescription(String newVal) {
        processDescription = newVal;
    }
}// end AuctionTerms