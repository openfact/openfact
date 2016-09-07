

/**
 * A class to define an application for a Certificate of Origin (CoO).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplication {

	/**
	 * A code signifying the status of the application (revision, replacement, etc.).
	 */
	private Code. Type ApplicationStatusCode;
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private Text. Type CertificateType;
	/**
	 * The latest job number given to the CoO application. This is used by the system
	 * to keep track of amendments to or cancellation of any earlier applications.
	 */
	private Identifier. Type OriginalJobID;
	/**
	 * An identifier for the previous job used in case the application requires query
	 * or change.
	 */
	private Identifier. Type PreviousJobID;
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private Identifier. Type ReferenceID;
	/**
	 * Remarks by the applicant for the CoO.
	 */
	private Text. Type Remarks;
	private Document Distribution m_Document Distribution;
	private Document Reference Supporting Document Reference;
	private Endorser Party m_Endorser Party;
	private Party Preparation Party;
	private Party Exporter Party;
	private Party Issuer Party;
	private Party Importer Party;
	private Shipment m_Shipment;
	private Signature m_Signature;
	private Country Issuing Country;

	public Certificate Of Origin Application(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getApplicationStatusCode(){
		return ApplicationStatusCode;
	}

	public Text. Type getCertificateType(){
		return CertificateType;
	}

	public Document Distribution getDocument Distribution(){
		return m_Document Distribution;
	}

	public Endorser Party getEndorser Party(){
		return m_Endorser Party;
	}

	public Party getExporter Party(){
		return Exporter Party;
	}

	public Party getImporter Party(){
		return Importer Party;
	}

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public Country getIssuing Country(){
		return Issuing Country;
	}

	public Identifier. Type getOriginalJobID(){
		return OriginalJobID;
	}

	public Party getPreparation Party(){
		return Preparation Party;
	}

	public Identifier. Type getPreviousJobID(){
		return PreviousJobID;
	}

	public Identifier. Type getReferenceID(){
		return ReferenceID;
	}

	public Text. Type getRemarks(){
		return Remarks;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Document Reference getSupporting Document Reference(){
		return Supporting Document Reference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicationStatusCode(Code. Type newVal){
		ApplicationStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCertificateType(Text. Type newVal){
		CertificateType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Distribution(Document Distribution newVal){
		m_Document Distribution = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndorser Party(Endorser Party newVal){
		m_Endorser Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExporter Party(Party newVal){
		Exporter Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setImporter Party(Party newVal){
		Importer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuing Country(Country newVal){
		Issuing Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginalJobID(Identifier. Type newVal){
		OriginalJobID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreparation Party(Party newVal){
		Preparation Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousJobID(Identifier. Type newVal){
		PreviousJobID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceID(Identifier. Type newVal){
		ReferenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRemarks(Text. Type newVal){
		Remarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupporting Document Reference(Document Reference newVal){
		Supporting Document Reference = newVal;
	}
}//end Certificate Of Origin Application