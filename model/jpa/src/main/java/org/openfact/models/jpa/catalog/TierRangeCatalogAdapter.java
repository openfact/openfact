package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.TierRangeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.TierRangeCatalogEntity;

public class TierRangeCatalogAdapter implements TierRangeCatalogModel, JpaModel<TierRangeCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(TierRangeCatalogAdapter.class);
	protected TierRangeCatalogEntity tierRangeCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public TierRangeCatalogAdapter(TierRangeCatalogEntity tierRangeCatalog, EntityManager em, OpenfactSession session) {
		this.tierRangeCatalog = tierRangeCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public TierRangeCatalogEntity getEntity() {	
		return tierRangeCatalog;
	}

	@Override
	public String getId() {
		return tierRangeCatalog.getId();
	}

	@Override
	public String getID() {
		return tierRangeCatalog.getID();
	}

	@Override
	public String getCode() {
		return tierRangeCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		tierRangeCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return tierRangeCatalog.getName();
	}

	@Override
	public void setName(String name) {
		tierRangeCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return tierRangeCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		tierRangeCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return tierRangeCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		tierRangeCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return tierRangeCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		tierRangeCatalog.setLocale(locale);

	}


}
