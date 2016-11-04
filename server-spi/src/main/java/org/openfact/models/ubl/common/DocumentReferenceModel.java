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
import java.util.List;

public interface DocumentReferenceModel {

    String getID();

    void setID(String value);

    boolean getCopyIndicator();

    void setCopyIndicator(boolean value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    String getDocumentCode();

    void setDocumentCode(String value);

    String getDocument();

    void setDocument(String value);

    List<String> getXPath();

    void setXPath(List<String> xPath);

    AttachmentModel getAttachment();

    void setAttachment(AttachmentModel value);

    String getId();


}
