package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.TaxTypeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.TaxTypeCatalogEntity;

public class TaxTypeCatalogAdapter implements TaxTypeCatalogModel, JpaModel<TaxTypeCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(TaxTypeCatalogAdapter.class);
	protected TaxTypeCatalogEntity taxTypeCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public TaxTypeCatalogAdapter(TaxTypeCatalogEntity taxTypeCatalog, EntityManager em, OpenfactSession session) {
		this.taxTypeCatalog = taxTypeCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public TaxTypeCatalogEntity getEntity() {		
		return taxTypeCatalog;
	}

	@Override
	public String getId() {
		return taxTypeCatalog.getId();
	}

	@Override
	public String getID() {
		return taxTypeCatalog.getID();
	}

	@Override
	public String getCode() {
		return taxTypeCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		taxTypeCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return taxTypeCatalog.getName();
	}

	@Override
	public void setName(String name) {
		taxTypeCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return taxTypeCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		taxTypeCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return taxTypeCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		taxTypeCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return taxTypeCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		taxTypeCatalog.setLocale(locale);

	}

}
