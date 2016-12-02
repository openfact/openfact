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
import org.openfact.models.FileModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.FileEntity;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.jpa.entities.SendEventEntity;

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

    public SendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            SendEventEntity sendEvent) {
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
    public boolean getResult() {
        return sendEvent.isResult();
    }

    @Override
    public void setResult(boolean result) {
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
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public List<FileModel> getFileAttatchments() {
        List<FileModel> files = new ArrayList<>();
        for (Map.Entry<String, FileEntity> entry : sendEvent.getFileAttatchments().entrySet())
        {
            FileEntity entity = entry.getValue();

            FileModel model = new FileModel();
            model.setId(entity.getId());
            model.setFile(entity.getFile());
            model.setFileName(entity.getFileName());
            model.setMimeType(entity.getMimeType());

            files.add(model);
        }
        return files;
    }

    @Override
    public void setFileAttatchments(List<FileModel> files) {
        for (FileModel model: files) {
            FileEntity entity = new FileEntity();
            entity.setFileName(model.getFileName());
            entity.setMimeType(model.getMimeType());
            entity.setFile(model.getFile());
            em.persist(entity);

            sendEvent.getFileAttatchments().put(entity.getId(), entity);
        }
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
    public Map<String, String> getDestity() {
        return sendEvent.getDestiny();
    }

    @Override
    public void setDestiny(Map<String, String> destiny) {
        sendEvent.setDestiny(destiny);
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return sendEvent.getCreatedTimestamp();
    }

}
