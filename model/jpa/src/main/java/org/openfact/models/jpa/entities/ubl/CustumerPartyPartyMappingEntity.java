package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "INVOICE_TAXTOTAL_MAPPING")
@Entity
@IdClass(CustumerPartyPartyMappingEntity.Key.class)
public class CustumerPartyPartyMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_PARTY_ID")
	protected CustomerPartyEntity custumerParty;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_ID")
	protected PartyEntity party;

	/**
	 * @return the custumerParty
	 */
	public CustomerPartyEntity getCustumerParty() {
		return custumerParty;
	}

	/**
	 * @param custumerParty
	 *            the custumerParty to set
	 */
	public void setCustumerParty(CustomerPartyEntity custumerParty) {
		this.custumerParty = custumerParty;
	}

	/**
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party
	 *            the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

	public static class Key implements Serializable {

		protected CustomerPartyEntity custumerParty;

		protected PartyEntity party;

		public Key() {

		}

		public Key(CustomerPartyEntity custumerParty, PartyEntity party) {
			super();
			this.custumerParty = custumerParty;
			this.party = party;
		}

		/**
		 * @return the custumerParty
		 */
		public CustomerPartyEntity getCustumerParty() {
			return custumerParty;
		}

		/**
		 * @return the party
		 */
		public PartyEntity getParty() {
			return party;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (custumerParty != null
					? !custumerParty.getId().equals(key.custumerParty != null ? key.custumerParty.getId() : null)
					: key.custumerParty != null)
				return false;
			if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null) : key.party != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = custumerParty != null ? custumerParty.getId().hashCode() : 0;
			result = 31 * result + (party != null ? party.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CustumerPartyPartyMappingEntity))
			return false;

		CustumerPartyPartyMappingEntity key = (CustumerPartyPartyMappingEntity) o;

		if (custumerParty != null
				? !custumerParty.getId().equals(key.custumerParty != null ? key.custumerParty.getId() : null)
				: key.custumerParty != null)
			return false;
		if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null) : key.party != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = custumerParty != null ? custumerParty.getId().hashCode() : 0;
		result = 31 * result + (party != null ? party.getId().hashCode() : 0);
		return result;
	}
}
