package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "SUPPLIER_PARTY_PARTY_MAPPING")
@Entity
@IdClass(SupplierPartyPartyMappingEntity.Key.class)
public class SupplierPartyPartyMappingEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_PARTY_ID")
	protected SupplierPartyEntity supplierParty;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_ID")
	protected PartyEntity party;

	/**
	 * @return the supplierParty
	 */
	public SupplierPartyEntity getSupplierParty() {
		return supplierParty;
	}

	/**
	 * @param supplierParty
	 *            the supplierParty to set
	 */
	public void setSupplierParty(SupplierPartyEntity supplierParty) {
		this.supplierParty = supplierParty;
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

		protected SupplierPartyEntity supplierParty;

		protected PartyEntity party;

		public Key() {

		}

		public Key(SupplierPartyEntity supplierParty, PartyEntity party) {
			super();
			this.supplierParty = supplierParty;
			this.party = party;
		}

		/**
		 * @return the supplierParty
		 */
		public SupplierPartyEntity getSupplierParty() {
			return supplierParty;
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

			if (supplierParty != null
					? !supplierParty.getId().equals(key.supplierParty != null ? key.supplierParty.getId() : null)
					: key.supplierParty != null)
				return false;
			if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null) : key.party != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = supplierParty != null ? supplierParty.getId().hashCode() : 0;
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
		if (!(o instanceof SupplierPartyPartyMappingEntity))
			return false;

		SupplierPartyPartyMappingEntity key = (SupplierPartyPartyMappingEntity) o;

		if (supplierParty != null
				? !supplierParty.getId().equals(key.supplierParty != null ? key.supplierParty.getId() : null)
				: key.supplierParty != null)
			return false;
		if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null) : key.party != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = supplierParty != null ? supplierParty.getId().hashCode() : 0;
		result = 31 * result + (party != null ? party.getId().hashCode() : 0);
		return result;
	}
}
