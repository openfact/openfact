package org.openfact.models.jpa.ubl.common;

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

    String getID() {
        return this.language.getID();
    }

    void setID(String value) {
        this.language.setID(value);
    }

    String getName() {
        return this.language.getName();
    }

    void setName(String value) {
        this.language.setName(value);
    }

    String getLocaleCode() {
        return this.language.getLocaleCode();
    }

    void setLocaleCode(String value) {
        this.language.setLocaleCode(value);
    }

    String getId() {
        return this.language.getId();
    }

    void setId(String value) {
        this.language.setId(value);
    }

}
