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
package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.ubl.common.ResponseModel;

public class ResponseAdapter implements ResponseModel, JpaModel<ResponseEntity> {

    protected static final Logger logger = Logger.getLogger(ResponseAdapter.class);
    protected ResponseEntity response;
    protected EntityManager em;
    protected OpenfactSession session;

    public ResponseAdapter(OpenfactSession session, EntityManager em, ResponseEntity response) {
        this.session = session;
        this.em = em;
        this.response = response;
    }

    @Override
    public String getReferenceID() {
        return this.response.getReferenceID();
    }

    @Override
    public void setReferenceID(String value) {
        this.response.setReferenceID(value);
    }

    @Override
    public String getResponseCode() {
        return this.response.getResponseCode();
    }

    @Override
    public void setResponseCode(String value) {
        this.response.setResponseCode(value);
    }

    @Override
    public List<String> getDescription() {
        return this.response.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.response.setDescription(description);
    }

    @Override
    public String getId() {
        return this.response.getId();
    }

    @Override
    public ResponseEntity getEntity() {
        return response;
    }

    public static ResponseEntity toEntity(ResponseModel model, EntityManager em) {
        if (model instanceof ResponseAdapter) {
            return ((ResponseAdapter) model).getEntity();
        }
        return em.getReference(ResponseEntity.class, model.getId());
    }

}
