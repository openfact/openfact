

/**
 * A class to describe a means of payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
public class PaymentMeans {

	/**
	 * An identifier for this means of payment.
	 */
	private Identifier. Type ID;
	/**
	 * An identifier for the payment instruction.
	 */
	private Identifier. Type InstructionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type InstructionNote;
	/**
	 * A code signifying the payment channel for this means of payment.
	 */
	private Code. Type PaymentChannelCode;
	/**
	 * The date on which payment is due for this means of payment.
	 */
	private Date. Type PaymentDueDate;
	/**
	 * An identifier for a payment made using this means of payment.
	 */
	private Identifier. Type PaymentID;
	/**
	 * A code signifying the type of this means of payment.
	 */
	private Payment Means_ Code. Type PaymentMeansCode;
	private Card Account m_Card Account;
	private Credit Account m_Credit Account;
	private Financial Account Payee Financial Account;
	private Financial Account Payer Financial Account;
	private Payment Mandate m_Payment Mandate;
	private Trade Financing m_Trade Financing;

	public Payment Means(){

	}

	public void finalize() throws Throwable {

	}
	public Card Account getCard Account(){
		return m_Card Account;
	}

	public Credit Account getCredit Account(){
		return m_Credit Account;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getInstructionID(){
		return InstructionID;
	}

	public Text. Type getInstructionNote(){
		return InstructionNote;
	}

	public Financial Account getPayee Financial Account(){
		return Payee Financial Account;
	}

	public Financial Account getPayer Financial Account(){
		return Payer Financial Account;
	}

	public Payment Mandate getPayment Mandate(){
		return m_Payment Mandate;
	}

	public Code. Type getPaymentChannelCode(){
		return PaymentChannelCode;
	}

	public Date. Type getPaymentDueDate(){
		return PaymentDueDate;
	}

	public Identifier. Type getPaymentID(){
		return PaymentID;
	}

	public Payment Means_ Code. Type getPaymentMeansCode(){
		return PaymentMeansCode;
	}

	public Trade Financing getTrade Financing(){
		return m_Trade Financing;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCard Account(Card Account newVal){
		m_Card Account = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCredit Account(Credit Account newVal){
		m_Credit Account = newVal;
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
	public void setInstructionID(Identifier. Type newVal){
		InstructionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInstructionNote(Text. Type newVal){
		InstructionNote = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayee Financial Account(Financial Account newVal){
		Payee Financial Account = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayer Financial Account(Financial Account newVal){
		Payer Financial Account = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Mandate(Payment Mandate newVal){
		m_Payment Mandate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentChannelCode(Code. Type newVal){
		PaymentChannelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentDueDate(Date. Type newVal){
		PaymentDueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentID(Identifier. Type newVal){
		PaymentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentMeansCode(Payment Means_ Code. Type newVal){
		PaymentMeansCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrade Financing(Trade Financing newVal){
		m_Trade Financing = newVal;
	}
}//end Payment Means