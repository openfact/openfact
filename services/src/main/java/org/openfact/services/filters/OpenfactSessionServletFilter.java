package org.openfact.services.filters;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactTransaction;

public class OpenfactSessionServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		servletRequest.setCharacterEncoding("UTF-8");

		final HttpServletRequest request = (HttpServletRequest) servletRequest;

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
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public String getLocalAddr() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getLocalPort() {
                // TODO Auto-generated method stub
                return 0;
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
        // OpenfactTransactionCommitter is responsible for committing the
        // transaction, but if an exception is thrown it's not invoked and
        // transaction
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
