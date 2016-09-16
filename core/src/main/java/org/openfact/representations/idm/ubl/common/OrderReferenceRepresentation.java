package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderReferenceRepresentation {
    private String ID;
    private String SalesOrderID;
    private boolean CopyIndicator;
    private String UUID;
    private LocalDate IssueDate;
    private LocalTime IssueTime;
    private String CustomerReference;
    private DocumentReferenceRepresentation DocumentReference;
    private String Id;
}