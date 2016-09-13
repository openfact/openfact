package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

public interface AddressModel {

    String getId();

    NameType getAdditionalStreetName();

    void setAdditionalStreetName(String additionalStreetName);

    void setAdditionalStreetName(NameType additionalStreetName);

    CodeType getAddressFormatCode();

    void setAddressFormatCode(CodeType addressFormatCode);

    CodeType getAddressTypeCode();

    void setAddressTypeCode(CodeType addressTypeCode);

    NameType getBlockName();

    void setBlockName(String blockName);

    void setBlockName(NameType blockName);

    NameType getBuildingName();

    void setBuildingName(String buildingName);

    void setBuildingName(NameType buildingName);

    TextType getBuildingNumber();

    void setBuildingNumber(String buildingNumber);

    void setBuildingNumber(TextType buildingNumber);

    NameType getCityName();

    void setCityName(String cityName);

    void setCityName(NameType cityName);

    NameType getCitySubdivisionName();

    void setCitySubdivisionName(String citySubdivisionName);

    void setCitySubdivisionName(NameType citySubdivisionName);

    TextType getCountrySubentity();

    void setCountrySubentity(String countrySubentity);

    void setCountrySubentity(TextType countrySubentity);

    CodeType getCountrySubentityCode();

    void setCountrySubentityCode(CodeType countrySubentityCode);

    TextType getDepartment();

    void setDepartment(String department);

    void setDepartment(TextType department);

    TextType getDistrict();

    void setDistrict(String district);

    void setDistrict(TextType district);

    TextType getFloor();

    void setFloor(String floor);

    void setFloor(TextType floor);

    IdentifierType getID();

    void setID(IdentifierType iD);

    TextType getInhouseMail();

    void setInhouseMail(String inhouseMail);

    void setInhouseMail(TextType inhouseMail);

    TextType getMarkAttention();

    void setMarkAttention(String markAttention);

    void setMarkAttention(TextType markAttention);

    TextType getMarkCare();

    void setMarkCare(String markCare);

    void setMarkCare(TextType markCare);

    TextType getPlotIdentification();

    void setPlotIdentification(String plotIdentification);

    void setPlotIdentification(TextType plotIdentification);

    TextType getPostalZone();

    void setPostalZone(String postalZone);

    void setPostalZone(TextType postalZone);

    TextType getPostbox();

    void setPostbox(String postbox);

    void setPostbox(TextType postbox);

    TextType getRegion();

    void setRegion(String region);

    void setRegion(TextType region);

    TextType getRoom();

    void setRoom(String room);

    void setRoom(TextType room);

    NameType getStreetName();

    void setStreetName(String streetName);

    void setStreetName(NameType streetName);

    TextType getTimezoneOffset();

    void setTimezoneOffset(String timezoneOffset);

    void setTimezoneOffset(TextType timezoneOffset);

    List<AddressLineModel> getAddressLines();

    void setAddressLines(List<AddressLineModel> addressLines);

    List<CountryModel> getCountries();

    void setCountries(List<CountryModel> countries);

    List<LocationCoordinateModel> getLocationCoordinates();

    void setLocationCoordinates(List<LocationCoordinateModel> locationCoordinates);

}
