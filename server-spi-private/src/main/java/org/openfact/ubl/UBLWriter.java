package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

public interface UBLWriter<T> {

    Document write(OrganizationModel organization, T t);

}
