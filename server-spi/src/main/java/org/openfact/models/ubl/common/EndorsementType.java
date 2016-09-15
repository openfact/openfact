package org.openfact.models.ubl.common;

import java.util.List;

public interface EndorsementType {

    DocumentIDType getDocumentID();

    void setDocumentID(DocumentIDType value);

    ApprovalStatusType getApprovalStatus();

    void setApprovalStatus(ApprovalStatusType value);

    List<RemarksType> getRemarks();

    void setRemarks(List<RemarksType> remarks);

    EndorserPartyType getEndorserParty();

    void setEndorserParty(EndorserPartyType value);

    List<SignatureType> getSignature();

    void setSignature(List<SignatureType> signature);

    String getId();

    void setId(String value);

}
