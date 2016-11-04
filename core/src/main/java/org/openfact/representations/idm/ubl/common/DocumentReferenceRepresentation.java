/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DocumentReferenceRepresentation {
    private String idUbl;
    private Boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private String documentCodeRepresentation;
    private String documentRepresentation;
    private List<String> XPath;
    private AttachmentRepresentation attachment;
    private String id;

    /**/
    public void addXpath(String rep) {
        if (XPath == null) {
            XPath = new ArrayList<>();
        }
        XPath.add(rep);
    }
    /**/

    public String getDocumentCodeRepresentation() {
        return this.documentCodeRepresentation;
    }

    public void setDocumentCodeRepresentation(String documentCodeRepresentation) {
        this.documentCodeRepresentation = documentCodeRepresentation;
    }

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public List<String> getXPath() {
        return this.XPath;
    }

    public void setXPath(List<String> XPath) {
        this.XPath = XPath;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getDocumentRepresentation() {
        return this.documentRepresentation;
    }

    public void setDocumentRepresentation(String documentRepresentation) {
        this.documentRepresentation = documentRepresentation;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public AttachmentRepresentation getAttachment() {
        return this.attachment;
    }

    public void setAttachment(AttachmentRepresentation attachment) {
        this.attachment = attachment;
    }

    public Boolean getCopyIndicator() {
        return this.copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }
}