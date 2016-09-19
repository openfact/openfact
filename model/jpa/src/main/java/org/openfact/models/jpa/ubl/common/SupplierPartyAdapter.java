package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SupplierPartyModel;

public class SupplierPartyAdapter implements SupplierPartyModel, JpaModel<SupplierPartyEntity> {

	protected static final Logger logger = Logger.getLogger(SupplierPartyAdapter.class);
	protected SupplierPartyEntity supplierParty;
	protected EntityManager em;
	protected OpenfactSession session;

	public SupplierPartyAdapter(OpenfactSession session, EntityManager em, SupplierPartyEntity supplierParty) {
		this.session = session;
		this.em = em;
		this.supplierParty = supplierParty;
	}

	@Override
	public String getCustomerAssignedAccountID() {
		return this.supplierParty.getCustomerAssignedAccountID();
	}

	@Override
	public void setCustomerAssignedAccountID(String value) {
		this.supplierParty.setCustomerAssignedAccountID(value);
	}

	@Override
	public List<String> getAdditionalAccountID() {
		return this.supplierParty.getAdditionalAccountID();
	}

	@Override
	public void setAdditionalAccountID(List<String> additionalAccountID) {
		this.supplierParty.setAdditionalAccountID(additionalAccountID);
	}

	@Override
	public String getDataSendingCapability() {
		return this.supplierParty.getDataSendingCapability();
	}

	@Override
	public void setDataSendingCapability(String value) {
		this.supplierParty.setDataSendingCapability(value);
	}

	@Override
	public PartyModel getParty() {
		return new PartyAdapter(session, em, supplierParty.getParty());
	}

	@Override
	public void setParty(PartyModel value) {
		this.supplierParty.setParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public ContactModel getDespatchContact() {
		return new ContactAdapter(session, em, supplierParty.getDespatchContact());

	}

	@Override
	public void setDespatchContact(ContactModel value) {
		this.supplierParty.setDespatchContact(ContactAdapter.toEntity(value, em));
	}

	@Override
	public ContactModel getAccountingContact() {
		return new ContactAdapter(session, em, supplierParty.getAccountingContact());

	}

	@Override
	public void setAccountingContact(ContactModel value) {
		this.supplierParty.setAccountingContact(ContactAdapter.toEntity(value, em));
	}

	@Override
	public ContactModel getSellerContact() {
		return new ContactAdapter(session, em, supplierParty.getSellerContact());
	}

	@Override
	public void setSellerContact(ContactModel value) {
		this.supplierParty.setSellerContact(ContactAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return this.supplierParty.getId();
	}

	@Override
	public void setId(String value) {
		this.supplierParty.setId(value);
	}

	@Override
	public SupplierPartyEntity getEntity() {		
		return supplierParty;
	}

}
