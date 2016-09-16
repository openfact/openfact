package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class PartyModel {
    protected boolean MarkCareIndicator;
    protected boolean MarkAttentionIndicator;
    protected String WebsiteURI;
    protected String LogoReferenceID;
    protected String EndpointID;
    protected List<String> PartyIdentification;
    protected List<String> PartyName;
    protected LanguageModel Language;
    protected AddressModel PostalAddress;
    protected LocationModelCommAgg PhysicalLocation;
    protected List<PartyTaxSchemeModel> PartyTaxScheme;
    protected List<PartyLegalEntityModel> PartyLegalEntity;
    protected ContactModel Contact;
    protected PersonModel Person;
    protected PartyModel AgentParty;
    protected String Id;
}