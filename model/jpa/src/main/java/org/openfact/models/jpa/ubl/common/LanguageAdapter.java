package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.LanguageEntity;
import org.openfact.models.ubl.common.LanguageModel;

public class LanguageAdapter implements LanguageModel, JpaModel<LanguageEntity> {

    protected static final Logger logger = Logger.getLogger(LanguageAdapter.class);
    protected LanguageEntity language;
    protected EntityManager em;
    protected OpenfactSession session;

    public LanguageAdapter(OpenfactSession session, EntityManager em, LanguageEntity language) {
        this.session = session;
        this.em = em;
        this.language = language;
    }

    @Override
    public String getID() {
        return this.language.getID();
    }

    @Override
    public void setID(String value) {
        this.language.setID(value);
    }

    @Override
    public String getName() {
        return this.language.getName();
    }

    @Override
    public void setName(String value) {
        this.language.setName(value);
    }

    @Override
    public String getLocaleCode() {
        return this.language.getLocaleCode();
    }

    @Override
    public void setLocaleCode(String value) {
        this.language.setLocaleCode(value);
    }

    @Override
    public String getId() {
        return this.language.getId();
    }

    @Override
    public void setId(String value) {
        this.language.setId(value);
    }

	public static LanguageEntity toEntity(LanguageModel value, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

}
