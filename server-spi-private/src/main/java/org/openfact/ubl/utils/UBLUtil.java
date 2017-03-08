package org.openfact.ubl.utils;

import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLIDGenerator;
import org.openfact.ubl.UBLReaderWriterProvider;

public interface UBLUtil {

    UBLReaderWriterProvider getReaderWriter(String providerType, DocumentType documentType);
    UBLReaderWriterProvider getReaderWriter(String providerType, String documentType);

    UBLIDGenerator getIDGenerator(String providerType, DocumentType documentType);
    UBLIDGenerator getIDGenerator(String providerType, String documentType);

}
