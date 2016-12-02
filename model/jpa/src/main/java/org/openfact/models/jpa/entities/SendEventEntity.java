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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "SEND_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NamedQueries({
        @NamedQuery(name = "getAllSendEventsByOrganization", query = "select i from SendEventEntity i where i.organization.id = :organizationId order by i.createdTimestamp")})
public class SendEventEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "RESULT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean result;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TYPE")
    private String type;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "SEND_EVENT_DESTINY", joinColumns = {@JoinColumn(name = "SEND_EVENT_ID")})
    private Map<String, String> destiny = new HashMap<String, String>();

    @OneToMany(fetch = FetchType.LAZY)
    @ElementCollection
    @CollectionTable(name = "SEND_EVENT_FILES", joinColumns = @JoinColumn(name = "SEND_EVENT_ID"))
    @MapKeyColumn(name = "FILE_TYPE")
    private Map<String, FileEntity> fileAttatchments = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
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

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public Map<String, String> getDestiny() {
        return destiny;
    }

    public void setDestiny(Map<String, String> destiny) {
        this.destiny = destiny;
    }

    public Map<String, FileEntity> getFileAttatchments() {
        return fileAttatchments;
    }

    public void setFileAttatchments(Map<String, FileEntity> fileAttatchments) {
        this.fileAttatchments = fileAttatchments;
    }
}