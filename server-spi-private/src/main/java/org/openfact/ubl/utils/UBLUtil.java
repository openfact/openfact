package org.openfact.ubl.utils;

import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLCustomizationProvider;
import org.openfact.ubl.UBLIDGenerator;
import org.openfact.ubl.UBLReaderWriterProvider;
import org.openfact.ubl.UBLThirdPartySender;

public interface UBLUtil {

    UBLReaderWriterProvider getReaderWriter(DocumentType documentType);
    UBLReaderWriterProvider getReaderWriter(String documentType);
    UBLReaderWriterProvider getReaderWriter(String providerType, String documentType);

    UBLIDGenerator getIDGenerator(DocumentType documentType);
    UBLIDGenerator getIDGenerator(String documentType);
    UBLIDGenerator getIDGenerator(String providerType, String documentType);

    UBLCustomizationProvider getCustomizationProvider(DocumentType documentType);
    UBLCustomizationProvider getCustomizationProvider(String documentType);
    UBLCustomizationProvider getCustomizationProvider(String providerType, String documentType);

    UBLThirdPartySender getThirdPartySender(DocumentType documentType);
    UBLThirdPartySender getThirdPartySender(String documentType);
    UBLThirdPartySender getThirdPartySender(String providerType, String documentType);

}
