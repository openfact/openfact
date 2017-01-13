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
import org.openfact.models.enums.SendResultType;
import org.openfact.models.SendEventModel;
import org.openfact.models.jpa.entities.SendEventDestinyAttributeEntity;
import org.openfact.models.jpa.entities.SendEventEntity;
import org.openfact.models.jpa.entities.SendEventResponseAttributeEntity;
import org.openfact.models.utils.OpenfactModelUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SendEventAdapter implements SendEventModel, JpaModel<SendEventEntity> {

    protected static final Logger logger = Logger.getLogger(SendEventAdapter.class);
    protected OrganizationModel organization;
    protected SendEventEntity sendEvent;
    protected EntityManager em;
    protected OpenfactSession session;

    public SendEventAdapter(OpenfactSession session, EntityManager em, OrganizationModel organization, SendEventEntity sendEvent) {
        this.session = session;
        this.em = em;
        this.organization = organization;
        this.sendEvent = sendEvent;
    }

    public static SendEventEntity toEntity(SendEventModel model, EntityManager em) {
        if (model instanceof SendEventAdapter) {
            return ((SendEventAdapter) model).getEntity();
        }
        return em.getReference(SendEventEntity.class, model.getId());
    }

    @Override
    public SendEventEntity getEntity() {
        return sendEvent;
    }

    @Override
    public String getId() {
        return sendEvent.getId();
    }

    @Override
    public SendResultType getResult() {
        return sendEvent.getResult();
    }

    @Override
    public void setResult(SendResultType result) {
        sendEvent.setResult(result);
    }

    @Override
    public String getDescription() {
        return sendEvent.getDescription();
    }

    @Override
    public void setDescription(String description) {
        sendEvent.setDescription(description);
    }

    @Override
    public List<FileModel> getFileAttatchments() {
        FileProvider fileProvider = session.getProvider(FileProvider.class);
        List<FileModel> files = new ArrayList<>();
        for (String fileId : sendEvent.getFileAttatchmentIds()) {
            files.add(fileProvider.getFileById(organization, fileId));
        }
        return files;
    }

    @Override
    public void attachFile(FileModel file) {
        sendEvent.getFileAttatchmentIds().add(file.getId());
    }

    @Override
    public void unattachFile(FileModel file) {
        sendEvent.getFileAttatchmentIds().remove(file.getId());
    }

    @Override
    public String getType() {
        return sendEvent.getType();
    }

    @Override
    public void setType(String type) {
        sendEvent.setType(type);
    }

    @Override
    public void setSingleDestinyAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<SendEventDestinyAttributeEntity> toRemove = new ArrayList<>();
        for (SendEventDestinyAttributeEntity attr : sendEvent.getDestinyAttributes()) {
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
            Query query = em.createNamedQuery("deleteSendEventDestinyAttributesByNameAndSendEventOtherThan");
            query.setParameter("name", name);
            query.setParameter("sendEventId", sendEvent.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            sendEvent.getDestinyAttributes().removeAll(toRemove);
        } else {
            persistDestinyAttributeValue(name, value);
        }
    }

    @Override
    public void setDestinyAttribute(String name, List<String> values) {
        // Remove all existing
        removeDestinyAttribute(name);

        // Put all new
        for (String value : values) {
            persistDestinyAttributeValue(name, value);
        }
    }

    private void persistDestinyAttributeValue(String name, String value) {
        SendEventDestinyAttributeEntity attr = new SendEventDestinyAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setSendEvent(sendEvent);
        em.persist(attr);
        sendEvent.getDestinyAttributes().add(attr);
    }

    @Override
    public void removeDestinyAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteSendEventDestinyAttributesByNameAndSendEvent");
        query.setParameter("name", name);
        query.setParameter("sendEventId", sendEvent.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<SendEventDestinyAttributeEntity> toRemove = new ArrayList<>();
        for (SendEventDestinyAttributeEntity attr : sendEvent.getDestinyAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        sendEvent.getDestinyAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstDestinyAttribute(String name) {
        for (SendEventDestinyAttributeEntity attr : sendEvent.getDestinyAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getDestinyAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (SendEventDestinyAttributeEntity attr : sendEvent.getDestinyAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getDestinyAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (SendEventDestinyAttributeEntity attr : sendEvent.getDestinyAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    @Override
    public void setSingleResponseAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<SendEventResponseAttributeEntity> toRemove = new ArrayList<>();
        for (SendEventResponseAttributeEntity attr : sendEvent.getResponseAttributes()) {
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
            query.setParameter("sendEventId", sendEvent.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            sendEvent.getResponseAttributes().removeAll(toRemove);
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
        SendEventResponseAttributeEntity attr = new SendEventResponseAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setSendEvent(sendEvent);
        em.persist(attr);
        sendEvent.getResponseAttributes().add(attr);
    }

    @Override
    public void removeResponseAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteSendEventResponseAttributesByNameAndSendEvent");
        query.setParameter("name", name);
        query.setParameter("sendEventId", sendEvent.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<SendEventResponseAttributeEntity> toRemove = new ArrayList<>();
        for (SendEventResponseAttributeEntity attr : sendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        sendEvent.getResponseAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstResponseAttribute(String name) {
        for (SendEventResponseAttributeEntity attr : sendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getResponseAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (SendEventResponseAttributeEntity attr : sendEvent.getResponseAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getResponseAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (SendEventResponseAttributeEntity attr : sendEvent.getResponseAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return sendEvent.getCreatedTimestamp();
    }

    @Override
    public DestinyType getDestityType() {
        return sendEvent.getDestinyType();
    }

    @Override
    public List<FileModel> getResponseFileAttatchments() {
        FileProvider fileProvider = session.getProvider(FileProvider.class);
        List<FileModel> files = new ArrayList<>();
        for (String fileId : sendEvent.getFileResponseAttatchmentIds()) {
            files.add(fileProvider.getFileById(organization, fileId));
        }
        return files;
    }

    @Override
    public void attachResponseFile(FileModel file) {
        sendEvent.getFileResponseAttatchmentIds().add(file.getId());
    }

    @Override
    public void unattachResponseFile(FileModel file) {
        sendEvent.getFileResponseAttatchmentIds().remove(file.getId());
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
