package org.openfact.soa.builder;

import javax.xml.namespace.QName;

public interface SoapOperation {

	QName getBindingName();

	String getOperationName();

	String getOperationInputName();

	String getOperationOutputName();

	String getSoapAction();

	boolean isRpc();

	boolean isInputSoapEncoded();

	boolean isOutputSoapEncoded();

}
