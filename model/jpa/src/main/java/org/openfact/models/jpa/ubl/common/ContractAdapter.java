package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ContractAdapter implements ContractModel, JpaModel<ContractEntity> {

    protected static final Logger logger = Logger.getLogger(ContractAdapter.class);
    protected ContractEntity contract;
    protected EntityManager em;
    protected OpenfactSession session;

    public ContractAdapter(OpenfactSession session, EntityManager em, ContractEntity contract) {
        this.session = session;
        this.em = em;
        this.contract = contract;
    }

    String getID() {
        return this.contract.getID();
    }

    void setID(String value) {
        this.contract.setID(value);
    }

    LocalDate getIssueDate() {
        return this.contract.getIssueDate();
    }

    void setIssueDate(LocalDate value) {
        this.contract.setIssueDate(value);
    }

    LocalTime getIssueTime() {
        return this.contract.getIssueTime();
    }

    void setIssueTime(LocalTime value) {
        this.contract.setIssueTime(value);
    }

    String getContractAdapterCode() {
        return this.contract.getContractAdapterCode();
    }

    void setContractAdapterCode(String value) {
        this.contract.setContractAdapterCode(value);
    }

    String getContractAdapter() {
        return this.contract.getContractAdapter();
    }

    void setContractAdapter(String value) {
        this.contract.setContractAdapter(value);
    }

    PeriodAdapter getValidityPeriod() {
        return this.contract.getValidityPeriod();
    }

    void setValidityPeriod(PeriodAdapter value) {
        this.contract.setValidityPeriod(value);
    }

    List<DocumentReferenceAdapter> getContractDocumentReference() {
        return this.contract.getContractDocumentReference();
    }

    void setContractDocumentReference(List<DocumentReferenceAdapter> contractDocumentReference) {
        this.contract.setContractDocumentReference(contractDocumentReference);
    }

    String getId() {
        return this.contract.getId();
    }

    void setId(String value) {
        this.contract.setId(value);
    }

}
