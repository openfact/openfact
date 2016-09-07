package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line item describing the expected impacts associated with a
 * retail event involving a specific product at a specific location.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:56 a. m.
 */
public class EventLineItem {

	/**
	 * The number of this event line item.
	 */
	private BigDecimal LineNumberNumeric;
	private Item Supply Item;
	private Location Participating Locations Location;
	private Retail Planned Impact m_Retail Planned Impact;

	public Event Line Item(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getLineNumberNumeric(){
		return LineNumberNumeric;
	}

	public Location getParticipating Locations Location(){
		return Participating Locations Location;
	}

	public Retail Planned Impact getRetail Planned Impact(){
		return m_Retail Planned Impact;
	}

	public Item getSupply Item(){
		return Supply Item;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineNumberNumeric(BigDecimal newVal){
		LineNumberNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParticipating Locations Location(Location newVal){
		Participating Locations Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRetail Planned Impact(Retail Planned Impact newVal){
		m_Retail Planned Impact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupply Item(Item newVal){
		Supply Item = newVal;
	}
}//end Event Line Item