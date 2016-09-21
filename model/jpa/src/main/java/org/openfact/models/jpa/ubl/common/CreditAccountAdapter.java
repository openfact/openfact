package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.CreditAccountEntity;
import org.openfact.models.ubl.common.CreditAccountModel;

public class CreditAccountAdapter implements CreditAccountModel, JpaModel<CreditAccountEntity> {

    protected static final Logger logger = Logger.getLogger(CreditAccountAdapter.class);
    protected CreditAccountEntity creditAccount;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditAccountAdapter(OpenfactSession session, EntityManager em,
            CreditAccountEntity creditAccount) {
        this.session = session;
        this.em = em;
        this.creditAccount = creditAccount;
    }

    @Override
    public String getAccountID() {
        return this.creditAccount.getAccountID();
    }

    @Override
    public void setAccountID(String value) {
        this.creditAccount.setAccountID(value);
    }

    @Override
    public String getId() {
        return this.creditAccount.getId();
    }

    @Override
    public void setId(String value) {
        this.creditAccount.setId(value);
    }

    @Override
    public CreditAccountEntity getEntity() {
        return this.creditAccount;
    }

    public static CreditAccountEntity toEntity(CreditAccountModel model, EntityManager em) {
        if (model instanceof CreditAccountModel) {
            return ((CreditAccountAdapter) model).getEntity();
        }
        return em.getReference(CreditAccountEntity.class, model.getId());
    }

}
