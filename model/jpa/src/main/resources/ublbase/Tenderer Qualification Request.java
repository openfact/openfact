

/**
 * The evaluation that the Contracting Authority party requests to fulfill to the
 * tenderers.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class Tenderer Qualification Request {

	/**
	 * The legal status requested for potential tenderers, expressed as text
	 */
	private Text. Type CompanyLegalForm;
	/**
	 * The legal status requested for potential tenderers, expressed as a code.
	 */
	private Code. Type CompanyLegalFormCode;
	/**
	 * Text describing the evaluation requirements for this tenderer.
	 */
	private Text. Type Description;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private Quantity. Type EmployeeQuantity;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private Quantity. Type OperatingYearsQuantity;
	/**
	 * Text describing the personal situation of the economic operators in this
	 * tendering process.
	 */
	private Text. Type PersonalSituation;
	private Classification Scheme Required Business Classification Scheme;
	private Economic Operator Role m_Economic Operator Role;
	private Evaluation Criterion Technical Evaluation Criterion;
	private Tendering Terms Financial Evaluation Criterion;
	private Tenderer Requirement Specific Tenderer Requirement;

	public Tenderer Qualification Request(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getCompanyLegalForm(){
		return CompanyLegalForm;
	}

	public Code. Type getCompanyLegalFormCode(){
		return CompanyLegalFormCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Economic Operator Role getEconomic Operator Role(){
		return m_Economic Operator Role;
	}

	public Quantity. Type getEmployeeQuantity(){
		return EmployeeQuantity;
	}

	public Tendering Terms getFinancial Evaluation Criterion(){
		return Financial Evaluation Criterion;
	}

	public Quantity. Type getOperatingYearsQuantity(){
		return OperatingYearsQuantity;
	}

	public Text. Type getPersonalSituation(){
		return PersonalSituation;
	}

	public Classification Scheme getRequired Business Classification Scheme(){
		return Required Business Classification Scheme;
	}

	public Tenderer Requirement getSpecific Tenderer Requirement(){
		return Specific Tenderer Requirement;
	}

	public Evaluation Criterion getTechnical Evaluation Criterion(){
		return Technical Evaluation Criterion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLegalForm(Text. Type newVal){
		CompanyLegalForm = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyLegalFormCode(Code. Type newVal){
		CompanyLegalFormCode = newVal;
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
	public void setEconomic Operator Role(Economic Operator Role newVal){
		m_Economic Operator Role = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmployeeQuantity(Quantity. Type newVal){
		EmployeeQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinancial Evaluation Criterion(Tendering Terms newVal){
		Financial Evaluation Criterion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOperatingYearsQuantity(Quantity. Type newVal){
		OperatingYearsQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPersonalSituation(Text. Type newVal){
		PersonalSituation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequired Business Classification Scheme(Classification Scheme newVal){
		Required Business Classification Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecific Tenderer Requirement(Tenderer Requirement newVal){
		Specific Tenderer Requirement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnical Evaluation Criterion(Evaluation Criterion newVal){
		Technical Evaluation Criterion = newVal;
	}
}//end Tenderer Qualification Request