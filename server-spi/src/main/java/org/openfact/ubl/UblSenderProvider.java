package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.provider.Provider;

public interface UblSenderProvider extends Provider {

	public byte[] send(OrganizationModel organization, byte[] document, String fileName, String invoiceType,
			InternetMediaType mediaType, String wsUrl) throws UblSenderException;

	public byte[] getStatus(OrganizationModel organization, String ticket, String wsUrl) throws UblSenderException;

	public byte[] voided(OrganizationModel organization, byte[] document, String fileName, String invoiceType,
			InternetMediaType mediaType, String wsUrl) throws UblSenderException;
}
