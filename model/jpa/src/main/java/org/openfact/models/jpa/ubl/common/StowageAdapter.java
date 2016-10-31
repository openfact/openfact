package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.jpa.entities.ubl.common.LocationCommAggEntity;
import org.openfact.models.jpa.entities.ubl.common.StowageEntity;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.StowageModel;

public class StowageAdapter implements StowageModel, JpaModel<StowageEntity> {

	protected static final Logger logger = Logger.getLogger(StowageAdapter.class);

	protected StowageEntity stowage;
	protected EntityManager em;
	protected OpenfactSession session;

	public StowageAdapter(OpenfactSession session, EntityManager em, StowageEntity stowage) {
		this.session = session;
		this.em = em;
		this.stowage = stowage;
	}

	@Override
	public StowageEntity getEntity() {
		return stowage;
	}

	@Override
	public String getLocationID() {
		return stowage.getLocationID();
	}

	@Override
	public void setLocationID(String value) {
		stowage.setLocationID(value);
	}

	@Override
	public List<LocationCommAggModel> getLocation() {
		return stowage.getLocation().stream().map(f -> new LocationCommAggAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setLocation(List<LocationCommAggModel> location) {
		List<LocationCommAggEntity> entities = location.stream().map(f -> LocationCommAggAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		stowage.setLocation(entities);
	}

	@Override
	public List<DimensionModel> getMeasurementDimension() {
		return stowage.getMeasurementDimension().stream().map(f -> new DimensionAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
		List<DimensionEntity> entities = measurementDimension.stream().map(f -> DimensionAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		stowage.setMeasurementDimension(entities);
	}

	@Override
	public String getId() {
		return stowage.getId();
	}

	public static StowageEntity toEntity(StowageModel model, EntityManager em) {
		if (model instanceof StowageAdapter) {
			return ((StowageAdapter) model).getEntity();
		}
		return em.getReference(StowageEntity.class, model.getId());
	}
}
