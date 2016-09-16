package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class PartyRepresentation {
    private boolean MarkCareIndicator;
    private boolean MarkAttentionIndicator;
    private String WebsiteURI;
    private String LogoReferenceID;
    private String EndpointID;
    private List<String> PartyIdentification;
    private List<String> PartyName;
    private LanguageRepresentation Language;
    private AddressRepresentation PostalAddress;
    private LocationRepresentationCommAgg PhysicalLocation;
    private List<PartyTaxSchemeRepresentation> PartyTaxScheme;
    private List<PartyLegalEntityRepresentation> PartyLegalEntity;
    private ContactRepresentation Contact;
    private PersonRepresentation Person;
    private PartyRepresentation AgentParty;
    private String Id;
}