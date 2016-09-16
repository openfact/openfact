package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class DocumentReferenceRepresentation {
    private String ID;
    private boolean CopyIndicator;
    private String UUID;
    private LocalDate IssueDate;
    private String DocumentCodeRepresentation;
    private String DocumentRepresentation;
    private List<String> XPath;
    private AttachmentRepresentation Attachment;
    private String Id;
}