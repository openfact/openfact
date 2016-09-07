package org.openfact.models.jpa.entities.ubl;


/**
 * A class defining how goods items are split across transport equipment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:25 a. m.
 */
public class GoodsItemContainer {

	/**
	 * An identifier for this goods item container.
	 */
	private String ID;
	/**
	 * The number of goods items loaded into or onto one piece of transport equipment
	 * as a total consignment or part of a consignment.
	 */
	private BigDecimal Quantity;
	private Transport Equipment m_Transport Equipment;

	public Goods Item Container(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Transport Equipment getTransport Equipment(){
		return m_Transport Equipment;
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
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Equipment(Transport Equipment newVal){
		m_Transport Equipment = newVal;
	}
}//end Goods Item Container