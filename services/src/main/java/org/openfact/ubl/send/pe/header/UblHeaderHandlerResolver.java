package org.openfact.ubl.send.pe.header;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.openfact.models.OrganizationModel;

public class UblHeaderHandlerResolver implements HandlerResolver {
	private OrganizationModel organization;

	public UblHeaderHandlerResolver(OrganizationModel organization) {
		this.organization = organization;
	}

	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<>();
		UblHeaderHandler ublHeaderHandler = new UblHeaderHandler(organization);
		handlerChain.add(ublHeaderHandler);
		return handlerChain;
	}

}
