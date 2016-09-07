package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the classification of a commodity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:37 a. m.
 */
public class CommodityClassification {

	/**
	 * A mutually agreed code signifying the type of cargo for purposes of commodity
	 * classification.
	 */
	private String CargoTypeCode;
	/**
	 * The harmonized international commodity code for cross border and regulatory
	 * (customs and trade statistics) purposes.
	 */
	private String CommodityCode;
	/**
	 * A code signifying the trade classification of the commodity.
	 */
	private String ItemClassificationCode;
	/**
	 * A code defined by a specific maintenance agency signifying the high-level
	 * nature of the commodity.
	 */
	private String NatureCode;

	public CommodityClassification(){

	}

	public void finalize() throws Throwable {

	}
	public String getCargoTypeCode(){
		return CargoTypeCode;
	}

	public String getCommodityCode(){
		return CommodityCode;
	}

	public String getItemClassificationCode(){
		return ItemClassificationCode;
	}

	public String getNatureCode(){
		return NatureCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCargoTypeCode(String newVal){
		CargoTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCommodityCode(String newVal){
		CommodityCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItemClassificationCode(String newVal){
		ItemClassificationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNatureCode(String newVal){
		NatureCode = newVal;
	}
}//end CommodityClassification