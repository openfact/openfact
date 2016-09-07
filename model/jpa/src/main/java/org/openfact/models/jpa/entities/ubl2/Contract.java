

/**
 * A class to describe a contract.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class Contract {

	/**
	 * The type of this contract, expressed as text, such as "Cost plus award fee" and
	 * "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private Text. Type ContractType;
	/**
	 * The type of this contract, expressed as a code, such as "Cost plus award fee"
	 * and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private Code. Type ContractTypeCode;
	/**
	 * Text describing this contract.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this contract.
	 */
	private Identifier. Type ID;
	/**
	 * The date on which this contract was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which this contract was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * In a transportation contract, the deadline date by which the services referred
	 * to in the transport execution plan have to be booked. For example, if this
	 * service is a carrier service scheduled for Wednesday 16 February 2011 at 10 a.m.
	 * CET, the nomination 
	 */
	private Date. Type NominationDate;
	/**
	 * In a transportation contract, the deadline time by which the services referred
	 * to in the transport execution plan have to be booked. For example, if this
	 * service is a carrier service scheduled for Wednesday 16 February 2011 at 10 a.m.
	 * CET, the nomination 
	 */
	private Time. Type NominationTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An identifier for the current version of this contract.
	 */
	private Identifier. Type VersionID;
	private Delivery Contractual Delivery;
	private Document Reference Contract Document Reference;
	private Period Validity Period;
	private Period Nomination Period;

	public Contract(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getContract Document Reference(){
		return Contract Document Reference;
	}

	public Text. Type getContractType(){
		return ContractType;
	}

	public Code. Type getContractTypeCode(){
		return ContractTypeCode;
	}

	public Delivery getContractual Delivery(){
		return Contractual Delivery;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Period getNomination Period(){
		return Nomination Period;
	}

	public Date. Type getNominationDate(){
		return NominationDate;
	}

	public Time. Type getNominationTime(){
		return NominationTime;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	public Identifier. Type getVersionID(){
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Document Reference(Document Reference newVal){
		Contract Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractType(Text. Type newVal){
		ContractType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractTypeCode(Code. Type newVal){
		ContractTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractual Delivery(Delivery newVal){
		Contractual Delivery = newVal;
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNomination Period(Period newVal){
		Nomination Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNominationDate(Date. Type newVal){
		NominationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNominationTime(Time. Type newVal){
		NominationTime = newVal;
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
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(Identifier. Type newVal){
		VersionID = newVal;
	}
}//end Contract