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

package org.openfact.models.jpa;

import org.openfact.migration.MigrationModel;
import org.openfact.models.jpa.entities.MigrationModelEntity;

import javax.persistence.EntityManager;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class MigrationModelAdapter implements MigrationModel {
    protected EntityManager em;

    public MigrationModelAdapter(EntityManager em) {
        this.em = em;
    }

    @Override
    public String getStoredVersion() {
        MigrationModelEntity entity = em.find(MigrationModelEntity.class, MigrationModelEntity.SINGLETON_ID);
        if (entity == null) return null;
        return entity.getVersion();
    }

    @Override
    public void setStoredVersion(String version) {
        MigrationModelEntity entity = em.find(MigrationModelEntity.class, MigrationModelEntity.SINGLETON_ID);
        if (entity == null) {
            entity = new MigrationModelEntity();
            entity.setId(MigrationModelEntity.SINGLETON_ID);
            entity.setVersion(version);
            em.persist(entity);
        } else {
            entity.setVersion(version);
            em.flush();
        }
    }
}
