package org.openfact.ubl.send;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

public class ServiceWrapper<T> {
	private String wsUrl;
	private Map<String, String> config;
	private ServicePasswordThread passwordThread;

	public ServiceWrapper(Map<String, String> config, String wsUrl) {
		this.wsUrl = wsUrl;
		this.config = config;
		passwordThread = new ServicePasswordThread(config);
	}

	public T initWebService(Class<?> serviceClass) {
		Properties properties = System.getProperties();
		properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
		System.setProperties(properties);
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		Map<String, Object> props = new HashMap<>();
		props.put("mtom-enabled", Boolean.FALSE);
		factory.setProperties(props);
		factory.setAddress(wsUrl);		
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(serviceClass);
		T client = (T) factory.create();
		try {
			configureSSLOnTheClient(client, config.get("username"));
			return client;
		} catch (ServiceConfigurationException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void configureSSLOnTheClient(Object object, String username) throws ServiceConfigurationException {
		Client client = ClientProxy.getClient(object);
		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
		TLSClientParameters tlsParams = new TLSClientParameters();
		tlsParams.setDisableCNCheck(true);		
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(30000L);	
		policy.setReceiveTimeout(15000L);
		policy.setAllowChunking(false);
		httpConduit.setClient(policy);		
		FiltersType filter = new FiltersType();
		filter.getInclude().add(".*_EXPORT_.*");
		filter.getInclude().add(".*_EXPORT1024_.*");
		filter.getInclude().add(".*_WITH_DES_.*");
		filter.getInclude().add(".*_WITH_NULL_.*");
		filter.getExclude().add(".*_DH_anon_.*");
		tlsParams.setCipherSuitesFilter(filter);
		httpConduit.setTlsClientParameters(tlsParams);
		HashMap outProps = new HashMap();
		outProps.put("action", "UsernameToken");
		outProps.put("user", username);
		outProps.put("passwordType", "PasswordText");
		outProps.put("passwordCallbackClass", ServicePasswordCallback.class.getName());
		WSS4JOutInterceptor wsOut = new WSS4JOutInterceptor(outProps);
		client.getEndpoint().getOutInterceptors().add(wsOut);
	}
}
