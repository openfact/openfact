package org.openfact.services.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.RepeidTransaction;

public class OpenfactTransactionCommitter implements ContainerResponseFilter {

	private static final Logger logger = Logger.getLogger(OpenfactTransactionCommitter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
    	logger.info("RepeidTransactionCommitter empezado");
    	RepeidTransaction tx = ResteasyProviderFactory.getContextData(RepeidTransaction.class);
        if (tx != null && tx.isActive()) {
            if (tx.getRollbackOnly()) {
                tx.rollback();
            } else {
                tx.commit();
            }
        }
        logger.info("RepeidTransactionCommitter terminado");
    }

}
