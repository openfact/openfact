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

public class UBLExtensionRepresentation {
    private String idUbl;
    private String name;
    private String extensionAgencyID;
    private String extensionAgencyName;
    private String extensionVersionID;
    private String extensionAgencyURI;
    private String extensionURI;
    private String extensionReasonCode;
    private String extensionReason;
    private ExtensionContentRepresentation extensionContent;
    private String id;

    public String getExtensionAgencyName() {
        return this.extensionAgencyName;
    }

    public void setExtensionAgencyName(String extensionAgencyName) {
        this.extensionAgencyName = extensionAgencyName;
    }

    public String getExtensionURI() {
        return this.extensionURI;
    }

    public void setExtensionURI(String extensionURI) {
        this.extensionURI = extensionURI;
    }

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

    public String getExtensionReason() {
        return this.extensionReason;
    }

    public void setExtensionReason(String extensionReason) {
        this.extensionReason = extensionReason;
    }

    public ExtensionContentRepresentation getExtensionContent() {
        return this.extensionContent;
    }

    public void setExtensionContent(ExtensionContentRepresentation extensionContent) {
        this.extensionContent = extensionContent;
    }

    public String getExtensionReasonCode() {
        return this.extensionReasonCode;
    }

    public void setExtensionReasonCode(String extensionReasonCode) {
        this.extensionReasonCode = extensionReasonCode;
    }

    public String getExtensionAgencyURI() {
        return this.extensionAgencyURI;
    }

    public void setExtensionAgencyURI(String extensionAgencyURI) {
        this.extensionAgencyURI = extensionAgencyURI;
    }

    public String getExtensionAgencyID() {
        return this.extensionAgencyID;
    }

    public void setExtensionAgencyID(String extensionAgencyID) {
        this.extensionAgencyID = extensionAgencyID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtensionVersionID() {
        return this.extensionVersionID;
    }

    public void setExtensionVersionID(String extensionVersionID) {
        this.extensionVersionID = extensionVersionID;
    }
}