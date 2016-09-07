package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a piece of equipment used to transport goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class TransportEquipment {

	/**
	 * The percent of the airflow within this piece of transport equipment.
	 */
	private BigDecimal AirFlowPercent;
	/**
	 * An indicator that this piece of transport equipment is approved for animal food
	 * (true) or not (false).
	 */
	private boolean AnimalFoodApprovedIndicator;
	/**
	 * Characteristics of this piece of transport equipment.
	 */
	private String Characteristics;
	/**
	 * Damage associated with this piece of transport equipment.
	 */
	private String DamageRemarks;
	/**
	 * An indicator that this piece of transport equipment is approved for dangerous
	 * goods (true) or not (false).
	 */
	private boolean DangerousGoodsApprovedIndicator;
	/**
	 * Text describing this piece of transport equipment.
	 */
	private String Description;
	/**
	 * A code signifying the current disposition of this piece of transport equipment.
	 */
	private String DispositionCode;
	/**
	 * A code signifying whether this piece of transport equipment is full, partially
	 * full, or empty.
	 */
	private String FullnessIndicationCode;
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
	private boolean HumanFoodApprovedIndicator;
	/**
	 * The percent humidity within this piece of transport equipment.
	 */
	private BigDecimal HumidityPercent;
	/**
	 * An identifier for this piece of transport equipment.
	 */
	private String ID;
	/**
	 * Additional information about this piece of transport equipment.
	 */
	private String Information;
	/**
	 * An indication of the legal status of this piece of transport equipment with
	 * respect to the Container Convention Code.
	 */
	private boolean LegalStatusIndicator;
	/**
	 * A code signifying the type of owner of this piece of transport equipment.
	 */
	private String OwnerTypeCode;
	/**
	 * An indicator that this piece of transport equipment can supply power (true) or
	 * not (false).
	 */
	private boolean PowerIndicator;
	/**
	 * A code signifying the type of provider of this piece of transport equipment.
	 */
	private String ProviderTypeCode;
	/**
	 * An identifier for the consignment contained by this piece of transport
	 * equipment.
	 */
	private String ReferencedConsignmentID;
	/**
	 * An indicator that this piece of transport equipment is refrigerated (true) or
	 * not (false).
	 */
	private boolean RefrigeratedIndicator;
	/**
	 * An indicator that this piece of transport equipment's refrigeration is on
	 * (true) or off (false).
	 */
	private boolean RefrigerationOnIndicator;
	/**
	 * An indicator that this piece of transport equipment is returnable (true) or not
	 * (false).
	 */
	private boolean ReturnabilityIndicator;
	/**
	 * A code signifying the size and type of this piece of piece of transport
	 * equipment. When the piece of transport equipment is a shipping container, it is
	 * recommended to use ContainerSizeTypeCode for validation.
	 */
	private String SizeTypeCode;
	/**
	 * Special transport requirements expressed as text.
	 */
	private String SpecialTransportRequirements;
	/**
	 * The weight of this piece of transport equipment when empty.
	 */
	private Measure. Type TareWeightMeasure;
	/**
	 * An identifier for use in tracing this piece of transport equipment, such as the
	 * EPC number used in RFID.
	 */
	private String TraceID;
	/**
	 * A code signifying the tracking device for this piece of transport equipment.
	 */
	private String TrackingDeviceCode;
	/**
	 * A code signifying the type of this piece of transport equipment.
	 */
	private TransportEquipment Type_ String TransportEquipmentTypeCode;
	private AllowanceCharge Service AllowanceCharge;
	private AllowanceCharge Freight AllowanceCharge;
	private Delivery m_Delivery;
	private Despatch m_Despatch;
	private Dimension Measurement Dimension;
	private DocumentReference Shipment DocumentReference;
	private GoodsItem m_GoodsItem;
	private HazardousGoodsTransit m_HazardousGoodsTransit;
	private Location Loading Location;
	private Location Unloading Location;
	private Location Storage Location;
	private Package m_Package;
	private Party Owner Party;
	private Party Operating Party;
	private Party Provider Party;
	private Party Loading Proof Party;
	private Pickup m_Pickup;
	private SupplierParty m_SupplierParty;
	private Temperature Maximum Temperature;
	private Temperature Minimum Temperature;
	private Trading Terms Haulage Trading Terms;
	private TransportEquipment Contained In TransportEquipment;
	private TransportEquipment Attached TransportEquipment;
	private TransportEquipment Seal m_TransportEquipment Seal;
	private TransportEvent Quarantine TransportEvent;
	private TransportEvent Positioning TransportEvent;
	private TransportEvent m_TransportEvent;
	private TransportEvent Loading TransportEvent;
	private TransportEvent Delivery TransportEvent;
	private TransportEvent Pickup TransportEvent;
	private TransportEvent Handling TransportEvent;
	private Transport Handling Unit Packaged Transport Handling Unit;
	private TransportMeans Applicable TransportMeans;

	public TransportEquipment(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getAirFlowPercent(){
		return AirFlowPercent;
	}

	public boolean getAnimalFoodApprovedIndicator(){
		return AnimalFoodApprovedIndicator;
	}

	public TransportMeans getApplicable TransportMeans(){
		return Applicable TransportMeans;
	}

	public TransportEquipment getAttached TransportEquipment(){
		return Attached TransportEquipment;
	}

	public String getCharacteristics(){
		return Characteristics;
	}

	public TransportEquipment getContained In TransportEquipment(){
		return Contained In TransportEquipment;
	}

	public String getDamageRemarks(){
		return DamageRemarks;
	}

	public boolean getDangerousGoodsApprovedIndicator(){
		return DangerousGoodsApprovedIndicator;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public TransportEvent getDelivery TransportEvent(){
		return Delivery TransportEvent;
	}

	public String getDescription(){
		return Description;
	}

	public Despatch getDespatch(){
		return m_Despatch;
	}

	public String getDispositionCode(){
		return DispositionCode;
	}

	public AllowanceCharge getFreight AllowanceCharge(){
		return Freight AllowanceCharge;
	}

	public String getFullnessIndicationCode(){
		return FullnessIndicationCode;
	}

	public GoodsItem getGoodsItem(){
		return m_GoodsItem;
	}

	public Measure. Type getGrossVolumeMeasure(){
		return GrossVolumeMeasure;
	}

	public Measure. Type getGrossWeightMeasure(){
		return GrossWeightMeasure;
	}

	public TransportEvent getHandling TransportEvent(){
		return Handling TransportEvent;
	}

	public Trading Terms getHaulage Trading Terms(){
		return Haulage Trading Terms;
	}

	public HazardousGoodsTransit getHazardousGoodsTransit(){
		return m_HazardousGoodsTransit;
	}

	public boolean getHumanFoodApprovedIndicator(){
		return HumanFoodApprovedIndicator;
	}

	public BigDecimal getHumidityPercent(){
		return HumidityPercent;
	}

	public String getID(){
		return ID;
	}

	public String getInformation(){
		return Information;
	}

	public boolean getLegalStatusIndicator(){
		return LegalStatusIndicator;
	}

	public Location getLoading Location(){
		return Loading Location;
	}

	public Party getLoading Proof Party(){
		return Loading Proof Party;
	}

	public TransportEvent getLoading TransportEvent(){
		return Loading TransportEvent;
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

	public String getOwnerTypeCode(){
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

	public TransportEvent getPickup TransportEvent(){
		return Pickup TransportEvent;
	}

	public TransportEvent getPositioning TransportEvent(){
		return Positioning TransportEvent;
	}

	public boolean getPowerIndicator(){
		return PowerIndicator;
	}

	public Party getProvider Party(){
		return Provider Party;
	}

	public String getProviderTypeCode(){
		return ProviderTypeCode;
	}

	public TransportEvent getQuarantine TransportEvent(){
		return Quarantine TransportEvent;
	}

	public String getReferencedConsignmentID(){
		return ReferencedConsignmentID;
	}

	public boolean getRefrigeratedIndicator(){
		return RefrigeratedIndicator;
	}

	public boolean getRefrigerationOnIndicator(){
		return RefrigerationOnIndicator;
	}

	public boolean getReturnabilityIndicator(){
		return ReturnabilityIndicator;
	}

	public AllowanceCharge getService AllowanceCharge(){
		return Service AllowanceCharge;
	}

	public DocumentReference getShipment DocumentReference(){
		return Shipment DocumentReference;
	}

	public String getSizeTypeCode(){
		return SizeTypeCode;
	}

	public String getSpecialTransportRequirements(){
		return SpecialTransportRequirements;
	}

	public Location getStorage Location(){
		return Storage Location;
	}

	public SupplierParty getSupplierParty(){
		return m_SupplierParty;
	}

	public Measure. Type getTareWeightMeasure(){
		return TareWeightMeasure;
	}

	public String getTraceID(){
		return TraceID;
	}

	public String getTrackingDeviceCode(){
		return TrackingDeviceCode;
	}

	public TransportEquipment Seal getTransportEquipment Seal(){
		return m_TransportEquipment Seal;
	}

	public TransportEvent getTransportEvent(){
		return m_TransportEvent;
	}

	public TransportEquipment Type_ String getTransportEquipmentTypeCode(){
		return TransportEquipmentTypeCode;
	}

	public Location getUnloading Location(){
		return Unloading Location;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAirFlowPercent(BigDecimal newVal){
		AirFlowPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAnimalFoodApprovedIndicator(boolean newVal){
		AnimalFoodApprovedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable TransportMeans(TransportMeans newVal){
		Applicable TransportMeans = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAttached TransportEquipment(TransportEquipment newVal){
		Attached TransportEquipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCharacteristics(String newVal){
		Characteristics = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContained In TransportEquipment(TransportEquipment newVal){
		Contained In TransportEquipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDamageRemarks(String newVal){
		DamageRemarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDangerousGoodsApprovedIndicator(boolean newVal){
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
	public void setDelivery TransportEvent(TransportEvent newVal){
		Delivery TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
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
	public void setDispositionCode(String newVal){
		DispositionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight AllowanceCharge(AllowanceCharge newVal){
		Freight AllowanceCharge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullnessIndicationCode(String newVal){
		FullnessIndicationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGoodsItem(GoodsItem newVal){
		m_GoodsItem = newVal;
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
	public void setHandling TransportEvent(TransportEvent newVal){
		Handling TransportEvent = newVal;
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
	public void setHazardousGoodsTransit(HazardousGoodsTransit newVal){
		m_HazardousGoodsTransit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHumanFoodApprovedIndicator(boolean newVal){
		HumanFoodApprovedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHumidityPercent(BigDecimal newVal){
		HumidityPercent = newVal;
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
	public void setInformation(String newVal){
		Information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegalStatusIndicator(boolean newVal){
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
	public void setLoading TransportEvent(TransportEvent newVal){
		Loading TransportEvent = newVal;
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
	public void setOwnerTypeCode(String newVal){
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
	public void setPickup TransportEvent(TransportEvent newVal){
		Pickup TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPositioning TransportEvent(TransportEvent newVal){
		Positioning TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPowerIndicator(boolean newVal){
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
	public void setProviderTypeCode(String newVal){
		ProviderTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuarantine TransportEvent(TransportEvent newVal){
		Quarantine TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferencedConsignmentID(String newVal){
		ReferencedConsignmentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRefrigeratedIndicator(boolean newVal){
		RefrigeratedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRefrigerationOnIndicator(boolean newVal){
		RefrigerationOnIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReturnabilityIndicator(boolean newVal){
		ReturnabilityIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService AllowanceCharge(AllowanceCharge newVal){
		Service AllowanceCharge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment DocumentReference(DocumentReference newVal){
		Shipment DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSizeTypeCode(String newVal){
		SizeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecialTransportRequirements(String newVal){
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
	public void setSupplierParty(SupplierParty newVal){
		m_SupplierParty = newVal;
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
	public void setTraceID(String newVal){
		TraceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrackingDeviceCode(String newVal){
		TrackingDeviceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEquipment Seal(TransportEquipment Seal newVal){
		m_TransportEquipment Seal = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEvent(TransportEvent newVal){
		m_TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEquipmentTypeCode(TransportEquipment Type_ String newVal){
		TransportEquipmentTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnloading Location(Location newVal){
		Unloading Location = newVal;
	}
}//end TransportEquipment