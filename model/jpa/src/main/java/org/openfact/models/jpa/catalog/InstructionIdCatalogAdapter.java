package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.InstructionIdCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.InstructionIdCatalogEntity;

public class InstructionIdCatalogAdapter implements InstructionIdCatalogModel, JpaModel<InstructionIdCatalogEntity> {
	protected static final Logger logger = Logger.getLogger(InstructionIdCatalogAdapter.class);
	protected InstructionIdCatalogEntity instructionIdCatalog;
	protected EntityManager em;
	protected OpenfactSession session;

	public InstructionIdCatalogAdapter(InstructionIdCatalogEntity instructionIdCatalog, EntityManager em,
			OpenfactSession session) {
		this.instructionIdCatalog = instructionIdCatalog;
		this.em = em;
		this.session = session;
	}

	@Override
	public InstructionIdCatalogEntity getEntity() {		
		return instructionIdCatalog;
	}

	@Override
	public String getId() {
		return instructionIdCatalog.getId();
	}

	@Override
	public String getID() {
		return instructionIdCatalog.getID();
	}

	@Override
	public String getCode() {
		return instructionIdCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		instructionIdCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return instructionIdCatalog.getName();
	}

	@Override
	public void setName(String name) {
		instructionIdCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return instructionIdCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		instructionIdCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return instructionIdCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		instructionIdCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return instructionIdCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		instructionIdCatalog.setLocale(locale);

	}


}
