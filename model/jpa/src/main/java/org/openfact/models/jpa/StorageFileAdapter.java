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

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.StorageFileModel;
import org.openfact.models.jpa.entities.*;

import javax.persistence.EntityManager;

public class StorageFileAdapter implements StorageFileModel, JpaModel<StorageFileEntity> {

    protected static final Logger logger = Logger.getLogger(StorageFileAdapter.class);

    protected StorageFileEntity file;
    protected EntityManager em;
    protected OpenfactSession session;

    public StorageFileAdapter(OpenfactSession session, EntityManager em, StorageFileEntity file) {
        this.session = session;
        this.em = em;
        this.file = file;
    }

    public static StorageFileEntity toEntity(StorageFileModel model, EntityManager em) {
        if (model instanceof StorageFileAdapter) {
            return ((StorageFileAdapter) model).getEntity();
        }
        return em.getReference(StorageFileEntity.class, model.getId());
    }

    @Override
    public StorageFileEntity getEntity() {
        return file;
    }

    @Override
    public String getId() {
        return file.getId();
    }

    @Override
    public String getFileName() {
        return file.getFileName();
    }

    @Override
    public void setFileName(String fileName) {
        file.setFileName(fileName);
    }

    @Override
    public String getMimeType() {
        return file.getMimeType();
    }

    @Override
    public void setMimeType(String mimeType) {
        file.setMimeType(mimeType);
    }

    @Override
    public byte[] getFile() {
        return file.getFile();
    }

    @Override
    public void setFile(byte[] bytes) {
        file.setFile(bytes);
    }

}
