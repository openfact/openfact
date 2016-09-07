

/**
 * A class to describe terms applying to a transport execution plan.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:44 a. m.
 */
public class TransportExecutionTerms {

	/**
	 * Text describing conditions applying to a change of these transport execution
	 * terms.
	 */
	private Text. Type ChangeConditions;
	/**
	 * Text describing special terms specified by the transport service provider.
	 */
	private Text. Type TransportServiceProviderSpecialTerms;
	/**
	 * Text describing special terms specified by the transport user.
	 */
	private Text. Type TransportUserSpecialTerms;
	private Delivery Terms m_Delivery Terms;
	private Environmental Emission m_Environmental Emission;
	private Notification Requirement m_Notification Requirement;
	private Payment Terms Bonus Payment Terms;
	private Payment Terms Commission Payment Terms;
	private Payment Terms Penalty Payment Terms;
	private Payment Terms Service Charge Payment Terms;
	private Payment Terms m_Payment Terms;

	public Transport Execution Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Payment Terms getBonus Payment Terms(){
		return Bonus Payment Terms;
	}

	public Text. Type getChangeConditions(){
		return ChangeConditions;
	}

	public Payment Terms getCommission Payment Terms(){
		return Commission Payment Terms;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Environmental Emission getEnvironmental Emission(){
		return m_Environmental Emission;
	}

	public Notification Requirement getNotification Requirement(){
		return m_Notification Requirement;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public Payment Terms getPenalty Payment Terms(){
		return Penalty Payment Terms;
	}

	public Payment Terms getService Charge Payment Terms(){
		return Service Charge Payment Terms;
	}

	public Text. Type getTransportServiceProviderSpecialTerms(){
		return TransportServiceProviderSpecialTerms;
	}

	public Text. Type getTransportUserSpecialTerms(){
		return TransportUserSpecialTerms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBonus Payment Terms(Payment Terms newVal){
		Bonus Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChangeConditions(Text. Type newVal){
		ChangeConditions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCommission Payment Terms(Payment Terms newVal){
		Commission Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmental Emission(Environmental Emission newVal){
		m_Environmental Emission = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotification Requirement(Notification Requirement newVal){
		m_Notification Requirement = newVal;
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
	public void setPenalty Payment Terms(Payment Terms newVal){
		Penalty Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService Charge Payment Terms(Payment Terms newVal){
		Service Charge Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportServiceProviderSpecialTerms(Text. Type newVal){
		TransportServiceProviderSpecialTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportUserSpecialTerms(Text. Type newVal){
		TransportUserSpecialTerms = newVal;
	}
}//end Transport Execution Terms