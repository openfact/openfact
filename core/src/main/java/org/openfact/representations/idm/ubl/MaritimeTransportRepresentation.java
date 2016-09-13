package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a vessel used for transport by water (including sea,
 * river, and canal).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:05 a. m.
 */
public class MaritimeTransportRepresentation {

    /**
     * Gross tonnage is calculated by measuring a ship's volume (from keel to
     * funnel, to the outside of the hull framing) and applying a mathematical
     * formula and is used to determine things such as a ship's manning
     * regulations, safety rules, registration fees an
     */
    private MeasureRepresentation grossTonnageMeasure;
    /**
     * Net tonnage is calculated by measuring a ship's internal volume and
     * applying a mathematical formula and is used to calculate the port duties.
     */
    private MeasureRepresentation netTonnageMeasure;
    /**
     * The radio call sign of the vessel.
     */
    private IdentifierRepresentation radioCallSignID;
    /**
     * Information about what services a vessel will require when it arrives at
     * a port, such as refueling, maintenance, waste disposal etc.
     */
    private TextRepresentation shipsRequirements;
    /**
     * An identifier for a specific vessel.
     */
    private IdentifierRepresentation vesselID;
    /**
     * The name of the vessel.
     */
    private NameRepresentation vesselName;
    private DocumentReferenceRepresentation registryCertificateDocumentReference;
    private LocationRepresentation registryPortLocation;

}
