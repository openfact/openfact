package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a signature.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
public class Signature {

    /**
     * The method used to perform XML canonicalization of this signature.
     */
    private String CanonicalizationMethod;
    /**
     * An identifier for this signature.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, information regarding the circumstances
     * in which the signature is being used.
     */
    private String Note;
    /**
     * Text describing the method of signature.
     */
    private String SignatureMethod;
    /**
     * The date upon which this signature was verified.
     */
    private LocalDate ValidationDate;
    /**
     * The time at which this signature was verified.
     */
    private LocalTime ValidationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified this signature.
     */
    private String ValidatorID;
    private Attachment Digital
    Signature Attachment;
    private DocumentReference
    Original DocumentReference;
    private Party Signatory Party;

    public Signature() {

    }

    public void finalize() throws Throwable {

    }

    public String getCanonicalizationMethod() {
        return CanonicalizationMethod;
    }

    public Attachment getDigital

    Signature Attachment(){
		return Digital Signature Attachment;
	}

    public String getID() {
        return ID;
    }

    public String getNote() {
        return Note;
    }

    public DocumentReference
    getOriginal Document

    Reference(){
		return Original DocumentReference;
	}

    public Party getSignatory

    Party(){
		return Signatory Party;
	}

    public String getSignatureMethod() {
        return SignatureMethod;
    }

    public LocalDate getValidationDate() {
        return ValidationDate;
    }

    public LocalTime getValidationTime() {
        return ValidationTime;
    }

    public String getValidatorID() {
        return ValidatorID;
    }

    /**
     * 
     * @param newVal
     */
    public void setCanonicalizationMethod(String newVal) {
        CanonicalizationMethod = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDigital

    Signature Attachment(Attachment newVal){
		Digital Signature Attachment = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setOriginal

    DocumentReference(DocumentReference newVal){
		Original DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSignatory

    Party(Party newVal){
		Signatory Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setSignatureMethod(String newVal) {
        SignatureMethod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidationDate(LocalDate newVal) {
        ValidationDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidationTime(LocalTime newVal) {
        ValidationTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidatorID(String newVal) {
        ValidatorID = newVal;
    }
}// end Signature