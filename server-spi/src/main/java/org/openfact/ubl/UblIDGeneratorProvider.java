package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.provider.Provider;

public interface UblIDGeneratorProvider extends Provider {

    String generateID(OrganizationModel organization, UblDocumentType type) throws UblException;

    String generateID(OrganizationModel organization, UblDocumentType type, String codeType)
            throws UblException;

}