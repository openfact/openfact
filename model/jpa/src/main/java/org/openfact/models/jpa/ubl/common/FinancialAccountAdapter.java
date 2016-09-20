package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.FinancialAccountEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BranchModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.FinancialAccountModel;

public class FinancialAccountAdapter implements FinancialAccountModel, JpaModel<FinancialAccountEntity> {

	protected static final Logger logger = Logger.getLogger(FinancialAccountAdapter.class);
	protected FinancialAccountEntity financialAccount;
	protected EntityManager em;
	protected OpenfactSession session;

	public FinancialAccountAdapter(OpenfactSession session, EntityManager em, FinancialAccountEntity financialAccount) {
		this.session = session;
		this.em = em;
		this.financialAccount = financialAccount;
	}

	@Override
	public String getID() {
		return this.financialAccount.getID();
	}

	@Override
	public void setID(String value) {
		this.financialAccount.setID(value);
	}

	@Override
	public String getName() {
		return this.financialAccount.getName();
	}

	@Override
	public void setName(String value) {
		this.financialAccount.setName(value);
	}

	@Override
	public String getAccountTypeCode() {
		return this.financialAccount.getAccountTypeCode();
	}

	@Override
	public void setAccountTypeCode(String value) {
		this.financialAccount.setAccountTypeCode(value);
	}

	@Override
	public String getCurrencyCode() {
		return this.financialAccount.getCurrencyCode();
	}

	@Override
	public void setCurrencyCode(String value) {
		this.financialAccount.setCurrencyCode(value);
	}

	@Override
	public List<String> getPaymentNote() {
		return this.financialAccount.getPaymentNote();
	}

	@Override
	public void setPaymentNote(List<String> paymentNote) {
		this.financialAccount.setPaymentNote(paymentNote);
	}

	@Override
	public BranchModel getFinancialInstitutionBranch() {
		return new BranchAdapter(session, em, financialAccount.getFinancialInstitutionBranch());
	}

	@Override
	public void setFinancialInstitutionBranch(BranchModel value) {
		this.financialAccount.setFinancialInstitutionBranch(BranchAdapter.toEntity(value, em));
	}

	@Override
	public CountryModel getCountry() {
		return new CountryAdapter(session, em, financialAccount.getCountry());
	}

	@Override
	public void setCountry(CountryModel value) {
		this.financialAccount.setCountry(CountryAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return this.financialAccount.getId();
	}

	@Override
	public void setId(String value) {
		this.financialAccount.setId(value);
	}

	public static FinancialAccountEntity toEntity(FinancialAccountModel model, EntityManager em) {
		if (model instanceof FinancialAccountModel) {
			return ((FinancialAccountAdapter) model).getEntity();
		}
		return em.getReference(FinancialAccountEntity.class, model.getId());
	}

	@Override
	public FinancialAccountEntity getEntity() {
		return financialAccount;
	}

}
