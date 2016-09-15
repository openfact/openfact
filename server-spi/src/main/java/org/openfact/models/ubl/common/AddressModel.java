package org.openfact.models.ubl.common;

import java.util.List;

public interface AddressModel {

    IDModel getID();

    void setID(IDModel value);

    String getAddressModelCode();

    void setAddressModelCode(String value);

    String getAddressFormatCode();

    void setAddressFormatCode(String value);

    PostboxModel getPostbox();

    void setPostbox(PostboxModel value);

    FloorModel getFloor();

    void setFloor(FloorModel value);

    RoomModel getRoom();

    void setRoom(RoomModel value);

    StreetNameModel getStreetName();

    void setStreetName(StreetNameModel value);

    AdditionalStreetNameModel getAdditionalStreetName();

    void setAdditionalStreetName(AdditionalStreetNameModel value);

    BlockNameModel getBlockName();

    void setBlockName(BlockNameModel value);

    BuildingNameModel getBuildingName();

    void setBuildingName(BuildingNameModel value);

    BuildingNumberModel getBuildingNumber();

    void setBuildingNumber(BuildingNumberModel value);

    InhouseMailModel getInhouseMail();

    void setInhouseMail(InhouseMailModel value);

    DepartmentModel getDepartment();

    void setDepartment(DepartmentModel value);

    MarkAttentionModel getMarkAttention();

    void setMarkAttention(MarkAttentionModel value);

    MarkCareModel getMarkCare();

    void setMarkCare(MarkCareModel value);

    PlotIdentificationModel getPlotIdentification();

    void setPlotIdentification(PlotIdentificationModel value);

    CitySubdivisionNameModel getCitySubdivisionName();

    void setCitySubdivisionName(CitySubdivisionNameModel value);

    CityNameModel getCityName();

    void setCityName(CityNameModel value);

    PostalZoneModel getPostalZone();

    void setPostalZone(PostalZoneModel value);

    CountrySubentityModel getCountrySubentity();

    void setCountrySubentity(CountrySubentityModel value);

    String getCountrySubentityCode();

    void setCountrySubentityCode(String value);

    RegionModel getRegion();

    void setRegion(RegionModel value);

    DistrictModel getDistrict();

    void setDistrict(DistrictModel value);

    TimezoneOffsetModel getTimezoneOffset();

    void setTimezoneOffset(TimezoneOffsetModel value);

    List<AddressLineModel> getAddressLine();

    void setAddressLine(List<AddressLineModel> addressLine);

    CountryModel getCountry();

    void setCountry(CountryModel value);

    LocationCoordinateModel getLocationCoordinate();

    void setLocationCoordinate(LocationCoordinateModel value);

    String getId();

    void setId(String value);

}
