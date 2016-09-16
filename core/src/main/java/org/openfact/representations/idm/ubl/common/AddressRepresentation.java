package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class AddressRepresentation {
    private String ID;
    private String addressRepresentationCode;
    private String addressFormatCode;
    private String postbox;
    private String floor;
    private String room;
    private String streetName;
    private String additionalStreetName;
    private String blockName;
    private String buildingName;
    private String buildingNumber;
    private String inhouseMail;
    private String department;
    private String markAttention;
    private String markCare;
    private String plotIdentification;
    private String citySubdivisionName;
    private String cityName;
    private String postalZone;
    private String countrySubentity;
    private String countrySubentityCode;
    private String region;
    private String district;
    private String timezoneOffset;
    private List<String> addressLine;
    private CountryRepresentation country;
    private LocationCoordinateRepresentation locationCoordinate;
    private String id;

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildingNumber() {
        return this.buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public List<String> getAddressLine() {
        return this.addressLine;
    }

    public void setAddressLine(List<String> addressLine) {
        this.addressLine = addressLine;
    }

    public String getAdditionalStreetName() {
        return this.additionalStreetName;
    }

    public void setAdditionalStreetName(String additionalStreetName) {
        this.additionalStreetName = additionalStreetName;
    }

    public String getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(String timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public String getMarkCare() {
        return this.markCare;
    }

    public void setMarkCare(String markCare) {
        this.markCare = markCare;
    }

    public String getCountrySubentity() {
        return this.countrySubentity;
    }

    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocationCoordinateRepresentation getLocationCoordinate() {
        return this.locationCoordinate;
    }

    public void setLocationCoordinate(LocationCoordinateRepresentation locationCoordinate) {
        this.locationCoordinate = locationCoordinate;
    }

    public String getPostbox() {
        return this.postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public String getPostalZone() {
        return this.postalZone;
    }

    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getMarkAttention() {
        return this.markAttention;
    }

    public void setMarkAttention(String markAttention) {
        this.markAttention = markAttention;
    }

    public String getCountrySubentityCode() {
        return this.countrySubentityCode;
    }

    public void setCountrySubentityCode(String countrySubentityCode) {
        this.countrySubentityCode = countrySubentityCode;
    }

    public String getCitySubdivisionName() {
        return this.citySubdivisionName;
    }

    public void setCitySubdivisionName(String citySubdivisionName) {
        this.citySubdivisionName = citySubdivisionName;
    }

    public String getAddressFormatCode() {
        return this.addressFormatCode;
    }

    public void setAddressFormatCode(String addressFormatCode) {
        this.addressFormatCode = addressFormatCode;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public CountryRepresentation getCountry() {
        return this.country;
    }

    public void setCountry(CountryRepresentation country) {
        this.country = country;
    }

    public String getInhouseMail() {
        return this.inhouseMail;
    }

    public void setInhouseMail(String inhouseMail) {
        this.inhouseMail = inhouseMail;
    }

    public String getAddressRepresentationCode() {
        return this.addressRepresentationCode;
    }

    public void setAddressRepresentationCode(String addressRepresentationCode) {
        this.addressRepresentationCode = addressRepresentationCode;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPlotIdentification() {
        return this.plotIdentification;
    }

    public void setPlotIdentification(String plotIdentification) {
        this.plotIdentification = plotIdentification;
    }
}