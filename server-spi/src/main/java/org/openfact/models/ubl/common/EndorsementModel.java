package org.openfact.models.ubl.common;

import java.util.List;

public interface EndorsementModel {

    DocumentIDModel getDocumentID();

    void setDocumentID(DocumentIDModel value);

    ApprovalStatusModel getApprovalStatus();

    void setApprovalStatus(ApprovalStatusModel value);

    List<RemarksModel> getRemarks();

    void setRemarks(List<RemarksModel> remarks);

    EndorserPartyModel getEndorserParty();

    void setEndorserParty(EndorserPartyModel value);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    String getId();

    void setId(String value);

}
