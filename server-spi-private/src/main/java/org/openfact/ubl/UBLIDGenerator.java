package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UBLIDGenerator<T> extends Provider {

    String generateID(OrganizationModel organization, T t);

}
