package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderReferenceRepresentation {
    private String ID;
    private String salesOrderID;
    private boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String customerReference;
    private DocumentReferenceRepresentation documentReference;
    private String id;
}
