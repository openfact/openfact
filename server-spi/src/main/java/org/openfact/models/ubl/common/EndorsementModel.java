package org.openfact.models.ubl.common;

import java.util.List;

public interface EndorsementModel {

    String getDocumentID();

    void setDocumentID(String value);

    String getApprovalStatus();

    void setApprovalStatus(String value);

    List<String> getRemarks();

    void setRemarks(List<String> remarks);

    EndorserPartyModel getEndorserParty();

    void setEndorserParty(EndorserPartyModel value);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    String getId();

    void setId(String value);

}
