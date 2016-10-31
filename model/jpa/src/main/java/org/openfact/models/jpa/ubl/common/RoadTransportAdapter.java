package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.RoadTransportEntity;
import org.openfact.models.ubl.common.RoadTransportModel;

public class RoadTransportAdapter implements RoadTransportModel, JpaModel<RoadTransportEntity> {

	protected static final Logger logger = Logger.getLogger(RoadTransportAdapter.class);
	protected RoadTransportEntity roadTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public RoadTransportAdapter(OpenfactSession session, EntityManager em, RoadTransportEntity roadTransport) {
		this.session = session;
		this.em = em;
		this.roadTransport = roadTransport;
	}

	@Override
	public RoadTransportEntity getEntity() {
		return roadTransport;
	}

	@Override
	public String getLicensePlateID() {
		return roadTransport.getLicensePlateID();
	}

	@Override
	public void setLicensePlateID(String value) {
		roadTransport.setLicensePlateID(value);
	}

	@Override
	public String getId() {
		return roadTransport.getId();
	}

	public static RoadTransportEntity toEntity(RoadTransportModel model, EntityManager em) {
		if (model instanceof RoadTransportAdapter) {
			return ((RoadTransportAdapter) model).getEntity();
		}
		return em.getReference(RoadTransportEntity.class, model.getId());
	}

}
