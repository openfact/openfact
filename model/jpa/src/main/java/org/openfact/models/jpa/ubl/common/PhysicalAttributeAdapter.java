package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.PhysicalAttributeEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.PhysicalAttributeModel;

public class PhysicalAttributeAdapter implements PhysicalAttributeModel, JpaModel<PhysicalAttributeEntity> {

	protected static final Logger logger = Logger.getLogger(PhysicalAttributeAdapter.class);
	protected PhysicalAttributeEntity physicalAttribute;
	protected EntityManager em;
	protected OpenfactSession session;

	public PhysicalAttributeAdapter(OpenfactSession session, EntityManager em,
			PhysicalAttributeEntity physicalAttribute) {
		this.session = session;
		this.em = em;
		this.physicalAttribute = physicalAttribute;
	}

	@Override
	public String getAttributeID() {
		return this.physicalAttribute.getAttributeID();
	}

	@Override
	public void setAttributeID(String value) {
		this.physicalAttribute.setAttributeID(value);
	}

	@Override
	public String getPositionCode() {
		return this.physicalAttribute.getPositionCode();
	}

	@Override
	public void setPositionCode(String value) {
		this.physicalAttribute.setPositionCode(value);
	}

	@Override
	public String getDescriptionCode() {
		return this.physicalAttribute.getDescriptionCode();
	}

	@Override
	public void setDescriptionCode(String value) {
		this.physicalAttribute.setDescriptionCode(value);
	}

	@Override
	public List<String> getDescription() {
		return this.physicalAttribute.getDescription();
	}

	@Override
	public void setDescription(List<String> description) {
		this.physicalAttribute.setDescription(description);
	}

	@Override
	public String getId() {
		return this.physicalAttribute.getId();
	}

	@Override
	public void setId(String value) {
		this.physicalAttribute.setId(value);
	}

	@Override
	public PhysicalAttributeEntity getEntity() {
		// TODO Auto-generated method stub
		return physicalAttribute;
	}

	public static PhysicalAttributeEntity toEntity(PhysicalAttributeModel model, EntityManager em) {
		if (model instanceof PhysicalAttributeModel) {
			return ((PhysicalAttributeAdapter) model).getEntity();
		}
		return em.getReference(PhysicalAttributeEntity.class, model.getId());
	}

}
