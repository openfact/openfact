package org.openfact.connections.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersistenceExceptionConverter implements InvocationHandler {

    private EntityManager em;

    public PersistenceExceptionConverter(EntityManager em) {
        this.em = em;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(em, args);
        } catch (InvocationTargetException e) {
            throw convert(e.getCause());
        }
    }

    public static ModelException convert(Throwable t) {
        if (t.getCause() != null && t.getCause() instanceof ConstraintViolationException) {
            throw new ModelDuplicateException(t);
        }
        if (t instanceof EntityExistsException || t instanceof ConstraintViolationException) {
            throw new ModelDuplicateException(t);
        } else {
            throw new ModelException(t);
        }
    }

}
