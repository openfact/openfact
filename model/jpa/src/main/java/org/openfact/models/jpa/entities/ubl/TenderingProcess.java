package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the process of a formal offer and response to execute work
 * or supply goods at a stated price.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:27 a. m.
 */
public class TenderingProcess {

	/**
	 * An indicator that the number of candidates participating in this process has
	 * been reduced (true) or not (false).
	 */
	private boolean CandidateReductionConstraintIndicator;
	/**
	 * A code signifying the type of contracting system (e.g., framework agreement,
	 * dynamic purchasing system). If the procedure is individual (nonrepetitive),
	 * this code should be omitted.
	 */
	private String ContractingSystemCode;
	/**
	 * Text describing the tendering process.
	 */
	private String Description;
	/**
	 * A code signifying the type of expense for this tendering process.
	 */
	private String ExpenseCode;
	/**
	 * An indicator that the project associated with this tendering process is
	 * constrained by a government procurement agreement (true) or not (false).
	 */
	private boolean GovernmentAgreementConstraintIndicator;
	/**
	 * An identifier for this tendering process.
	 */
	private String ID;
	/**
	 * Text describing the negotiation to be followed during the tendering process.
	 */
	private String NegotiationDescription;
	/**
	 * When reopening a tendering process, the identifier of the original framework
	 * agreement or dynamic purchasing system.
	 */
	private String OriginalContractingSystemID;
	/**
	 * A code signifying the type of presentation of tenders required (e.g., one lot,
	 * multiple lots, or all the lots).
	 */
	private String PartPresentationCode;
	/**
	 * A code signifying the type of this tendering procedure.
	 */
	private String ProcedureCode;
	/**
	 * A code signifying the method to be followed in submitting tenders.
	 */
	private String SubmissionMethodCode;
	/**
	 * A code signifying the urgency of this tendering process.
	 */
	private String UrgencyCode;
	private Auction Terms m_Auction Terms;
	private Document Reference Notice Document Reference;
	private Document Reference Additional Document Reference;
	private Economic Operator Short List m_Economic Operator Short List;
	private Event Open Tender Event;
	private Framework Agreement m_Framework Agreement;
	private Period Participation Request Reception Period;
	private Period Invitation Submission Period;
	private Period Tender Submission Deadline Period;
	private Period Document Availability Period;
	private Process Justification m_Process Justification;

	public Tendering Process(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Auction Terms getAuction Terms(){
		return m_Auction Terms;
	}

	public boolean getCandidateReductionConstraintIndicator(){
		return CandidateReductionConstraintIndicator;
	}

	public String getContractingSystemCode(){
		return ContractingSystemCode;
	}

	public String getDescription(){
		return Description;
	}

	public Period getDocument Availability Period(){
		return Document Availability Period;
	}

	public Economic Operator Short List getEconomic Operator Short List(){
		return m_Economic Operator Short List;
	}

	public String getExpenseCode(){
		return ExpenseCode;
	}

	public Framework Agreement getFramework Agreement(){
		return m_Framework Agreement;
	}

	public boolean getGovernmentAgreementConstraintIndicator(){
		return GovernmentAgreementConstraintIndicator;
	}

	public String getID(){
		return ID;
	}

	public Period getInvitation Submission Period(){
		return Invitation Submission Period;
	}

	public String getNegotiationDescription(){
		return NegotiationDescription;
	}

	public Document Reference getNotice Document Reference(){
		return Notice Document Reference;
	}

	public Event getOpen Tender Event(){
		return Open Tender Event;
	}

	public String getOriginalContractingSystemID(){
		return OriginalContractingSystemID;
	}

	public Period getParticipation Request Reception Period(){
		return Participation Request Reception Period;
	}

	public String getPartPresentationCode(){
		return PartPresentationCode;
	}

	public String getProcedureCode(){
		return ProcedureCode;
	}

	public Process Justification getProcess Justification(){
		return m_Process Justification;
	}

	public String getSubmissionMethodCode(){
		return SubmissionMethodCode;
	}

	public Period getTender Submission Deadline Period(){
		return Tender Submission Deadline Period;
	}

	public String getUrgencyCode(){
		return UrgencyCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAuction Terms(Auction Terms newVal){
		m_Auction Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCandidateReductionConstraintIndicator(boolean newVal){
		CandidateReductionConstraintIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractingSystemCode(String newVal){
		ContractingSystemCode = newVal;
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
	public void setDocument Availability Period(Period newVal){
		Document Availability Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEconomic Operator Short List(Economic Operator Short List newVal){
		m_Economic Operator Short List = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpenseCode(String newVal){
		ExpenseCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFramework Agreement(Framework Agreement newVal){
		m_Framework Agreement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGovernmentAgreementConstraintIndicator(boolean newVal){
		GovernmentAgreementConstraintIndicator = newVal;
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
	public void setInvitation Submission Period(Period newVal){
		Invitation Submission Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNegotiationDescription(String newVal){
		NegotiationDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotice Document Reference(Document Reference newVal){
		Notice Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOpen Tender Event(Event newVal){
		Open Tender Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginalContractingSystemID(String newVal){
		OriginalContractingSystemID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParticipation Request Reception Period(Period newVal){
		Participation Request Reception Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartPresentationCode(String newVal){
		PartPresentationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcedureCode(String newVal){
		ProcedureCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcess Justification(Process Justification newVal){
		m_Process Justification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubmissionMethodCode(String newVal){
		SubmissionMethodCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Submission Deadline Period(Period newVal){
		Tender Submission Deadline Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUrgencyCode(String newVal){
		UrgencyCode = newVal;
	}
}//end Tendering Process