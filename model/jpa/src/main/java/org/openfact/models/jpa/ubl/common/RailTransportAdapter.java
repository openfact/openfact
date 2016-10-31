package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.RailTransportEntity;
import org.openfact.models.ubl.common.RailTransportModel;

public class RailTransportAdapter implements RailTransportModel, JpaModel<RailTransportEntity> {

	protected static final Logger logger = Logger.getLogger(RailTransportAdapter.class);
	protected RailTransportEntity railTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public RailTransportAdapter(OpenfactSession session, EntityManager em, RailTransportEntity railTransport) {
		this.session = session;
		this.em = em;
		this.railTransport = railTransport;
	}

	@Override
	public RailTransportEntity getEntity() {
		return railTransport;
	}

	@Override
	public String getTrainID() {
		return railTransport.getTrainID();
	}

	@Override
	public void setTrainID(String value) {
		railTransport.setTrainID(value);
	}

	@Override
	public String getRailCarID() {
		return railTransport.getRailCarID();
	}

	@Override
	public void setRailCarID(String value) {
		railTransport.setRailCarID(value);
	}

	@Override
	public String getId() {
		return railTransport.getId();
	}

	public static RailTransportEntity toEntity(RailTransportModel model, EntityManager em) {
		if (model instanceof RailTransportAdapter) {
			return ((RailTransportAdapter) model).getEntity();
		}
		return em.getReference(RailTransportEntity.class, model.getId());
	}
}
