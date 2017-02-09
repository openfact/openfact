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
import org.openfact.models.enums.SendEventStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "UBL_DOCUMENT_SEND_EVENT")
@NamedQueries(value = {
        @NamedQuery(name = "getAllSendEventByDocumentId", query = "select s from UBLDocumentSendEventEntity s where s.ublDocument.id=:documentId"),
        @NamedQuery(name = "getDocumentSendEventCountByDocument", query = "select count(s) from UBLDocumentSendEventEntity s where s.ublDocument.id=:documentId"),
        @NamedQuery(name = "deleteDocumentSendEventByOrganization", query = "delete from UBLDocumentSendEventEntity event where event.ublDocument IN (select i from UBLDocumentEntity i where i.organizationId=:organizationId)")
})
public class UBLDocumentSendEventEntity {

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
    @JoinColumn(foreignKey = @ForeignKey, name = "UBL_DOCUMENT_ID")
    private UBLDocumentEntity ublDocument;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "ublDocumentSendEvent", fetch = FetchType.LAZY)
    private Collection<UBLDocumentSendEventResponseAttributeEntity> responseAttributes = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_FILE_RESPONSE_ATTACHMENT", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Set<String> fileResponseAttachmentIds = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DestinyType getDestiny() {
        return destiny;
    }

    public void setDestiny(DestinyType destinyType) {
        this.destiny = destinyType;
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

    public UBLDocumentEntity getUblDocument() {
        return ublDocument;
    }

    public void setUblDocument(UBLDocumentEntity ublDocument) {
        this.ublDocument = ublDocument;
    }

    public Collection<UBLDocumentSendEventResponseAttributeEntity> getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(Collection<UBLDocumentSendEventResponseAttributeEntity> responseAttributes) {
        this.responseAttributes = responseAttributes;
    }

    public Set<String> getFileResponseAttachmentIds() {
        return fileResponseAttachmentIds;
    }

    public void setFileResponseAttachmentIds(Set<String> fileResponseAttachmentIds) {
        this.fileResponseAttachmentIds = fileResponseAttachmentIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof UBLDocumentSendEventEntity)) return false;

        UBLDocumentSendEventEntity that = (UBLDocumentSendEventEntity) o;

        if (!getId().equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}