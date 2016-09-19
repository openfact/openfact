package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.BranchEntity;
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
        return branch.getID();
    }

    @Override
    public void setID(String value) {
        branch.setID(value);
    }

    @Override
    public String getName() {
        return branch.getName();
    }

    @Override
    public void setName(String value) {
        branch.setName(value);
    }

    @Override
    public FinancialInstitutionModel getFinancialInstitution() {
        return new FinancialInstitutionAdapter(session, em, branch.getFinancialInstitution());
    }

    @Override
    public void setFinancialInstitution(FinancialInstitutionModel value) {
        branch.setFinancialInstitution(FinancialInstitutionAdapter.toEntity(value, em));
    }

    @Override
    public AddressModel getAddress() {
        return new AddressAdapter(session, em, branch.getAddress());
    }

    @Override
    public void setAddress(AddressModel value) {
        branch.setAddress(AddressAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return branch.getId();
    }

    @Override
    public void setId(String value) {
        branch.setId(value);
    }

    @Override
    public BranchEntity getEntity() {
        return branch;
    }

    public static BranchEntity toEntity(BranchModel model, EntityManager em) {
        if (model instanceof BranchAdapter) {
            return ((BranchAdapter) model).getEntity();
        }
        return em.getReference(BranchEntity.class, model.getId());
    }

}
