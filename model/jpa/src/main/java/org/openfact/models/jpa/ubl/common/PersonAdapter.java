package org.openfact.models.jpa.ubl.common;

public class PersonAdapter implements PersonModel, JpaModel<PersonEntity> {

    protected static final Logger logger = Logger.getLogger(PersonAdapter.class);
    protected PersonEntity person;
    protected EntityManager em;
    protected OpenfactSession session;

    public PersonAdapter(OpenfactSession session, EntityManager em, PersonEntity person) {
        this.session = session;
        this.em = em;
        this.person = person;
    }

    String getFirstName() {
        return this.person.getFirstName();
    }

    void setFirstName(String value) {
        this.person.setFirstName(value);
    }

    String getFamilyName() {
        return this.person.getFamilyName();
    }

    void setFamilyName(String value) {
        this.person.setFamilyName(value);
    }

    String getTitle() {
        return this.person.getTitle();
    }

    void setTitle(String value) {
        this.person.setTitle(value);
    }

    String getMiddleName() {
        return this.person.getMiddleName();
    }

    void setMiddleName(String value) {
        this.person.setMiddleName(value);
    }

    String getNameSuffix() {
        return this.person.getNameSuffix();
    }

    void setNameSuffix(String value) {
        this.person.setNameSuffix(value);
    }

    String getJobTitle() {
        return this.person.getJobTitle();
    }

    void setJobTitle(String value) {
        this.person.setJobTitle(value);
    }

    String getOrganizationDepartment() {
        return this.person.getOrganizationDepartment();
    }

    void setOrganizationDepartment(String value) {
        this.person.setOrganizationDepartment(value);
    }

    String getId() {
        return this.person.getId();
    }

    void setId(String value) {
        this.person.setId(value);
    }

}
