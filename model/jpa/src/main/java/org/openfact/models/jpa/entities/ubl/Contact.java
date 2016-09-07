package org.openfact.models.jpa.entities.ubl;

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
    private String ElectronicMail;
    /**
     * An identifier for this contact.
     */
    private String ID;
    /**
     * The name of this contact. It is recommended that this be used for a
     * functional name and not a personal name.
     */
    private String Name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, a textual description of the
     * circumstances under which this contact can be used (e.g., "emergency" or
     * "after hours").
     */
    private String Note;
    /**
     * The primary fax number of this contact.
     */
    private String Telefax;
    /**
     * The primary telephone number of this contact.
     */
    private String Telephone;
    private Communication Other Communication;

    public Contact() {

    }

    public void finalize() throws Throwable {

    }

    public String getElectronicMail() {
        return ElectronicMail;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getNote() {
        return Note;
    }

    public Communication getOther

    Communication(){
		return Other Communication;
	}

    public String getTelefax() {
        return Telefax;
    }

    public String getTelephone() {
        return Telephone;
    }

    /**
     * 
     * @param newVal
     */
    public void setElectronicMail(String newVal) {
        ElectronicMail = newVal;
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
    public void setName(String newVal) {
        Name = newVal;
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
	public void setOther

    Communication(Communication newVal){
		Other Communication = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTelefax(String newVal) {
        Telefax = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTelephone(String newVal) {
        Telephone = newVal;
    }
}// end Contact