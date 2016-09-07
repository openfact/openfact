

/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class Billing Reference {

	private Billing Reference Line m_Billing Reference Line;
	private Document Reference Self Billed Invoice Document Reference;
	private Document Reference Self Billed Credit Note Document Reference;
	private Document Reference Reminder Document Reference;
	private Document Reference Credit Note Document Reference;
	private Document Reference Debit Note Document Reference;
	private Document Reference Invoice Document Reference;
	private Document Reference Additional Document Reference;

	public Billing Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Billing Reference Line getBilling Reference Line(){
		return m_Billing Reference Line;
	}

	public Document Reference getCredit Note Document Reference(){
		return Credit Note Document Reference;
	}

	public Document Reference getDebit Note Document Reference(){
		return Debit Note Document Reference;
	}

	public Document Reference getInvoice Document Reference(){
		return Invoice Document Reference;
	}

	public Document Reference getReminder Document Reference(){
		return Reminder Document Reference;
	}

	public Document Reference getSelf Billed Credit Note Document Reference(){
		return Self Billed Credit Note Document Reference;
	}

	public Document Reference getSelf Billed Invoice Document Reference(){
		return Self Billed Invoice Document Reference;
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
	public void setBilling Reference Line(Billing Reference Line newVal){
		m_Billing Reference Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCredit Note Document Reference(Document Reference newVal){
		Credit Note Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebit Note Document Reference(Document Reference newVal){
		Debit Note Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoice Document Reference(Document Reference newVal){
		Invoice Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReminder Document Reference(Document Reference newVal){
		Reminder Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSelf Billed Credit Note Document Reference(Document Reference newVal){
		Self Billed Credit Note Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSelf Billed Invoice Document Reference(Document Reference newVal){
		Self Billed Invoice Document Reference = newVal;
	}
}//end Billing Reference