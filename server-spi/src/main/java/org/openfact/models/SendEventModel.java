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
package org.openfact.models;

import org.openfact.file.FileModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendEventStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SendEventModel {

    String getId();
    LocalDateTime getCreatedTimestamp();
    DestinyType getDestityType();

    SendEventStatus getResult();
    void setResult(SendEventStatus result);

    String getDescription();
    void setDescription(String description);

    void setAttribute(String name, String value);
    void setAttribute(String name, Boolean value);
    void setAttribute(String name, Integer value);
    void setAttribute(String name, Long value);
    void removeAttribute(String name);
    String getAttribute(String name);
    Integer getAttribute(String name, Integer defaultValue);
    Long getAttribute(String name, Long defaultValue);
    Boolean getAttribute(String name, Boolean defaultValue);
    Map<String, String> getAttributes();

    List<FileModel> getAttachedFiles();
    void attachFile(FileModel file);
    void unattachResponseFile(FileModel file);
}
