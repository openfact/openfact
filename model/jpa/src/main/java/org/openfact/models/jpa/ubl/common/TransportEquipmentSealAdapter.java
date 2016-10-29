package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentSealEntity;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TransportEquipmentSealModel;

public class TransportEquipmentSealAdapter
		implements TransportEquipmentSealModel, JpaModel<TransportEquipmentSealEntity> {
	protected static final Logger logger = Logger.getLogger(TransportEquipmentSealAdapter.class);

	protected TransportEquipmentSealEntity transportEquipmentSeal;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportEquipmentSealAdapter(OpenfactSession session, EntityManager em,
			TransportEquipmentSealEntity transportEquipmentSeal) {
		this.session = session;
		this.em = em;
		this.transportEquipmentSeal = transportEquipmentSeal;
	}

	@Override
	public TransportEquipmentSealEntity getEntity() {
		return transportEquipmentSeal;
	}

	@Override
	public String getID() {
		return transportEquipmentSeal.getID();
	}

	@Override
	public void setID(String value) {
		transportEquipmentSeal.setID(value);
	}

	@Override
	public String getSealIssuerTypeCode() {
		return transportEquipmentSeal.getSealIssuerTypeCode();
	}

	@Override
	public void setSealIssuerTypeCode(String value) {
		transportEquipmentSeal.setSealIssuerTypeCode(value);
	}

	@Override
	public String getCondition() {
		return transportEquipmentSeal.getCondition();
	}

	@Override
	public void setCondition(String value) {
		transportEquipmentSeal.setCondition(value);
	}

	@Override
	public String getSealStatusCode() {
		return transportEquipmentSeal.getSealStatusCode();
	}

	@Override
	public void setSealStatusCode(String value) {
		transportEquipmentSeal.setSealStatusCode(value);
	}

	@Override
	public String getSealingPartyType() {
		return transportEquipmentSeal.getSealingPartyType();
	}

	@Override
	public void setSealingPartyType(String value) {
		transportEquipmentSeal.setSealingPartyType(value);
	}

	@Override
	public String getId() {
		return getId();
	}

	public static TransportEquipmentSealEntity toEntity(TransportEquipmentSealModel model, EntityManager em) {
		if (model instanceof TransportEquipmentSealAdapter) {
			return ((TransportEquipmentSealAdapter) model).getEntity();
		}
		return em.getReference(TransportEquipmentSealEntity.class, model.getId());
	}

}
