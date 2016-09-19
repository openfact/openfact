package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.ContractModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.PeriodModel;

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

    @Override
    public String getID() {
        return this.contract.getID();
    }

    @Override
    public void setID(String value) {
        this.contract.setID(value);
    }

    @Override
    public LocalDate getIssueDate() {
        return this.contract.getIssueDate();
    }

    @Override
    public void setIssueDate(LocalDate value) {
        this.contract.setIssueDate(value);
    }

    @Override
    public LocalTime getIssueTime() {
        return this.contract.getIssueTime();
    }

    @Override
    public void setIssueTime(LocalTime value) {
        this.contract.setIssueTime(value);
    }

    @Override
    public String getContractModelCode() {
        return this.contract.getContractModelCode();
    }

    @Override
    public void setContractAdapterCode(String value) {
        this.contract.setContractAdapterCode(value);
    }

    @Override
    public String getContractModel() {
        return this.contract.getContractModel();
    }

    @Override
    public void setContractAdapter(String value) {
        this.contract.setContractAdapter(value);
    }

    @Override
    public PeriodModel getValidityPeriod() {
        return this.contract.getValidityPeriod();
    }

    @Override
    public void setValidityPeriod(PeriodAdapter value) {
        this.contract.setValidityPeriod(value);
    }

    @Override
    public List<DocumentReferenceModel> getContractDocumentReference() {
        return this.contract.getContractDocumentReference();
    }

    @Override
    public void setContractDocumentReference(List<DocumentReferenceAdapter> contractDocumentReference) {
        this.contract.setContractDocumentReference(contractDocumentReference);
    }

    @Override
    public String getId() {
        return this.contract.getId();
    }

    @Override
    public void setId(String value) {
        this.contract.setId(value);
    }

}
