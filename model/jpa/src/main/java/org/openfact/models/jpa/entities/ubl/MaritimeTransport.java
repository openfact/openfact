package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a vessel used for transport by water (including sea,
 * river, and canal).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:05 a. m.
 */
public class MaritimeTransport {

	/**
	 * Gross tonnage is calculated by measuring a ship's volume (from keel to
	 * funnel, to the outside of the hull framing) and applying a mathematical
	 * formula and is used to determine things such as a ship's manning
	 * regulations, safety rules, registration fees an
	 */
	private BigDecimal grossTonnageMeasure;
	/**
	 * Net tonnage is calculated by measuring a ship's internal volume and
	 * applying a mathematical formula and is used to calculate the port duties.
	 */
	private BigDecimal netTonnageMeasure;
	/**
	 * The radio call sign of the vessel.
	 */
	private String radioCallSignID;
	/**
	 * Information about what services a vessel will require when it arrives at
	 * a port, such as refueling, maintenance, waste disposal etc.
	 */
	private String shipsRequirements;
	/**
	 * An identifier for a specific vessel.
	 */
	private String vesselID;
	/**
	 * The name of the vessel.
	 */
	private String vesselName;
	private DocumentReference registryCertificateDocumentReference;
	private Location registryPortLocation;

	public MaritimeTransport() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getGrossTonnageMeasure() {
		return grossTonnageMeasure;
	}

	public void setGrossTonnageMeasure(BigDecimal grossTonnageMeasure) {
		this.grossTonnageMeasure = grossTonnageMeasure;
	}

	public BigDecimal getNetTonnageMeasure() {
		return netTonnageMeasure;
	}

	public void setNetTonnageMeasure(BigDecimal netTonnageMeasure) {
		this.netTonnageMeasure = netTonnageMeasure;
	}

	public String getRadioCallSignID() {
		return radioCallSignID;
	}

	public void setRadioCallSignID(String radioCallSignID) {
		this.radioCallSignID = radioCallSignID;
	}

	public String getShipsRequirements() {
		return shipsRequirements;
	}

	public void setShipsRequirements(String shipsRequirements) {
		this.shipsRequirements = shipsRequirements;
	}

	public String getVesselID() {
		return vesselID;
	}

	public void setVesselID(String vesselID) {
		this.vesselID = vesselID;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public DocumentReference getRegistryCertificateDocumentReference() {
		return registryCertificateDocumentReference;
	}

	public void setRegistryCertificateDocumentReference(DocumentReference registryCertificateDocumentReference) {
		this.registryCertificateDocumentReference = registryCertificateDocumentReference;
	}

	public Location getRegistryPortLocation() {
		return registryPortLocation;
	}

	public void setRegistryPortLocation(Location registryPortLocation) {
		this.registryPortLocation = registryPortLocation;
	}
}// end MaritimeTransport