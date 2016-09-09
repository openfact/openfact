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
    private IdentifierType EndpointID;
    /**
     * This party's Industry Classification Code.
     */
    private CodeType IndustryClassificationCode;
    /**
     * An identifier for this party's logo.
     */
    private IdentifierType LogoReferenceID;
    /**
     * An indicator that this party is "for the attention of" (FAO) (true) or
     * not (false).
     */
    private IndicatorType MarkAttentionIndicator;
    /**
     * An indicator that this party is "care of" (c/o) (true) or not (false).
     */
    private IndicatorType MarkCareIndicator;
    /**
     * The Uniform Resource Identifier (URI) that identifies this party's web
     * site; i. e., the web site's Uniform Resource Locator (URL).
     */
    private IdentifierType WebsiteURIID;
    private AddressEntity PostalAddress;
    private List<ContactEntity> Contacts = new ArrayList<>();
    private List<FinancialAccountEntity> FinancialAccounts = new ArrayList<>();
    private List<LanguageEntity> Languages = new ArrayList<>();
    private LocationEntity PhysicalLocation;
    private List<PartyEntity> AgentParty = new ArrayList<>();
    private List<PartyIdentificationEntity> PartyIdentifications = new ArrayList<>();
    private List<PartyLegalEntity> PartyLegalEntities = new ArrayList<>();
    private List<PartyNameEntity> PartyNames = new ArrayList<>();
    private List<PartyEntity> TaxSchemePartyTaxSchemes = new ArrayList<>();
    private List<PersonEntity> Persons = new ArrayList<>();
    private List<PowerOfAttorneyEntity> PowerOfAttorneys = new ArrayList<>();
    private List<ServiceProviderPartyEntity> ServiceProviderParties = new ArrayList<>();

}
