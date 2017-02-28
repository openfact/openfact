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

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.openfact.files.FileModel;
import org.openfact.files.FileProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.FileEntity;

@Stateless
public class JpaFileProvider implements FileProvider {

    protected static final Logger logger = Logger.getLogger(JpaFileProvider.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public FileModel createFile(OrganizationModel organization, String fileName, byte[] file) {
        FileEntity entity = new FileEntity();
        entity.setFileName(fileName);
        entity.setFile(file);
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(entity);
        return new FileAdapter(em, entity);
    }

    @Override
    public FileModel getFileById(OrganizationModel organization, String id) {
        FileEntity entity = em.find(FileEntity.class, id);
        if (entity != null) {
            return new FileAdapter(em, entity);
        }
        return null;
    }

    @Override
    public boolean removeFile(OrganizationModel organization, FileModel file) {
        FileEntity entity = em.find(FileEntity.class, file.getId());
        if (entity != null && entity.getOrganization().getId().equals(organization.getId())) {
            em.remove(entity);
            em.flush();
            return true;
        }
        return false;
    }

    @Override
    public void preRemove(OrganizationModel organization) {
         em.createNamedQuery("deleteFilesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }
}
