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
package org.openfact.ubl;

import org.openfact.models.FileModel;
import org.openfact.models.OrganizationModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SendEventModel {

    String getId();

    boolean getResult();

    void setResult(boolean result);

    String getDescription();

    void setDescription(String description);

    OrganizationModel getOrganization();

    List<FileModel> getFileAttatchments();

    void setFileAttatchments(List<FileModel> files);

    String getType();

    void setType(String type);

    Map<String, String> getDestity();

    void setDestiny(Map<String, String> destiny);

    LocalDateTime getCreatedTimestamp();

}
