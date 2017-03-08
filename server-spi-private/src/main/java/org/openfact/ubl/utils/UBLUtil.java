package org.openfact.ubl.utils;

import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLReaderWriterProvider;

public interface UBLUtil {

    UBLReaderWriterProvider getFactory(String providerType, DocumentType documentType);

    UBLReaderWriterProvider getFactory(String providerType, String documentType);

}
