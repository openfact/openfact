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
import java.util.List;

public class ContractRepresentation {
    private String idUbl;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String contractRepresentationCode;
    private String contractRepresentation;
    private PeriodRepresentation validityPeriod;
    private List<DocumentReferenceRepresentation> contractDocumentReference;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public PeriodRepresentation getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(PeriodRepresentation validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getContractRepresentationCode() {
        return this.contractRepresentationCode;
    }

    public void setContractRepresentationCode(String contractRepresentationCode) {
        this.contractRepresentationCode = contractRepresentationCode;
    }

    public List<DocumentReferenceRepresentation> getContractDocumentReference() {
        return this.contractDocumentReference;
    }

    public void setContractDocumentReference(
            List<DocumentReferenceRepresentation> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    public String getContractRepresentation() {
        return this.contractRepresentation;
    }

    public void setContractRepresentation(String contractRepresentation) {
        this.contractRepresentation = contractRepresentation;
    }

    public LocalTime getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }
}