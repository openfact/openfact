package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyEntity;
import org.openfact.models.ubl.common.ItemPropertyGroupModel;
import org.openfact.models.ubl.common.ItemPropertyModel;
import org.openfact.models.ubl.common.PeriodModel;

public class ItemPropertyAdapter implements ItemPropertyModel, JpaModel<ItemPropertyEntity> {

	protected static final Logger logger = Logger.getLogger(ItemPropertyAdapter.class);
	protected ItemPropertyEntity itemProperty;
	protected EntityManager em;
	protected OpenfactSession session;

	public ItemPropertyAdapter(OpenfactSession session, EntityManager em, ItemPropertyEntity itemProperty) {
		this.session = session;
		this.em = em;
		this.itemProperty = itemProperty;
	}

	@Override
	public String getName() {
		return this.itemProperty.getName();
	}

	@Override
	public void setName(String value) {
		this.itemProperty.setName(value);
	}

	@Override
	public String getValue() {
		return this.itemProperty.getValue();
	}

	@Override
	public void setValue(String value) {
		this.itemProperty.setValue(value);
	}

	@Override
	public PeriodModel getUsabilityPeriod() {
		return this.itemProperty.getUsabilityPeriod();
	}

	@Override
	public void setUsabilityPeriod(PeriodAdapter value) {
		this.itemProperty.setUsabilityPeriod(value);
	}

	@Override
	public List<ItemPropertyGroupModel> getItemPropertyGroup() {
		return this.itemProperty.getItemPropertyGroup();
	}

	@Override
	public void setItemPropertyGroup(List<ItemPropertyGroupAdapter> itemPropertyGroup) {
		this.itemProperty.setItemPropertyGroup(itemPropertyGroup);
	}

	@Override
	public String getId() {
		return this.itemProperty.getId();
	}

	@Override
	public void setId(String value) {
		this.itemProperty.setId(value);
	}

	public static ItemPropertyEntity toEntity(ItemPropertyModel model, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

}
