

/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantity {

	/**
	 * An indication that the transported item, as delivered, in the stated quantity
	 * to the stated location, is subject to an international regulation concerning
	 * the carriage of dangerous goods (true) or not (false).
	 */
	private Indicator. Type HazardousRiskIndicator;
	/**
	 * The lead time, i.e., the time taken from the time at which an item is ordered
	 * to the time of its delivery.
	 */
	private Measure. Type LeadTimeMeasure;
	/**
	 * The maximum quantity that can be ordered to qualify for a specific price.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum quantity that can be ordered to qualify for a specific price.
	 */
	private Quantity. Type MinimumQuantity;
	/**
	 * Text describing trade restrictions on the quantity of this item or on the item
	 * itself.
	 */
	private Text. Type TradingRestrictions;
	private Address Applicable Territory Address;
	private Allowance Charge m_Allowance Charge;
	private Delivery Unit m_Delivery Unit;
	private Dependent Price Reference m_Dependent Price Reference;
	private Package m_Package;
	private Price m_Price;
	private Tax Category Applicable Tax Category;

	public Item Location Quantity(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Tax Category getApplicable Tax Category(){
		return Applicable Tax Category;
	}

	public Address getApplicable Territory Address(){
		return Applicable Territory Address;
	}

	public Delivery Unit getDelivery Unit(){
		return m_Delivery Unit;
	}

	public Dependent Price Reference getDependent Price Reference(){
		return m_Dependent Price Reference;
	}

	public Indicator. Type getHazardousRiskIndicator(){
		return HazardousRiskIndicator;
	}

	public Measure. Type getLeadTimeMeasure(){
		return LeadTimeMeasure;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Package getPackage(){
		return m_Package;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Text. Type getTradingRestrictions(){
		return TradingRestrictions;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Tax Category(Tax Category newVal){
		Applicable Tax Category = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Territory Address(Address newVal){
		Applicable Territory Address = newVal;
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
	public void setDependent Price Reference(Dependent Price Reference newVal){
		m_Dependent Price Reference = newVal;
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
	public void setLeadTimeMeasure(Measure. Type newVal){
		LeadTimeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(Quantity. Type newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(Quantity. Type newVal){
		MinimumQuantity = newVal;
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
	public void setPrice(Price newVal){
		m_Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTradingRestrictions(Text. Type newVal){
		TradingRestrictions = newVal;
	}
}//end Item Location Quantity