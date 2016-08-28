package org.openfact.services.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.OpenfactTransaction;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class OpenfactTransactionCommitter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        OpenfactTransaction tx = ResteasyProviderFactory.getContextData(OpenfactTransaction.class);
        if (tx != null && tx.isActive()) {
            if (tx.getRollbackOnly()) {
                tx.rollback();
            } else {
                tx.commit();
            }
        }
    }

}
