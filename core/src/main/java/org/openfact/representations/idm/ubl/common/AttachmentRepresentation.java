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

public class AttachmentRepresentation {
    private BinaryObjectRepresentation embeddedDocumentBinaryObject;
    private ExternalReferenceRepresentation externalReference;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExternalReferenceRepresentation getExternalReference() {
        return this.externalReference;
    }

    public void setExternalReference(ExternalReferenceRepresentation externalReference) {
        this.externalReference = externalReference;
    }

    public BinaryObjectRepresentation getEmbeddedDocumentBinaryObject() {
        return this.embeddedDocumentBinaryObject;
    }

    public void setEmbeddedDocumentBinaryObject(BinaryObjectRepresentation embeddedDocumentBinaryObject) {
        this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
    }
}