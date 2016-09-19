package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PersonEntity;
import org.openfact.models.ubl.common.PersonModel;

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

    @Override
    public String getFirstName() {
        return this.person.getFirstName();
    }

    @Override
    public void setFirstName(String value) {
        this.person.setFirstName(value);
    }

    @Override
    public String getFamilyName() {
        return this.person.getFamilyName();
    }

    @Override
    public void setFamilyName(String value) {
        this.person.setFamilyName(value);
    }

    @Override
    public String getTitle() {
        return this.person.getTitle();
    }

    @Override
    public void setTitle(String value) {
        this.person.setTitle(value);
    }

    @Override
    public String getMiddleName() {
        return this.person.getMiddleName();
    }

    @Override
    public void setMiddleName(String value) {
        this.person.setMiddleName(value);
    }

    @Override
    public String getNameSuffix() {
        return this.person.getNameSuffix();
    }

    @Override
    public void setNameSuffix(String value) {
        this.person.setNameSuffix(value);
    }

    @Override
    public String getJobTitle() {
        return this.person.getJobTitle();
    }

    @Override
    public void setJobTitle(String value) {
        this.person.setJobTitle(value);
    }

    @Override
    public String getOrganizationDepartment() {
        return this.person.getOrganizationDepartment();
    }

    @Override
    public void setOrganizationDepartment(String value) {
        this.person.setOrganizationDepartment(value);
    }

    @Override
    public String getId() {
        return this.person.getId();
    }

    @Override
    public void setId(String value) {
        this.person.setId(value);
    }

	@Override
	public PersonEntity getEntity() {
		// TODO Auto-generated method stub
		return person;
	}

}
