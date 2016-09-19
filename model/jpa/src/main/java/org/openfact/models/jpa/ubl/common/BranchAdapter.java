package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.BranchModel;
import org.openfact.models.ubl.common.FinancialInstitutionModel;

public class BranchAdapter implements BranchModel, JpaModel<BranchEntity> {

    protected static final Logger logger = Logger.getLogger(BranchAdapter.class);
    protected BranchEntity branch;
    protected EntityManager em;
    protected OpenfactSession session;

    public BranchAdapter(OpenfactSession session, EntityManager em, BranchEntity branch) {
        this.session = session;
        this.em = em;
        this.branch = branch;
    }

    @Override
    public String getID() {
        return this.branch.getID();
    }

    @Override
    public void setID(String value) {
        this.branch.setID(value);
    }

    @Override
    public String getName() {
        return this.branch.getName();
    }

    @Override
    public void setName(String value) {
        this.branch.setName(value);
    }

    @Override
    public FinancialInstitutionModel getFinancialInstitution() {
        return this.branch.getFinancialInstitution();
    }

    @Override
    public void setFinancialInstitution(FinancialInstitutionAdapter value) {
        this.branch.setFinancialInstitution(value);
    }

    @Override
    public AddressModel getAddress() {
        return this.branch.getAddress();
    }

    @Override
    public void setAddress(AddressAdapter value) {
        this.branch.setAddress(value);
    }

    @Override
    public String getId() {
        return this.branch.getId();
    }

    @Override
    public void setId(String value) {
        this.branch.setId(value);
    }

    @Override
    public BranchEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFinancialInstitution(FinancialInstitutionModel value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAddress(AddressModel value) {
        // TODO Auto-generated method stub
        
    }

}
