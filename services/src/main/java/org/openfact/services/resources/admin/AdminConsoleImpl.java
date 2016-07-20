package org.openfact.services.resources.admin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.services.resources.RepeidApplication;
import org.openfact.services.resources.admin.AdminConsole;

public class AdminConsoleImpl implements AdminConsole {

	private static final Logger logger = Logger.getLogger(AdminConsoleImpl.class);

	@Context
	protected UriInfo uriInfo;

	@Context
	protected RepeidApplication repeid;

	// protected AppAuthManager authManager;
	protected OrganizationModel organization;

	public AdminConsoleImpl(OrganizationModel organization) {
		this.organization = organization;
		// this.authManager = new AppAuthManager();
	}

	@Override
	public Response getMainPage() throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getIndexHtmlRedirect() {
		// TODO Auto-generated method stub
		return null;
	}

}
