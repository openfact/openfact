package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private Communication otherCommunication;

	public Contact() {

	}

	public void finalize() throws Throwable {

	}

	public String getElectronicMail() {
		return electronicMail;
	}

	public void setElectronicMail(String electronicMail) {
		this.electronicMail = electronicMail;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTelefax() {
		return telefax;
	}

	public void setTelefax(String telefax) {
		this.telefax = telefax;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Communication getOtherCommunication() {
		return otherCommunication;
	}

	public void setOtherCommunication(Communication otherCommunication) {
		this.otherCommunication = otherCommunication;
	}
}// end Contact