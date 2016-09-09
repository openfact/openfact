

/**
 * A class to describe a package.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class Package {

	/**
	 * An identifier for this package.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying a level of packaging.
	 */
	private Code. Type PackageLevelCode;
	/**
	 * A code signifying a type of packaging.
	 */
	private Packaging Type_ Code. Type PackagingTypeCode;
	/**
	 * Text describing the packaging material.
	 */
	private Text. Type PackingMaterial;
	/**
	 * The quantity of items contained in this package.
	 */
	private Quantity. Type Quantity;
	/**
	 * An indicator that the packaging material is returnable (true) or not (false).
	 */
	private Indicator. Type ReturnableMaterialIndicator;
	/**
	 * An identifier for use in tracing this package, such as the EPC number used in
	 * RFID.
	 */
	private Identifier. Type TraceID;
	private Delivery m_Delivery;
	private Delivery Unit m_Delivery Unit;
	private Despatch m_Despatch;
	private Dimension Measurement Dimension;
	private Goods Item m_Goods Item;
	private Package Contained Package;
	private Pickup m_Pickup;
	private Transport Equipment Containing Transport Equipment;

	public Package(){

	}

	public void finalize() throws Throwable {

	}
	public Package getContained Package(){
		return Contained Package;
	}

	public Transport Equipment getContaining Transport Equipment(){
		return Containing Transport Equipment;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Delivery Unit getDelivery Unit(){
		return m_Delivery Unit;
	}

	public Despatch getDespatch(){
		return m_Despatch;
	}

	public Goods Item getGoods Item(){
		return m_Goods Item;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Dimension getMeasurement Dimension(){
		return Measurement Dimension;
	}

	public Code. Type getPackageLevelCode(){
		return PackageLevelCode;
	}

	public Packaging Type_ Code. Type getPackagingTypeCode(){
		return PackagingTypeCode;
	}

	public Text. Type getPackingMaterial(){
		return PackingMaterial;
	}

	public Pickup getPickup(){
		return m_Pickup;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Indicator. Type getReturnableMaterialIndicator(){
		return ReturnableMaterialIndicator;
	}

	public Identifier. Type getTraceID(){
		return TraceID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContained Package(Package newVal){
		Contained Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContaining Transport Equipment(Transport Equipment newVal){
		Containing Transport Equipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery(Delivery newVal){
		m_Delivery = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Unit(Delivery Unit newVal){
		m_Delivery Unit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch(Despatch newVal){
		m_Despatch = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGoods Item(Goods Item newVal){
		m_Goods Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasurement Dimension(Dimension newVal){
		Measurement Dimension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackageLevelCode(Code. Type newVal){
		PackageLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackagingTypeCode(Packaging Type_ Code. Type newVal){
		PackagingTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackingMaterial(Text. Type newVal){
		PackingMaterial = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPickup(Pickup newVal){
		m_Pickup = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReturnableMaterialIndicator(Indicator. Type newVal){
		ReturnableMaterialIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTraceID(Identifier. Type newVal){
		TraceID = newVal;
	}
}//end Package