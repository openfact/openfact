package org.openfact.models.ubl.common;

import java.util.List;

public interface AddressType {

    IDType getID();

    void setID(IDType value);

    AddressTypeCodeType getAddressTypeCode();

    void setAddressTypeCode(AddressTypeCodeType value);

    AddressFormatCodeType getAddressFormatCode();

    void setAddressFormatCode(AddressFormatCodeType value);

    PostboxType getPostbox();

    void setPostbox(PostboxType value);

    FloorType getFloor();

    void setFloor(FloorType value);

    RoomType getRoom();

    void setRoom(RoomType value);

    StreetNameType getStreetName();

    void setStreetName(StreetNameType value);

    AdditionalStreetNameType getAdditionalStreetName();

    void setAdditionalStreetName(AdditionalStreetNameType value);

    BlockNameType getBlockName();

    void setBlockName(BlockNameType value);

    BuildingNameType getBuildingName();

    void setBuildingName(BuildingNameType value);

    BuildingNumberType getBuildingNumber();

    void setBuildingNumber(BuildingNumberType value);

    InhouseMailType getInhouseMail();

    void setInhouseMail(InhouseMailType value);

    DepartmentType getDepartment();

    void setDepartment(DepartmentType value);

    MarkAttentionType getMarkAttention();

    void setMarkAttention(MarkAttentionType value);

    MarkCareType getMarkCare();

    void setMarkCare(MarkCareType value);

    PlotIdentificationType getPlotIdentification();

    void setPlotIdentification(PlotIdentificationType value);

    CitySubdivisionNameType getCitySubdivisionName();

    void setCitySubdivisionName(CitySubdivisionNameType value);

    CityNameType getCityName();

    void setCityName(CityNameType value);

    PostalZoneType getPostalZone();

    void setPostalZone(PostalZoneType value);

    CountrySubentityType getCountrySubentity();

    void setCountrySubentity(CountrySubentityType value);

    CountrySubentityCodeType getCountrySubentityCode();

    void setCountrySubentityCode(CountrySubentityCodeType value);

    RegionType getRegion();

    void setRegion(RegionType value);

    DistrictType getDistrict();

    void setDistrict(DistrictType value);

    TimezoneOffsetType getTimezoneOffset();

    void setTimezoneOffset(TimezoneOffsetType value);

    List<AddressLineType> getAddressLine();

    void setAddressLine(List<AddressLineType> addressLine);

    CountryType getCountry();

    void setCountry(CountryType value);

    LocationCoordinateType getLocationCoordinate();

    void setLocationCoordinate(LocationCoordinateType value);

    String getId();

    void setId(String value);

}
