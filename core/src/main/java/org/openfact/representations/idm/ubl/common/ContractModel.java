package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ContractModel {

    String getID();

    void setID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    String getContractModelCode();

    void setContractModelCode(String value);

    String getContractModel();

    void setContractModel(String value);

    PeriodModel getValidityPeriod();

    void setValidityPeriod(PeriodModel value);

    List<DocumentReferenceModel> getContractDocumentReference();

    void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference);

    String getId();

    void setId(String value);

}
