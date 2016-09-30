package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UblSenderProvider extends Provider {

    void send(OrganizationModel organization, String fileName, byte[] document, String contentType)
            throws UblSenderException;
}
