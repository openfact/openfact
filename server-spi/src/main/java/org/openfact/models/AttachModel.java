package org.openfact.models;

import org.openfact.models.enums.InternetMediaType;

public interface AttachModel {

	String getFileName();

	byte[] getFile();

	String getMimiType();

	String getExtension();

	// InternetMediaType getMediaType();

}
