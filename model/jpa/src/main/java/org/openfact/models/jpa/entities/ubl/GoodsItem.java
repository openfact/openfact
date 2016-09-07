package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a separately identifiable quantity of goods of a single
 * product type.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:24 a. m.
 */
public class GoodsItem {

	/**
	 * The number of units in the goods item to which charges apply.
	 */
	private BigDecimal ChargeableQuantity;
	/**
	 * The weight on which a charge is to be based.
	 */
	private Measure. Type ChargeableWeightMeasure;
	/**
	 * An indicator that this goods item has been classified for import by customs
	 * (true) or not (false).
	 */
	private boolean CustomsImportClassifiedIndicator;
	/**
	 * A code assigned by customs to signify the status of this goods item.
	 */
	private String CustomsStatusCode;
	/**
	 * Quantity of the units in this goods item as required by customs for tariff,
	 * statistical, or fiscal purposes.
	 */
	private BigDecimal CustomsTariffQuantity;
	/**
	 * The total declared value for customs purposes of the goods item.
	 */
	private BigDecimal DeclaredCustomsValueAmount;
	/**
	 * The value of this goods item, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
	 */
	private BigDecimal DeclaredForCarriageValueAmount;
	/**
	 * The total declared value of all the goods items in the same consignment with
	 * this goods item that have the same statistical heading.
	 */
	private BigDecimal DeclaredStatisticsValueAmount;
	/**
	 * Text describing this goods item to identify it for customs, statistical, or
	 * transport purposes.
	 */
	private String Description;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private BigDecimal FreeOnBoardValueAmount;
	/**
	 * The volume of this goods item, normally calculated by multiplying its maximum
	 * length, width, and height.
	 */
	private Measure. Type GrossVolumeMeasure;
	/**
	 * The weight of this goods item, including packing and packaging but excluding
	 * the carrier's equipment.
	 */
	private Measure. Type GrossWeightMeasure;
	/**
	 * An indication that the transported goods item is subject to an international
	 * regulation concerning the carriage of dangerous goods (true) or not (false).
	 */
	private boolean HazardousRiskIndicator;
	/**
	 * An identifier for this goods item.
	 */
	private String ID;
	/**
	 * The amount covered by insurance for this goods item.
	 */
	private BigDecimal InsuranceValueAmount;
	/**
	 * The total weight of this goods item, excluding all packing and packaging.
	 */
	private Measure. Type NetNetWeightMeasure;
	/**
	 * The volume contained by a goods item, excluding the volume of any packaging
	 * material.
	 */
	private Measure. Type NetVolumeMeasure;
	/**
	 * The weight of this goods item, excluding packing but including packaging that
	 * normally accompanies the goods.
	 */
	private Measure. Type NetWeightMeasure;
	/**
	 * A code signifying the treatment preference for this goods item according to
	 * international trading agreements.
	 */
	private String PreferenceCriterionCode;
	/**
	 * The number of units making up this goods item.
	 */
	private BigDecimal Quantity;
	/**
	 * An identifier for a set of tariff codes required to specify a type of goods for
	 * customs, transport, statistical, or other regulatory purposes.
	 */
	private String RequiredCustomsID;
	/**
	 * The number of units in the goods item that may be returned.
	 */
	private BigDecimal ReturnableQuantity;
	/**
	 * A sequence number differentiating a specific goods item within a consignment.
	 */
	private String SequenceNumberID;
	/**
	 * An identifier for use in tracing this goods item, such as the EPC number used
	 * in RFID.
	 */
	private String TraceID;
	/**
	 * The amount on which a duty, tax, or fee will be assessed.
	 */
	private BigDecimal ValueAmount;
	private Address Origin Address;
	private Allowance Charge Freight Allowance Charge;
	private Delivery m_Delivery;
	private Despatch m_Despatch;
	private Dimension Measurement Dimension;
	private DocumentReference Shipment DocumentReference;
	private Invoice Line m_Invoice Line;
	private Goods Item Contained Goods Item;
	private Goods Item Container m_Goods Item Container;
	private Item m_Item;
	private Package Containing Package;
	private Pickup m_Pickup;
	private Temperature m_Temperature;
	private Temperature Maximum Temperature;
	private Temperature Minimum Temperature;

	public Goods Item(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getChargeableQuantity(){
		return ChargeableQuantity;
	}

	public Measure. Type getChargeableWeightMeasure(){
		return ChargeableWeightMeasure;
	}

	public Goods Item getContained Goods Item(){
		return Contained Goods Item;
	}

	public Package getContaining Package(){
		return Containing Package;
	}

	public boolean getCustomsImportClassifiedIndicator(){
		return CustomsImportClassifiedIndicator;
	}

	public String getCustomsStatusCode(){
		return CustomsStatusCode;
	}

	public BigDecimal getCustomsTariffQuantity(){
		return CustomsTariffQuantity;
	}

	public BigDecimal getDeclaredCustomsValueAmount(){
		return DeclaredCustomsValueAmount;
	}

	public BigDecimal getDeclaredForCarriageValueAmount(){
		return DeclaredForCarriageValueAmount;
	}

	public BigDecimal getDeclaredStatisticsValueAmount(){
		return DeclaredStatisticsValueAmount;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public String getDescription(){
		return Description;
	}

	public Despatch getDespatch(){
		return m_Despatch;
	}

	public BigDecimal getFreeOnBoardValueAmount(){
		return FreeOnBoardValueAmount;
	}

	public Allowance Charge getFreight Allowance Charge(){
		return Freight Allowance Charge;
	}

	public Goods Item Container getGoods Item Container(){
		return m_Goods Item Container;
	}

	public Measure. Type getGrossVolumeMeasure(){
		return GrossVolumeMeasure;
	}

	public Measure. Type getGrossWeightMeasure(){
		return GrossWeightMeasure;
	}

	public boolean getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getInsuranceValueAmount(){
		return InsuranceValueAmount;
	}

	public Invoice Line getInvoice Line(){
		return m_Invoice Line;
	}

	public Item getItem(){
		return m_Item;
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

	public Measure. Type getNetNetWeightMeasure(){
		return NetNetWeightMeasure;
	}

	public Measure. Type getNetVolumeMeasure(){
		return NetVolumeMeasure;
	}

	public Measure. Type getNetWeightMeasure(){
		return NetWeightMeasure;
	}

	public Address getOrigin Address(){
		return Origin Address;
	}

	public Pickup getPickup(){
		return m_Pickup;
	}

	public String getPreferenceCriterionCode(){
		return PreferenceCriterionCode;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public String getRequiredCustomsID(){
		return RequiredCustomsID;
	}

	public BigDecimal getReturnableQuantity(){
		return ReturnableQuantity;
	}

	public String getSequenceNumberID(){
		return SequenceNumberID;
	}

	public DocumentReference getShipment DocumentReference(){
		return Shipment DocumentReference;
	}

	public Temperature getTemperature(){
		return m_Temperature;
	}

	public String getTraceID(){
		return TraceID;
	}

	public BigDecimal getValueAmount(){
		return ValueAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeableQuantity(BigDecimal newVal){
		ChargeableQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeableWeightMeasure(Measure. Type newVal){
		ChargeableWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContained Goods Item(Goods Item newVal){
		Contained Goods Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContaining Package(Package newVal){
		Containing Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomsImportClassifiedIndicator(boolean newVal){
		CustomsImportClassifiedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomsStatusCode(String newVal){
		CustomsStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomsTariffQuantity(BigDecimal newVal){
		CustomsTariffQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredCustomsValueAmount(BigDecimal newVal){
		DeclaredCustomsValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredForCarriageValueAmount(BigDecimal newVal){
		DeclaredForCarriageValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeclaredStatisticsValueAmount(BigDecimal newVal){
		DeclaredStatisticsValueAmount = newVal;
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
	public void setFreeOnBoardValueAmount(BigDecimal newVal){
		FreeOnBoardValueAmount = newVal;
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
	public void setGoods Item Container(Goods Item Container newVal){
		m_Goods Item Container = newVal;
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
	public void setHazardousRiskIndicator(boolean newVal){
		HazardousRiskIndicator = newVal;
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
	public void setInsuranceValueAmount(BigDecimal newVal){
		InsuranceValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoice Line(Invoice Line newVal){
		m_Invoice Line = newVal;
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
	public void setNetNetWeightMeasure(Measure. Type newVal){
		NetNetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetVolumeMeasure(Measure. Type newVal){
		NetVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetWeightMeasure(Measure. Type newVal){
		NetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrigin Address(Address newVal){
		Origin Address = newVal;
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
	public void setPreferenceCriterionCode(String newVal){
		PreferenceCriterionCode = newVal;
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
	public void setRequiredCustomsID(String newVal){
		RequiredCustomsID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReturnableQuantity(BigDecimal newVal){
		ReturnableQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumberID(String newVal){
		SequenceNumberID = newVal;
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
	public void setTemperature(Temperature newVal){
		m_Temperature = newVal;
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
	public void setValueAmount(BigDecimal newVal){
		ValueAmount = newVal;
	}
}//end Goods Item