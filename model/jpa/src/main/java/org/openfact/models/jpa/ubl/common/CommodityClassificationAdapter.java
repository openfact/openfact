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
import org.openfact.models.jpa.entities.ubl.common.CommodityClassificationEntity;
import org.openfact.models.ubl.common.CommodityClassificationModel;

public class CommodityClassificationAdapter
        implements CommodityClassificationModel, JpaModel<CommodityClassificationEntity> {

    protected static final Logger logger = Logger.getLogger(CommodityClassificationAdapter.class);
    protected CommodityClassificationEntity commodityClassification;
    protected EntityManager em;
    protected OpenfactSession session;

    public CommodityClassificationAdapter(OpenfactSession session, EntityManager em,
            CommodityClassificationEntity commodityClassification) {
        this.session = session;
        this.em = em;
        this.commodityClassification = commodityClassification;
    }

    @Override
    public String getNatureCode() {
        return this.commodityClassification.getNatureCode();
    }

    @Override
    public void setNatureCode(String value) {
        this.commodityClassification.setNatureCode(value);
    }

    @Override
    public String getCargoCode() {
        return this.commodityClassification.getCargoCode();
    }

    @Override
    public void setCargoCode(String value) {
        this.commodityClassification.setCargoCode(value);
    }

    @Override
    public String getCommodityCode() {
        return this.commodityClassification.getCommodityCode();
    }

    @Override
    public void setCommodityCode(String value) {
        this.commodityClassification.setCommodityCode(value);
    }

    @Override
    public String getItemClassificationCode() {
        return this.commodityClassification.getItemClassificationCode();
    }

    @Override
    public void setItemClassificationCode(String value) {
        this.commodityClassification.setItemClassificationCode(value);
    }

    @Override
    public String getId() {
        return this.commodityClassification.getId();
    }

    @Override
    public CommodityClassificationEntity getEntity() {
        return commodityClassification;
    }

    public static CommodityClassificationEntity toEntity(CommodityClassificationModel model,
            EntityManager em) {
        if (model instanceof CommodityClassificationAdapter) {
            return ((CommodityClassificationAdapter) model).getEntity();
        }
        return em.getReference(CommodityClassificationEntity.class, model.getId());
    }

}
