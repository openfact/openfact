package org.openfact.soa.builder;

import javax.xml.namespace.QName;

import org.openfact.soa.common.SoapContext;

public interface SoapBuilderFinder {

	SoapBuilderFinder name(String name);

	SoapBuilderFinder name(QName name);

	SoapBuilderFinder namespaceURI(String namespaceURI);

	SoapBuilderFinder localPart(String localPart);

	SoapBuilderFinder prefix(String prefix);

	SoapBuilder find();

	SoapBuilder find(SoapContext context);

}
