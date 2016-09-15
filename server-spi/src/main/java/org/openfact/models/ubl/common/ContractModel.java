package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ContractModel {

    IDModel getID();

    void setID(IDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    String getContractModelCode();

    void setContractModelCode(String value);

    ContractModelModel getContractModel();

    void setContractModel(ContractModelModel value);

    PeriodModel getValidityPeriod();

    void setValidityPeriod(PeriodModel value);

    List<DocumentReferenceModel> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference);

    String getId();

    void setId(String value);

}
