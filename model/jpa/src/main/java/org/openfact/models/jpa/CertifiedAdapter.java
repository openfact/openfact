package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.CertifiedModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CertifiedEntity;

import javax.persistence.EntityManager;
import java.io.FileInputStream;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 10/08/2016.
 */
public class CertifiedAdapter implements CertifiedModel, JpaModel<CertifiedEntity> {

    protected static final Logger logger = Logger.getLogger(CertifiedAdapter.class);
    protected OrganizationModel organization;
    protected CertifiedEntity certified;
    protected EntityManager em;
    protected OpenfactSession session;

    public CertifiedAdapter(OrganizationModel organization, CertifiedEntity certified, EntityManager em, OpenfactSession session) {
        this.organization = organization;
        this.certified = certified;
        this.em = em;
        this.session = session;
    }

    public static CertifiedEntity toEntity(CertifiedModel model, EntityManager em) {
        if (model instanceof CertifiedAdapter) {
            return ((CertifiedAdapter) model).getEntity();
        }
        return em.getReference(CertifiedEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return certified.getId();
    }

    @Override
    public LocalDate getValidity() {
        return certified.getValidity();
    }

    @Override
    public String getAlias() {
        return certified.getAlias();
    }

    @Override
    public void setAlias(String alias) {
        certified.setAlias(alias);
    }

    @Override
    public String getCertificate() {
        return certified.getCertificate();
    }

    @Override
    public String getPassword() {
        return certified.getPassword();
    }

    @Override
    public void setPassword(String password) {
        certified.setPassword(password);
    }

    @Override
    public String getPasswordConfirmation() {
        return certified.getPassword();
    }

    @Override
    public void setPasswordConfirmation(String passwordConfirmation) {
        certified.setPassword(passwordConfirmation);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public CertifiedEntity getEntity() {
        return certified;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceAdapter other = (InvoiceAdapter) obj;
        if (certified == null) {
            if (other.invoice != null)
                return false;
        } else if (!certified.equals(other.invoice))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((certified == null) ? 0 : certified.hashCode());
        return result;
    }

	@Override
	public void disable() {
		certified.setEnabled(false);
	}
}
