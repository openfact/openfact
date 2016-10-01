package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.AdditionalAccountIdCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.AdditionalAccountIdCatalogEntity;;

public class AdditionalAccountIdCatalogAdapter
		implements AdditionalAccountIdCatalogModel, JpaModel<AdditionalAccountIdCatalogEntity> {
	
	 protected static final Logger logger = Logger.getLogger(AdditionalAccountIdCatalogAdapter.class);
	protected AdditionalAccountIdCatalogEntity additionalAccountIdCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public AdditionalAccountIdCatalogAdapter(AdditionalAccountIdCatalogEntity additionalAccountIdCatalog,
			EntityManager em, OpenfactSession session) {
		this.additionalAccountIdCatalog = additionalAccountIdCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public AdditionalAccountIdCatalogEntity getEntity() {
		return additionalAccountIdCatalog;
	}

	@Override
	public String getId() {
		return additionalAccountIdCatalog.getId();
	}

	@Override
	public String getID() {
		return additionalAccountIdCatalog.getID();
	}

	@Override
	public String getCode() {
		return additionalAccountIdCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		additionalAccountIdCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return additionalAccountIdCatalog.getName();
	}

	@Override
	public void setName(String name) {
		additionalAccountIdCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return additionalAccountIdCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		additionalAccountIdCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return additionalAccountIdCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		additionalAccountIdCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return additionalAccountIdCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		additionalAccountIdCatalog.setLocale(locale);

	}


}
