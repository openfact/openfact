

/**
 * A class to describe a project to procure goods, works, or services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class Procurement Project {

	/**
	 * Text describing this procurement project.
	 */
	private Text. Type Description;
	/**
	 * The estimated overall quantity for this procurement project.
	 */
	private Quantity. Type EstimatedOverallContractQuantity;
	/**
	 * Text describing the reimbursement fee for concession procurement projects.
	 */
	private Text. Type FeeDescription;
	/**
	 * An identifier for this procurement project.
	 */
	private Identifier. Type ID;
	/**
	 * A name of this procurement project.
	 */
	private Name. Type Name;
	/**
	 * Free-form text applying to the Procurement Project. This element may contain
	 * additional information about the lot/contract that is not contained explicitly
	 * in another structure.
	 */
	private Text. Type Note;
	/**
	 * A code signifying the subcategory of the type of work for this project (e.g.,
	 * land surveying, IT consulting).
	 */
	private Code. Type ProcurementSubTypeCode;
	/**
	 * A code signifying the type of procurement project (e.g., goods, works,
	 * services).
	 */
	private Code. Type ProcurementTypeCode;
	/**
	 * The indication of whether or not the control quality is included in the works
	 * project.
	 */
	private Code. Type QualityControlCode;
	/**
	 * The requested delivery date for this procurement project.
	 */
	private Date. Type RequestedDeliveryDate;
	/**
	 * The amount of the reimbursement fee for concession procurement projects.
	 */
	private Amount. Type RequiredFeeAmount;
	private Commodity Classification Additional Commodity Classification;
	private Commodity Classification Main Commodity Classification;
	private Contract Extension m_Contract Extension;
	private Location Realized Location;
	private Period Planned Period;
	private Requested Tender Total m_Requested Tender Total;
	private Request For Tender Line m_Request For Tender Line;

	public Procurement Project(){

	}

	public void finalize() throws Throwable {

	}
	public Commodity Classification getAdditional Commodity Classification(){
		return Additional Commodity Classification;
	}

	public Contract Extension getContract Extension(){
		return m_Contract Extension;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Quantity. Type getEstimatedOverallContractQuantity(){
		return EstimatedOverallContractQuantity;
	}

	public Text. Type getFeeDescription(){
		return FeeDescription;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Commodity Classification getMain Commodity Classification(){
		return Main Commodity Classification;
	}

	public Name. Type getName(){
		return Name;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Period getPlanned Period(){
		return Planned Period;
	}

	public Code. Type getProcurementSubTypeCode(){
		return ProcurementSubTypeCode;
	}

	public Code. Type getProcurementTypeCode(){
		return ProcurementTypeCode;
	}

	public Code. Type getQualityControlCode(){
		return QualityControlCode;
	}

	public Location getRealized Location(){
		return Realized Location;
	}

	public Request For Tender Line getRequest For Tender Line(){
		return m_Request For Tender Line;
	}

	public Requested Tender Total getRequested Tender Total(){
		return m_Requested Tender Total;
	}

	public Date. Type getRequestedDeliveryDate(){
		return RequestedDeliveryDate;
	}

	public Amount. Type getRequiredFeeAmount(){
		return RequiredFeeAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Commodity Classification(Commodity Classification newVal){
		Additional Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Extension(Contract Extension newVal){
		m_Contract Extension = newVal;
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
	public void setEstimatedOverallContractQuantity(Quantity. Type newVal){
		EstimatedOverallContractQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeDescription(Text. Type newVal){
		FeeDescription = newVal;
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
	public void setMain Commodity Classification(Commodity Classification newVal){
		Main Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Period(Period newVal){
		Planned Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementSubTypeCode(Code. Type newVal){
		ProcurementSubTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementTypeCode(Code. Type newVal){
		ProcurementTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQualityControlCode(Code. Type newVal){
		QualityControlCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRealized Location(Location newVal){
		Realized Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequest For Tender Line(Request For Tender Line newVal){
		m_Request For Tender Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Tender Total(Requested Tender Total newVal){
		m_Requested Tender Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequestedDeliveryDate(Date. Type newVal){
		RequestedDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredFeeAmount(Amount. Type newVal){
		RequiredFeeAmount = newVal;
	}
}//end Procurement Project