package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.MaritimeTransportEntity;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.ubl.common.MaritimeTransportModel;
import org.openfact.models.ubl.common.QuantityModel;

public class MaritimeTransportAdapter implements MaritimeTransportModel, JpaModel<MaritimeTransportEntity> {

	protected static final Logger logger = Logger.getLogger(MaritimeTransportAdapter.class);
	protected MaritimeTransportEntity maritimeTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public MaritimeTransportAdapter(OpenfactSession session, EntityManager em,
			MaritimeTransportEntity maritimeTransport) {
		this.session = session;
		this.em = em;
		this.maritimeTransport = maritimeTransport;
	}

	@Override
	public MaritimeTransportEntity getEntity() {
		return maritimeTransport;
	}

	@Override
	public String getId() {
		return maritimeTransport.getId();
	}

	@Override
	public String getVesselID() {
		return maritimeTransport.getVesselID();
	}

	@Override
	public void setVesselID(String vesselID) {
		maritimeTransport.setVesselID(vesselID);
	}

	@Override
	public String getVesselName() {
		return maritimeTransport.getVesselName();
	}

	@Override
	public void setVesselName(String vesselName) {
		maritimeTransport.setVesselName(vesselName);
	}

	public static MaritimeTransportEntity toEntity(MaritimeTransportModel model, EntityManager em) {
		if (model instanceof MaritimeTransportAdapter) {
			return ((MaritimeTransportAdapter) model).getEntity();
		}
		return em.getReference(MaritimeTransportEntity.class, model.getId());
	}

}
