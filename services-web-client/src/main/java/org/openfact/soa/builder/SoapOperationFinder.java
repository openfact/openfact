package org.openfact.soa.builder;

import org.openfact.soa.common.SoapContext;


public interface SoapOperationFinder {

    SoapOperationFinder name(String operationName);

    SoapOperationFinder soapAction(String soapAction);

    SoapOperationFinder inputName(String inputName);

    SoapOperationFinder outputName(String inputName);

    SoapOperationBuilder find();

    SoapOperationBuilder find(SoapContext context);


}
