package org.openfact.models.ubl.common;

import java.util.List;

public interface DocumentResponseType {

    ResponseType getResponse();

    void setResponse(ResponseType value);

    DocumentReferenceType getDocumentReference();

    void setDocumentReference(DocumentReferenceType value);

    PartyType getIssuerParty();

    void setIssuerParty(PartyType value);

    PartyType getRecipientParty();

    void setRecipientParty(PartyType value);

    List<LineResponseType> getLineResponse();

    void setLineResponse(List<LineResponseType> lineResponse);

    String getId();

    void setId(String value);

}
