package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ContractRepresentation {
    private String idUbl;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String contractRepresentationCode;
    private String contractRepresentation;
    private PeriodRepresentation validityPeriod;
    private List<DocumentReferenceRepresentation> contractDocumentReference;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public PeriodRepresentation getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(PeriodRepresentation validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getContractRepresentationCode() {
        return this.contractRepresentationCode;
    }

    public void setContractRepresentationCode(String contractRepresentationCode) {
        this.contractRepresentationCode = contractRepresentationCode;
    }

    public List<DocumentReferenceRepresentation> getContractDocumentReference() {
        return this.contractDocumentReference;
    }

    public void setContractDocumentReference(
            List<DocumentReferenceRepresentation> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    public String getContractRepresentation() {
        return this.contractRepresentation;
    }

    public void setContractRepresentation(String contractRepresentation) {
        this.contractRepresentation = contractRepresentation;
    }

    public LocalTime getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }
}