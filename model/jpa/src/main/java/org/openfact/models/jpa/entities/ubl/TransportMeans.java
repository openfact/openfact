package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeans {

    /**
     * A code signifying the direction of this means of transport.
     */
    private String directionCode;
    /**
     * An identifier for the regular service schedule of this means of
     * transport.
     */
    private String journeyID;
    /**
     * Text describing the country in which this means of transport is
     * registered.
     */
    private String registrationNationality;
    /**
     * An identifier for the country in which this means of transport is
     * registered.
     */
    private String registrationNationalityID;
    /**
     * A code signifying the service regularly provided by the carrier operating
     * this means of transport.
     */
    private String tradeServiceCode;
    /**
     * A code signifying the type of this means of transport (truck, vessel,
     * etc.).
     */
    private String transportMeansTypeCode;
    private List<AirTransport> airTransports = new ArrayList<>();
    private Dimension measurementDimension;
    private List<MaritimeTransport> maritimeTransports = new ArrayList<>();
    private Party ownerParty;
    private List<RailTransport> railTransports = new ArrayList<>();
    private List<RoadTransport> roadTransports = new ArrayList<>();
    private List<Stowage> stowages = new ArrayList<>();

    /**
     * @return the directionCode
     */
    public String getDirectionCode() {
        return directionCode;
    }

    /**
     * @param directionCode
     *            the directionCode to set
     */
    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    /**
     * @return the journeyID
     */
    public String getJourneyID() {
        return journeyID;
    }

    /**
     * @param journeyID
     *            the journeyID to set
     */
    public void setJourneyID(String journeyID) {
        this.journeyID = journeyID;
    }

    /**
     * @return the registrationNationality
     */
    public String getRegistrationNationality() {
        return registrationNationality;
    }

    /**
     * @param registrationNationality
     *            the registrationNationality to set
     */
    public void setRegistrationNationality(String registrationNationality) {
        this.registrationNationality = registrationNationality;
    }

    /**
     * @return the registrationNationalityID
     */
    public String getRegistrationNationalityID() {
        return registrationNationalityID;
    }

    /**
     * @param registrationNationalityID
     *            the registrationNationalityID to set
     */
    public void setRegistrationNationalityID(String registrationNationalityID) {
        this.registrationNationalityID = registrationNationalityID;
    }

    /**
     * @return the tradeServiceCode
     */
    public String getTradeServiceCode() {
        return tradeServiceCode;
    }

    /**
     * @param tradeServiceCode
     *            the tradeServiceCode to set
     */
    public void setTradeServiceCode(String tradeServiceCode) {
        this.tradeServiceCode = tradeServiceCode;
    }

    /**
     * @return the transportMeansTypeCode
     */
    public String getTransportMeansTypeCode() {
        return transportMeansTypeCode;
    }

    /**
     * @param transportMeansTypeCode
     *            the transportMeansTypeCode to set
     */
    public void setTransportMeansTypeCode(String transportMeansTypeCode) {
        this.transportMeansTypeCode = transportMeansTypeCode;
    }

    /**
     * @return the airTransports
     */
    public List<AirTransport> getAirTransports() {
        return airTransports;
    }

    /**
     * @param airTransports
     *            the airTransports to set
     */
    public void setAirTransports(List<AirTransport> airTransports) {
        this.airTransports = airTransports;
    }

    /**
     * @return the measurementDimension
     */
    public Dimension getMeasurementDimension() {
        return measurementDimension;
    }

    /**
     * @param measurementDimension
     *            the measurementDimension to set
     */
    public void setMeasurementDimension(Dimension measurementDimension) {
        this.measurementDimension = measurementDimension;
    }

    /**
     * @return the maritimeTransports
     */
    public List<MaritimeTransport> getMaritimeTransports() {
        return maritimeTransports;
    }

    /**
     * @param maritimeTransports
     *            the maritimeTransports to set
     */
    public void setMaritimeTransports(List<MaritimeTransport> maritimeTransports) {
        this.maritimeTransports = maritimeTransports;
    }

    /**
     * @return the ownerParty
     */
    public Party getOwnerParty() {
        return ownerParty;
    }

    /**
     * @param ownerParty
     *            the ownerParty to set
     */
    public void setOwnerParty(Party ownerParty) {
        this.ownerParty = ownerParty;
    }

    /**
     * @return the railTransports
     */
    public List<RailTransport> getRailTransports() {
        return railTransports;
    }

    /**
     * @param railTransports
     *            the railTransports to set
     */
    public void setRailTransports(List<RailTransport> railTransports) {
        this.railTransports = railTransports;
    }

    /**
     * @return the roadTransports
     */
    public List<RoadTransport> getRoadTransports() {
        return roadTransports;
    }

    /**
     * @param roadTransports
     *            the roadTransports to set
     */
    public void setRoadTransports(List<RoadTransport> roadTransports) {
        this.roadTransports = roadTransports;
    }

    /**
     * @return the stowages
     */
    public List<Stowage> getStowages() {
        return stowages;
    }

    /**
     * @param stowages
     *            the stowages to set
     */
    public void setStowages(List<Stowage> stowages) {
        this.stowages = stowages;
    }

}