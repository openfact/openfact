package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.PriceTypeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.PriceTypeCatalogEntity;

public class PriceTypeCatalogAdapter implements PriceTypeCatalogModel, JpaModel<PriceTypeCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(PriceTypeCatalogAdapter.class);
	protected PriceTypeCatalogEntity priceTypeCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public PriceTypeCatalogAdapter(PriceTypeCatalogEntity priceTypeCatalog, EntityManager em, OpenfactSession session) {
		this.priceTypeCatalog = priceTypeCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public PriceTypeCatalogEntity getEntity() {		
		return priceTypeCatalog;
	}

	@Override
	public String getId() {
		return priceTypeCatalog.getId();
	}

	@Override
	public String getID() {
		return priceTypeCatalog.getID();
	}

	@Override
	public String getCode() {
		return priceTypeCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		priceTypeCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return priceTypeCatalog.getName();
	}

	@Override
	public void setName(String name) {
		priceTypeCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return priceTypeCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		priceTypeCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return priceTypeCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		priceTypeCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return priceTypeCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		priceTypeCatalog.setLocale(locale);

	}

}
