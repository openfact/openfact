package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

public interface UBLSigner {

    Document sign(Document document, OrganizationModel organization);

}