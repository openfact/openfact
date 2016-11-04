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

public interface PersonModel {

    String getFirstName();

    void setFirstName(String value);

    String getFamilyName();

    void setFamilyName(String value);

    String getTitle();

    void setTitle(String value);

    String getMiddleName();

    void setMiddleName(String value);

    String getNameSuffix();

    void setNameSuffix(String value);

    String getJobTitle();

    void setJobTitle(String value);

    String getOrganizationDepartment();

    void setOrganizationDepartment(String value);

    String getId();


}
