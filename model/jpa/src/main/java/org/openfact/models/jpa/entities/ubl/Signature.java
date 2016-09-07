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
    private Text.Type CanonicalizationMethod;
    /**
     * An identifier for this signature.
     */
    private Identifier.Type ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, information regarding the circumstances
     * in which the signature is being used.
     */
    private Text.Type Note;
    /**
     * Text describing the method of signature.
     */
    private Text.Type SignatureMethod;
    /**
     * The date upon which this signature was verified.
     */
    private Date.Type ValidationDate;
    /**
     * The time at which this signature was verified.
     */
    private Time.Type ValidationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified this signature.
     */
    private Identifier.Type ValidatorID;
    private Attachment Digital
    Signature Attachment;
    private Document Reference
    Original Document Reference;
    private Party Signatory Party;

    public Signature() {

    }

    public void finalize() throws Throwable {

    }

    public Text.Type getCanonicalizationMethod() {
        return CanonicalizationMethod;
    }

    public Attachment getDigital

    Signature Attachment(){
		return Digital Signature Attachment;
	}

    public Identifier.Type getID() {
        return ID;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Document Reference
    getOriginal Document

    Reference(){
		return Original Document Reference;
	}

    public Party getSignatory

    Party(){
		return Signatory Party;
	}

    public Text.Type getSignatureMethod() {
        return SignatureMethod;
    }

    public Date.Type getValidationDate() {
        return ValidationDate;
    }

    public Time.Type getValidationTime() {
        return ValidationTime;
    }

    public Identifier.Type getValidatorID() {
        return ValidatorID;
    }

    /**
     * 
     * @param newVal
     */
    public void setCanonicalizationMethod(Text.Type newVal) {
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
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(Text.Type newVal) {
        Note = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setOriginal

    Document Reference(Document Reference newVal){
		Original Document Reference = newVal;
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
    public void setSignatureMethod(Text.Type newVal) {
        SignatureMethod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidationDate(Date.Type newVal) {
        ValidationDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidationTime(Time.Type newVal) {
        ValidationTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidatorID(Identifier.Type newVal) {
        ValidatorID = newVal;
    }
}// end Signature