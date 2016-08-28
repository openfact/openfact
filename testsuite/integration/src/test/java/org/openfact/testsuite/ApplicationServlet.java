package org.openfact.testsuite;

import org.openfact.services.resources.OrganizationsResource;
import org.openfact.services.resources.OrganizationsResourceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.PrintWriter;

public class ApplicationServlet extends HttpServlet {

    private static final String LINK = "<a href=\"%s\" id=\"%s\">%s</a>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "";
        if (req.getRequestURI().endsWith("auth")) {
            title = "AUTH_RESPONSE";
        } else if (req.getRequestURI().endsWith("logout")) {
            title = "LOGOUT_REQUEST";
        } else {
            title = "APP_REQUEST";
        }

        PrintWriter pw = resp.getWriter();
        pw.printf("<html><head><title>%s</title></head><body>", title);
        UriBuilder base = UriBuilder.fromUri("http://localhost:8081/openfact");
        //pw.printf(LINK, OrganizationsResourceImpl.accountUrl(base).build("test"), "account", "account");

        pw.print("</body></html>");
        pw.flush();
    }

}
