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
@Table(name = "CREDIT_NOTE_SIGNATURE_MAPPING")
@IdClass(CreditNoteSignatureMappingEntity.Key.class)
public class CreditNoteSignatureMappingEntity {	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	protected CreditNoteEntity creditNote;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SIGNATURE_ID")
	protected SignatureEntity signature;
	
	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}

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

	public static class Key implements Serializable {

		protected SignatureEntity signature;

		protected CreditNoteEntity creditNote;

		public Key() {

		}

		public Key(SignatureEntity signature, CreditNoteEntity creditNote) {
			super();
			this.signature = signature;
			this.creditNote = creditNote;
		}
		
		/**
		 * @return the signature
		 */
		public SignatureEntity getSignature() {
			return signature;
		}

		/**
		 * @return the creditNote
		 */
		public CreditNoteEntity getCreditNote() {
			return creditNote;
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
			if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
					: key.creditNote != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = signature != null ? signature.getId().hashCode() : 0;
			result = 31 * result + (creditNote != null ? creditNote.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CreditNoteSignatureMappingEntity))
			return false;

		CreditNoteSignatureMappingEntity key = (CreditNoteSignatureMappingEntity) o;

		if (signature != null
				? !signature.getId()
						.equals(key.signature != null ? key.signature.getId() : null)
				: key.signature != null)
			return false;
		if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
				: key.creditNote != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = signature != null ? signature.getId().hashCode() : 0;
		result = 31 * result + (creditNote != null ? creditNote.getId().hashCode() : 0);
		return result;
	}
}
