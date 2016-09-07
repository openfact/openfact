package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the awarding of a tender in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:19 a. m.
 */
public class TenderResult {

	/**
	 * The monetary value of the advertisement for this tendering process. 
	 */
	private Amount. Type AdvertisementAmount;
	/**
	 * The date on which this result was formalized.
	 */
	private Date. Type AwardDate;
	/**
	 * The time at which this result was formalized.
	 */
	private Time. Type AwardTime;
	/**
	 * Text describing the result of the tendering process.
	 */
	private Text. Type Description;
	/**
	 * The most expensive tender received in this tendering process.
	 */
	private Amount. Type HigherTenderAmount;
	/**
	 * The least expensive tender received in the tendering process.
	 */
	private Amount. Type LowerTenderAmount;
	/**
	 * The number of electronic tenders received.
	 */
	private Quantity. Type ReceivedElectronicTenderQuantity;
	/**
	 * The number of foreing tenders received.
	 */
	private Quantity. Type ReceivedForeignTenderQuantity;
	/**
	 * The total number of tenders received in this tendering process.
	 */
	private Quantity. Type ReceivedTenderQuantity;
	/**
	 * The date on which the awarded contract begins.
	 */
	private Date. Type StartDate;
	/**
	 * A code signifying the result of the tendering process.
	 */
	private Code. Type TenderResultCode;
	private Contract m_Contract;
	private Period Contract Formalization Period;
	private Subcontract Terms m_Subcontract Terms;
	private Tendered Project Awarded Tendered Project;
	private Winning Party m_Winning Party;

	public Tender Result(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAdvertisementAmount(){
		return AdvertisementAmount;
	}

	public Date. Type getAwardDate(){
		return AwardDate;
	}

	public Tendered Project getAwarded Tendered Project(){
		return Awarded Tendered Project;
	}

	public Time. Type getAwardTime(){
		return AwardTime;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public Period getContract Formalization Period(){
		return Contract Formalization Period;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Amount. Type getHigherTenderAmount(){
		return HigherTenderAmount;
	}

	public Amount. Type getLowerTenderAmount(){
		return LowerTenderAmount;
	}

	public Quantity. Type getReceivedElectronicTenderQuantity(){
		return ReceivedElectronicTenderQuantity;
	}

	public Quantity. Type getReceivedForeignTenderQuantity(){
		return ReceivedForeignTenderQuantity;
	}

	public Quantity. Type getReceivedTenderQuantity(){
		return ReceivedTenderQuantity;
	}

	public Date. Type getStartDate(){
		return StartDate;
	}

	public Subcontract Terms getSubcontract Terms(){
		return m_Subcontract Terms;
	}

	public Code. Type getTenderResultCode(){
		return TenderResultCode;
	}

	public Winning Party getWinning Party(){
		return m_Winning Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdvertisementAmount(Amount. Type newVal){
		AdvertisementAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardDate(Date. Type newVal){
		AwardDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwarded Tendered Project(Tendered Project newVal){
		Awarded Tendered Project = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardTime(Time. Type newVal){
		AwardTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract(Contract newVal){
		m_Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Formalization Period(Period newVal){
		Contract Formalization Period = newVal;
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
	public void setHigherTenderAmount(Amount. Type newVal){
		HigherTenderAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLowerTenderAmount(Amount. Type newVal){
		LowerTenderAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedElectronicTenderQuantity(Quantity. Type newVal){
		ReceivedElectronicTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedForeignTenderQuantity(Quantity. Type newVal){
		ReceivedForeignTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedTenderQuantity(Quantity. Type newVal){
		ReceivedTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(Date. Type newVal){
		StartDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubcontract Terms(Subcontract Terms newVal){
		m_Subcontract Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderResultCode(Code. Type newVal){
		TenderResultCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWinning Party(Winning Party newVal){
		m_Winning Party = newVal;
	}
}//end Tender Result