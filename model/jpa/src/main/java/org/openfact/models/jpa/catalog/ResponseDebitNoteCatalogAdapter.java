package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.ResponseDebitNoteCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.ResponseDebitNoteCatalogEntity;

public class ResponseDebitNoteCatalogAdapter
		implements ResponseDebitNoteCatalogModel, JpaModel<ResponseDebitNoteCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(ResponseDebitNoteCatalogAdapter.class);
	protected ResponseDebitNoteCatalogEntity responseDebitNoteCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public ResponseDebitNoteCatalogAdapter(ResponseDebitNoteCatalogEntity responseDebitNoteCatalog, EntityManager em,
			OpenfactSession session) {
		this.responseDebitNoteCatalog = responseDebitNoteCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public ResponseDebitNoteCatalogEntity getEntity() {		
		return responseDebitNoteCatalog;
	}

	@Override
	public String getId() {
		return responseDebitNoteCatalog.getId();
	}

	@Override
	public String getID() {
		return responseDebitNoteCatalog.getID();
	}

	@Override
	public String getCode() {
		return responseDebitNoteCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		responseDebitNoteCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return responseDebitNoteCatalog.getName();
	}

	@Override
	public void setName(String name) {
		responseDebitNoteCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return responseDebitNoteCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		responseDebitNoteCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return responseDebitNoteCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		responseDebitNoteCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return responseDebitNoteCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		responseDebitNoteCatalog.setLocale(locale);

	}

}
