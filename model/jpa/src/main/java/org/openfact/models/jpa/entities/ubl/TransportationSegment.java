package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe one segment or leg in a transportation service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegment {

	/**
	 * A number indicating the order of this segment in the sequence of
	 * transportation segments making up a transportation service.
	 */
	private BigDecimal SequenceNumeric;
	/**
	 * An identifier for the transport execution plan governing this
	 * transportation segment.
	 */
	private String TransportExecutionPlanReferenceID;
	private Consignment ReferencedConsignment;
	private Party TransportServiceProviderParty;
	private ShipmentStage m_ShipmentStage;
	private TransportationService m_TransportationService;

	/**
	 * @return the sequenceNumeric
	 */
	public BigDecimal getSequenceNumeric() {
		return SequenceNumeric;
	}

	/**
	 * @param sequenceNumeric
	 *            the sequenceNumeric to set
	 */
	public void setSequenceNumeric(BigDecimal sequenceNumeric) {
		SequenceNumeric = sequenceNumeric;
	}

	/**
	 * @return the transportExecutionPlanReferenceID
	 */
	public String getTransportExecutionPlanReferenceID() {
		return TransportExecutionPlanReferenceID;
	}

	/**
	 * @param transportExecutionPlanReferenceID
	 *            the transportExecutionPlanReferenceID to set
	 */
	public void setTransportExecutionPlanReferenceID(String transportExecutionPlanReferenceID) {
		TransportExecutionPlanReferenceID = transportExecutionPlanReferenceID;
	}

	/**
	 * @return the referencedConsignment
	 */
	public Consignment getReferencedConsignment() {
		return ReferencedConsignment;
	}

	/**
	 * @param referencedConsignment
	 *            the referencedConsignment to set
	 */
	public void setReferencedConsignment(Consignment referencedConsignment) {
		ReferencedConsignment = referencedConsignment;
	}

	/**
	 * @return the transportServiceProviderParty
	 */
	public Party getTransportServiceProviderParty() {
		return TransportServiceProviderParty;
	}

	/**
	 * @param transportServiceProviderParty
	 *            the transportServiceProviderParty to set
	 */
	public void setTransportServiceProviderParty(Party transportServiceProviderParty) {
		TransportServiceProviderParty = transportServiceProviderParty;
	}

	/**
	 * @return the m_ShipmentStage
	 */
	public ShipmentStage getM_ShipmentStage() {
		return m_ShipmentStage;
	}

	/**
	 * @param m_ShipmentStage
	 *            the m_ShipmentStage to set
	 */
	public void setM_ShipmentStage(ShipmentStage m_ShipmentStage) {
		this.m_ShipmentStage = m_ShipmentStage;
	}

	/**
	 * @return the m_TransportationService
	 */
	public TransportationService getM_TransportationService() {
		return m_TransportationService;
	}

	/**
	 * @param m_TransportationService
	 *            the m_TransportationService to set
	 */
	public void setM_TransportationService(TransportationService m_TransportationService) {
		this.m_TransportationService = m_TransportationService;
	}

}// end Transportation Segment