package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class DocumentReferenceModel {
    protected String ID;
    protected boolean CopyIndicator;
    protected String UUID;
    protected LocalDate IssueDate;
    protected String DocumentCodeModel;
    protected String DocumentModel;
    protected List<String> XPath;
    protected AttachmentModel Attachment;
    protected String Id;
}