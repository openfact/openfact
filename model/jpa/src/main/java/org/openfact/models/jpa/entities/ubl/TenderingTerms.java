package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe tendering terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class TenderingTerms {

	/**
	 * Text specifying the things for which variants are accepted.
	 */
	private String AcceptedVariantsDescription;
	/**
	 * Other existing conditions.
	 */
	private String AdditionalConditions;
	/**
	 * A code signifying the awarding method in a tendering process (e.g., a method
	 * favoring the tender with the lowest price or the tender that is most
	 * economically advantageous).
	 */
	private String AwardingMethodTypeCode;
	/**
	 * The amount to be paid to obtain the contract documents and additional
	 * documentation.
	 */
	private BigDecimal DocumentationFeeAmount;
	/**
	 * The Uniform Resource Identifier (URI) of an electronic registry of economic
	 * operators.
	 */
	private String EconomicOperatorRegistryURIID;
	/**
	 * The program that funds the tendering process (e.g., EU 6th Framework Program)
	 * expressed as text.
	 */
	private String FundingProgram;
	/**
	 * The program that funds the tendering process (e.g., "National", "European"),
	 * expressed as a code.
	 */
	private String FundingProgramCode;
	/**
	 * The end date until which the candidates can obtain the necessary level of
	 * security clearance.
	 */
	private LocalDate LatestSecurityClearanceDate;
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private BigDecimal MaximumAdvertisementAmount;
	/**
	 * Maximum number of variants the tenderer is allowed to present for this
	 * tendering project.
	 */
	private BigDecimal MaximumVariantQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * Indicates whether other conditions exist (true) or not (false). If the
	 * indicator is true, the description may be provided.
	 */
	private boolean OtherConditionsIndicator;
	/**
	 * A code signifying the frequency of payment in the contract associated with the
	 * tendering process.
	 */
	private String PaymentFrequencyCode;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private String PriceEvaluationCode;
	/**
	 * Text describing the formula for price revision.
	 */
	private String PriceRevisionFormulaDescription;
	/**
	 * An indicator that tenderers are required to provide a curriculum vitae for each
	 * participant in the project (true) or are not so required (false).
	 */
	private boolean RequiredCurriculaIndicator;
	/**
	 * An indicator that variants are allowed and unconstrained in number (true) or
	 * not allowed (false).
	 */
	private boolean VariantConstraintIndicator;
	private AppealTerms m_AppealTerms;
	private Awarding Terms m_Awarding Terms;
	private Budget Account Line m_Budget Account Line;
	private Clause Penalty Clause;
	private Contract Execution Requirement m_Contract Execution Requirement;
	private DocumentReference Environmental Legislation DocumentReference;
	private DocumentReference Procurement Legislation DocumentReference;
	private DocumentReference Fiscal Legislation DocumentReference;
	private DocumentReference Contractual DocumentReference;
	private DocumentReference Call For Tenders DocumentReference;
	private DocumentReference Employment Legislation DocumentReference;
	private DocumentReference Replaced Notice DocumentReference;
	private FinancialGuarantee Required FinancialGuarantee;
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
	public String getAcceptedVariantsDescription(){
		return AcceptedVariantsDescription;
	}

	public Party getAdditional Information Party(){
		return Additional Information Party;
	}

	public String getAdditionalConditions(){
		return AdditionalConditions;
	}

	public Subcontract Terms getAllowed Subcontract Terms(){
		return Allowed Subcontract Terms;
	}

	public AppealTerms getAppealTerms(){
		return m_AppealTerms;
	}

	public Awarding Terms getAwarding Terms(){
		return m_Awarding Terms;
	}

	public String getAwardingMethodTypeCode(){
		return AwardingMethodTypeCode;
	}

	public Budget Account Line getBudget Account Line(){
		return m_Budget Account Line;
	}

	public DocumentReference getCall For Tenders DocumentReference(){
		return Call For Tenders DocumentReference;
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

	public DocumentReference getContractual DocumentReference(){
		return Contractual DocumentReference;
	}

	public Party getDocument Provider Party(){
		return Document Provider Party;
	}

	public BigDecimal getDocumentationFeeAmount(){
		return DocumentationFeeAmount;
	}

	public String getEconomicOperatorRegistryURIID(){
		return EconomicOperatorRegistryURIID;
	}

	public DocumentReference getEmployment Legislation DocumentReference(){
		return Employment Legislation DocumentReference;
	}

	public DocumentReference getEnvironmental Legislation DocumentReference(){
		return Environmental Legislation DocumentReference;
	}

	public DocumentReference getFiscal Legislation DocumentReference(){
		return Fiscal Legislation DocumentReference;
	}

	public String getFundingProgram(){
		return FundingProgram;
	}

	public String getFundingProgramCode(){
		return FundingProgramCode;
	}

	public Language getLanguage(){
		return m_Language;
	}

	public LocalDate getLatestSecurityClearanceDate(){
		return LatestSecurityClearanceDate;
	}

	public BigDecimal getMaximumAdvertisementAmount(){
		return MaximumAdvertisementAmount;
	}

	public BigDecimal getMaximumVariantQuantity(){
		return MaximumVariantQuantity;
	}

	public String getNote(){
		return Note;
	}

	public boolean getOtherConditionsIndicator(){
		return OtherConditionsIndicator;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public String getPaymentFrequencyCode(){
		return PaymentFrequencyCode;
	}

	public Clause getPenalty Clause(){
		return Penalty Clause;
	}

	public String getPriceEvaluationCode(){
		return PriceEvaluationCode;
	}

	public String getPriceRevisionFormulaDescription(){
		return PriceRevisionFormulaDescription;
	}

	public DocumentReference getProcurement Legislation DocumentReference(){
		return Procurement Legislation DocumentReference;
	}

	public DocumentReference getReplaced Notice DocumentReference(){
		return Replaced Notice DocumentReference;
	}

	public FinancialGuarantee getRequired FinancialGuarantee(){
		return Required FinancialGuarantee;
	}

	public boolean getRequiredCurriculaIndicator(){
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

	public boolean getVariantConstraintIndicator(){
		return VariantConstraintIndicator;
	}

	public Period getWarranty Validity Period(){
		return Warranty Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAcceptedVariantsDescription(String newVal){
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
	public void setAdditionalConditions(String newVal){
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
	public void setAppealTerms(AppealTerms newVal){
		m_AppealTerms = newVal;
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
	public void setAwardingMethodTypeCode(String newVal){
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
	public void setCall For Tenders DocumentReference(DocumentReference newVal){
		Call For Tenders DocumentReference = newVal;
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
	public void setContractual DocumentReference(DocumentReference newVal){
		Contractual DocumentReference = newVal;
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
	public void setDocumentationFeeAmount(BigDecimal newVal){
		DocumentationFeeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEconomicOperatorRegistryURIID(String newVal){
		EconomicOperatorRegistryURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmployment Legislation DocumentReference(DocumentReference newVal){
		Employment Legislation DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmental Legislation DocumentReference(DocumentReference newVal){
		Environmental Legislation DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFiscal Legislation DocumentReference(DocumentReference newVal){
		Fiscal Legislation DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFundingProgram(String newVal){
		FundingProgram = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFundingProgramCode(String newVal){
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
	public void setLatestSecurityClearanceDate(LocalDate newVal){
		LatestSecurityClearanceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAdvertisementAmount(BigDecimal newVal){
		MaximumAdvertisementAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumVariantQuantity(BigDecimal newVal){
		MaximumVariantQuantity = newVal;
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
	public void setOtherConditionsIndicator(boolean newVal){
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
	public void setPaymentFrequencyCode(String newVal){
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
	public void setPriceEvaluationCode(String newVal){
		PriceEvaluationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceRevisionFormulaDescription(String newVal){
		PriceRevisionFormulaDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Legislation DocumentReference(DocumentReference newVal){
		Procurement Legislation DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReplaced Notice DocumentReference(DocumentReference newVal){
		Replaced Notice DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequired FinancialGuarantee(FinancialGuarantee newVal){
		Required FinancialGuarantee = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredCurriculaIndicator(boolean newVal){
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
	public void setVariantConstraintIndicator(boolean newVal){
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