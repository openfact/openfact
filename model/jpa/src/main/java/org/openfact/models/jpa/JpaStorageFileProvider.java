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
import org.openfact.models.*;
import org.openfact.models.jpa.entities.StorageFileEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JpaStorageFileProvider extends AbstractHibernateStorage implements StorageFileProvider {

    protected static final Logger logger = Logger.getLogger(JpaStorageFileProvider.class);

    private static final String FILE_NAME = "fileName";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaStorageFileProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public StorageFileModel createFile(OrganizationModel organization, String fileName, byte[] file) {
        StorageFileEntity entity = new StorageFileEntity();
        entity.setFileName(fileName);
        entity.setFile(file);
        em.persist(file);
        em.flush();

        return new StorageFileAdapter(session, em, entity);
    }

    @Override
    public StorageFileModel getFileById(OrganizationModel organization, String id) {
        StorageFileEntity entity = em.find(StorageFileEntity.class, id);
        if(entity != null) {
            return new StorageFileAdapter(session, em, entity);
        }
        return null;
    }

    @Override
    public List<StorageFileModel> getFiles(OrganizationModel organization) {
        return getFiles(organization, -1, -1);
    }

    @Override
    public List<StorageFileModel> getFiles(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        TypedQuery<StorageFileEntity> query = em.createNamedQuery("getAllStorageFiles", StorageFileEntity.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }

        List<StorageFileEntity> entities = query.getResultList();
        return entities.stream().map(f -> new StorageFileAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public boolean removeFile(OrganizationModel organization, String id) {
        StorageFileEntity entity = em.find(StorageFileEntity.class, id);
        em.remove(entity);
        return true;
    }

    @Override
    public boolean removeFile(OrganizationModel organization, StorageFileModel file) {
        return removeFile(organization, file.getId());
    }

    @Override
    public void close() {
    }

}
