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
    private Date.Type ActualDespatchDate;
    /**
     * The actual despatch (pickup) time.
     */
    private Time.Type ActualDespatchTime;
    /**
     * The estimated despatch (pickup) date.
     */
    private Date.Type EstimatedDespatchDate;
    /**
     * The estimated despatch (pickup) time.
     */
    private Time.Type EstimatedDespatchTime;
    /**
     * The date guaranteed for the despatch (pickup).
     */
    private Date.Type GuaranteedDespatchDate;
    /**
     * The time guaranteed for the despatch (pickup).
     */
    private Time.Type GuaranteedDespatchTime;
    /**
     * An identifier for this despatch event.
     */
    private Identifier.Type ID;
    /**
     * Text describing any special instructions applying to the despatch
     * (pickup).
     */
    private Text.Type Instructions;
    /**
     * An identifier for the release of the despatch used as security control or
     * cargo control (pick-up).
     */
    private Identifier.Type ReleaseID;
    /**
     * The despatch (pickup) date requested, normally by the buyer.
     */
    private Date.Type RequestedDespatchDate;
    /**
     * The despatch (pickup) time requested, normally by the buyer.
     */
    private Time.Type RequestedDespatchTime;
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

    public Date.Type getActualDespatchDate() {
        return ActualDespatchDate;
    }

    public Time.Type getActualDespatchTime() {
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

    public Date.Type getEstimatedDespatchDate() {
        return EstimatedDespatchDate;
    }

    public Time.Type getEstimatedDespatchTime() {
        return EstimatedDespatchTime;
    }

    public Date.Type getGuaranteedDespatchDate() {
        return GuaranteedDespatchDate;
    }

    public Time.Type getGuaranteedDespatchTime() {
        return GuaranteedDespatchTime;
    }

    public Identifier.Type getID() {
        return ID;
    }

    public Text.Type getInstructions() {
        return Instructions;
    }

    public Party getNotify

    Party(){
		return Notify Party;
	}

    public Identifier.Type getReleaseID() {
        return ReleaseID;
    }

    public Period getRequested

    Despatch Period(){
		return Requested Despatch Period;
	}

    public Date.Type getRequestedDespatchDate() {
        return RequestedDespatchDate;
    }

    public Time.Type getRequestedDespatchTime() {
        return RequestedDespatchTime;
    }

    /**
     * 
     * @param newVal
     */
    public void setActualDespatchDate(Date.Type newVal) {
        ActualDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setActualDespatchTime(Time.Type newVal) {
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
    public void setEstimatedDespatchDate(Date.Type newVal) {
        EstimatedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEstimatedDespatchTime(Time.Type newVal) {
        EstimatedDespatchTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGuaranteedDespatchDate(Date.Type newVal) {
        GuaranteedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGuaranteedDespatchTime(Time.Type newVal) {
        GuaranteedDespatchTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInstructions(Text.Type newVal) {
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
    public void setReleaseID(Identifier.Type newVal) {
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
    public void setRequestedDespatchDate(Date.Type newVal) {
        RequestedDespatchDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRequestedDespatchTime(Time.Type newVal) {
        RequestedDespatchTime = newVal;
    }
}// end Despatch