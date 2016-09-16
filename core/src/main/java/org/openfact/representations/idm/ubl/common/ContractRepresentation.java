package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ContractRepresentation {
    private String ID;
    private LocalDate IssueDate;
    private LocalTime IssueTime;
    private String ContractRepresentationCode;
    private String ContractRepresentation;
    private PeriodRepresentation ValidityPeriod;
    private List<DocumentReferenceRepresentation> ContractDocumentReference;
    private String Id;
}