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
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.LocationCoordinateModel;

public class AddressAdapter implements AddressModel, JpaModel<AddressEntity> {

    protected static final Logger logger = Logger.getLogger(AddressAdapter.class);

    protected AddressEntity address;
    protected EntityManager em;
    protected OpenfactSession session;

    public AddressAdapter(OpenfactSession session, EntityManager em, AddressEntity address) {
        this.session = session;
        this.em = em;
        this.address = address;
    }

    @Override
    public String getID() {
        return address.getID();
    }

    @Override
    public void setID(String value) {
        address.setID(value);
    }

    @Override
    public String getAddressCode() {
        return address.getAddressCode();
    }

    @Override
    public void setAddressCode(String value) {
        address.setAddressCode(value);
    }

    @Override
    public String getAddressFormatCode() {
        return address.getAddressFormatCode();
    }

    @Override
    public void setAddressFormatCode(String value) {
        address.setAddressFormatCode(value);
    }

    @Override
    public String getPostbox() {
        return address.getPostbox();
    }

    @Override
    public void setPostbox(String value) {
        address.setPostbox(value);
    }

    @Override
    public String getFloor() {
        return address.getFloor();
    }

    @Override
    public void setFloor(String value) {
        address.setFloor(value);
    }

    @Override
    public String getRoom() {
        return address.getRoom();
    }

    @Override
    public void setRoom(String value) {
        address.setRoom(value);
    }

    @Override
    public String getStreetName() {
        return address.getStreetName();
    }

    @Override
    public void setStreetName(String value) {
        address.setStreetName(value);
    }

    @Override
    public String getAdditionalStreetName() {
        return address.getAdditionalStreetName();
    }

    @Override
    public void setAdditionalStreetName(String value) {
        address.setAdditionalStreetName(value);
    }

    @Override
    public String getBlockName() {
        return address.getBlockName();
    }

    @Override
    public void setBlockName(String value) {
        address.setBlockName(value);
    }

    @Override
    public String getBuildingName() {
        return address.getBuildingName();
    }

    @Override
    public void setBuildingName(String value) {
        address.setBuildingName(value);
    }

    @Override
    public String getBuildingNumber() {
        return address.getBuildingNumber();
    }

    @Override
    public void setBuildingNumber(String value) {
        address.setBuildingNumber(value);
    }

    @Override
    public String getInhouseMail() {
        return address.getInhouseMail();
    }

    @Override
    public void setInhouseMail(String value) {
        address.setInhouseMail(value);
    }

    @Override
    public String getDepartment() {
        return address.getDepartment();
    }

    @Override
    public void setDepartment(String value) {
        address.setDepartment(value);
    }

    @Override
    public String getMarkAttention() {
        return address.getMarkAttention();
    }

    @Override
    public void setMarkAttention(String value) {
        address.setMarkAttention(value);
    }

    @Override
    public String getMarkCare() {
        return address.getMarkCare();
    }

    @Override
    public void setMarkCare(String value) {
        address.setMarkCare(value);
    }

    @Override
    public String getPlotIdentification() {
        return address.getPlotIdentification();
    }

    @Override
    public void setPlotIdentification(String value) {
        address.setPlotIdentification(value);
    }

    @Override
    public String getCitySubdivisionName() {
        return address.getCitySubdivisionName();
    }

    @Override
    public void setCitySubdivisionName(String value) {
        address.setCitySubdivisionName(value);
    }

    @Override
    public String getCityName() {
        return address.getCityName();
    }

    @Override
    public void setCityName(String value) {
        address.setCityName(value);
    }

    @Override
    public String getPostalZone() {
        return address.getPostalZone();
    }

    @Override
    public void setPostalZone(String value) {
        address.setPostalZone(value);
    }

    @Override
    public String getCountrySubentity() {
        return address.getCountrySubentity();
    }

    @Override
    public void setCountrySubentity(String value) {
        address.setCountrySubentity(value);
    }

    @Override
    public String getCountrySubentityCode() {
        return address.getCountrySubentityCode();
    }

    @Override
    public void setCountrySubentityCode(String value) {
        address.setCountrySubentityCode(value);
    }

    @Override
    public String getRegion() {
        return address.getRegion();
    }

    @Override
    public void setRegion(String value) {
        address.setRegion(value);
    }

    @Override
    public String getDistrict() {
        return address.getDistrict();
    }

    @Override
    public void setDistrict(String value) {
        address.setDistrict(value);
    }

    @Override
    public String getTimezoneOffset() {
        return address.getTimezoneOffset();
    }

    @Override
    public void setTimezoneOffset(String value) {
        address.setTimezoneOffset(value);
    }

    @Override
    public List<String> getAddressLine() {
        return address.getAddressLine();
    }

    @Override
    public void setAddressLine(List<String> addressLine) {
        address.setAddressLine(addressLine);
    }

    @Override
    public CountryModel getCountry() {
        return new CountryAdapter(session, em, address.getCountry());
    }

    @Override
    public void setCountry(CountryModel value) {
        address.setCountry(CountryAdapter.toEntity(value, em));
    }

    @Override
    public LocationCoordinateModel getLocationCoordinate() {
        return new LocationCoordinateAdapter(session, em, address.getLocationCoordinate());
    }

    @Override
    public void setLocationCoordinate(LocationCoordinateModel value) {
        address.setLocationCoordinate(LocationCoordinateAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return address.getId();
    }

    @Override
    public AddressEntity getEntity() {
        return address;
    }

    public static AddressEntity toEntity(AddressModel model, EntityManager em) {
        if (model instanceof AddressAdapter) {
            return ((AddressAdapter) model).getEntity();
        }
        return em.getReference(AddressEntity.class, model.getId());
    }

}
