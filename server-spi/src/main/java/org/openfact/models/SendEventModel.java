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
import org.openfact.models.enums.SendResultType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SendEventModel {

    String getId();
    LocalDateTime getCreatedTimestamp();
    DestinyType getDestityType();

    SendResultType getResult();
    void setResult(SendResultType result);

    String getDescription();
    void setDescription(String description);
    
    String getType();
    void setType(String type);

    void setSingleDestinyAttribute(String name, String value);
    void setDestinyAttribute(String name, List<String> values);
    void removeDestinyAttribute(String name);
    String getFirstDestinyAttribute(String name);
    List<String> getDestinyAttribute(String name);
    Map<String, List<String>> getDestinyAttributes();

    void setSingleResponseAttribute(String name, String value);
    void setResponseAttribute(String name, List<String> values);
    void removeResponseAttribute(String name);
    String getFirstResponseAttribute(String name);
    List<String> getResponseAttribute(String name);
    Map<String, List<String>> getResponseAttributes();

    List<FileModel> getFileAttatchments();
    void attachFile(FileModel file);
    void unattachFile(FileModel file);

    List<FileModel> getResponseFileAttatchments();
    void attachResponseFile(FileModel file);
    void unattachResponseFile(FileModel file);
}