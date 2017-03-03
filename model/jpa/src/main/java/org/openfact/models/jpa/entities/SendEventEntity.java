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
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.SendEventStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "SEND_EVENT")
@NamedQueries(value = {
        @NamedQuery(name = "getAllSendEventsByDocumentPkId", query = "select s from SendEventEntity s where s.document.id=:documentPkId"),
        @NamedQuery(name = "getDocumentSendEventCountByDocument", query = "select count(s) from SendEventEntity s where s.document.id=:documentId"),
        @NamedQuery(name = "deleteSendEventsByOrganization", query = "delete from SendEventEntity event where event.document IN (select i from DocumentEntity i where i.organizationId=:organizationId)")
})
public class SendEventEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "DESTINY")
    private DestinyType destiny;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private SendEventStatus status;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @NotNull
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ID")
    private DocumentEntity document;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "sendEvent")
    private Collection<SendEventAttributeEntity> attributes = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "sendEvent")
    private Collection<SendEventAttachedFileEntity> attachedFiles = new ArrayList<>();

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

    public DestinyType getDestiny() {
        return destiny;
    }

    public void setDestiny(DestinyType destiny) {
        this.destiny = destiny;
    }

    public SendEventStatus getStatus() {
        return status;
    }

    public void setStatus(SendEventStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity ublDocument) {
        this.document = ublDocument;
    }

    public Collection<SendEventAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<SendEventAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public Collection<SendEventAttachedFileEntity> getAttachedFiles() {
        return attachedFiles;
    }

    public void setAttachedFiles(Collection<SendEventAttachedFileEntity> attachedFiles) {
        this.attachedFiles = attachedFiles;
    }
}