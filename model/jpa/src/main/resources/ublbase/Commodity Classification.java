

/**
 * A class to describe the classification of a commodity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:37 a. m.
 */
public class Commodity Classification {

	/**
	 * A mutually agreed code signifying the type of cargo for purposes of commodity
	 * classification.
	 */
	private Code. Type CargoTypeCode;
	/**
	 * The harmonized international commodity code for cross border and regulatory
	 * (customs and trade statistics) purposes.
	 */
	private Code. Type CommodityCode;
	/**
	 * A code signifying the trade classification of the commodity.
	 */
	private Code. Type ItemClassificationCode;
	/**
	 * A code defined by a specific maintenance agency signifying the high-level
	 * nature of the commodity.
	 */
	private Code. Type NatureCode;

	public Commodity Classification(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCargoTypeCode(){
		return CargoTypeCode;
	}

	public Code. Type getCommodityCode(){
		return CommodityCode;
	}

	public Code. Type getItemClassificationCode(){
		return ItemClassificationCode;
	}

	public Code. Type getNatureCode(){
		return NatureCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCargoTypeCode(Code. Type newVal){
		CargoTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCommodityCode(Code. Type newVal){
		CommodityCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItemClassificationCode(Code. Type newVal){
		ItemClassificationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNatureCode(Code. Type newVal){
		NatureCode = newVal;
	}
}//end Commodity Classification