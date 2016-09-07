

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
	private Amount. Type FeeAmount;
	/**
	 * Text describing the fee amount for tendered projects.
	 */
	private Text. Type FeeDescription;
	/**
	 * An identifier for the tender envelope this tendered project belongs to.
	 */
	private Identifier. Type TenderEnvelopeID;
	/**
	 * A code signifying the type of tender envelope this tendered project belongs to.
	 */
	private Code. Type TenderEnvelopeTypeCode;
	/**
	 * An identifier for this variant of a tendered project.
	 */
	private Identifier. Type VariantID;
	private Awarding Criterion Response m_Awarding Criterion Response;
	private Document Reference Evidence Document Reference;
	private Monetary Total Legal Monetary Total;
	private Procurement Project Lot m_Procurement Project Lot;
	private Tax Total m_Tax Total;
	private Tender Line m_Tender Line;

	public Tendered Project(){

	}

	public void finalize() throws Throwable {

	}
	public Awarding Criterion Response getAwarding Criterion Response(){
		return m_Awarding Criterion Response;
	}

	public Document Reference getEvidence Document Reference(){
		return Evidence Document Reference;
	}

	public Amount. Type getFeeAmount(){
		return FeeAmount;
	}

	public Text. Type getFeeDescription(){
		return FeeDescription;
	}

	public Monetary Total getLegal Monetary Total(){
		return Legal Monetary Total;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Tender Line getTender Line(){
		return m_Tender Line;
	}

	public Identifier. Type getTenderEnvelopeID(){
		return TenderEnvelopeID;
	}

	public Code. Type getTenderEnvelopeTypeCode(){
		return TenderEnvelopeTypeCode;
	}

	public Identifier. Type getVariantID(){
		return VariantID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAwarding Criterion Response(Awarding Criterion Response newVal){
		m_Awarding Criterion Response = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvidence Document Reference(Document Reference newVal){
		Evidence Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeAmount(Amount. Type newVal){
		FeeAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeeDescription(Text. Type newVal){
		FeeDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegal Monetary Total(Monetary Total newVal){
		Legal Monetary Total = newVal;
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
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
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
	public void setTenderEnvelopeID(Identifier. Type newVal){
		TenderEnvelopeID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderEnvelopeTypeCode(Code. Type newVal){
		TenderEnvelopeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVariantID(Identifier. Type newVal){
		VariantID = newVal;
	}
}//end Tendered Project