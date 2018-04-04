package org.openfact.core.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class SecurityContextFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        AbstractSecurityContext.setServletRequest((HttpServletRequest) request);
        try {
            chain.doFilter(request, response);
        } finally {
            AbstractSecurityContext.clearServletRequest();
        }
    }

    @Override
    public void destroy() {
        // Nothing to do
    }

}
