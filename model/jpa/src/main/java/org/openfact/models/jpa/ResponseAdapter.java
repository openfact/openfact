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

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.ResponseModel;
import org.openfact.models.jpa.entities.ResponseEntity;

public class ResponseAdapter implements ResponseModel, JpaModel<ResponseEntity> {

    protected static final Logger logger = Logger.getLogger(ResponseAdapter.class);
    protected ResponseEntity party;
    protected EntityManager em;
    protected OpenfactSession session;

    public ResponseAdapter(OpenfactSession session, EntityManager em, ResponseEntity supplierResponse) {
        this.session = session;
        this.em = em;
        this.party = supplierResponse;
    }

    @Override
    public ResponseEntity getEntity() {
        return party;
    }

    @Override
    public String getId() {
        return party.getId();
    }

    @Override
    public String getReferenceID() {
        return party.getReferenceId();
    }

    @Override
    public void setReferenceID(String value) {
        party.setReferenceId(value);
    }

    @Override
    public String getResponseCode() {
        return party.getResponseCode();
    }

    @Override
    public void setResponseCode(String value) {
        party.setResponseCode(value);
    }

    @Override
    public List<String> getDescription() {
        return party.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        party.setDescription(description);
    }

}
