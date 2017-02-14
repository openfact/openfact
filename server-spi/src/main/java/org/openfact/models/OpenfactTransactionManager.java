package org.openfact.models;

public interface OpenfactTransactionManager extends OpenfactTransaction {

    enum JTAPolicy {
        /**
         * Do not interact with JTA at all
         */
        NOT_SUPPORTED,
        /**
         * A new JTA Transaction will be created when Openfact TM begin() is called.  If an existing JTA transaction
         * exists, it is suspended and resumed after the Openfact transaction finishes.
         */
        REQUIRES_NEW,
    }

    JTAPolicy getJTAPolicy();

    void setJTAPolicy(JTAPolicy policy);

    void enlist(OpenfactTransaction transaction);

    void enlistAfterCompletion(OpenfactTransaction transaction);

    void enlistPrepare(OpenfactTransaction transaction);

}
