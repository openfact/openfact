package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ContractRepresentation {
    private String ID;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String contractRepresentationCode;
    private String contractRepresentation;
    private PeriodRepresentation validityPeriod;
    private List<DocumentReferenceRepresentation> contractDocumentReference;
    private String id;
}
