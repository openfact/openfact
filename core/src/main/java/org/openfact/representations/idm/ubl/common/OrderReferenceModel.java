package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderReferenceModel {
    protected String ID;
    protected String SalesOrderID;
    protected boolean CopyIndicator;
    protected String UUID;
    protected LocalDate IssueDate;
    protected LocalTime IssueTime;
    protected String CustomerReference;
    protected DocumentReferenceModel DocumentReference;
    protected String Id;
}