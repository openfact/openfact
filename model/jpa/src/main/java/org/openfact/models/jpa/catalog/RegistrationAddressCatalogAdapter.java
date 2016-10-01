package org.openfact.models.jpa.catalog;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.RegistrationAddressCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.RegistrationAddressCatalogEntity;

public class RegistrationAddressCatalogAdapter  implements RegistrationAddressCatalogModel, JpaModel<RegistrationAddressCatalogEntity>{
	protected static final Logger logger = Logger.getLogger(RegistrationAddressCatalogAdapter.class);
	protected RegistrationAddressCatalogEntity registrationAddressCatalog;
	protected EntityManager em;
	protected OpenfactSession session;
	public RegistrationAddressCatalogAdapter(RegistrationAddressCatalogEntity registrationAddressCatalog,
			EntityManager em, OpenfactSession session) {		
		this.registrationAddressCatalog = registrationAddressCatalog;
		this.em = em;
		this.session = session;
	}
	@Override
	public RegistrationAddressCatalogEntity getEntity() {		
		return registrationAddressCatalog;
	}
	@Override
	public String getId() {
		return registrationAddressCatalog.getId();
	}

	@Override
	public String getID() {
		return registrationAddressCatalog.getID();
	}

	@Override
	public String getCode() {
		return registrationAddressCatalog.getCode();
	}

	@Override
	public void setCode(String code) {
		registrationAddressCatalog.setCode(code);

	}

	@Override
	public String getName() {
		return registrationAddressCatalog.getName();
	}

	@Override
	public void setName(String name) {
		registrationAddressCatalog.setName(name);

	}

	@Override
	public String getDescription() {
		return registrationAddressCatalog.getDescription();
	}

	@Override
	public void setDescription(String description) {
		registrationAddressCatalog.setDescription(description);

	}

	@Override
	public BigDecimal getValue() {
		return registrationAddressCatalog.getValue();
	}

	@Override
	public void setValue(BigDecimal value) {
		registrationAddressCatalog.setValue(value);

	}

	@Override
	public String getLocale() {
		return registrationAddressCatalog.getLocale();
	}

	@Override
	public void setLocale(String locale) {
		registrationAddressCatalog.setLocale(locale);

	}

}
