package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CurrencyCatalogEntity;

public class CurrencyCatalogAdapter  implements CurrencyCatalogModel, JpaModel<CurrencyCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(CurrencyCatalogAdapter.class);
	protected CurrencyCatalogEntity currencyCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public CurrencyCatalogAdapter(CurrencyCatalogEntity currencyCatalog, EntityManager em, OpenfactSession session) {		
		this.currencyCatalog = currencyCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public CurrencyCatalogEntity getEntity() {		
		return currencyCatalog;
	}
	@Override
	public String getId() {
		return currencyCatalog.getId();
	}

	@Override
	public String getID() {
		return currencyCatalog.getID();
	}

	@Override
	public String getCode() {
		return currencyCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		currencyCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return currencyCatalog.getName();
	}

	@Override
	public void setName(String name) {
		currencyCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return currencyCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		currencyCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return currencyCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		currencyCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return currencyCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		currencyCatalog.setLocale(locale);

	}

}
