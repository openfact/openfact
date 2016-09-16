package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class PartyRepresentation {
    private boolean markCareIndicator;
    private boolean markAttentionIndicator;
    private String websiteURI;
    private String logoReferenceID;
    private String endpointID;
    private List<String> partyIdentification;
    private List<String> partyName;
    private LanguageRepresentation language;
    private AddressRepresentation postalAddress;
    private LocationRepresentationCommAgg physicalLocation;
    private List<PartyTaxSchemeRepresentation> partyTaxScheme;
    private List<PartyLegalEntityRepresentation> partyLegalEntity;
    private ContactRepresentation contact;
    private PersonRepresentation person;
    private PartyRepresentation agentParty;
    private String id;
}
