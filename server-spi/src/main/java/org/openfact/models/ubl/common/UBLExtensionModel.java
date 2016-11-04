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

public interface UBLExtensionModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    String getExtensionAgencyID();

    void setExtensionAgencyID(String value);

    String getExtensionAgencyName();

    void setExtensionAgencyName(String value);

    String getExtensionVersionID();

    void setExtensionVersionID(String value);

    String getExtensionAgencyURI();

    void setExtensionAgencyURI(String value);

    String getExtensionURI();

    void setExtensionURI(String value);

    String getExtensionReasonCode();

    void setExtensionReasonCode(String value);

    String getExtensionReason();

    void setExtensionReason(String value);

    ExtensionContentModel getExtensionContent();

    void setExtensionContent(ExtensionContentModel value);

    String getId();


}
