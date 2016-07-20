package org.openfact.theme;

import javax.ws.rs.core.Response;

import org.openfact.models.BrowserSecurityHeaders;
import org.openfact.models.OrganizationModel;

import java.util.HashMap;
import java.util.Map;

public class BrowserSecurityHeaderSetup {

	public static Response.ResponseBuilder headers(Response.ResponseBuilder builder, OrganizationModel organization) {
		return headers(builder, /* organization.getBrowserSecurityHeaders() */new HashMap<String, String>());
	}

	public static Response.ResponseBuilder headers(Response.ResponseBuilder builder, Map<String, String> headers) {
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			String headerName = BrowserSecurityHeaders.headerAttributeMap.get(entry.getKey());
			if (headerName != null && entry.getValue() != null && entry.getValue().length() > 0) {
				builder.header(headerName, entry.getValue());
			}
		}
		return builder;
	}

}
