package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class DocumentReferenceRepresentation {
    private String ID;
    private boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private String documentCodeRepresentation;
    private String documentRepresentation;
    private List<String> XPath;
    private AttachmentRepresentation attachment;
    private String id;
}
