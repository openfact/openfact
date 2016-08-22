package org.openfact.models;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface PostalAddressSavedModel {

    String getId();

    String getStreetName();

    void setStreetName(String streetName);

    String getCitySubdivisionName();

    void setCitySubdivisionName(String citySubdivisionName);

    String getCityName();

    void setCityName(String cityName);

    String getCountrySubentity();

    void setCountrySubentity(String countrySubentity);

    String getDistrict();

    void setDistrict(String district);

    String getCountryIdentificationCode();

    void setCountryIdentificationCode(String countryIdentificationCode);

}
