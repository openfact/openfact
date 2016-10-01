package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.DocumentTypeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.DocumentTypeCatalogEntity;

public class DocumentTypeCatalogAdapter  implements DocumentTypeCatalogModel, JpaModel<DocumentTypeCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(DocumentTypeCatalogAdapter.class);
	protected DocumentTypeCatalogEntity documentTypeCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public DocumentTypeCatalogAdapter(DocumentTypeCatalogEntity documentTypeCatalog, EntityManager em,
			OpenfactSession session) {		
		this.documentTypeCatalog = documentTypeCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public DocumentTypeCatalogEntity getEntity() {		
		return documentTypeCatalog;
	}
	@Override
	public String getId() {
		return documentTypeCatalog.getId();
	}

	@Override
	public String getID() {
		return documentTypeCatalog.getID();
	}

	@Override
	public String getCode() {
		return documentTypeCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		documentTypeCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return documentTypeCatalog.getName();
	}

	@Override
	public void setName(String name) {
		documentTypeCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return documentTypeCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		documentTypeCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return documentTypeCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		documentTypeCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return documentTypeCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		documentTypeCatalog.setLocale(locale);

	}

	
}
