package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UBLWriter<T> extends Provider {

    Document write(OrganizationModel organization, T t);

}
