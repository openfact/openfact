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

public class SendEventRepresentation {

    private String id;
    private String description;
    private String result;

    private String type;
    private Map<String, List<String>> destinyAttributes;
    private List<FileRepresentation> filesAttatchment;
    private Map<String, List<String>> responseAttributes;
    private List<FileRepresentation> responseFilesAttatchment;

    private LocalDateTime createdTimestamp;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, List<String>> getDestinyAttributes() {
        return destinyAttributes;
    }

    public void setDestinyAttributes(Map<String, List<String>> destinyAttributes) {
        this.destinyAttributes = destinyAttributes;
    }

    public List<FileRepresentation> getFilesAttatchment() {
        return filesAttatchment;
    }

    public void setFilesAttatchment(List<FileRepresentation> filesAttatchment) {
        this.filesAttatchment = filesAttatchment;
    }

    public Map<String, List<String>> getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(Map<String, List<String>> responseAttributes) {
        this.responseAttributes = responseAttributes;
    }

    public List<FileRepresentation> getResponseFilesAttatchment() {
        return responseFilesAttatchment;
    }

    public void setResponseFilesAttatchment(List<FileRepresentation> responseFilesAttatchment) {
        this.responseFilesAttatchment = responseFilesAttatchment;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}
