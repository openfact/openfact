package org.openfact.models.jpa.ubl.common;

public class SecondaryHazardAdapter implements SecondaryHazardModel, JpaModel<SecondaryHazardEntity> {

    protected static final Logger logger = Logger.getLogger(SecondaryHazardAdapter.class);
    protected SecondaryHazardEntity secondaryHazard;
    protected EntityManager em;
    protected OpenfactSession session;

    public SecondaryHazardAdapter(OpenfactSession session, EntityManager em,
            SecondaryHazardEntity secondaryHazard) {
        this.session = session;
        this.em = em;
        this.secondaryHazard = secondaryHazard;
    }

    String getID() {
        return this.secondaryHazard.getID();
    }

    void setID(String value) {
        this.secondaryHazard.setID(value);
    }

    String getPlacardNotation() {
        return this.secondaryHazard.getPlacardNotation();
    }

    void setPlacardNotation(String value) {
        this.secondaryHazard.setPlacardNotation(value);
    }

    String getPlacardEndorsement() {
        return this.secondaryHazard.getPlacardEndorsement();
    }

    void setPlacardEndorsement(String value) {
        this.secondaryHazard.setPlacardEndorsement(value);
    }

    String getEmergencyProceduresCode() {
        return this.secondaryHazard.getEmergencyProceduresCode();
    }

    void setEmergencyProceduresCode(String value) {
        this.secondaryHazard.setEmergencyProceduresCode(value);
    }

    String getExtension() {
        return this.secondaryHazard.getExtension();
    }

    void setExtension(String value) {
        this.secondaryHazard.setExtension(value);
    }

    String getId() {
        return this.secondaryHazard.getId();
    }

    void setId(String value) {
        this.secondaryHazard.setId(value);
    }

}
