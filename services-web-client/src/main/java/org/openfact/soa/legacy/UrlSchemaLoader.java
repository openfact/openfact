package org.openfact.soa.legacy;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openfact.soa.common.SoapBuilderException;

import java.net.URL;

public class UrlSchemaLoader implements SchemaLoader, DefinitionLoader {
	private String baseURI;

	public UrlSchemaLoader(String baseURI) {
		this.baseURI = baseURI;
	}

	public XmlObject loadXmlObject(String wsdlUrl, XmlOptions options) throws Exception {
		return XmlUtils.createXmlObject(new URL(wsdlUrl), options);
	}

	public String getBaseURI() {
		return baseURI;
	}

	public void setProgressInfo(String info) {
		throw new SoapBuilderException("Not Implemented");
	}

	public boolean isAborted() {
		throw new SoapBuilderException("Not Implemented");
	}

	public boolean abort() {
		throw new SoapBuilderException("Not Implemented");
	}

	public void setNewBaseURI(String uri) {
		throw new SoapBuilderException("Not Implemented");
	}

	public String getFirstNewURI() {
		throw new SoapBuilderException("Not Implemented");
	}
}
