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
package org.openfact.models.ubl.common;

import java.util.List;

public interface AddressModel {

    String getID();

    void setID(String value);

    String getAddressCode();

    void setAddressCode(String value);

    String getAddressFormatCode();

    void setAddressFormatCode(String value);

    String getPostbox();

    void setPostbox(String value);

    String getFloor();

    void setFloor(String value);

    String getRoom();

    void setRoom(String value);

    String getStreetName();

    void setStreetName(String value);

    String getAdditionalStreetName();

    void setAdditionalStreetName(String value);

    String getBlockName();

    void setBlockName(String value);

    String getBuildingName();

    void setBuildingName(String value);

    String getBuildingNumber();

    void setBuildingNumber(String value);

    String getInhouseMail();

    void setInhouseMail(String value);

    String getDepartment();

    void setDepartment(String value);

    String getMarkAttention();

    void setMarkAttention(String value);

    String getMarkCare();

    void setMarkCare(String value);

    String getPlotIdentification();

    void setPlotIdentification(String value);

    String getCitySubdivisionName();

    void setCitySubdivisionName(String value);

    String getCityName();

    void setCityName(String value);

    String getPostalZone();

    void setPostalZone(String value);

    String getCountrySubentity();

    void setCountrySubentity(String value);

    String getCountrySubentityCode();

    void setCountrySubentityCode(String value);

    String getRegion();

    void setRegion(String value);

    String getDistrict();

    void setDistrict(String value);

    String getTimezoneOffset();

    void setTimezoneOffset(String value);

    List<String> getAddressLine();

    void setAddressLine(List<String> addressLine);

    CountryModel getCountry();

    void setCountry(CountryModel value);

    LocationCoordinateModel getLocationCoordinate();

    void setLocationCoordinate(LocationCoordinateModel value);

    String getId();

}
