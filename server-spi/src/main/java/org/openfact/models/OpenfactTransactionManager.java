package org.openfact.models;

public interface OpenfactTransactionManager extends OpenfactTransaction {

    void enlist(OpenfactTransaction transaction);

    void enlistAfterCompletion(OpenfactTransaction transaction);

    void enlistPrepare(OpenfactTransaction transaction);

}
