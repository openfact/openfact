package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a tendered project or project lot.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:21 a. m.
 */
public class TenderedProject {

	/**
	 * The fee amount for tendered projects.
	 */
	private BigDecimal FeeAmount;
	/**
	 * Text describing the fee amount for tendered projects.
	 */
	private String FeeDescription;
	/**
	 * An identifier for the tender envelope this tendered project belongs to.
	 */
	private String TenderEnvelopeID;
	/**
	 * A code signifying the type of tender envelope this tendered project belongs to.
	 */
	private String TenderEnvelopeTypeCode;
	/**
	 * An identifier for this variant of a tendered project.
	 */
	private String VariantID;
	private AwardingCriterion Response m_AwardingCriterion Response;
	private DocumentReference Evidence DocumentReference;
	private MonetaryTotal Legal MonetaryTotal;
	private Procurement Project Lot m_Procurement Project Lot;
	private TaxTotal m_TaxTotal;
	private Tender Line m_Tender Line;

	public TenderedProject(){

	}

	public void finalize() throws Throwable {

	}
	public AwardingCriterion Response getAwardingCriterion Response(){
		return m_AwardingCriterion Response;
	}

	public DocumentReference getEvidence DocumentReference(){
		return Evidence DocumentReference;
	}

	public BigDecimal getFeeAmount(){
		return FeeAmount;
	}

	public String getFeeDescription(){
		return FeeDescription;
	}

	public MonetaryTotal getLegal MonetaryTotal(){
		return Legal MonetaryTotal;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public TaxTotal getTaxTotal(){
		return m_TaxTotal;
	}

	public Tender Line getTender Line(){
		return m_Tender Line;
	}

	public String getTenderEnvelopeID(){
		return TenderEnvelopeID;
	}

	public String getTenderEnvelopeTypeCode(){
		return TenderEnvelopeTypeCode;
	}

	public String getVariantID(){
		return VariantID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwardingCriterion Response(AwardingCriterion Response newVal){
		m_AwardingCriterion Response = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvidence DocumentReference(DocumentReference newVal){
		Evidence DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeAmount(BigDecimal newVal){
		FeeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeDescription(String newVal){
		FeeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegal MonetaryTotal(MonetaryTotal newVal){
		Legal MonetaryTotal = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Project Lot(Procurement Project Lot newVal){
		m_Procurement Project Lot = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxTotal(TaxTotal newVal){
		m_TaxTotal = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTender Line(Tender Line newVal){
		m_Tender Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderEnvelopeID(String newVal){
		TenderEnvelopeID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderEnvelopeTypeCode(String newVal){
		TenderEnvelopeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVariantID(String newVal){
		VariantID = newVal;
	}
}//end TenderedProject