package org.openfact.connections.jpa;

import org.openfact.provider.ExceptionConverter;

import javax.persistence.PersistenceException;

public class JpaExceptionConverter implements ExceptionConverter {
    @Override
    public Throwable convert(Throwable e) {
        if (!(e instanceof PersistenceException)) return null;
        return PersistenceExceptionConverter.convert(e.getCause() != null ? e.getCause() : e);
    }

    @Override
    public String getId() {
        return "jpa";
    }
}
