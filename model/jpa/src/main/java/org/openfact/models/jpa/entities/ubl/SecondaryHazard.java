package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a secondary hazard associated with a hazardous item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:17:38 a. m.
 */
public class SecondaryHazard {

    /**
     * A code signifying the emergency procedures for this secondary hazard.
     */
    private String EmergencyProceduresCode;
    /**
     * Additional information about the hazardous substance, which can be used
     * (for example) to specify the type of regulatory requirements that apply
     * to this secondary hazard.
     */
    private String Extension;
    /**
     * An identifier for this secondary hazard.
     */
    private String ID;
    /**
     * Text of the placard endorsement for this secondary hazard that is to be
     * shown on the shipping papers for a hazardous item. Can also be used for
     * the number of the orange placard (lower part) required on the means of
     * transport.
     */
    private String PlacardEndorsement;
    /**
     * Text of the placard notation corresponding to the hazard class of this
     * secondary hazard. Can also be the hazard identification number of the
     * orange placard (upper part) required on the means of transport.
     */
    private String PlacardNotation;

    public SecondaryHazard() {

    }

    public void finalize() throws Throwable {

    }

    public String getEmergencyProceduresCode() {
        return EmergencyProceduresCode;
    }

    public String getExtension() {
        return Extension;
    }

    public String getID() {
        return ID;
    }

    public String getPlacardEndorsement() {
        return PlacardEndorsement;
    }

    public String getPlacardNotation() {
        return PlacardNotation;
    }

    /**
     * 
     * @param newVal
     */
    public void setEmergencyProceduresCode(String newVal) {
        EmergencyProceduresCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setExtension(String newVal) {
        Extension = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPlacardEndorsement(String newVal) {
        PlacardEndorsement = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPlacardNotation(String newVal) {
        PlacardNotation = newVal;
    }
}// end Secondary Hazard