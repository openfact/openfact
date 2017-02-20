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
package org.openfact.representations.idm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DocumentRepresentation {

    private String id;
    private String documentId;
    private String documentType;
    private LocalDateTime createdTimestamp;

    private String documentCurrencyCode;
    private String customerRegistrationName;
    private String customerAssignedAccountId;
    private String customerElectronicMail;

    private boolean enabled;

    private Map<String, List<String>> attributes;
    private Set<String> requiredActions;

    private List<DocumentRepresentation> attachedDocumentsAsOrigin;
    private List<DocumentRepresentation> attachedDocumentsAsDestiny;

    private List<Map<String, String>> documentLines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getCustomerRegistrationName() {
        return customerRegistrationName;
    }

    public void setCustomerRegistrationName(String customerRegistrationName) {
        this.customerRegistrationName = customerRegistrationName;
    }

    public String getCustomerAssignedAccountId() {
        return customerAssignedAccountId;
    }

    public void setCustomerAssignedAccountId(String customerAssignedAccountId) {
        this.customerAssignedAccountId = customerAssignedAccountId;
    }

    public String getCustomerElectronicMail() {
        return customerElectronicMail;
    }

    public void setCustomerElectronicMail(String customerElectronicMail) {
        this.customerElectronicMail = customerElectronicMail;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, List<String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, List<String>> attributes) {
        this.attributes = attributes;
    }

    public Set<String> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Set<String> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public List<DocumentRepresentation> getAttachedDocumentsAsOrigin() {
        return attachedDocumentsAsOrigin;
    }

    public void setAttachedDocumentsAsOrigin(List<DocumentRepresentation> attachedDocumentsAsOrigin) {
        this.attachedDocumentsAsOrigin = attachedDocumentsAsOrigin;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<DocumentRepresentation> getAttachedDocumentsAsDestiny() {
        return attachedDocumentsAsDestiny;
    }

    public void setAttachedDocumentsAsDestiny(List<DocumentRepresentation> attachedDocumentsAsDestiny) {
        this.attachedDocumentsAsDestiny = attachedDocumentsAsDestiny;
    }

    public List<Map<String, String>> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<Map<String, String>> documentLines) {
        this.documentLines = documentLines;
    }
}
