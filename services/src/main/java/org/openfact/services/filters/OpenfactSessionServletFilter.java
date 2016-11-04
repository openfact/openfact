/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.services.filters;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactTransaction;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class OpenfactSessionServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");

        final HttpServletRequest request = (HttpServletRequest)servletRequest;

        OpenfactSessionFactory sessionFactory = (OpenfactSessionFactory) servletRequest.getServletContext().getAttribute(OpenfactSessionFactory.class.getName());
        OpenfactSession session = sessionFactory.create();
        ResteasyProviderFactory.pushContext(OpenfactSession.class, session);
        ClientConnection connection = new ClientConnection() {
            @Override
            public String getRemoteAddr() {
                return request.getRemoteAddr();
            }

            @Override
            public String getRemoteHost() {
                return request.getRemoteHost();
            }

            @Override
            public int getRemotePort() {
                return request.getRemotePort();
            }

            @Override
            public String getLocalAddr() {
                return request.getLocalAddr();
            }

            @Override
            public int getLocalPort() {
                return request.getLocalPort();
            }
        };
        session.getContext().setConnection(connection);
        ResteasyProviderFactory.pushContext(ClientConnection.class, connection);

        OpenfactTransaction tx = session.getTransactionManager();
        ResteasyProviderFactory.pushContext(OpenfactTransaction.class, tx);
        tx.begin();

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            if (servletRequest.isAsyncStarted()) {
                servletRequest.getAsyncContext().addListener(createAsyncLifeCycleListener(session));
            } else {
                closeSession(session);
            }
        }
    }

    private AsyncListener createAsyncLifeCycleListener(final OpenfactSession session) {
        return new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) {
                closeSession(session);
            }

            @Override
            public void onTimeout(AsyncEvent event) {
                closeSession(session);
            }

            @Override
            public void onError(AsyncEvent event) {
                closeSession(session);
            }

            @Override
            public void onStartAsync(AsyncEvent event) {
            }
        };
    }

    private void closeSession(OpenfactSession session) {
        // OpenfactTransactionCommitter is responsible for committing the transaction, but if an exception is thrown it's not invoked and transaction
        // should be rolled back
        if (session.getTransactionManager() != null && session.getTransactionManager().isActive()) {
            session.getTransactionManager().rollback();
        }

        session.close();
        ResteasyProviderFactory.clearContextData();
    }

    @Override
    public void destroy() {
    }
}
