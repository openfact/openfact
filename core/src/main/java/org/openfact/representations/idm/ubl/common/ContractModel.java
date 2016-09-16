package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ContractModel {
    protected String ID;
    protected LocalDate IssueDate;
    protected LocalTime IssueTime;
    protected String ContractModelCode;
    protected String ContractModel;
    protected PeriodModel ValidityPeriod;
    protected List<DocumentReferenceModel> ContractDocumentReference;
    protected String Id;
}