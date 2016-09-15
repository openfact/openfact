package org.openfact.models.ubl.common;

import java.util.List;

public interface ContractModel {

    IDModel getID();

    void setID(IDModel value);

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    IssueTimeModel getIssueTime();

    void setIssueTime(IssueTimeModel value);

    ContractModelCodeModel getContractModelCode();

    void setContractModelCode(ContractModelCodeModel value);

    ContractModelModel getContractModel();

    void setContractModel(ContractModelModel value);

    PeriodModel getValidityPeriod();

    void setValidityPeriod(PeriodModel value);

    List<DocumentReferenceModel> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference);

    String getId();

    void setId(String value);

}
