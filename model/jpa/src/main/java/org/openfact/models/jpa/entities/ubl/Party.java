package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class Party {

    /**
     * An identifier for the end point of the routing service (e.g., EAN
     * Location Number, GLN).
     */
    private String EndpointID;
    /**
     * This party's Industry Classification Code.
     */
    private String IndustryClassificationCode;
    /**
     * An identifier for this party's logo.
     */
    private String LogoReferenceID;
    /**
     * An indicator that this party is "for the attention of" (FAO) (true) or
     * not (false).
     */
    private boolean MarkAttentionIndicator;
    /**
     * An indicator that this party is "care of" (c/o) (true) or not (false).
     */
    private boolean MarkCareIndicator;
    /**
     * The Uniform Resource Identifier (URI) that identifies this party's web
     * site; i. e., the web site's Uniform Resource Locator (URL).
     */
    private String WebsiteURIID;
    private Address Postal Address;
    private Contact m_Contact;
    private Financial Account
    m_Financial Account;
    private Language m_Language;
    private Location Physical Location;
    private Party Agent Party;
    private Party Identification
    m_Party Identification;
    private Party Legal
    Entity m_Party
    Legal Entity;
    private Party Name
    m_Party Name;
    private Party Tax
    Scheme m_Party
    Tax Scheme;
    private Person m_Person;
    private Power Of
    Attorney m_Power
    Of Attorney;
    private Service Provider
    Party m_Service
    Provider Party;

    public Party() {

    }

    public void finalize() throws Throwable {

    }

    public Party getAgent

    Party(){
		return Agent Party;
	}

    public Contact getContact() {
        return m_Contact;
    }

    public String getEndpointID() {
        return EndpointID;
    }

    public Financial Account

    getFinancial Account(){
		return m_Financial Account;
	}

    public String getIndustryClassificationCode() {
        return IndustryClassificationCode;
    }

    public Language getLanguage() {
        return m_Language;
    }

    public String getLogoReferenceID() {
        return LogoReferenceID;
    }

    public boolean getMarkAttentionIndicator() {
        return MarkAttentionIndicator;
    }

    public boolean getMarkCareIndicator() {
        return MarkCareIndicator;
    }

    public Party Identification

    getParty Identification(){
		return m_Party Identification;
	}

    public Party Legal
    Entity getParty

    Legal Entity(){
		return m_Party Legal Entity;
	}

    public Party Name

    getParty Name(){
		return m_Party Name;
	}

    public Party Tax
    Scheme getParty

    Tax Scheme(){
		return m_Party Tax Scheme;
	}

    public Person getPerson() {
        return m_Person;
    }

    public Location getPhysical

    Location(){
		return Physical Location;
	}

    public Address getPostal

    Address(){
		return Postal Address;
	}

    public Power Of
    Attorney getPower

    Of Attorney(){
		return m_Power Of Attorney;
	}

    public Service Provider
    Party getService

    Provider Party(){
		return m_Service Provider Party;
	}

    public String getWebsiteURIID() {
        return WebsiteURIID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAgent

    Party(Party newVal) {
        Agent Party = newVal;
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
    public void setEndpointID(String newVal) {
        EndpointID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setFinancial

    Account(Financial Account newVal){
		m_Financial Account = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setIndustryClassificationCode(String newVal) {
        IndustryClassificationCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLanguage(Language newVal) {
        m_Language = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLogoReferenceID(String newVal) {
        LogoReferenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMarkAttentionIndicator(boolean newVal) {
        MarkAttentionIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMarkCareIndicator(boolean newVal) {
        MarkCareIndicator = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setParty

    Identification(Party Identification newVal){
		m_Party Identification = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setParty

    Legal Entity(Party Legal Entity newVal){
		m_Party Legal Entity = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setParty

    Name(Party Name newVal){
		m_Party Name = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setParty

    Tax Scheme(Party Tax Scheme newVal){
		m_Party Tax Scheme = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPerson(Person newVal) {
        m_Person = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setPhysical

    Location(Location newVal){
		Physical Location = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPostal

    Address(Address newVal){
		Postal Address = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPower

    Of Attorney(Power Of Attorney newVal){
		m_Power Of Attorney = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setService

    Provider Party(Service Provider Party newVal){
		m_Service Provider Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setWebsiteURIID(String newVal) {
        WebsiteURIID = newVal;
    }
}// end Party