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
	private BigDecimal AdvertisementAmount;
	/**
	 * The date on which this result was formalized.
	 */
	private LocalDate AwardDate;
	/**
	 * The time at which this result was formalized.
	 */
	private LocalTime AwardTime;
	/**
	 * Text describing the result of the tendering process.
	 */
	private String Description;
	/**
	 * The most expensive tender received in this tendering process.
	 */
	private BigDecimal HigherTenderAmount;
	/**
	 * The least expensive tender received in the tendering process.
	 */
	private BigDecimal LowerTenderAmount;
	/**
	 * The number of electronic tenders received.
	 */
	private BigDecimal ReceivedElectronicTenderQuantity;
	/**
	 * The number of foreing tenders received.
	 */
	private BigDecimal ReceivedForeignTenderQuantity;
	/**
	 * The total number of tenders received in this tendering process.
	 */
	private BigDecimal ReceivedTenderQuantity;
	/**
	 * The date on which the awarded contract begins.
	 */
	private LocalDate StartDate;
	/**
	 * A code signifying the result of the tendering process.
	 */
	private String TenderResultCode;
	private Contract m_Contract;
	private Period Contract Formalization Period;
	private Subcontract Terms m_Subcontract Terms;
	private Tendered Project Awarded Tendered Project;
	private Winning Party m_Winning Party;

	public TenderResult(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getAdvertisementAmount(){
		return AdvertisementAmount;
	}

	public LocalDate getAwardDate(){
		return AwardDate;
	}

	public Tendered Project getAwarded Tendered Project(){
		return Awarded Tendered Project;
	}

	public LocalTime getAwardTime(){
		return AwardTime;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public Period getContract Formalization Period(){
		return Contract Formalization Period;
	}

	public String getDescription(){
		return Description;
	}

	public BigDecimal getHigherTenderAmount(){
		return HigherTenderAmount;
	}

	public BigDecimal getLowerTenderAmount(){
		return LowerTenderAmount;
	}

	public BigDecimal getReceivedElectronicTenderQuantity(){
		return ReceivedElectronicTenderQuantity;
	}

	public BigDecimal getReceivedForeignTenderQuantity(){
		return ReceivedForeignTenderQuantity;
	}

	public BigDecimal getReceivedTenderQuantity(){
		return ReceivedTenderQuantity;
	}

	public LocalDate getStartDate(){
		return StartDate;
	}

	public Subcontract Terms getSubcontract Terms(){
		return m_Subcontract Terms;
	}

	public String getTenderResultCode(){
		return TenderResultCode;
	}

	public Winning Party getWinning Party(){
		return m_Winning Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdvertisementAmount(BigDecimal newVal){
		AdvertisementAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardDate(LocalDate newVal){
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
	public void setAwardTime(LocalTime newVal){
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHigherTenderAmount(BigDecimal newVal){
		HigherTenderAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLowerTenderAmount(BigDecimal newVal){
		LowerTenderAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedElectronicTenderQuantity(BigDecimal newVal){
		ReceivedElectronicTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedForeignTenderQuantity(BigDecimal newVal){
		ReceivedForeignTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedTenderQuantity(BigDecimal newVal){
		ReceivedTenderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(LocalDate newVal){
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
	public void setTenderResultCode(String newVal){
		TenderResultCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWinning Party(Winning Party newVal){
		m_Winning Party = newVal;
	}
}//end TenderResult