package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a project to procure goods, works, or services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:04 a. m.
 */
public class ProcurementProject {

	/**
	 * Text describing this procurement project.
	 */
	private String Description;
	/**
	 * The estimated overall quantity for this procurement project.
	 */
	private BigDecimal EstimatedOverallContractQuantity;
	/**
	 * Text describing the reimbursement fee for concession procurement projects.
	 */
	private String FeeDescription;
	/**
	 * An identifier for this procurement project.
	 */
	private String ID;
	/**
	 * A name of this procurement project.
	 */
	private String Name;
	/**
	 * Free-form text applying to the Procurement Project. This element may contain
	 * additional information about the lot/contract that is not contained explicitly
	 * in another structure.
	 */
	private String Note;
	/**
	 * A code signifying the subcategory of the type of work for this project (e.g.,
	 * land surveying, IT consulting).
	 */
	private String ProcurementSubTypeCode;
	/**
	 * A code signifying the type of procurement project (e.g., goods, works,
	 * services).
	 */
	private String ProcurementTypeCode;
	/**
	 * The indication of whether or not the control quality is included in the works
	 * project.
	 */
	private String QualityControlCode;
	/**
	 * The requested delivery date for this procurement project.
	 */
	private LocalDate RequestedDeliveryDate;
	/**
	 * The amount of the reimbursement fee for concession procurement projects.
	 */
	private BigDecimal RequiredFeeAmount;
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

	public String getDescription(){
		return Description;
	}

	public BigDecimal getEstimatedOverallContractQuantity(){
		return EstimatedOverallContractQuantity;
	}

	public String getFeeDescription(){
		return FeeDescription;
	}

	public String getID(){
		return ID;
	}

	public Commodity Classification getMain Commodity Classification(){
		return Main Commodity Classification;
	}

	public String getName(){
		return Name;
	}

	public String getNote(){
		return Note;
	}

	public Period getPlanned Period(){
		return Planned Period;
	}

	public String getProcurementSubTypeCode(){
		return ProcurementSubTypeCode;
	}

	public String getProcurementTypeCode(){
		return ProcurementTypeCode;
	}

	public String getQualityControlCode(){
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

	public LocalDate getRequestedDeliveryDate(){
		return RequestedDeliveryDate;
	}

	public BigDecimal getRequiredFeeAmount(){
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedOverallContractQuantity(BigDecimal newVal){
		EstimatedOverallContractQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeDescription(String newVal){
		FeeDescription = newVal;
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
	public void setMain Commodity Classification(Commodity Classification newVal){
		Main Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
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
	public void setProcurementSubTypeCode(String newVal){
		ProcurementSubTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementTypeCode(String newVal){
		ProcurementTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQualityControlCode(String newVal){
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
	public void setRequestedDeliveryDate(LocalDate newVal){
		RequestedDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredFeeAmount(BigDecimal newVal){
		RequiredFeeAmount = newVal;
	}
}//end Procurement Project