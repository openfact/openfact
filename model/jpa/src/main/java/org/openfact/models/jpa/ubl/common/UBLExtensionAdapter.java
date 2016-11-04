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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionEntity;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.UBLExtensionModel;

public class UBLExtensionAdapter implements UBLExtensionModel, JpaModel<UBLExtensionEntity> {

    protected static final Logger logger = Logger.getLogger(UBLExtensionAdapter.class);
    protected UBLExtensionEntity uBLExtension;
    protected EntityManager em;
    protected OpenfactSession session;

    public UBLExtensionAdapter(OpenfactSession session, EntityManager em, UBLExtensionEntity uBLExtension) {
        this.session = session;
        this.em = em;
        this.uBLExtension = uBLExtension;
    }

    @Override
    public String getID() {
        return this.uBLExtension.getID();
    }

    @Override
    public void setID(String value) {
        this.uBLExtension.setID(value);
    }

    @Override
    public String getName() {
        return this.uBLExtension.getName();
    }

    @Override
    public void setName(String value) {
        this.uBLExtension.setName(value);
    }

    @Override
    public String getExtensionAgencyID() {
        return this.uBLExtension.getExtensionAgencyID();
    }

    @Override
    public void setExtensionAgencyID(String value) {
        this.uBLExtension.setExtensionAgencyID(value);
    }

    @Override
    public String getExtensionAgencyName() {
        return this.uBLExtension.getExtensionAgencyName();
    }

    @Override
    public void setExtensionAgencyName(String value) {
        this.uBLExtension.setExtensionAgencyName(value);
    }

    @Override
    public String getExtensionVersionID() {
        return this.uBLExtension.getExtensionVersionID();
    }

    @Override
    public void setExtensionVersionID(String value) {
        this.uBLExtension.setExtensionVersionID(value);
    }

    @Override
    public String getExtensionAgencyURI() {
        return this.uBLExtension.getExtensionAgencyURI();
    }

    @Override
    public void setExtensionAgencyURI(String value) {
        this.uBLExtension.setExtensionAgencyURI(value);
    }

    @Override
    public String getExtensionURI() {
        return this.uBLExtension.getExtensionURI();
    }

    @Override
    public void setExtensionURI(String value) {
        this.uBLExtension.setExtensionURI(value);
    }

    @Override
    public String getExtensionReasonCode() {
        return this.uBLExtension.getExtensionReasonCode();
    }

    @Override
    public void setExtensionReasonCode(String value) {
        this.uBLExtension.setExtensionReasonCode(value);
    }

    @Override
    public String getExtensionReason() {
        return this.uBLExtension.getExtensionReason();
    }

    @Override
    public void setExtensionReason(String value) {
        this.uBLExtension.setExtensionReason(value);
    }

    @Override
    public ExtensionContentModel getExtensionContent() {
        return new ExtensionContentAdapter(session, em, uBLExtension.getExtensionContent());
    }

    @Override
    public void setExtensionContent(ExtensionContentModel value) {
        uBLExtension.setExtensionContent(ExtensionContentAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.uBLExtension.getId();
    }

    @Override
    public UBLExtensionEntity getEntity() {
        return this.uBLExtension;
    }

    public static UBLExtensionEntity toEntity(UBLExtensionModel model, EntityManager em) {
        if (model instanceof UBLExtensionAdapter) {
            return ((UBLExtensionAdapter) model).getEntity();
        }
        return em.getReference(UBLExtensionEntity.class, model.getId());
    }

}
