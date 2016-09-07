package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the despatching of goods (their pickup for delivery).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:28 a. m.
 */
public class Despatch {

    /**
     * The actual despatch (pickup) date.
     */
    private LocalDate ActualDespatchDate;
    /**
     * The actual despatch (pickup) time.
     */
    private LocalTime ActualDespatchTime;
    /**
     * The estimated despatch (pickup) date.
     */
    private LocalDate EstimatedDespatchDate;
    /**
     * The estimated despatch (pickup) time.
     */
    private LocalTime EstimatedDespatchTime;
    /**
     * The date guaranteed for the despatch (pickup).
     */
    private LocalDate GuaranteedDespatchDate;
    /**
     * The time guaranteed for the despatch (pickup).
     */
    private LocalTime GuaranteedDespatchTime;
    /**
     * An identifier for this despatch event.
     */
    private String ID;
    /**
     * Text describing any special instructions applying to the despatch
     * (pickup).
     */
    private String Instructions;
    /**
     * An identifier for the release of the despatch used as security control or
     * cargo control (pick-up).
     */
    private String ReleaseID;
    /**
     * The despatch (pickup) date requested, normally by the buyer.
     */
    private LocalDate RequestedDespatchDate;
    /**
     * The despatch (pickup) time requested, normally by the buyer.
     */
    private LocalTime RequestedDespatchTime;
    private Address Despatch Address;
    private Contact m_Contact;
    private Location Despatch Location;
    private Party Notify Party;
    private Party Carrier Party;
    private Party Despatch Party;
    private Period Requested
    Despatch Period;
    private Period Estimated
    Despatch Period;

    public Despatch() {

    }

    public void finalize() throws Throwable {

    }

    public LocalDate getActualDespatchDate() {
        return ActualDespatchDate;
    }

    public LocalTime getActualDespatchTime() {
        return ActualDespatchTime;
    }

    public Party getCarrier

    Party(){
		return Carrier Party;
	}

    public Contact getContact() {
        return m_Contact;
    }

    public Address getDespatch

    Address(){
		return Despatch Address;
	}

    public Location getDespatch

    Location(){
		return Despatch Location;
	}

    public Party getDespatch

    Party(){
		return Despatch Party;
	}

    public Period getEstimated

    Despatch Period(){
		return Estimated Despatch Period;
	}

    public LocalDate getEstimatedDespatchDate() {
        return EstimatedDespatchDate;
    }

    public LocalTime getEstimatedDespatchTime() {
        return EstimatedDespatchTime;
    }

    public LocalDate getGuaranteedDespatchDate() {
        return GuaranteedDespatchDate;
    }

    public LocalTime getGuaranteedDespatchTime() {
        return GuaranteedDespatchTime;
    }

    public String getID() {
        return ID;
    }

    public String getInstructions() {
        return Instructions;
    }

    public Party getNotify

    Party(){
		return Notify Party;
	}

    public String getReleaseID() {
        return ReleaseID;
    }

    public Period getRequested

    Despatch Period(){
		return Requested Despatch Period;
	}

    public LocalDate getRequestedDespatchDate() {
        return RequestedDespatchDate;
    }

    public LocalTime getRequestedDespatchTime() {
        return RequestedDespatchTime;
    }

    /**
     * 
     * @param newVal
     */
    public void setActualDespatchDate(LocalDate newVal) {
        ActualDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setActualDespatchTime(LocalTime newVal) {
        ActualDespatchTime = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setCarrier

    Party(Party newVal){
		Carrier Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setContact(Contact newVal) {
        m_Contact = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDespatch

    Address(Address newVal){
		Despatch Address = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setDespatch

    Location(Location newVal){
		Despatch Location = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setDespatch

    Party(Party newVal){
		Despatch Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setEstimated

    Despatch Period(Period newVal){
		Estimated Despatch Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setEstimatedDespatchDate(LocalDate newVal) {
        EstimatedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEstimatedDespatchTime(LocalTime newVal) {
        EstimatedDespatchTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGuaranteedDespatchDate(LocalDate newVal) {
        GuaranteedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGuaranteedDespatchTime(LocalTime newVal) {
        GuaranteedDespatchTime = newVal;
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
    public void setInstructions(String newVal) {
        Instructions = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setNotify

    Party(Party newVal){
		Notify Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setReleaseID(String newVal) {
        ReleaseID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setRequested

    Despatch Period(Period newVal){
		Requested Despatch Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setRequestedDespatchDate(LocalDate newVal) {
        RequestedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRequestedDespatchTime(LocalTime newVal) {
        RequestedDespatchTime = newVal;
    }
}// end Despatch