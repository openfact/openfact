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

import java.util.Map;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.UserModel;
import org.openfact.models.jpa.entities.UserEntity;

public class UserAdapter implements UserModel, JpaModel<UserEntity> {

    protected static final Logger logger = Logger.getLogger(UserAdapter.class);
    protected UserEntity user;
    protected EntityManager em;
    protected OpenfactSession session;

    public UserAdapter(OpenfactSession session, EntityManager em, UserEntity user) {
        this.session = session;
        this.em = em;
        this.user = user;
    }

    /*public static UserEntity toEntity(UserModel model, EntityManager em) {
        if (model instanceof UserAdapter) {
            return ((UserAdapter) model).getEntity();
        }
        return em.getReference(UserEntity.class, model.getId());
    }*/

    @Override
    public UserEntity getEntity() {
        return user;
    }

    //@Override
    public String getId() {
        //return user.getId();
        return null;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFullName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getEmail() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasRole(String role) {
        // TODO Auto-generated method stub
        return false;
    }

}
