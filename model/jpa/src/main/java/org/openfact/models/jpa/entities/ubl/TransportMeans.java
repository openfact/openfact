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
	private AirTransport m_AirTransport;
	private Dimension measurementDimension;
	private MaritimeTransport m_MaritimeTransport;
	private Party ownerParty;
	private RailTransport m_RailTransport;
	private RoadTransport m_RoadTransport;
	private Stowage m_Stowage;

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
	 * @return the m_AirTransport
	 */
	public AirTransport getM_AirTransport() {
		return m_AirTransport;
	}

	/**
	 * @param m_AirTransport
	 *            the m_AirTransport to set
	 */
	public void setM_AirTransport(AirTransport m_AirTransport) {
		this.m_AirTransport = m_AirTransport;
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
	 * @return the m_MaritimeTransport
	 */
	public MaritimeTransport getM_MaritimeTransport() {
		return m_MaritimeTransport;
	}

	/**
	 * @param m_MaritimeTransport
	 *            the m_MaritimeTransport to set
	 */
	public void setM_MaritimeTransport(MaritimeTransport m_MaritimeTransport) {
		this.m_MaritimeTransport = m_MaritimeTransport;
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
	 * @return the m_RailTransport
	 */
	public RailTransport getM_RailTransport() {
		return m_RailTransport;
	}

	/**
	 * @param m_RailTransport
	 *            the m_RailTransport to set
	 */
	public void setM_RailTransport(RailTransport m_RailTransport) {
		this.m_RailTransport = m_RailTransport;
	}

	/**
	 * @return the m_RoadTransport
	 */
	public RoadTransport getM_RoadTransport() {
		return m_RoadTransport;
	}

	/**
	 * @param m_RoadTransport
	 *            the m_RoadTransport to set
	 */
	public void setM_RoadTransport(RoadTransport m_RoadTransport) {
		this.m_RoadTransport = m_RoadTransport;
	}

	/**
	 * @return the m_Stowage
	 */
	public Stowage getM_Stowage() {
		return m_Stowage;
	}

	/**
	 * @param m_Stowage
	 *            the m_Stowage to set
	 */
	public void setM_Stowage(Stowage m_Stowage) {
		this.m_Stowage = m_Stowage;
	}

}