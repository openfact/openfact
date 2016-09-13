package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

public interface ExternalReferenceModel {

    CodeModel getCharacterSetCode();

    void setCharacterSetCode(CodeModel characterSetCode);

    TextModel getDescription();

    void setDescription(TextModel description);

    TextModel getDocumentHash();

    void setDocumentHash(TextModel documentHash);

    CodeModel getEncodingCode();

    void setEncodingCode(CodeModel encodingCode);

    LocalDate getExpiryDate();

    void setExpiryDate(LocalDate expiryDate);

    LocalTime getExpiryTime();

    void setExpiryTime(LocalTime expiryTime);

    NameModel getFileName();

    void setFileName(NameModel fileName);

    CodeModel getFormatCode();

    void setFormatCode(CodeModel formatCode);

    TextModel getHashAlgorithmMethod();

    void setHashAlgorithmMethod(TextModel hashAlgorithmMethod);

    CodeModel getMimeCode();

    void setMimeCode(CodeModel mimeCode);

    IdentifierModel getURIID();

    void setURIID(IdentifierModel uRIID);

}
