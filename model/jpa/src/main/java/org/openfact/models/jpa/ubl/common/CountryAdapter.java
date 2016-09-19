package org.openfact.models.jpa.ubl.common;

public class CountryAdapter implements CountryModel, JpaModel<CountryEntity> {

    protected static final Logger logger = Logger.getLogger(CountryAdapter.class);
    protected CountryEntity country;
    protected EntityManager em;
    protected OpenfactSession session;

    public CountryAdapter(OpenfactSession session, EntityManager em, CountryEntity country) {
        this.session = session;
        this.em = em;
        this.country = country;
    }

    String getIdentificationCode() {
        return this.country.getIdentificationCode();
    }

    void setIdentificationCode(String value) {
        this.country.setIdentificationCode(value);
    }

    String getName() {
        return this.country.getName();
    }

    void setName(String value) {
        this.country.setName(value);
    }

    String getId() {
        return this.country.getId();
    }

    void setId(String value) {
        this.country.setId(value);
    }

}
