package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CountryCatalogEntity;

public class CountryCatalogAdapter implements CountryCatalogModel, JpaModel<CountryCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(CountryCatalogAdapter.class);
	protected CountryCatalogEntity countryCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public CountryCatalogAdapter(CountryCatalogEntity countryCatalog, EntityManager em, OpenfactSession session) {

		this.countryCatalog = countryCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public CountryCatalogEntity getEntity() {		
		return countryCatalog;
	}

	@Override
	public String getId() {
		return countryCatalog.getId();
	}

	@Override
	public String getID() {
		return countryCatalog.getID();
	}

	@Override
	public String getCode() {
		return countryCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		countryCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return countryCatalog.getName();
	}

	@Override
	public void setName(String name) {
		countryCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return countryCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		countryCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return countryCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		countryCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return countryCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		countryCatalog.setLocale(locale);

	}


}
