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
	private TransportEquipment m_TransportEquipment;

	public GoodsItem Container(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public TransportEquipment getTransportEquipment(){
		return m_TransportEquipment;
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
	public void setTransportEquipment(TransportEquipment newVal){
		m_TransportEquipment = newVal;
	}
}//end GoodsItem Container