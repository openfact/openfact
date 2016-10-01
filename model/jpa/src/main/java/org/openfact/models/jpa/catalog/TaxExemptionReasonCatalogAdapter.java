package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.TaxExemptionReasonCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.TaxExemptionReasonCatalogEntity;

public class TaxExemptionReasonCatalogAdapter
		implements TaxExemptionReasonCatalogModel, JpaModel<TaxExemptionReasonCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(TaxExemptionReasonCatalogAdapter.class);
	protected TaxExemptionReasonCatalogEntity taxExemptionReasonCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public TaxExemptionReasonCatalogAdapter(TaxExemptionReasonCatalogEntity taxExemptionReasonCatalog, EntityManager em,
			OpenfactSession session) {
		this.taxExemptionReasonCatalog = taxExemptionReasonCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public TaxExemptionReasonCatalogEntity getEntity() {		
		return taxExemptionReasonCatalog;
	}

	@Override
	public String getId() {
		return taxExemptionReasonCatalog.getId();
	}

	@Override
	public String getID() {
		return taxExemptionReasonCatalog.getID();
	}

	@Override
	public String getCode() {
		return taxExemptionReasonCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		taxExemptionReasonCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return taxExemptionReasonCatalog.getName();
	}

	@Override
	public void setName(String name) {
		taxExemptionReasonCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return taxExemptionReasonCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		taxExemptionReasonCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return taxExemptionReasonCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		taxExemptionReasonCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return taxExemptionReasonCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		taxExemptionReasonCatalog.setLocale(locale);

	}

}
