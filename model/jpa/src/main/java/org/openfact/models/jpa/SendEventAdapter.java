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

import org.jboss.logging.Logger;
import org.openfact.files.FileModel;
import org.openfact.files.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.SendEventDestiny;
import org.openfact.models.enums.SendEventStatus;
import org.openfact.models.SendEventModel;
import org.openfact.models.jpa.entities.SendEventAttachedFileEntity;
import org.openfact.models.jpa.entities.SendEventEntity;
import org.openfact.models.jpa.entities.SendEventAttributeEntity;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SendEventAdapter implements SendEventModel, JpaModel<SendEventEntity> {

    protected static final Logger logger = Logger.getLogger(SendEventAdapter.class);
    protected OrganizationModel organization;
    protected SendEventEntity sendEvent;
    protected EntityManager em;

    public SendEventAdapter(EntityManager em, OrganizationModel organization, SendEventEntity ublDocumentDendEvent) {
        this.em = em;
        this.organization = organization;
        this.sendEvent = ublDocumentDendEvent;
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
    public SendEventStatus getResult() {
        return sendEvent.getStatus();
    }

    @Override
    public void setResult(SendEventStatus result) {
        sendEvent.setStatus(result);
    }

    @Override
    public String getDescription() {
        return sendEvent.getDescription();
    }

    @Override
    public void setDescription(String description) {
        sendEvent.setDescription(description);
    }

    /**
     * Attribute
     */
    @Override
    public void setAttribute(String name, String value) {
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            if (attr.getName().equals(name)) {
                attr.setValue(value);
                return;
            }
        }
        SendEventAttributeEntity attr = new SendEventAttributeEntity();
        attr.setName(name);
        attr.setValue(value);
        attr.setSendEvent(sendEvent);
        em.persist(attr);
        sendEvent.getAttributes().add(attr);
    }

    @Override
    public void setAttribute(String name, Boolean value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Integer value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Long value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void removeAttribute(String name) {
        Iterator<SendEventAttributeEntity> it = sendEvent.getAttributes().iterator();
        while (it.hasNext()) {
            SendEventAttributeEntity attr = it.next();
            if (attr.getName().equals(name)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public String getAttribute(String name) {
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public Integer getAttribute(String name, Integer defaultValue) {
        String v = getAttribute(name);
        return v != null ? Integer.parseInt(v) : defaultValue;

    }

    @Override
    public Long getAttribute(String name, Long defaultValue) {
        String v = getAttribute(name);
        return v != null ? Long.parseLong(v) : defaultValue;

    }

    @Override
    public Boolean getAttribute(String name, Boolean defaultValue) {
        String v = getAttribute(name);
        return v != null ? Boolean.parseBoolean(v) : defaultValue;

    }

    @Override
    public Map<String, String> getAttributes() {
        // should always return a copy
        Map<String, String> result = new HashMap<String, String>();
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            result.put(attr.getName(), attr.getValue());
        }
        return result;
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return sendEvent.getCreatedTimestamp();
    }

    @Override
    public SendEventDestiny getDestityType() {
        return sendEvent.getDestiny();
    }

    @Override
    public List<String> getAttachedFileIds() {        
        return sendEvent.getAttachedFiles().stream()
        		.map(f -> f.getFileId())
        		.collect(Collectors.toList());
    }

    @Override
    public void attachFile(FileModel file) {
        SendEventAttachedFileEntity entity = new SendEventAttachedFileEntity();
        entity.setFileId(file.getId());
        entity.setSendEvent(sendEvent);
        em.persist(entity);
        sendEvent.getAttachedFiles().add(entity);
    }

    @Override
    public void unattachResponseFile(FileModel file) {
        Iterator<SendEventAttachedFileEntity> it = sendEvent.getAttachedFiles().iterator();
        while (it.hasNext()) {
            SendEventAttachedFileEntity attachFile = it.next();
            if (attachFile.getFileId().equals(file.getId())) {
                it.remove();
                em.remove(attachFile);
            }
        }
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
