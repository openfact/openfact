/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendResultType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "SEND_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class SendEventEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DESTITY_TYPE")
    private DestinyType destityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULT")
    private SendResultType result;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @Column(name = "SEND_TYPE")
    private String type;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_DESTINY", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Map<String, String> destiny = new HashMap<String, String>();

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_REPONSE", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Map<String, String> response = new HashMap<String, String>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_FILE_ATTATCHMENT", joinColumns = { @JoinColumn(name = "SEND_EVENT_ID") })
    private Collection<String> fileAttatchmentIds = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_FILE_RESPONSE_ATTATCHMENT", joinColumns = { @JoinColumn(name = "SEND_EVENT_ID") })
    private Collection<String> fileResponseAttatchmentIds = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SendEventEntity)) return false;

        SendEventEntity that = (SendEventEntity) o;

        if (!getId().equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SendResultType getResult() {
        return result;
    }

    public void setResult(SendResultType result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Map<String, String> getDestiny() {
        return destiny;
    }

    public void setDestiny(Map<String, String> destiny) {
        this.destiny = destiny;
    }

    public Map<String, String> getResponse() {
        return response;
    }

    public void setResponse(Map<String, String> response) {
        this.response = response;
    }

    public Collection<String> getFileAttatchmentIds() {
        return fileAttatchmentIds;
    }

    public void setFileAttatchmentIds(Collection<String> fileAttatchmentIds) {
        this.fileAttatchmentIds = fileAttatchmentIds;
    }

    public Collection<String> getFileResponseAttatchmentIds() {
        return fileResponseAttatchmentIds;
    }

    public void setFileResponseAttatchmentIds(Collection<String> fileResponseAttatchmentIds) {
        this.fileResponseAttatchmentIds = fileResponseAttatchmentIds;
    }

    public DestinyType getDestityType() {
        return destityType;
    }

    public void setDestityType(DestinyType destityType) {
        this.destityType = destityType;
    }
}