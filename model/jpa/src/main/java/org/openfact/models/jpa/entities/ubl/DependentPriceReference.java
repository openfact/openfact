package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define the price of an item as a percentage of the price of a
 * different item.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:26 a. m.
 */
public class DependentPriceReference {

	/**
	 * The percentage by which the price of the different item is multiplied to
	 * calculate the price of the item.
	 */
	private BigDecimal Percent;
	private Address Location Address;
	private LineReference Dependent LineReference;

	public Dependent Price Reference(){

	}

	public void finalize() throws Throwable {

	}
	public LineReference getDependent LineReference(){
		return Dependent LineReference;
	}

	public Address getLocation Address(){
		return Location Address;
	}

	public BigDecimal getPercent(){
		return Percent;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDependent LineReference(LineReference newVal){
		Dependent LineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocation Address(Address newVal){
		Location Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPercent(BigDecimal newVal){
		Percent = newVal;
	}
}//end Dependent Price Reference