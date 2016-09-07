package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe a person.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class Person {

	/**
	 * This person's date of birth.
	 */
	private Date. Type BirthDate;
	/**
	 * The name of the place where this person was born, expressed as text.
	 */
	private Text. Type BirthplaceName;
	/**
	 * This person's family name.
	 */
	private Name. Type FamilyName;
	/**
	 * This person's given name.
	 */
	private Name. Type FirstName;
	/**
	 * A code (e.g., ISO 5218) signifying the gender of this person.
	 */
	private Code. Type GenderCode;
	/**
	 * An identifier for this person.
	 */
	private Identifier. Type ID;
	/**
	 * This person's job title (for a particular role) within an organization.
	 */
	private Text. Type JobTitle;
	/**
	 * This person's middle name(s) or initials.
	 */
	private Name. Type MiddleName;
	/**
	 * A suffix to this person's name (e.g., PhD, OBE, Jr).
	 */
	private Text. Type NameSuffix;
	/**
	 * An identifier for this person's nationality.
	 */
	private Identifier. Type NationalityID;
	/**
	 * The department or subdivision of an organization that this person belongs to
	 * (in a particular role).
	 */
	private Text. Type OrganizationDepartment;
	/**
	 * This person's second family name.
	 */
	private Name. Type OtherName;
	/**
	 * This person's title of address (e.g., Mr, Ms, Dr, Sir).
	 */
	private Text. Type Title;
	private Address Residence Address;
	private Contact m_Contact;
	private Document Reference Identity Document Reference;
	private Financial Account m_Financial Account;

	public Person(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getBirthDate(){
		return BirthDate;
	}

	public Text. Type getBirthplaceName(){
		return BirthplaceName;
	}

	public Contact getContact(){
		return m_Contact;
	}

	public Name. Type getFamilyName(){
		return FamilyName;
	}

	public Financial Account getFinancial Account(){
		return m_Financial Account;
	}

	public Name. Type getFirstName(){
		return FirstName;
	}

	public Code. Type getGenderCode(){
		return GenderCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Document Reference getIdentity Document Reference(){
		return Identity Document Reference;
	}

	public Text. Type getJobTitle(){
		return JobTitle;
	}

	public Name. Type getMiddleName(){
		return MiddleName;
	}

	public Text. Type getNameSuffix(){
		return NameSuffix;
	}

	public Identifier. Type getNationalityID(){
		return NationalityID;
	}

	public Text. Type getOrganizationDepartment(){
		return OrganizationDepartment;
	}

	public Name. Type getOtherName(){
		return OtherName;
	}

	public Address getResidence Address(){
		return Residence Address;
	}

	public Text. Type getTitle(){
		return Title;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBirthDate(Date. Type newVal){
		BirthDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBirthplaceName(Text. Type newVal){
		BirthplaceName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContact(Contact newVal){
		m_Contact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFamilyName(Name. Type newVal){
		FamilyName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinancial Account(Financial Account newVal){
		m_Financial Account = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirstName(Name. Type newVal){
		FirstName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGenderCode(Code. Type newVal){
		GenderCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIdentity Document Reference(Document Reference newVal){
		Identity Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJobTitle(Text. Type newVal){
		JobTitle = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMiddleName(Name. Type newVal){
		MiddleName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNameSuffix(Text. Type newVal){
		NameSuffix = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNationalityID(Identifier. Type newVal){
		NationalityID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrganizationDepartment(Text. Type newVal){
		OrganizationDepartment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOtherName(Name. Type newVal){
		OtherName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidence Address(Address newVal){
		Residence Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTitle(Text. Type newVal){
		Title = newVal;
	}
}//end Person