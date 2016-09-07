

/**
 * A class to describe tendering terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class Tendering Terms {

	/**
	 * Text specifying the things for which variants are accepted.
	 */
	private Text. Type AcceptedVariantsDescription;
	/**
	 * Other existing conditions.
	 */
	private Text. Type AdditionalConditions;
	/**
	 * A code signifying the awarding method in a tendering process (e.g., a method
	 * favoring the tender with the lowest price or the tender that is most
	 * economically advantageous).
	 */
	private Code. Type AwardingMethodTypeCode;
	/**
	 * The amount to be paid to obtain the contract documents and additional
	 * documentation.
	 */
	private Amount. Type DocumentationFeeAmount;
	/**
	 * The Uniform Resource Identifier (URI) of an electronic registry of economic
	 * operators.
	 */
	private Identifier. Type EconomicOperatorRegistryURIID;
	/**
	 * The program that funds the tendering process (e.g., EU 6th Framework Program)
	 * expressed as text.
	 */
	private Text. Type FundingProgram;
	/**
	 * The program that funds the tendering process (e.g., "National", "European"),
	 * expressed as a code.
	 */
	private Code. Type FundingProgramCode;
	/**
	 * The end date until which the candidates can obtain the necessary level of
	 * security clearance.
	 */
	private Date. Type LatestSecurityClearanceDate;
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private Amount. Type MaximumAdvertisementAmount;
	/**
	 * Maximum number of variants the tenderer is allowed to present for this
	 * tendering project.
	 */
	private Quantity. Type MaximumVariantQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * Indicates whether other conditions exist (true) or not (false). If the
	 * indicator is true, the description may be provided.
	 */
	private Indicator. Type OtherConditionsIndicator;
	/**
	 * A code signifying the frequency of payment in the contract associated with the
	 * tendering process.
	 */
	private Code. Type PaymentFrequencyCode;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private Code. Type PriceEvaluationCode;
	/**
	 * Text describing the formula for price revision.
	 */
	private Text. Type PriceRevisionFormulaDescription;
	/**
	 * An indicator that tenderers are required to provide a curriculum vitae for each
	 * participant in the project (true) or are not so required (false).
	 */
	private Indicator. Type RequiredCurriculaIndicator;
	/**
	 * An indicator that variants are allowed and unconstrained in number (true) or
	 * not allowed (false).
	 */
	private Indicator. Type VariantConstraintIndicator;
	private Appeal Terms m_Appeal Terms;
	private Awarding Terms m_Awarding Terms;
	private Budget Account Line m_Budget Account Line;
	private Clause Penalty Clause;
	private Contract Execution Requirement m_Contract Execution Requirement;
	private Document Reference Environmental Legislation Document Reference;
	private Document Reference Procurement Legislation Document Reference;
	private Document Reference Fiscal Legislation Document Reference;
	private Document Reference Contractual Document Reference;
	private Document Reference Call For Tenders Document Reference;
	private Document Reference Employment Legislation Document Reference;
	private Document Reference Replaced Notice Document Reference;
	private Financial Guarantee Required Financial Guarantee;
	private Language m_Language;
	private Party Tender Evaluation Party;
	private Party Contract Responsible Party;
	private Party Tender Recipient Party;
	private Party Document Provider Party;
	private Party Additional Information Party;
	private Payment Terms m_Payment Terms;
	private Period Warranty Validity Period;
	private Period Tender Validity Period;
	private Period Contract Acceptance Period;
	private Subcontract Terms Allowed Subcontract Terms;
	private Tender Preparation m_Tender Preparation;
	private Tenderer Qualification Request m_Tenderer Qualification Request;

	public Tendering Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getAcceptedVariantsDescription(){
		return AcceptedVariantsDescription;
	}

	public Party getAdditional Information Party(){
		return Additional Information Party;
	}

	public Text. Type getAdditionalConditions(){
		return AdditionalConditions;
	}

	public Subcontract Terms getAllowed Subcontract Terms(){
		return Allowed Subcontract Terms;
	}

	public Appeal Terms getAppeal Terms(){
		return m_Appeal Terms;
	}

	public Awarding Terms getAwarding Terms(){
		return m_Awarding Terms;
	}

	public Code. Type getAwardingMethodTypeCode(){
		return AwardingMethodTypeCode;
	}

	public Budget Account Line getBudget Account Line(){
		return m_Budget Account Line;
	}

	public Document Reference getCall For Tenders Document Reference(){
		return Call For Tenders Document Reference;
	}

	public Period getContract Acceptance Period(){
		return Contract Acceptance Period;
	}

	public Contract Execution Requirement getContract Execution Requirement(){
		return m_Contract Execution Requirement;
	}

	public Party getContract Responsible Party(){
		return Contract Responsible Party;
	}

	public Document Reference getContractual Document Reference(){
		return Contractual Document Reference;
	}

	public Party getDocument Provider Party(){
		return Document Provider Party;
	}

	public Amount. Type getDocumentationFeeAmount(){
		return DocumentationFeeAmount;
	}

	public Identifier. Type getEconomicOperatorRegistryURIID(){
		return EconomicOperatorRegistryURIID;
	}

	public Document Reference getEmployment Legislation Document Reference(){
		return Employment Legislation Document Reference;
	}

	public Document Reference getEnvironmental Legislation Document Reference(){
		return Environmental Legislation Document Reference;
	}

	public Document Reference getFiscal Legislation Document Reference(){
		return Fiscal Legislation Document Reference;
	}

	public Text. Type getFundingProgram(){
		return FundingProgram;
	}

	public Code. Type getFundingProgramCode(){
		return FundingProgramCode;
	}

	public Language getLanguage(){
		return m_Language;
	}

	public Date. Type getLatestSecurityClearanceDate(){
		return LatestSecurityClearanceDate;
	}

	public Amount. Type getMaximumAdvertisementAmount(){
		return MaximumAdvertisementAmount;
	}

	public Quantity. Type getMaximumVariantQuantity(){
		return MaximumVariantQuantity;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Indicator. Type getOtherConditionsIndicator(){
		return OtherConditionsIndicator;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public Code. Type getPaymentFrequencyCode(){
		return PaymentFrequencyCode;
	}

	public Clause getPenalty Clause(){
		return Penalty Clause;
	}

	public Code. Type getPriceEvaluationCode(){
		return PriceEvaluationCode;
	}

	public Text. Type getPriceRevisionFormulaDescription(){
		return PriceRevisionFormulaDescription;
	}

	public Document Reference getProcurement Legislation Document Reference(){
		return Procurement Legislation Document Reference;
	}

	public Document Reference getReplaced Notice Document Reference(){
		return Replaced Notice Document Reference;
	}

	public Financial Guarantee getRequired Financial Guarantee(){
		return Required Financial Guarantee;
	}

	public Indicator. Type getRequiredCurriculaIndicator(){
		return RequiredCurriculaIndicator;
	}

	public Party getTender Evaluation Party(){
		return Tender Evaluation Party;
	}

	public Tender Preparation getTender Preparation(){
		return m_Tender Preparation;
	}

	public Party getTender Recipient Party(){
		return Tender Recipient Party;
	}

	public Period getTender Validity Period(){
		return Tender Validity Period;
	}

	public Tenderer Qualification Request getTenderer Qualification Request(){
		return m_Tenderer Qualification Request;
	}

	public Indicator. Type getVariantConstraintIndicator(){
		return VariantConstraintIndicator;
	}

	public Period getWarranty Validity Period(){
		return Warranty Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAcceptedVariantsDescription(Text. Type newVal){
		AcceptedVariantsDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Information Party(Party newVal){
		Additional Information Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditionalConditions(Text. Type newVal){
		AdditionalConditions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowed Subcontract Terms(Subcontract Terms newVal){
		Allowed Subcontract Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAppeal Terms(Appeal Terms newVal){
		m_Appeal Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwarding Terms(Awarding Terms newVal){
		m_Awarding Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingMethodTypeCode(Code. Type newVal){
		AwardingMethodTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBudget Account Line(Budget Account Line newVal){
		m_Budget Account Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall For Tenders Document Reference(Document Reference newVal){
		Call For Tenders Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Acceptance Period(Period newVal){
		Contract Acceptance Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Execution Requirement(Contract Execution Requirement newVal){
		m_Contract Execution Requirement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Responsible Party(Party newVal){
		Contract Responsible Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractual Document Reference(Document Reference newVal){
		Contractual Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Provider Party(Party newVal){
		Document Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentationFeeAmount(Amount. Type newVal){
		DocumentationFeeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEconomicOperatorRegistryURIID(Identifier. Type newVal){
		EconomicOperatorRegistryURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmployment Legislation Document Reference(Document Reference newVal){
		Employment Legislation Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmental Legislation Document Reference(Document Reference newVal){
		Environmental Legislation Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFiscal Legislation Document Reference(Document Reference newVal){
		Fiscal Legislation Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFundingProgram(Text. Type newVal){
		FundingProgram = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFundingProgramCode(Code. Type newVal){
		FundingProgramCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLanguage(Language newVal){
		m_Language = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestSecurityClearanceDate(Date. Type newVal){
		LatestSecurityClearanceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAdvertisementAmount(Amount. Type newVal){
		MaximumAdvertisementAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumVariantQuantity(Quantity. Type newVal){
		MaximumVariantQuantity = newVal;
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
	public void setOtherConditionsIndicator(Indicator. Type newVal){
		OtherConditionsIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentFrequencyCode(Code. Type newVal){
		PaymentFrequencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenalty Clause(Clause newVal){
		Penalty Clause = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceEvaluationCode(Code. Type newVal){
		PriceEvaluationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceRevisionFormulaDescription(Text. Type newVal){
		PriceRevisionFormulaDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Legislation Document Reference(Document Reference newVal){
		Procurement Legislation Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReplaced Notice Document Reference(Document Reference newVal){
		Replaced Notice Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequired Financial Guarantee(Financial Guarantee newVal){
		Required Financial Guarantee = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredCurriculaIndicator(Indicator. Type newVal){
		RequiredCurriculaIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Evaluation Party(Party newVal){
		Tender Evaluation Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Preparation(Tender Preparation newVal){
		m_Tender Preparation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Recipient Party(Party newVal){
		Tender Recipient Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Validity Period(Period newVal){
		Tender Validity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderer Qualification Request(Tenderer Qualification Request newVal){
		m_Tenderer Qualification Request = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVariantConstraintIndicator(Indicator. Type newVal){
		VariantConstraintIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarranty Validity Period(Period newVal){
		Warranty Validity Period = newVal;
	}
}//end Tendering Terms