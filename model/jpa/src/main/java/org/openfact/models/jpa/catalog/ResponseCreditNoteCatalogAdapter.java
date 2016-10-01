package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.ResponseCreditNoteCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.ResponseCreditNoteCatalogEntity;

public class ResponseCreditNoteCatalogAdapter  implements ResponseCreditNoteCatalogModel, JpaModel<ResponseCreditNoteCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(ResponseCreditNoteCatalogAdapter.class);
	protected ResponseCreditNoteCatalogEntity responseCreditNoteCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public ResponseCreditNoteCatalogAdapter(ResponseCreditNoteCatalogEntity responseCreditNoteCatalog, EntityManager em,
			OpenfactSession session) {
		this.responseCreditNoteCatalog = responseCreditNoteCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public ResponseCreditNoteCatalogEntity getEntity() {	
		return responseCreditNoteCatalog;
	}
	@Override
	public String getId() {
		return responseCreditNoteCatalog.getId();
	}

	@Override
	public String getID() {
		return responseCreditNoteCatalog.getID();
	}

	@Override
	public String getCode() {
		return responseCreditNoteCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		responseCreditNoteCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return responseCreditNoteCatalog.getName();
	}

	@Override
	public void setName(String name) {
		responseCreditNoteCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return responseCreditNoteCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		responseCreditNoteCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return responseCreditNoteCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		responseCreditNoteCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return responseCreditNoteCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		responseCreditNoteCatalog.setLocale(locale);

	}

}
