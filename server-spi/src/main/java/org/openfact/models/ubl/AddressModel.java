package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.type.CodeModel;
import org.openfact.models.ubl.type.IdentifierModel;
import org.openfact.models.ubl.type.NameModel;
import org.openfact.models.ubl.type.TextModel;

public interface AddressModel {

    String getId();

    NameModel getAdditionalStreetName();

    void setAdditionalStreetName(String additionalStreetName);

    void setAdditionalStreetName(NameModel additionalStreetName);

    CodeModel getAddressFormatCode();

    void setAddressFormatCode(CodeModel addressFormatCode);

    CodeModel getAddressTypeCode();

    void setAddressTypeCode(CodeModel addressTypeCode);

    NameModel getBlockName();

    void setBlockName(String blockName);

    void setBlockName(NameModel blockName);

    NameModel getBuildingName();

    void setBuildingName(String buildingName);

    void setBuildingName(NameModel buildingName);

    TextModel getBuildingNumber();

    void setBuildingNumber(String buildingNumber);

    void setBuildingNumber(TextModel buildingNumber);

    NameModel getCityName();

    void setCityName(String cityName);

    void setCityName(NameModel cityName);

    NameModel getCitySubdivisionName();

    void setCitySubdivisionName(String citySubdivisionName);

    void setCitySubdivisionName(NameModel citySubdivisionName);

    TextModel getCountrySubentity();

    void setCountrySubentity(String countrySubentity);

    void setCountrySubentity(TextModel countrySubentity);

    CodeModel getCountrySubentityCode();

    void setCountrySubentityCode(CodeModel countrySubentityCode);

    TextModel getDepartment();

    void setDepartment(String department);

    void setDepartment(TextModel department);

    TextModel getDistrict();

    void setDistrict(String district);

    void setDistrict(TextModel district);

    TextModel getFloor();

    void setFloor(String floor);

    void setFloor(TextModel floor);

    IdentifierModel getID();

    void setID(IdentifierModel iD);

    TextModel getInhouseMail();

    void setInhouseMail(String inhouseMail);

    void setInhouseMail(TextModel inhouseMail);

    TextModel getMarkAttention();

    void setMarkAttention(String markAttention);

    void setMarkAttention(TextModel markAttention);

    TextModel getMarkCare();

    void setMarkCare(String markCare);

    void setMarkCare(TextModel markCare);

    TextModel getPlotIdentification();

    void setPlotIdentification(String plotIdentification);

    void setPlotIdentification(TextModel plotIdentification);

    TextModel getPostalZone();

    void setPostalZone(String postalZone);

    void setPostalZone(TextModel postalZone);

    TextModel getPostbox();

    void setPostbox(String postbox);

    void setPostbox(TextModel postbox);

    TextModel getRegion();

    void setRegion(String region);

    void setRegion(TextModel region);

    TextModel getRoom();

    void setRoom(String room);

    void setRoom(TextModel room);

    NameModel getStreetName();

    void setStreetName(String streetName);

    void setStreetName(NameModel streetName);

    TextModel getTimezoneOffset();

    void setTimezoneOffset(String timezoneOffset);

    void setTimezoneOffset(TextModel timezoneOffset);

    List<AddressLineModel> getAddressLines();

    void setAddressLines(List<AddressLineModel> addressLines);

    List<CountryModel> getCountries();

    void setCountries(List<CountryModel> countries);

    List<LocationCoordinateModel> getLocationCoordinates();

    void setLocationCoordinates(List<LocationCoordinateModel> locationCoordinates);

}
