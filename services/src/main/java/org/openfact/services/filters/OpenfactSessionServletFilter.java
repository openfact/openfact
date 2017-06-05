package org.openfact.services.filters;


import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.services.DefaultOpenfactSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class OpenfactSessionServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        OpenfactSession session = new DefaultOpenfactSession();
        ResteasyProviderFactory.pushContext(OpenfactSession.class, session);
        ClientConnection clientConnection = new ClientConnection() {
            @Override
            public String getRemoteAddr() {
                return httpServletRequest.getRemoteAddr();
            }

            @Override
            public String getRemoteHost() {
                return httpServletRequest.getRemoteHost();
            }

            @Override
            public int getRemotePort() {
                return httpServletRequest.getRemotePort();
            }

            @Override
            public String getLocalAddr() {
                return httpServletRequest.getLocalAddr();
            }

            @Override
            public int getLocalPort() {
                return httpServletRequest.getLocalPort();
            }
        };

        session.getContext().setConnection(clientConnection);
        ResteasyProviderFactory.pushContext(ClientConnection.class, clientConnection);

        try {
            chain.doFilter(request, response);
        } finally {
            if (request.isAsyncStarted()) {
                request.getAsyncContext().addListener(createAsyncLifeCycleListener(session));
            } else {
                closeSession(session);
            }
        }
    }

    @Override
    public void destroy() {
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
        ResteasyProviderFactory.clearContextData();
    }

}
