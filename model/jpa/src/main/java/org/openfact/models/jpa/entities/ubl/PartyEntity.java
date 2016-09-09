package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class PartyEntity {

    /**
     * An identifier for the end point of the routing service (e.g., EAN
     * Location Number, GLN).
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
     * An indicator that this party is "for the attention of" (FAO) (true) or
     * not (false).
     */
    private IndicatorType markAttentionIndicator;
    /**
     * An indicator that this party is "care of" (c/o) (true) or not (false).
     */
    private IndicatorType markCareIndicator;
    /**
     * The Uniform Resource Identifier (URI) that identifies this party's web
     * site; i. e., the web site's Uniform Resource Locator (URL).
     */
    private IdentifierType websiteURIID;
    private AddressEntity postalAddress;
    private List<ContactEntity> contacts = new ArrayList<>();
    private List<FinancialAccountEntity> financialAccounts = new ArrayList<>();
    private List<LanguageEntity> languages = new ArrayList<>();
    private LocationEntity physicalLocation;
    private List<PartyEntity> agentParty = new ArrayList<>();
    private List<PartyIdentificationEntity> partyIdentifications = new ArrayList<>();
    private List<PartyLegalEntity> partyLegalEntities = new ArrayList<>();
    private List<PartyNameEntity> partyNames = new ArrayList<>();
    private List<PartyEntity> taxSchemePartyTaxSchemes = new ArrayList<>();
    private List<PersonEntity> persons = new ArrayList<>();
    private List<PowerOfAttorneyEntity> powerOfAttorneys = new ArrayList<>();
    private List<ServiceProviderPartyEntity> serviceProviderParties = new ArrayList<>();

}
