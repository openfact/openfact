package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class TemperatureAdapter implements TemperatureModel, JpaModel<TemperatureEntity> {

    protected static final Logger logger = Logger.getLogger(TemperatureAdapter.class);
    protected TemperatureEntity temperature;
    protected EntityManager em;
    protected OpenfactSession session;

    public TemperatureAdapter(OpenfactSession session, EntityManager em, TemperatureEntity temperature) {
        this.session = session;
        this.em = em;
        this.temperature = temperature;
    }

    String getAttributeID() {
        return this.temperature.getAttributeID();
    }

    void setAttributeID(String value) {
        this.temperature.setAttributeID(value);
    }

    MeasureAdapter getMeasure() {
        return this.temperature.getMeasure();
    }

    void setMeasure(MeasureAdapter value) {
        this.temperature.setMeasure(value);
    }

    List<String> getDescription() {
        return this.temperature.getDescription();
    }

    void setDescription(List<String> description) {
        this.temperature.setDescription(description);
    }

    String getId() {
        return this.temperature.getId();
    }

    void setId(String value) {
        this.temperature.setId(value);
    }

}
