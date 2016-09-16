package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class FinancialAccountModel {
    protected String ID;
    protected String Name;
    protected String AccountModelCode;
    protected String CurrencyCode;
    protected List<String> PaymentNote;
    protected BranchModel FinancialInstitutionBranch;
    protected CountryModel Country;
    protected String Id;
}