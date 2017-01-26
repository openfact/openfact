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
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "SEND_EVENT")
public class SendEventEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DESTINY_TYPE")
    private DestinyType destinyType;

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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ID")
    private DocumentEntity document;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "sendEvent")
    private Collection<SendEventDestinyAttributeEntity> destinyAttributes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "sendEvent")
    private Collection<SendEventResponseAttributeEntity> responseAttributes = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_FILE_ATTATCHMENT", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Set<String> fileAttatchmentIds = new HashSet<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_FILE_RESPONSE_ATTATCHMENT", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Set<String> fileResponseAttatchmentIds = new HashSet<>();

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

    public DestinyType getDestinyType() {
        return destinyType;
    }

    public void setDestinyType(DestinyType destinyType) {
        this.destinyType = destinyType;
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

    public Collection<SendEventDestinyAttributeEntity> getDestinyAttributes() {
        return destinyAttributes;
    }

    public void setDestinyAttributes(Collection<SendEventDestinyAttributeEntity> destinyAttributes) {
        this.destinyAttributes = destinyAttributes;
    }

    public Collection<SendEventResponseAttributeEntity> getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(Collection<SendEventResponseAttributeEntity> responseAttributes) {
        this.responseAttributes = responseAttributes;
    }

    public Set<String> getFileAttatchmentIds() {
        return fileAttatchmentIds;
    }

    public void setFileAttatchmentIds(Set<String> fileAttatchmentIds) {
        this.fileAttatchmentIds = fileAttatchmentIds;
    }

    public Set<String> getFileResponseAttatchmentIds() {
        return fileResponseAttatchmentIds;
    }

    public void setFileResponseAttatchmentIds(Set<String> fileResponseAttatchmentIds) {
        this.fileResponseAttatchmentIds = fileResponseAttatchmentIds;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }
}