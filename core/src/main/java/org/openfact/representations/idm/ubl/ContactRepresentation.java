package org.openfact.representations.idm.ubl;

/**
 * A class to describe a contactable person or department in an organization.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:58 a. m.
 */
public class ContactRepresentation {

    /**
     * The primary email address of this contact.
     */
    private String electronicMail;

    /**
     * An identifier for this contact.
     */
    private String ID;

    /**
     * The name of this contact. It is recommended that this be used for a
     * functional name and not a personal name.
     */
    private String name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, a textual description of the
     * circumstances under which this contact can be used (e.g., "emergency" or
     * "after hours").
     */
    private String note;
    /**
     * The primary fax number of this contact.
     */
    private String telefax;
    /**
     * The primary telephone number of this contact.
     */
    private String telephone;

    /**
     * @return the electronicMail
     */
    public String getElectronicMail() {
        return electronicMail;
    }

    /**
     * @param electronicMail
     *            the electronicMail to set
     */
    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the telefax
     */
    public String getTelefax() {
        return telefax;
    }

    /**
     * @param telefax
     *            the telefax to set
     */
    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
