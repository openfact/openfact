package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SIGNATURE_PARTY_MAPPING")
@IdClass(SignaturePartyMappingEntity.Key.class)
public class SignaturePartyMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SIGNATURE_ID")
	protected SignatureEntity signature;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_ID")
	protected PartyEntity party;

	
	/**
	 * @return the signature
	 */
	public SignatureEntity getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(SignatureEntity signature) {
		this.signature = signature;
	}

	/**
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

	public static class Key implements Serializable {

		protected SignatureEntity signature;

		protected PartyEntity party;

		public Key() {

		}

		public Key(SignatureEntity signature, PartyEntity party) {
			super();
			this.signature = signature;
			this.party = party;
		}

	

		/**
		 * @return the signature
		 */
		public SignatureEntity getSignature() {
			return signature;
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

			if (signature != null
					? !signature.getId()
							.equals(key.signature != null ? key.signature.getId() : null)
					: key.signature != null)
				return false;
			if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null)
					: key.party != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = signature != null ? signature.getId().hashCode() : 0;
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
		if (!(o instanceof SignaturePartyMappingEntity))
			return false;

		SignaturePartyMappingEntity key = (SignaturePartyMappingEntity) o;

		if (signature != null
				? !signature.getId()
						.equals(key.signature != null ? key.signature.getId() : null)
				: key.signature != null)
			return false;
		if (party != null ? !party.getId().equals(key.party != null ? key.party.getId() : null)
				: key.party != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = signature != null ? signature.getId().hashCode() : 0;
		result = 31 * result + (party != null ? party.getId().hashCode() : 0);
		return result;
	}
}
