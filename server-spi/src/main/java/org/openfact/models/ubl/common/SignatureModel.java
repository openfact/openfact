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
package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SignatureModel {

    String getID();

    void setID(String value);

    String getNote();

    void setNote(String value);

    LocalDate getValidationDate();

    void setValidationDate(LocalDate value);

    LocalTime getValidationTime();

    void setValidationTime(LocalTime value);

    String getValidatorID();

    void setValidatorID(String value);

    String getCanonicalizationMethod();

    void setCanonicalizationMethod(String value);

    String getSignatureMethod();

    void setSignatureMethod(String value);

    PartyModel getSignatoryParty();

    void setSignatoryParty(PartyModel value);

    AttachmentModel getDigitalSignatureAttachment();

    void setDigitalSignatureAttachment(AttachmentModel value);

    DocumentReferenceModel getOriginalDocumentReference();

    void setOriginalDocumentReference(DocumentReferenceModel value);

    String getId();


}
