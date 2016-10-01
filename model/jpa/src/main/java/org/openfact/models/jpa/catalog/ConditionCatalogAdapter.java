package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.ConditionCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.ConditionCatalogEntity;

public class ConditionCatalogAdapter implements ConditionCatalogModel, JpaModel<ConditionCatalogEntity> {

	protected static final Logger logger = Logger.getLogger(ConditionCatalogAdapter.class);
	protected ConditionCatalogEntity conditionCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public ConditionCatalogAdapter(ConditionCatalogEntity conditionCatalog, EntityManager em, OpenfactSession session) {
		this.conditionCatalog = conditionCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public ConditionCatalogEntity getEntity() {
		return conditionCatalog;
	}

	@Override
	public String getId() {
		return conditionCatalog.getId();
	}

	@Override
	public String getID() {
		return conditionCatalog.getID();
	}

	@Override
	public String getCode() {
		return conditionCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		conditionCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return conditionCatalog.getName();
	}

	@Override
	public void setName(String name) {
		conditionCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return conditionCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		conditionCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return conditionCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		conditionCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return conditionCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		conditionCatalog.setLocale(locale);

	}

}
