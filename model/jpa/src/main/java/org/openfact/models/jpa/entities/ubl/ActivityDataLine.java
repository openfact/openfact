package org.openfact.models.jpa.entities.ubl;


/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLine {

	/**
	 * An identifier for this activity data line.
	 */
	private String ID;
	/**
	 * A code signifying the type of supply chain activity.
	 */
	private String SupplyChainActivityTypeCode;
	private Customer Party Buyer Customer Party;
	private Location Activity Origin Location;
	private Period Activity Period;
	private Location Activity Final Location;
	private Sales Item m_Sales Item;
	private Supplier Party Seller Supplier Party;

	public Activity Data Line(){

	}

	public void finalize() throws Throwable {

	}
	public Location getActivity Final Location(){
		return Activity Final Location;
	}

	public Location getActivity Origin Location(){
		return Activity Origin Location;
	}

	public Period getActivity Period(){
		return Activity Period;
	}

	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
	}

	public String getID(){
		return ID;
	}

	public Sales Item getSales Item(){
		return m_Sales Item;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public String getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivity Final Location(Location newVal){
		Activity Final Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivity Origin Location(Location newVal){
		Activity Origin Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivity Period(Period newVal){
		Activity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSales Item(Sales Item newVal){
		m_Sales Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupplyChainActivityTypeCode(String newVal){
		SupplyChainActivityTypeCode = newVal;
	}
}//end Activity Data Line