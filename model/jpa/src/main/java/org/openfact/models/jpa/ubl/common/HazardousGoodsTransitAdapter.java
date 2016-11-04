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
import org.openfact.models.jpa.entities.ubl.common.HazardousGoodsTransitEntity;
import org.openfact.models.ubl.common.HazardousGoodsTransitModel;
import org.openfact.models.ubl.common.TemperatureModel;

public class HazardousGoodsTransitAdapter
        implements HazardousGoodsTransitModel, JpaModel<HazardousGoodsTransitEntity> {

    protected static final Logger logger = Logger.getLogger(HazardousGoodsTransitAdapter.class);
    protected HazardousGoodsTransitEntity hazardousGoodsTransit;
    protected EntityManager em;
    protected OpenfactSession session;

    public HazardousGoodsTransitAdapter(OpenfactSession session, EntityManager em,
            HazardousGoodsTransitEntity hazardousGoodsTransit) {
        this.session = session;
        this.em = em;
        this.hazardousGoodsTransit = hazardousGoodsTransit;
    }

    @Override
    public String getTransportEmergencyCardCode() {
        return this.hazardousGoodsTransit.getTransportEmergencyCardCode();
    }

    @Override
    public void setTransportEmergencyCardCode(String value) {
        this.hazardousGoodsTransit.setTransportEmergencyCardCode(value);
    }

    @Override
    public String getPackingCriteriaCode() {
        return this.hazardousGoodsTransit.getPackingCriteriaCode();
    }

    @Override
    public void setPackingCriteriaCode(String value) {
        this.hazardousGoodsTransit.setPackingCriteriaCode(value);
    }

    @Override
    public String getHazardousRegulationCode() {
        return this.hazardousGoodsTransit.getHazardousRegulationCode();
    }

    @Override
    public void setHazardousRegulationCode(String value) {
        this.hazardousGoodsTransit.setHazardousRegulationCode(value);
    }

    @Override
    public String getInhalationToxicityZoneCode() {
        return this.hazardousGoodsTransit.getInhalationToxicityZoneCode();
    }

    @Override
    public void setInhalationToxicityZoneCode(String value) {
        this.hazardousGoodsTransit.setInhalationToxicityZoneCode(value);
    }

    @Override
    public String getTransportAuthorizationCode() {
        return this.hazardousGoodsTransit.getTransportAuthorizationCode();
    }

    @Override
    public void setTransportAuthorizationCode(String value) {
        this.hazardousGoodsTransit.setTransportAuthorizationCode(value);
    }

    @Override
    public TemperatureModel getMaximumTemperature() {
        return new TemperatureAdapter(session, em, hazardousGoodsTransit.getMaximumTemperature());
    }

    @Override
    public void setMaximumTemperature(TemperatureModel value) {
        this.hazardousGoodsTransit.setMaximumTemperature(TemperatureAdapter.toEntity(value, em));
    }

    @Override
    public TemperatureModel getMinimumTemperature() {
        return new TemperatureAdapter(session, em, hazardousGoodsTransit.getMinimumTemperature());
    }

    @Override
    public void setMinimumTemperature(TemperatureModel value) {
        this.hazardousGoodsTransit.setMinimumTemperature(TemperatureAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.hazardousGoodsTransit.getId();
    }

    public static HazardousGoodsTransitEntity toEntity(HazardousGoodsTransitModel model, EntityManager em) {
        if (model instanceof HazardousGoodsTransitAdapter) {
            return ((HazardousGoodsTransitAdapter) model).getEntity();
        }
        return em.getReference(HazardousGoodsTransitEntity.class, model.getId());
    }

    @Override
    public HazardousGoodsTransitEntity getEntity() {
        return hazardousGoodsTransit;
    }

}
