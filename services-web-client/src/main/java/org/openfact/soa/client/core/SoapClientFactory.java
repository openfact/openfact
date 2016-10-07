package org.openfact.soa.client.core;

public class SoapClientFactory {

	private String endpointUri;
	private Security endpointSecurity;

	private String proxyUri;
	private Security proxySecurity;

	private Integer readTimeoutInMillis;
	private Integer connectTimeoutInMillis;

	public String getEndpointUri() {
		return endpointUri;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public String getProxyUri() {
		return proxyUri;
	}

	public void setProxyUri(String proxyUri) {
		this.proxyUri = proxyUri;
	}

	public Integer getReadTimeoutInMillis() {
		return readTimeoutInMillis;
	}

	public void setReadTimeoutInMillis(Integer readTimeoutInMillis) {
		this.readTimeoutInMillis = readTimeoutInMillis;
	}

	public Integer getConnectTimeoutInMillis() {
		return connectTimeoutInMillis;
	}

	public void setConnectTimeoutInMillis(Integer connectTimeoutInMillis) {
		this.connectTimeoutInMillis = connectTimeoutInMillis;
	}

	public Security getEndpointSecurity() {
		return endpointSecurity;
	}

	public void setEndpointSecurity(Security endpointSecurity) {
		this.endpointSecurity = endpointSecurity;
	}

	public Security getProxySecurity() {
		return proxySecurity;
	}

	public void setProxySecurity(Security proxySecurity) {
		this.proxySecurity = proxySecurity;
	}

	public SoapClient create() {
		SoapClient.Builder builder = SoapClient.builder();

		if (endpointUri != null) {
			builder.endpointUri(endpointUri);
		}
		if (proxyUri != null) {
			builder.proxyUri(proxyUri);
		}
		if (readTimeoutInMillis != null) {
			builder.readTimeoutInMillis(readTimeoutInMillis);
		}
		if (connectTimeoutInMillis != null) {
			builder.connectTimeoutInMillis(connectTimeoutInMillis);
		}
		if (endpointSecurity != null) {
			builder.endpointSecurity(endpointSecurity);
		}
		if (proxySecurity != null) {
			builder.proxySecurity(proxySecurity);
		}
		return builder.build();
	}

}
