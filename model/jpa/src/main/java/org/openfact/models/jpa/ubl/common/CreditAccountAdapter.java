package org.openfact.models.jpa.ubl.common;

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

    String getAccountID() {
        return this.creditAccount.getAccountID();
    }

    void setAccountID(String value) {
        this.creditAccount.setAccountID(value);
    }

    String getId() {
        return this.creditAccount.getId();
    }

    void setId(String value) {
        this.creditAccount.setId(value);
    }

}
