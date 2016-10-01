package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.UnitCatalogEntity;

public class UnitCatalogAdapter implements UnitCatalogModel, JpaModel<UnitCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(UnitCatalogAdapter.class);
	protected UnitCatalogEntity unitCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public UnitCatalogAdapter(UnitCatalogEntity unitCatalog, EntityManager em, OpenfactSession session) {
		this.unitCatalog = unitCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public UnitCatalogEntity getEntity() {		
		return unitCatalog;
	}

	@Override
	public String getId() {
		return unitCatalog.getId();
	}

	@Override
	public String getID() {
		return unitCatalog.getID();
	}

	@Override
	public String getCode() {
		return unitCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		unitCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return unitCatalog.getName();
	}

	@Override
	public void setName(String name) {
		unitCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return unitCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		unitCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return unitCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		unitCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return unitCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		unitCatalog.setLocale(locale);

	}

}
