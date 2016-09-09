

/**
 * A class to describe a uniquely identifiable unit consisting of one or more
 * packages, goods items, or pieces of transport equipment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:46 a. m.
 */
public class Transport Handling Unit {

	/**
	 * Text describing damage associated with this transport handling unit.
	 */
	private Text. Type DamageRemarks;
	/**
	 * The handling required for this transport handling unit, expressed as a code.
	 */
	private Code. Type HandlingCode;
	/**
	 * The handling required for this transport handling unit, expressed as text.
	 */
	private Text. Type HandlingInstructions;
	/**
	 * An indicator that the materials contained in this transport handling unit are
	 * subject to an international regulation concerning the carriage of dangerous
	 * goods (true) or not (false).
	 */
	private Indicator. Type HazardousRiskIndicator;
	/**
	 * An identifier for this transport handling unit.
	 */
	private Identifier. Type ID;
	/**
	 * Text describing the marks and numbers on this transport handling unit.
	 */
	private Text. Type ShippingMarks;
	/**
	 * The total number of goods items in this transport handling unit.
	 */
	private Quantity. Type TotalGoodsItemQuantity;
	/**
	 * The total number of packages in this transport handling unit.
	 */
	private Quantity. Type TotalPackageQuantity;
	/**
	 * An identifier for use in tracing this transport handling unit, such as the EPC
	 * number used in RFID.
	 */
	private Identifier. Type TraceID;
	/**
	 * A code signifying the type of this transport handling unit.
	 */
	private Code. Type TransportHandlingUnitTypeCode;
	private Customs Declaration m_Customs Declaration;
	private Despatch Line Handling Unit Despatch Line;
	private Dimension Floor Space Measurement Dimension;
	private Dimension Pallet Space Measurement Dimension;
	private Dimension Measurement Dimension;
	private Document Reference Shipment Document Reference;
	private Goods Item m_Goods Item;
	private Hazardous Goods Transit m_Hazardous Goods Transit;
	private Package m_Package;
	private Package Actual Package;
	private Receipt Line Received Handling Unit Receipt Line;
	private Shipment Referenced Shipment;
	private Status m_Status;
	private Temperature Minimum Temperature;
	private Temperature Maximum Temperature;
	private Transport Equipment m_Transport Equipment;
	private Transport Means m_Transport Means;

	public Transport Handling Unit(){

	}

	public void finalize() throws Throwable {

	}
	public Package getActual Package(){
		return Actual Package;
	}

	public Customs Declaration getCustoms Declaration(){
		return m_Customs Declaration;
	}

	public Text. Type getDamageRemarks(){
		return DamageRemarks;
	}

	public Dimension getFloor Space Measurement Dimension(){
		return Floor Space Measurement Dimension;
	}

	public Goods Item getGoods Item(){
		return m_Goods Item;
	}

	public Despatch Line getHandling Unit Despatch Line(){
		return Handling Unit Despatch Line;
	}

	public Code. Type getHandlingCode(){
		return HandlingCode;
	}

	public Text. Type getHandlingInstructions(){
		return HandlingInstructions;
	}

	public Hazardous Goods Transit getHazardous Goods Transit(){
		return m_Hazardous Goods Transit;
	}

	public Indicator. Type getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Temperature getMaximum Temperature(){
		return Maximum Temperature;
	}

	public Dimension getMeasurement Dimension(){
		return Measurement Dimension;
	}

	public Temperature getMinimum Temperature(){
		return Minimum Temperature;
	}

	public Package getPackage(){
		return m_Package;
	}

	public Dimension getPallet Space Measurement Dimension(){
		return Pallet Space Measurement Dimension;
	}

	public Receipt Line getReceived Handling Unit Receipt Line(){
		return Received Handling Unit Receipt Line;
	}

	public Shipment getReferenced Shipment(){
		return Referenced Shipment;
	}

	public Document Reference getShipment Document Reference(){
		return Shipment Document Reference;
	}

	public Text. Type getShippingMarks(){
		return ShippingMarks;
	}

	public Status getStatus(){
		return m_Status;
	}

	public Quantity. Type getTotalGoodsItemQuantity(){
		return TotalGoodsItemQuantity;
	}

	public Quantity. Type getTotalPackageQuantity(){
		return TotalPackageQuantity;
	}

	public Identifier. Type getTraceID(){
		return TraceID;
	}

	public Transport Equipment getTransport Equipment(){
		return m_Transport Equipment;
	}

	public Transport Means getTransport Means(){
		return m_Transport Means;
	}

	public Code. Type getTransportHandlingUnitTypeCode(){
		return TransportHandlingUnitTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Package(Package newVal){
		Actual Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustoms Declaration(Customs Declaration newVal){
		m_Customs Declaration = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDamageRemarks(Text. Type newVal){
		DamageRemarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFloor Space Measurement Dimension(Dimension newVal){
		Floor Space Measurement Dimension = newVal;
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
	public void setHandling Unit Despatch Line(Despatch Line newVal){
		Handling Unit Despatch Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingCode(Code. Type newVal){
		HandlingCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandlingInstructions(Text. Type newVal){
		HandlingInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardous Goods Transit(Hazardous Goods Transit newVal){
		m_Hazardous Goods Transit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRiskIndicator(Indicator. Type newVal){
		HazardousRiskIndicator = newVal;
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
	public void setMaximum Temperature(Temperature newVal){
		Maximum Temperature = newVal;
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
	public void setMinimum Temperature(Temperature newVal){
		Minimum Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackage(Package newVal){
		m_Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPallet Space Measurement Dimension(Dimension newVal){
		Pallet Space Measurement Dimension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceived Handling Unit Receipt Line(Receipt Line newVal){
		Received Handling Unit Receipt Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced Shipment(Shipment newVal){
		Referenced Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment Document Reference(Document Reference newVal){
		Shipment Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShippingMarks(Text. Type newVal){
		ShippingMarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatus(Status newVal){
		m_Status = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalGoodsItemQuantity(Quantity. Type newVal){
		TotalGoodsItemQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalPackageQuantity(Quantity. Type newVal){
		TotalPackageQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTraceID(Identifier. Type newVal){
		TraceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Equipment(Transport Equipment newVal){
		m_Transport Equipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Means(Transport Means newVal){
		m_Transport Means = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportHandlingUnitTypeCode(Code. Type newVal){
		TransportHandlingUnitTypeCode = newVal;
	}
}//end Transport Handling Unit