package org.openfact.ubl.utils;

import org.openfact.models.types.DocumentType;
import org.openfact.ubl.UBLCustomizator;
import org.openfact.ubl.UBLIDGenerator;
import org.openfact.ubl.UBLReaderWriter;
import org.openfact.ubl.UBLThirdPartySender;

public interface UBLUtil {

    UBLReaderWriter getReaderWriter(DocumentType documentType);
    UBLReaderWriter getReaderWriter(String documentType);
    UBLReaderWriter getReaderWriter(String providerType, String documentType);

    UBLIDGenerator getIDGenerator(DocumentType documentType);
    UBLIDGenerator getIDGenerator(String documentType);
    UBLIDGenerator getIDGenerator(String providerType, String documentType);

    UBLCustomizator getCustomizationProvider(DocumentType documentType);
    UBLCustomizator getCustomizationProvider(String documentType);
    UBLCustomizator getCustomizationProvider(String providerType, String documentType);

    UBLThirdPartySender getThirdPartySender(DocumentType documentType);
    UBLThirdPartySender getThirdPartySender(String documentType);
    UBLThirdPartySender getThirdPartySender(String providerType, String documentType);

}
