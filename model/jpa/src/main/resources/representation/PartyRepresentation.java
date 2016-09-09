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
public class PartyRepresentation{

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
	private AddressRepresentation postalAddress; 
	private List<ContactRepresentation> contacts = new ArrayList<>(); 
	private List<FinancialAccountRepresentation> financialAccounts = new ArrayList<>(); 
	private List<LanguageRepresentation> languages = new ArrayList<>(); 
	private LocationRepresentation physicalLocation; 
	private List<PartyRepresentation> agentParty = new ArrayList<>(); 
	private List<PartyIdentificationRepresentation> partyIdentifications = new ArrayList<>(); 
	private List<PartyLegalEntityRepresentation> partyLegalEntities = new ArrayList<>(); 
	private List<PartyNameRepresentation> partyNames = new ArrayList<>(); 
	private List<PartyRepresentation> taxSchemePartyTaxSchemes = new ArrayList<>(); 
	private List<PersonRepresentation> persons = new ArrayList<>(); 
	private List<PowerOfAttorneyRepresentation> powerOfAttorneys = new ArrayList<>(); 
	private List<ServiceProviderPartyRepresentation> serviceProviderParties = new ArrayList<>(); 

}
