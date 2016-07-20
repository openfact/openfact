package org.openfact.services.resources;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.openfact.Config;
import org.openfact.models.RepeidSession;
import org.openfact.services.util.CacheControlUtil;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

public class WelcomeResourceImpl/* implements WelcomeResource*/ {

	// private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

	// private static final String REPEID_STATE_CHECKER =
	// "REPEID_STATE_CHECKER";

//	private boolean bootstrap;
//
//	@Context
//	protected HttpHeaders headers;
//
//	@Context
//	private UriInfo uriInfo;
//
//	@Context
//	private RepeidSession session;
//
//	private String stateChecker;
//
//	public WelcomeResourceImpl(boolean bootstrapAdminUser) {
//
//	}
//
//	//@Override
//	public Response getWelcomePage() throws URISyntaxException {
//		String requestUri = uriInfo.getRequestUri().toString();
//		if (!requestUri.endsWith("/")) {
//			return Response.seeOther(new URI(requestUri + "/")).build();
//		} else {
//			return createWelcomePage(null, null);
//		}
//	}
//
//	//@Override
//	public Response createUser(MultivaluedMap<String, String> formData) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	//@Override
//	public Response getResource(String path) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private Response createWelcomePage(String successMessage, String errorMessage) {
//		try {
//			Map<String, Object> map = new HashMap<>();
//			map.put("bootstrap", bootstrap);
//			if (bootstrap) {
//				map.put("localUser", isLocal());
//
//				// updateCsrfChecks();
//				map.put("stateChecker", stateChecker);
//			}
//			if (successMessage != null) {
//				map.put("successMessage", successMessage);
//			}
//			if (errorMessage != null) {
//				map.put("errorMessage", errorMessage);
//			}
//			FreeMarkerUtil freeMarkerUtil = new FreeMarkerUtil();
//
//			String result = freeMarkerUtil.processTemplate(map, "index.ftl", getTheme());
//
//			ResponseBuilder rb = Response.status(errorMessage == null ? Status.OK : Status.BAD_REQUEST).entity(result)
//					.cacheControl(CacheControlUtil.noCache());
//			// BrowserSecurityHeaderSetup.headers(rb,
//			// BrowserSecurityHeaders.defaultHeaders);
//			return rb.build();
//		} catch (Exception e) {
//			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	private Theme getTheme() {
//		Config.Scope config = Config.scope("theme");
//		ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
//		try {
//			return themeProvider.getTheme(config.get("welcomeTheme"), Theme.Type.WELCOME);
//		} catch (IOException e) {
//			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	private boolean isLocal() {
//		try {
//			InetAddress inetAddress = InetAddress.getByName(session.getContext().getConnection().getRemoteAddr());
//			return inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress();
//		} catch (UnknownHostException e) {
//			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	private void updateCsrfChecks() {
//
//	}

}
