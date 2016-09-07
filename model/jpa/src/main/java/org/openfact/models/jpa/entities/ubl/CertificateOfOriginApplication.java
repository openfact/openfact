package org.openfact.models.jpa.entities.ubl;


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
	private String ApplicationStatusCode;
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private String CertificateType;
	/**
	 * The latest job number given to the CoO application. This is used by the system
	 * to keep track of amendments to or cancellation of any earlier applications.
	 */
	private String OriginalJobID;
	/**
	 * An identifier for the previous job used in case the application requires query
	 * or change.
	 */
	private String PreviousJobID;
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private String ReferenceID;
	/**
	 * Remarks by the applicant for the CoO.
	 */
	private String Remarks;
	private Document Distribution m_Document Distribution;
	private DocumentReference Supporting DocumentReference;
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
	public String getApplicationStatusCode(){
		return ApplicationStatusCode;
	}

	public String getCertificateType(){
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

	public String getOriginalJobID(){
		return OriginalJobID;
	}

	public Party getPreparation Party(){
		return Preparation Party;
	}

	public String getPreviousJobID(){
		return PreviousJobID;
	}

	public String getReferenceID(){
		return ReferenceID;
	}

	public String getRemarks(){
		return Remarks;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public DocumentReference getSupporting DocumentReference(){
		return Supporting DocumentReference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicationStatusCode(String newVal){
		ApplicationStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCertificateType(String newVal){
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
	public void setOriginalJobID(String newVal){
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
	public void setPreviousJobID(String newVal){
		PreviousJobID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceID(String newVal){
		ReferenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRemarks(String newVal){
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
	public void setSupporting DocumentReference(DocumentReference newVal){
		Supporting DocumentReference = newVal;
	}
}//end Certificate Of Origin Application