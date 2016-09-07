package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe information related to an item in a sales context
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItem {

	/**
	 * The quantity the given information are related to
	 */
	private BigDecimal Quantity;
	private Activity Property m_Activity Property;
	private Item m_Item;
	private Price Tax Exclusive Price;
	private Price Tax Inclusive Price;

	public Sales Item(){

	}

	public void finalize() throws Throwable {

	}
	public Activity Property getActivity Property(){
		return m_Activity Property;
	}

	public Item getItem(){
		return m_Item;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Price getTax Exclusive Price(){
		return Tax Exclusive Price;
	}

	public Price getTax Inclusive Price(){
		return Tax Inclusive Price;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivity Property(Activity Property newVal){
		m_Activity Property = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Exclusive Price(Price newVal){
		Tax Exclusive Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Inclusive Price(Price newVal){
		Tax Inclusive Price = newVal;
	}
}//end Sales Item