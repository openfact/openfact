package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyLegalEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.CorporateRegistrationSchemeModel;
import org.openfact.models.ubl.common.PartyLegalModel;

public class PartyLegalAdapter implements PartyLegalModel, JpaModel<PartyLegalEntity> {

	protected static final Logger logger = Logger.getLogger(PartyLegalAdapter.class);
	protected PartyLegalEntity partyLegalEntity;
	protected EntityManager em;
	protected OpenfactSession session;

	public PartyLegalAdapter(OpenfactSession session, EntityManager em, PartyLegalEntity partyLegalEntity) {
		this.session = session;
		this.em = em;
		this.partyLegalEntity = partyLegalEntity;
	}

	@Override
	public String getRegistrationName() {
		return this.partyLegalEntity.getRegistrationName();
	}

	@Override
	public void setRegistrationName(String value) {
		this.partyLegalEntity.setRegistrationName(value);
	}

	@Override
	public String getCompanyID() {
		return this.partyLegalEntity.getCompanyID();
	}

	@Override
	public void setCompanyID(String value) {
		this.partyLegalEntity.setCompanyID(value);
	}

	@Override
	public AddressModel getRegistrationAddress() {
		return new AddressAdapter(session, em, partyLegalEntity.getRegistrationAddress());
	}

	@Override
	public void setRegistrationAddress(AddressModel value) {
		this.partyLegalEntity.setRegistrationAddress(AddressAdapter.toEntity(value, em));
	}

	@Override
	public CorporateRegistrationSchemeModel getCorporateRegistrationScheme() {
		return new CorporateRegistrationSchemeAdapter(session, em, partyLegalEntity.getCorporateRegistrationScheme());
	}

	@Override
	public void setCorporateRegistrationScheme(CorporateRegistrationSchemeModel value) {
		this.partyLegalEntity.setCorporateRegistrationScheme(CorporateRegistrationSchemeAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return this.partyLegalEntity.getId();
	}

	@Override
	public void setId(String value) {
		this.partyLegalEntity.setId(value);
	}

	@Override
	public PartyLegalEntity getEntity() {
		// TODO Auto-generated method stub
		return partyLegalEntity;
	}

	public static PartyLegalEntity toEntity(PartyLegalModel model, EntityManager em) {
		if (model instanceof PartyLegalModel) {
			return ((PartyLegalAdapter) model).getEntity();
		}
		return em.getReference(PartyLegalEntity.class, model.getId());
	}

}
