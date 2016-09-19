package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TemperatureEntity;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.TemperatureModel;

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

    @Override
    public String getAttributeID() {
        return this.temperature.getAttributeID();
    }

    @Override
    public void setAttributeID(String value) {
        this.temperature.setAttributeID(value);
    }

    @Override
    public MeasureModel getMeasure() {
    	 return new MeasureAdapter(session, em, temperature.getMeasure());        
    }

    @Override
    public void setMeasure(MeasureModel value) {    	
    	temperature.setMeasure(MeasureAdapter.toEntity(value,em));        
    }

    @Override
    public List<String> getDescription() {
        return this.temperature.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.temperature.setDescription(description);
    }

    @Override
    public String getId() {
        return this.temperature.getId();
    }

    @Override
    public void setId(String value) {
        this.temperature.setId(value);
    }

	@Override
	public TemperatureEntity getEntity() {
		return temperature;
	}

}
