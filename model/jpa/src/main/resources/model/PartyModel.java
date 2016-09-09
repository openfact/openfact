package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an organization, sub-organization, or individual fulfilling
 * a role in a business process.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class PartyModel{

	/**
	 * An identifier for the end point of the routing service (e.g., EAN Location
	 * Number, GLN).
	 */
	private IdentifierType endpointID; 
	/**
	 * This party's Industry Classification Code.
	 */
	private CodeType industryClassificationCode; 
	/**
	 * An identifier for this party's logo.
	 */
	private IdentifierType logoReferenceID; 
	/**
	 * An indicator that this party is "for the attention of" (FAO) (true) or not
	 * (false).
	 */
	private boolean markAttentionIndicator; 
	/**
	 * An indicator that this party is "care of" (c/o) (true) or not (false).
	 */
	private boolean markCareIndicator; 
	/**
	 * The Uniform Resource Identifier (URI) that identifies this party's web site; i.
	 * e., the web site's Uniform Resource Locator (URL).
	 */
	private IdentifierType websiteURIID; 
	private AddressModel postalAddress; 
	private List<ContactModel> contacts = new ArrayList<>(); 
	private List<FinancialAccountModel> financialAccounts = new ArrayList<>(); 
	private List<LanguageModel> languages = new ArrayList<>(); 
	private LocationModel physicalLocation; 
	private List<PartyModel> agentParty = new ArrayList<>(); 
	private List<PartyIdentificationModel> partyIdentifications = new ArrayList<>(); 
	private List<PartyLegalEntityModel> partyLegalEntities = new ArrayList<>(); 
	private List<PartyNameModel> partyNames = new ArrayList<>(); 
	private List<PartyModel> taxSchemePartyTaxSchemes = new ArrayList<>(); 
	private List<PersonModel> persons = new ArrayList<>(); 
	private List<PowerOfAttorneyModel> powerOfAttorneys = new ArrayList<>(); 
	private List<ServiceProviderPartyModel> serviceProviderParties = new ArrayList<>(); 

}
