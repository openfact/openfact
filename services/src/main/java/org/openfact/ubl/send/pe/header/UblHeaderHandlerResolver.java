package org.openfact.ubl.send.pe.header;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.openfact.models.OrganizationModel;

public class UblHeaderHandlerResolver implements HandlerResolver {
	
    private Map<String, String> config;

	public UblHeaderHandlerResolver(Map<String, String> config) {
		this.config = config;
	}

	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<>();
		UblHeaderHandler ublHeaderHandler = new UblHeaderHandler(config);
		handlerChain.add(ublHeaderHandler);
		return handlerChain;
	}

}
