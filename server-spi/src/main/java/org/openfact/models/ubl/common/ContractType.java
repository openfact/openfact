package org.openfact.models.ubl.common;

import java.util.List;

public interface ContractType {

    IDType getID();

    void setID(IDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    IssueTimeType getIssueTime();

    void setIssueTime(IssueTimeType value);

    ContractTypeCodeType getContractTypeCode();

    void setContractTypeCode(ContractTypeCodeType value);

    ContractTypeType getContractType();

    void setContractType(ContractTypeType value);

    PeriodType getValidityPeriod();

    void setValidityPeriod(PeriodType value);

    List<DocumentReferenceType> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceType> contractDocumentReference);

    String getId();

    void setId(String value);

}
