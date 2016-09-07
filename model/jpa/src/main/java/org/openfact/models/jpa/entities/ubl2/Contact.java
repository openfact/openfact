package org.openfact.models.jpa.entities.ubl2;

/**
 * A class to describe a contactable person or department in an organization.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:58 a. m.
 */
public class Contact {

    /**
     * The primary email address of this contact.
     */
    private Text.Type ElectronicMail;
    /**
     * An identifier for this contact.
     */
    private Identifier.Type ID;
    /**
     * The name of this contact. It is recommended that this be used for a
     * functional name and not a personal name.
     */
    private Name.Type Name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, a textual description of the
     * circumstances under which this contact can be used (e.g., "emergency" or
     * "after hours").
     */
    private Text.Type Note;
    /**
     * The primary fax number of this contact.
     */
    private Text.Type Telefax;
    /**
     * The primary telephone number of this contact.
     */
    private Text.Type Telephone;
    private Communication Other Communication;

    public Contact() {

    }

    public void finalize() throws Throwable {

    }

    public Text.Type getElectronicMail() {
        return ElectronicMail;
    }

    public Identifier.Type getID() {
        return ID;
    }

    public Name.Type getName() {
        return Name;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Communication getOther

    Communication(){
		return Other Communication;
	}

    public Text.Type getTelefax() {
        return Telefax;
    }

    public Text.Type getTelephone() {
        return Telephone;
    }

    /**
     * 
     * @param newVal
     */
    public void setElectronicMail(Text.Type newVal) {
        ElectronicMail = newVal;
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
    public void setName(Name.Type newVal) {
        Name = newVal;
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
	public void setOther

    Communication(Communication newVal){
		Other Communication = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTelefax(Text.Type newVal) {
        Telefax = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTelephone(Text.Type newVal) {
        Telephone = newVal;
    }
}// end Contact