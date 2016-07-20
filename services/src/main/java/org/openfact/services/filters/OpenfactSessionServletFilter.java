package org.openfact.services.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.models.RepeidTransaction;

@WebFilter(urlPatterns = { "/*" })
public class OpenfactSessionServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		servletRequest.setCharacterEncoding("UTF-8");

		final HttpServletRequest request = (HttpServletRequest) servletRequest;

		RepeidSessionFactory sessionFactory = (RepeidSessionFactory) servletRequest.getServletContext()
				.getAttribute(RepeidSessionFactory.class.getName());
		RepeidSession session = sessionFactory.create();
		ResteasyProviderFactory.pushContext(RepeidSession.class, session);
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
			public int getReportPort() {
				return request.getRemotePort();
			}
		};
		session.getContext().setConnection(connection);
		ResteasyProviderFactory.pushContext(ClientConnection.class, connection);

		RepeidTransaction tx = session.getTransaction();
		ResteasyProviderFactory.pushContext(RepeidTransaction.class, tx);
		tx.begin();

		try {
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			// RepeidTransactionCommitter is responsible for committing the
			// transaction, but if an exception is thrown it's not invoked and
			// transaction
			// should be rolled back
			if (session.getTransaction() != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}

			session.close();
			ResteasyProviderFactory.clearContextData();
		}
	}

	@Override
	public void destroy() {
	}
}
