/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.connections.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class PersistenceExceptionConverter implements InvocationHandler {

    private EntityManager em;

    private PersistenceExceptionConverter(EntityManager em) {
        this.em = em;
    }

    public static EntityManager create(EntityManager em) {
        return (EntityManager) Proxy.newProxyInstance(EntityManager.class.getClassLoader(), new Class[]{EntityManager.class}, new PersistenceExceptionConverter(em));
    }

    public static ModelException convert(Throwable t) {
        if (t.getCause() != null && t.getCause() instanceof ConstraintViolationException) {
            throw new ModelDuplicateException(t);
        }
        if (t instanceof EntityExistsException) {
            throw new ModelDuplicateException(t);
        } else {
            throw new ModelException(t);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(em, args);
        } catch (InvocationTargetException e) {
            throw convert(e.getCause());
        }
    }

}
