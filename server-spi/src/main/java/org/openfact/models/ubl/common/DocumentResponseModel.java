package org.openfact.models.ubl.common;

import java.util.List;

public interface DocumentResponseModel {

    ResponseModel getResponse();

    void setResponse(ResponseModel value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    PartyModel getIssuerParty();

    void setIssuerParty(PartyModel value);

    PartyModel getRecipientParty();

    void setRecipientParty(PartyModel value);

    List<LineResponseModel> getLineResponse();

    void setLineResponse(List<LineResponseModel> lineResponse);

    String getId();

    void setId(String value);

}
