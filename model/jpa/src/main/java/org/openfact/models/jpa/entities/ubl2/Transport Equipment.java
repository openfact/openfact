

/**
 * A class to describe a piece of equipment used to transport goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class Transport Equipment {

	/**
	 * The percent of the airflow within this piece of transport equipment.
	 */
	private Percent. Type AirFlowPercent;
	/**
	 * An indicator that this piece of transport equipment is approved for animal food
	 * (true) or not (false).
	 */
	private Indicator. Type AnimalFoodApprovedIndicator;
	/**
	 * Characteristics of this piece of transport equipment.
	 */
	private Text. Type Characteristics;
	/**
	 * Damage associated with this piece of transport equipment.
	 */
	private Text. Type DamageRemarks;
	/**
	 * An indicator that this piece of transport equipment is approved for dangerous
	 * goods (true) or not (false).
	 */
	private Indicator. Type DangerousGoodsApprovedIndicator;
	/**
	 * Text describing this piece of transport equipment.
	 */
	private Text. Type Description;
	/**
	 * A code signifying the current disposition of this piece of transport equipment.
	 */
	private Code. Type DispositionCode;
	/**
	 * A code signifying whether this piece of transport equipment is full, partially
	 * full, or empty.
	 */
	private Code. Type FullnessIndicationCode;
	/**
	 * The gross volume of this piece of transport equipment.
	 */
	private Measure. Type GrossVolumeMeasure;
	/**
	 * The gross weight of this piece of transport equipment.
	 */
	private Measure. Type GrossWeightMeasure;
	/**
	 * An indicator that this piece of transport equipment is approved for human food
	 * (true) or not (false).
	 */
	private Indicator. Type HumanFoodApprovedIndicator;
	/**
	 * The percent humidity within this piece of transport equipment.
	 */
	private Percent. Type HumidityPercent;
	/**
	 * An identifier for this piece of transport equipment.
	 */
	private Identifier. Type ID;
	/**
	 * Additional information about this piece of transport equipment.
	 */
	private Text. Type Information;
	/**
	 * An indication of the legal status of this piece of transport equipment with
	 * respect to the Container Convention Code.
	 */
	private Indicator. Type LegalStatusIndicator;
	/**
	 * A code signifying the type of owner of this piece of transport equipment.
	 */
	private Code. Type OwnerTypeCode;
	/**
	 * An indicator that this piece of transport equipment can supply power (true) or
	 * not (false).
	 */
	private Indicator. Type PowerIndicator;
	/**
	 * A code signifying the type of provider of this piece of transport equipment.
	 */
	private Code. Type ProviderTypeCode;
	/**
	 * An identifier for the consignment contained by this piece of transport
	 * equipment.
	 */
	private Identifier. Type ReferencedConsignmentID;
	/**
	 * An indicator that this piece of transport equipment is refrigerated (true) or
	 * not (false).
	 */
	private Indicator. Type RefrigeratedIndicator;
	/**
	 * An indicator that this piece of transport equipment's refrigeration is on
	 * (true) or off (false).
	 */
	private Indicator. Type RefrigerationOnIndicator;
	/**
	 * An indicator that this piece of transport equipment is returnable (true) or not
	 * (false).
	 */
	private Indicator. Type ReturnabilityIndicator;
	/**
	 * A code signifying the size and type of this piece of piece of transport
	 * equipment. When the piece of transport equipment is a shipping container, it is
	 * recommended to use ContainerSizeTypeCode for validation.
	 */
	private Code. Type SizeTypeCode;
	/**
	 * Special transport requirements expressed as text.
	 */
	private Text. Type SpecialTransportRequirements;
	/**
	 * The weight of this piece of transport equipment when empty.
	 */
	private Measure. Type TareWeightMeasure;
	/**
	 * An identifier for use in tracing this piece of transport equipment, such as the
	 * EPC number used in RFID.
	 */
	private Identifier. Type TraceID;
	/**
	 * A code signifying the tracking device for this piece of transport equipment.
	 */
	private Code. Type TrackingDeviceCode;
	/**
	 * A code signifying the type of this piece of transport equipment.
	 */
	private Transport Equipment Type_ Code. Type TransportEquipmentTypeCode;
	private Allowance Charge Service Allowance Charge;
	private Allowance Charge Freight Allowance Charge;
	private Delivery m_Delivery;
	private Despatch m_Despatch;
	private Dimension Measurement Dimension;
	private Document Reference Shipment Document Reference;
	private Goods Item m_Goods Item;
	private Hazardous Goods Transit m_Hazardous Goods Transit;
	private Location Loading Location;
	private Location Unloading Location;
	private Location Storage Location;
	private Package m_Package;
	private Party Owner Party;
	private Party Operating Party;
	private Party Provider Party;
	private Party Loading Proof Party;
	private Pickup m_Pickup;
	private Supplier Party m_Supplier Party;
	private Temperature Maximum Temperature;
	private Temperature Minimum Temperature;
	private Trading Terms Haulage Trading Terms;
	private Transport Equipment Contained In Transport Equipment;
	private Transport Equipment Attached Transport Equipment;
	private Transport Equipment Seal m_Transport Equipment Seal;
	private Transport Event Quarantine Transport Event;
	private Transport Event Positioning Transport Event;
	private Transport Event m_Transport Event;
	private Transport Event Loading Transport Event;
	private Transport Event Delivery Transport Event;
	private Transport Event Pickup Transport Event;
	private Transport Event Handling Transport Event;
	private Transport Handling Unit Packaged Transport Handling Unit;
	private Transport Means Applicable Transport Means;

	public Transport Equipment(){

	}

	public void finalize() throws Throwable {

	}
	public Percent. Type getAirFlowPercent(){
		return AirFlowPercent;
	}

	public Indicator. Type getAnimalFoodApprovedIndicator(){
		return AnimalFoodApprovedIndicator;
	}

	public Transport Means getApplicable Transport Means(){
		return Applicable Transport Means;
	}

	public Transport Equipment getAttached Transport Equipment(){
		return Attached Transport Equipment;
	}

	public Text. Type getCharacteristics(){
		return Characteristics;
	}

	public Transport Equipment getContained In Transport Equipment(){
		return Contained In Transport Equipment;
	}

	public Text. Type getDamageRemarks(){
		return DamageRemarks;
	}

	public Indicator. Type getDangerousGoodsApprovedIndicator(){
		return DangerousGoodsApprovedIndicator;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Transport Event getDelivery Transport Event(){
		return Delivery Transport Event;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Despatch getDespatch(){
		return m_Despatch;
	}

	public Code. Type getDispositionCode(){
		return DispositionCode;
	}

	public Allowance Charge getFreight Allowance Charge(){
		return Freight Allowance Charge;
	}

	public Code. Type getFullnessIndicationCode(){
		return FullnessIndicationCode;
	}

	public Goods Item getGoods Item(){
		return m_Goods Item;
	}

	public Measure. Type getGrossVolumeMeasure(){
		return GrossVolumeMeasure;
	}

	public Measure. Type getGrossWeightMeasure(){
		return GrossWeightMeasure;
	}

	public Transport Event getHandling Transport Event(){
		return Handling Transport Event;
	}

	public Trading Terms getHaulage Trading Terms(){
		return Haulage Trading Terms;
	}

	public Hazardous Goods Transit getHazardous Goods Transit(){
		return m_Hazardous Goods Transit;
	}

	public Indicator. Type getHumanFoodApprovedIndicator(){
		return HumanFoodApprovedIndicator;
	}

	public Percent. Type getHumidityPercent(){
		return HumidityPercent;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getInformation(){
		return Information;
	}

	public Indicator. Type getLegalStatusIndicator(){
		return LegalStatusIndicator;
	}

	public Location getLoading Location(){
		return Loading Location;
	}

	public Party getLoading Proof Party(){
		return Loading Proof Party;
	}

	public Transport Event getLoading Transport Event(){
		return Loading Transport Event;
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

	public Party getOperating Party(){
		return Operating Party;
	}

	public Party getOwner Party(){
		return Owner Party;
	}

	public Code. Type getOwnerTypeCode(){
		return OwnerTypeCode;
	}

	public Package getPackage(){
		return m_Package;
	}

	public Transport Handling Unit getPackaged Transport Handling Unit(){
		return Packaged Transport Handling Unit;
	}

	public Pickup getPickup(){
		return m_Pickup;
	}

	public Transport Event getPickup Transport Event(){
		return Pickup Transport Event;
	}

	public Transport Event getPositioning Transport Event(){
		return Positioning Transport Event;
	}

	public Indicator. Type getPowerIndicator(){
		return PowerIndicator;
	}

	public Party getProvider Party(){
		return Provider Party;
	}

	public Code. Type getProviderTypeCode(){
		return ProviderTypeCode;
	}

	public Transport Event getQuarantine Transport Event(){
		return Quarantine Transport Event;
	}

	public Identifier. Type getReferencedConsignmentID(){
		return ReferencedConsignmentID;
	}

	public Indicator. Type getRefrigeratedIndicator(){
		return RefrigeratedIndicator;
	}

	public Indicator. Type getRefrigerationOnIndicator(){
		return RefrigerationOnIndicator;
	}

	public Indicator. Type getReturnabilityIndicator(){
		return ReturnabilityIndicator;
	}

	public Allowance Charge getService Allowance Charge(){
		return Service Allowance Charge;
	}

	public Document Reference getShipment Document Reference(){
		return Shipment Document Reference;
	}

	public Code. Type getSizeTypeCode(){
		return SizeTypeCode;
	}

	public Text. Type getSpecialTransportRequirements(){
		return SpecialTransportRequirements;
	}

	public Location getStorage Location(){
		return Storage Location;
	}

	public Supplier Party getSupplier Party(){
		return m_Supplier Party;
	}

	public Measure. Type getTareWeightMeasure(){
		return TareWeightMeasure;
	}

	public Identifier. Type getTraceID(){
		return TraceID;
	}

	public Code. Type getTrackingDeviceCode(){
		return TrackingDeviceCode;
	}

	public Transport Equipment Seal getTransport Equipment Seal(){
		return m_Transport Equipment Seal;
	}

	public Transport Event getTransport Event(){
		return m_Transport Event;
	}

	public Transport Equipment Type_ Code. Type getTransportEquipmentTypeCode(){
		return TransportEquipmentTypeCode;
	}

	public Location getUnloading Location(){
		return Unloading Location;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAirFlowPercent(Percent. Type newVal){
		AirFlowPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAnimalFoodApprovedIndicator(Indicator. Type newVal){
		AnimalFoodApprovedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Transport Means(Transport Means newVal){
		Applicable Transport Means = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAttached Transport Equipment(Transport Equipment newVal){
		Attached Transport Equipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCharacteristics(Text. Type newVal){
		Characteristics = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContained In Transport Equipment(Transport Equipment newVal){
		Contained In Transport Equipment = newVal;
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
	public void setDangerousGoodsApprovedIndicator(Indicator. Type newVal){
		DangerousGoodsApprovedIndicator = newVal;
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
	public void setDelivery Transport Event(Transport Event newVal){
		Delivery Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
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
	public void setDispositionCode(Code. Type newVal){
		DispositionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Allowance Charge(Allowance Charge newVal){
		Freight Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullnessIndicationCode(Code. Type newVal){
		FullnessIndicationCode = newVal;
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
	public void setGrossVolumeMeasure(Measure. Type newVal){
		GrossVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossWeightMeasure(Measure. Type newVal){
		GrossWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHandling Transport Event(Transport Event newVal){
		Handling Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHaulage Trading Terms(Trading Terms newVal){
		Haulage Trading Terms = newVal;
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
	public void setHumanFoodApprovedIndicator(Indicator. Type newVal){
		HumanFoodApprovedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHumidityPercent(Percent. Type newVal){
		HumidityPercent = newVal;
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
	public void setInformation(Text. Type newVal){
		Information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegalStatusIndicator(Indicator. Type newVal){
		LegalStatusIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoading Location(Location newVal){
		Loading Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoading Proof Party(Party newVal){
		Loading Proof Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoading Transport Event(Transport Event newVal){
		Loading Transport Event = newVal;
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
	public void setOperating Party(Party newVal){
		Operating Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOwner Party(Party newVal){
		Owner Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOwnerTypeCode(Code. Type newVal){
		OwnerTypeCode = newVal;
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
	public void setPackaged Transport Handling Unit(Transport Handling Unit newVal){
		Packaged Transport Handling Unit = newVal;
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
	public void setPickup Transport Event(Transport Event newVal){
		Pickup Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPositioning Transport Event(Transport Event newVal){
		Positioning Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPowerIndicator(Indicator. Type newVal){
		PowerIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProvider Party(Party newVal){
		Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProviderTypeCode(Code. Type newVal){
		ProviderTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuarantine Transport Event(Transport Event newVal){
		Quarantine Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferencedConsignmentID(Identifier. Type newVal){
		ReferencedConsignmentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRefrigeratedIndicator(Indicator. Type newVal){
		RefrigeratedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRefrigerationOnIndicator(Indicator. Type newVal){
		RefrigerationOnIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReturnabilityIndicator(Indicator. Type newVal){
		ReturnabilityIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService Allowance Charge(Allowance Charge newVal){
		Service Allowance Charge = newVal;
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
	public void setSizeTypeCode(Code. Type newVal){
		SizeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialTransportRequirements(Text. Type newVal){
		SpecialTransportRequirements = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStorage Location(Location newVal){
		Storage Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupplier Party(Supplier Party newVal){
		m_Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTareWeightMeasure(Measure. Type newVal){
		TareWeightMeasure = newVal;
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
	public void setTrackingDeviceCode(Code. Type newVal){
		TrackingDeviceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Equipment Seal(Transport Equipment Seal newVal){
		m_Transport Equipment Seal = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Event(Transport Event newVal){
		m_Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEquipmentTypeCode(Transport Equipment Type_ Code. Type newVal){
		TransportEquipmentTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnloading Location(Location newVal){
		Unloading Location = newVal;
	}
}//end Transport Equipment