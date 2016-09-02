package org.openfact.models;

public interface OpenfactTransaction {

    void begin();

    void commit();

    void rollback();

    void setRollbackOnly();

    boolean getRollbackOnly();

    boolean isActive();

}
