package org.openfact.models.jpa.entities.ubl;

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
    private LocalDate BirthDate;
    /**
     * The name of the place where this person was born, expressed as text.
     */
    private String BirthplaceName;
    /**
     * This person's family name.
     */
    private String FamilyName;
    /**
     * This person's given name.
     */
    private String FirstName;
    /**
     * A code (e.g., ISO 5218) signifying the gender of this person.
     */
    private String GenderCode;
    /**
     * An identifier for this person.
     */
    private String ID;
    /**
     * This person's job title (for a particular role) within an organization.
     */
    private String JobTitle;
    /**
     * This person's middle name(s) or initials.
     */
    private String MiddleName;
    /**
     * A suffix to this person's name (e.g., PhD, OBE, Jr).
     */
    private String NameSuffix;
    /**
     * An identifier for this person's nationality.
     */
    private String NationalityID;
    /**
     * The department or subdivision of an organization that this person belongs
     * to (in a particular role).
     */
    private String OrganizationDepartment;
    /**
     * This person's second family name.
     */
    private String OtherName;
    /**
     * This person's title of address (e.g., Mr, Ms, Dr, Sir).
     */
    private String Title;
    private Address Residence Address;
    private Contact m_Contact;
    private DocumentReference
    Identity DocumentReference;
    private FinancialAccount
    m_FinancialAccount;

    public Person() {

    }

    public void finalize() throws Throwable {

    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public String getBirthplaceName() {
        return BirthplaceName;
    }

    public Contact getContact() {
        return m_Contact;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public FinancialAccount

    getFinancialAccount(){
		return m_FinancialAccount;
	}

    public String getFirstName() {
        return FirstName;
    }

    public String getGenderCode() {
        return GenderCode;
    }

    public String getID() {
        return ID;
    }

    public DocumentReference
    getIdentity Document

    Reference(){
		return Identity DocumentReference;
	}

    public String getJobTitle() {
        return JobTitle;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getNameSuffix() {
        return NameSuffix;
    }

    public String getNationalityID() {
        return NationalityID;
    }

    public String getOrganizationDepartment() {
        return OrganizationDepartment;
    }

    public String getOtherName() {
        return OtherName;
    }

    public Address getResidence

    Address(){
		return Residence Address;
	}

    public String getTitle() {
        return Title;
    }

    /**
     * 
     * @param newVal
     */
    public void setBirthDate(LocalDate newVal) {
        BirthDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBirthplaceName(String newVal) {
        BirthplaceName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setContact(Contact newVal) {
        m_Contact = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFamilyName(String newVal) {
        FamilyName = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setFinancial

    Account(FinancialAccount newVal){
		m_FinancialAccount = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setFirstName(String newVal) {
        FirstName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setGenderCode(String newVal) {
        GenderCode = newVal;
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
	public void setIdentity

    DocumentReference(DocumentReference newVal){
		Identity DocumentReference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setJobTitle(String newVal) {
        JobTitle = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMiddleName(String newVal) {
        MiddleName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNameSuffix(String newVal) {
        NameSuffix = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNationalityID(String newVal) {
        NationalityID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOrganizationDepartment(String newVal) {
        OrganizationDepartment = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOtherName(String newVal) {
        OtherName = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setResidence

    Address(Address newVal){
		Residence Address = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTitle(String newVal) {
        Title = newVal;
    }
}// end Person