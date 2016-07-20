package org.openfact.models;

public interface RepeidTransaction {
    void begin();

    void commit();

    void rollback();

    void setRollbackOnly();

    boolean getRollbackOnly();

    boolean isActive();
}
