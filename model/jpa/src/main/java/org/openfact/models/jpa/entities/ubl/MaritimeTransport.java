package org.openfact.models.jpa.entities.ubl;

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
    private BigDecimal GrossTonnageMeasure;
    /**
     * Net tonnage is calculated by measuring a ship's internal volume and
     * applying a mathematical formula and is used to calculate the port duties.
     */
    private BigDecimal NetTonnageMeasure;
    /**
     * The radio call sign of the vessel.
     */
    private String RadioCallSignID;
    /**
     * Information about what services a vessel will require when it arrives at
     * a port, such as refueling, maintenance, waste disposal etc.
     */
    private String ShipsRequirements;
    /**
     * An identifier for a specific vessel.
     */
    private String VesselID;
    /**
     * The name of the vessel.
     */
    private String VesselName;
    private DocumentReference RegistryCertificateDocumentReference;
    private Location RegistryPortLocation;

    public MaritimeTransport() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the grossTonnageMeasure
     */
    public BigDecimal getGrossTonnageMeasure() {
        return GrossTonnageMeasure;
    }

    /**
     * @param grossTonnageMeasure
     *            the grossTonnageMeasure to set
     */
    public void setGrossTonnageMeasure(BigDecimal grossTonnageMeasure) {
        GrossTonnageMeasure = grossTonnageMeasure;
    }

    /**
     * @return the netTonnageMeasure
     */
    public BigDecimal getNetTonnageMeasure() {
        return NetTonnageMeasure;
    }

    /**
     * @param netTonnageMeasure
     *            the netTonnageMeasure to set
     */
    public void setNetTonnageMeasure(BigDecimal netTonnageMeasure) {
        NetTonnageMeasure = netTonnageMeasure;
    }

    /**
     * @return the radioCallSignID
     */
    public String getRadioCallSignID() {
        return RadioCallSignID;
    }

    /**
     * @param radioCallSignID
     *            the radioCallSignID to set
     */
    public void setRadioCallSignID(String radioCallSignID) {
        RadioCallSignID = radioCallSignID;
    }

    /**
     * @return the shipsRequirements
     */
    public String getShipsRequirements() {
        return ShipsRequirements;
    }

    /**
     * @param shipsRequirements
     *            the shipsRequirements to set
     */
    public void setShipsRequirements(String shipsRequirements) {
        ShipsRequirements = shipsRequirements;
    }

    /**
     * @return the vesselID
     */
    public String getVesselID() {
        return VesselID;
    }

    /**
     * @param vesselID
     *            the vesselID to set
     */
    public void setVesselID(String vesselID) {
        VesselID = vesselID;
    }

    /**
     * @return the vesselName
     */
    public String getVesselName() {
        return VesselName;
    }

    /**
     * @param vesselName
     *            the vesselName to set
     */
    public void setVesselName(String vesselName) {
        VesselName = vesselName;
    }

    /**
     * @return the registryCertificateDocumentReference
     */
    public DocumentReference getRegistryCertificateDocumentReference() {
        return RegistryCertificateDocumentReference;
    }

    /**
     * @param registryCertificateDocumentReference
     *            the registryCertificateDocumentReference to set
     */
    public void setRegistryCertificateDocumentReference(
            DocumentReference registryCertificateDocumentReference) {
        RegistryCertificateDocumentReference = registryCertificateDocumentReference;
    }

    /**
     * @return the registryPortLocation
     */
    public Location getRegistryPortLocation() {
        return RegistryPortLocation;
    }

    /**
     * @param registryPortLocation
     *            the registryPortLocation to set
     */
    public void setRegistryPortLocation(Location registryPortLocation) {
        RegistryPortLocation = registryPortLocation;
    }

}// end MaritimeTransport