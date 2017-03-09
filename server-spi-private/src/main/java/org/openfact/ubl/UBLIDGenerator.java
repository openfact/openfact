package org.openfact.ubl;

import org.openfact.models.OrganizationModel;

public interface UBLIDGenerator<T> {

    String generateID(OrganizationModel organization, T t);

}
