package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class FinancialAccountRepresentation {
    private String ID;
    private String name;
    private String accountRepresentationCode;
    private String currencyCode;
    private List<String> paymentNote;
    private BranchRepresentation financialInstitutionBranch;
    private CountryRepresentation country;
    private String id;
}
