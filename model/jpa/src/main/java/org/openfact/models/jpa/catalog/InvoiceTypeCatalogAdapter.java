package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.InvoiceTypeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.InvoiceTypeCatalogEntity;

public class InvoiceTypeCatalogAdapter  implements InvoiceTypeCatalogModel, JpaModel<InvoiceTypeCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(InvoiceTypeCatalogAdapter.class);
	protected InvoiceTypeCatalogEntity invoiceTypeCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public InvoiceTypeCatalogAdapter(InvoiceTypeCatalogEntity invoiceTypeCatalog, EntityManager em,
			OpenfactSession session) {
		super();
		this.invoiceTypeCatalog = invoiceTypeCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public InvoiceTypeCatalogEntity getEntity() {		
		return invoiceTypeCatalog;
	}
	@Override
	public String getId() {
		return invoiceTypeCatalog.getId();
	}

	@Override
	public String getID() {
		return invoiceTypeCatalog.getID();
	}

	@Override
	public String getCode() {
		return invoiceTypeCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		invoiceTypeCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return invoiceTypeCatalog.getName();
	}

	@Override
	public void setName(String name) {
		invoiceTypeCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return invoiceTypeCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		invoiceTypeCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return invoiceTypeCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		invoiceTypeCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return invoiceTypeCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		invoiceTypeCatalog.setLocale(locale);

	}

	
}
