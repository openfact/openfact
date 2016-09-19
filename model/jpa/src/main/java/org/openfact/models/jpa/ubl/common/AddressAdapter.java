package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getID() {
        return this.address.getID();
    }

    void setID(String value) {
        this.address.setID(value);
    }

    String getAddressAdapterCode() {
        return this.address.getAddressAdapterCode();
    }

    void setAddressAdapterCode(String value) {
        this.address.setAddressAdapterCode(value);
    }

    String getAddressFormatCode() {
        return this.address.getAddressFormatCode();
    }

    void setAddressFormatCode(String value) {
        this.address.setAddressFormatCode(value);
    }

    String getPostbox() {
        return this.address.getPostbox();
    }

    void setPostbox(String value) {
        this.address.setPostbox(value);
    }

    String getFloor() {
        return this.address.getFloor();
    }

    void setFloor(String value) {
        this.address.setFloor(value);
    }

    String getRoom() {
        return this.address.getRoom();
    }

    void setRoom(String value) {
        this.address.setRoom(value);
    }

    String getStreetName() {
        return this.address.getStreetName();
    }

    void setStreetName(String value) {
        this.address.setStreetName(value);
    }

    String getAdditionalStreetName() {
        return this.address.getAdditionalStreetName();
    }

    void setAdditionalStreetName(String value) {
        this.address.setAdditionalStreetName(value);
    }

    String getBlockName() {
        return this.address.getBlockName();
    }

    void setBlockName(String value) {
        this.address.setBlockName(value);
    }

    String getBuildingName() {
        return this.address.getBuildingName();
    }

    void setBuildingName(String value) {
        this.address.setBuildingName(value);
    }

    String getBuildingNumber() {
        return this.address.getBuildingNumber();
    }

    void setBuildingNumber(String value) {
        this.address.setBuildingNumber(value);
    }

    String getInhouseMail() {
        return this.address.getInhouseMail();
    }

    void setInhouseMail(String value) {
        this.address.setInhouseMail(value);
    }

    String getDepartment() {
        return this.address.getDepartment();
    }

    void setDepartment(String value) {
        this.address.setDepartment(value);
    }

    String getMarkAttention() {
        return this.address.getMarkAttention();
    }

    void setMarkAttention(String value) {
        this.address.setMarkAttention(value);
    }

    String getMarkCare() {
        return this.address.getMarkCare();
    }

    void setMarkCare(String value) {
        this.address.setMarkCare(value);
    }

    String getPlotIdentification() {
        return this.address.getPlotIdentification();
    }

    void setPlotIdentification(String value) {
        this.address.setPlotIdentification(value);
    }

    String getCitySubdivisionName() {
        return this.address.getCitySubdivisionName();
    }

    void setCitySubdivisionName(String value) {
        this.address.setCitySubdivisionName(value);
    }

    String getCityName() {
        return this.address.getCityName();
    }

    void setCityName(String value) {
        this.address.setCityName(value);
    }

    String getPostalZone() {
        return this.address.getPostalZone();
    }

    void setPostalZone(String value) {
        this.address.setPostalZone(value);
    }

    String getCountrySubentity() {
        return this.address.getCountrySubentity();
    }

    void setCountrySubentity(String value) {
        this.address.setCountrySubentity(value);
    }

    String getCountrySubentityCode() {
        return this.address.getCountrySubentityCode();
    }

    void setCountrySubentityCode(String value) {
        this.address.setCountrySubentityCode(value);
    }

    String getRegion() {
        return this.address.getRegion();
    }

    void setRegion(String value) {
        this.address.setRegion(value);
    }

    String getDistrict() {
        return this.address.getDistrict();
    }

    void setDistrict(String value) {
        this.address.setDistrict(value);
    }

    String getTimezoneOffset() {
        return this.address.getTimezoneOffset();
    }

    void setTimezoneOffset(String value) {
        this.address.setTimezoneOffset(value);
    }

    List<String> getAddressLine() {
        return this.address.getAddressLine();
    }

    void setAddressLine(List<String> addressLine) {
        this.address.setAddressLine(addressLine);
    }

    CountryAdapter getCountry() {
        return this.address.getCountry();
    }

    void setCountry(CountryAdapter value) {
        this.address.setCountry(value);
    }

    LocationCoordinateAdapter getLocationCoordinate() {
        return this.address.getLocationCoordinate();
    }

    void setLocationCoordinate(LocationCoordinateAdapter value) {
        this.address.setLocationCoordinate(value);
    }

    String getId() {
        return this.address.getId();
    }

    void setId(String value) {
        this.address.setId(value);
    }

}
