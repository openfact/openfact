package org.openfact.soa.common;

import javax.xml.namespace.QName;
import java.util.Set;


public interface SoapMultiValuesProvider {

    Set<String> getMultiValues(QName name);

}
