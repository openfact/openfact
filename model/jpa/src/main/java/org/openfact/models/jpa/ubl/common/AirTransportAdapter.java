package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AirTransportEntity;
import org.openfact.models.ubl.common.AirTransportModel;

public class AirTransportAdapter implements AirTransportModel, JpaModel<AirTransportEntity> {

	protected static final Logger logger = Logger.getLogger(AirTransportAdapter.class);
	protected AirTransportEntity airTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public AirTransportAdapter(OpenfactSession session, EntityManager em, AirTransportEntity airTransport) {
		this.session = session;
		this.em = em;
		this.airTransport = airTransport;
	}

	@Override
	public AirTransportEntity getEntity() {
		return airTransport;
	}

	@Override
	public String getAircraftID() {
		return airTransport.getAircraftID();
	}

	@Override
	public void setAircraftID(String value) {
		airTransport.setAircraftID(value);
	}

	@Override
	public String getId() {
		return airTransport.getId();
	}

	public static AirTransportEntity toEntity(AirTransportModel model, EntityManager em) {
		if (model instanceof AirTransportAdapter) {
			return ((AirTransportAdapter) model).getEntity();
		}
		return em.getReference(AirTransportEntity.class, model.getId());
	}

}
