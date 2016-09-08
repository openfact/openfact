package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * A class to describe a person.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class Person {

	/**
	 * This person's date of birth.
	 */
	private LocalDate birthDate;
	/**
	 * The name of the place where this person was born, expressed as text.
	 */
	private String birthplaceName;
	/**
	 * This person's family name.
	 */
	private String familyName;
	/**
	 * This person's given name.
	 */
	private String firstName;
	/**
	 * A code (e.g., ISO 5218) signifying the gender of this person.
	 */
	private String genderCode;
	/**
	 * An identifier for this person.
	 */
	private String id;
	/**
	 * This person's job title (for a particular role) within an organization.
	 */
	private String jobTitle;
	/**
	 * This person's middle name(s) or initials.
	 */
	private String middleName;
	/**
	 * A suffix to this person's name (e.g., PhD, OBE, Jr).
	 */
	private String nameSuffix;
	/**
	 * An identifier for this person's nationality.
	 */
	private String nationalityID;
	/**
	 * The department or subdivision of an organization that this person belongs
	 * to (in a particular role).
	 */
	private String organizationDepartment;
	/**
	 * This person's second family name.
	 */
	private String otherName;
	/**
	 * This person's title of address (e.g., Mr, Ms, Dr, Sir).
	 */
	private String title;
	private Address residenceAddress;
	private List<Contact> contacts = new ArrayList<>();
	private DocumentReference identityDocumentReference;
	private List<FinancialAccount> financialAccounts=new ArrayList<>();

	public Person() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthplaceName() {
		return birthplaceName;
	}

	public void setBirthplaceName(String birthplaceName) {
		this.birthplaceName = birthplaceName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getNationalityID() {
		return nationalityID;
	}

	public void setNationalityID(String nationalityID) {
		this.nationalityID = nationalityID;
	}

	public String getOrganizationDepartment() {
		return organizationDepartment;
	}

	public void setOrganizationDepartment(String organizationDepartment) {
		this.organizationDepartment = organizationDepartment;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(Address residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public DocumentReference getIdentityDocumentReference() {
		return identityDocumentReference;
	}

	public void setIdentityDocumentReference(DocumentReference identityDocumentReference) {
		this.identityDocumentReference = identityDocumentReference;
	}

	public List<FinancialAccount> getFinancialAccounts() {
		return financialAccounts;
	}

	public void setFinancialAccounts(List<FinancialAccount> financialAccounts) {
		this.financialAccounts = financialAccounts;
	}
}// end Person