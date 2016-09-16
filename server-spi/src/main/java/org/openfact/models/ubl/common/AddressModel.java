package org.openfact.models.ubl.common;

import java.util.List;

public interface AddressModel {

    String getID();

    void setID(String value);

    String getAddressModelCode();

    void setAddressModelCode(String value);

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

    void setId(String value);

}
