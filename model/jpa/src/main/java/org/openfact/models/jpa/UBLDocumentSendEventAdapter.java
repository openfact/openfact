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
package org.openfact.models.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendEventStatus;
import org.openfact.models.SendEventModel;
import org.openfact.models.jpa.entities.UBLDocumentSendEventEntity;
import org.openfact.models.jpa.entities.UBLDocumentSendEventResponseAttributeEntity;
import org.openfact.models.utils.OpenfactModelUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UBLDocumentSendEventAdapter implements SendEventModel, JpaModel<UBLDocumentSendEventEntity> {

    protected static final Logger logger = Logger.getLogger(UBLDocumentSendEventAdapter.class);
    protected OrganizationModel organization;
    protected UBLDocumentSendEventEntity ublDocumentDendEvent;
    protected EntityManager em;
    protected OpenfactSession session;

    public UBLDocumentSendEventAdapter(OpenfactSession session, EntityManager em, OrganizationModel organization, UBLDocumentSendEventEntity ublDocumentDendEvent) {
        this.session = session;
        this.em = em;
        this.organization = organization;
        this.ublDocumentDendEvent = ublDocumentDendEvent;
    }

    public static UBLDocumentSendEventEntity toEntity(SendEventModel model, EntityManager em) {
        if (model instanceof UBLDocumentSendEventAdapter) {
            return ((UBLDocumentSendEventAdapter) model).getEntity();
        }
        return em.getReference(UBLDocumentSendEventEntity.class, model.getId());
    }

    @Override
    public UBLDocumentSendEventEntity getEntity() {
        return ublDocumentDendEvent;
    }

    @Override
    public String getId() {
        return ublDocumentDendEvent.getId();
    }

    @Override
    public SendEventStatus getResult() {
        return ublDocumentDendEvent.getStatus();
    }

    @Override
    public void setResult(SendEventStatus result) {
        ublDocumentDendEvent.setStatus(result);
    }

    @Override
    public String getDescription() {
        return ublDocumentDendEvent.getDescription();
    }

    @Override
    public void setDescription(String description) {
        ublDocumentDendEvent.setDescription(description);
    }

    @Override
    public void setSingleResponseAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<UBLDocumentSendEventResponseAttributeEntity> toRemove = new ArrayList<>();
        for (UBLDocumentSendEventResponseAttributeEntity attr : ublDocumentDendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                if (firstExistingAttrId == null) {
                    attr.setValue(value);
                    firstExistingAttrId = attr.getId();
                } else {
                    toRemove.add(attr);
                }
            }
        }

        if (firstExistingAttrId != null) {
            // Remove attributes through HQL to avoid StaleUpdateException
            Query query = em.createNamedQuery("deleteSendEventResponseAttributesByNameAndSendEventOtherThan");
            query.setParameter("name", name);
            query.setParameter("sendEventId", ublDocumentDendEvent.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            ublDocumentDendEvent.getResponseAttributes().removeAll(toRemove);
        } else {
            persistResponseAttributeValue(name, value);
        }
    }

    @Override
    public void setResponseAttribute(String name, List<String> values) {
        // Remove all existing
        removeResponseAttribute(name);

        // Put all new
        for (String value : values) {
            persistResponseAttributeValue(name, value);
        }
    }

    private void persistResponseAttributeValue(String name, String value) {
        UBLDocumentSendEventResponseAttributeEntity attr = new UBLDocumentSendEventResponseAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setUblDocumentSendEvent(ublDocumentDendEvent);
        em.persist(attr);
        ublDocumentDendEvent.getResponseAttributes().add(attr);
    }

    @Override
    public void removeResponseAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteSendEventResponseAttributesByNameAndSendEvent");
        query.setParameter("name", name);
        query.setParameter("sendEventId", ublDocumentDendEvent.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<UBLDocumentSendEventResponseAttributeEntity> toRemove = new ArrayList<>();
        for (UBLDocumentSendEventResponseAttributeEntity attr : ublDocumentDendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        ublDocumentDendEvent.getResponseAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstResponseAttribute(String name) {
        for (UBLDocumentSendEventResponseAttributeEntity attr : ublDocumentDendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getResponseAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (UBLDocumentSendEventResponseAttributeEntity attr : ublDocumentDendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getResponseAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (UBLDocumentSendEventResponseAttributeEntity attr : ublDocumentDendEvent.getResponseAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return ublDocumentDendEvent.getCreatedTimestamp();
    }

    @Override
    public DestinyType getDestityType() {
        return ublDocumentDendEvent.getDestiny();
    }

    @Override
    public List<FileModel> getResponseFileAttatchments() {
        FileProvider fileProvider = session.getProvider(FileProvider.class);
        List<FileModel> files = new ArrayList<>();
        for (String fileId : ublDocumentDendEvent.getFileResponseAttachmentIds()) {
            files.add(fileProvider.getFileById(organization, fileId));
        }
        return files;
    }

    @Override
    public void attachResponseFile(FileModel file) {
        ublDocumentDendEvent.getFileResponseAttachmentIds().add(file.getId());
    }

    @Override
    public void unattachResponseFile(FileModel file) {
        ublDocumentDendEvent.getFileResponseAttachmentIds().remove(file.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof SendEventModel)) return false;

        SendEventModel that = (SendEventModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
