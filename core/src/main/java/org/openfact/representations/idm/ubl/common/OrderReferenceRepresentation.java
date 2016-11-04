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
import java.time.LocalTime;

public class OrderReferenceRepresentation {
    private String idUbl;
    private String salesOrderID;
    private Boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String customerReference;
    private DocumentReferenceRepresentation documentReference;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentReferenceRepresentation getDocumentReference() {
        return this.documentReference;
    }

    public void setDocumentReference(DocumentReferenceRepresentation documentReference) {
        this.documentReference = documentReference;
    }

    public String getSalesOrderID() {
        return this.salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalTime getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    public Boolean getCopyIndicator() {
        return this.copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getCustomerReference() {
        return this.customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }
}