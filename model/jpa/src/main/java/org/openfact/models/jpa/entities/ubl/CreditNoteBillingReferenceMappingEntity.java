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
@Table(name = "CREDIT_NOTE_BILLING_REFERENCE_MAPPING")
@IdClass(CreditNoteBillingReferenceMappingEntity.Key.class)
public class CreditNoteBillingReferenceMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BILLING_REFERENCE_ID")
	protected BillingReferenceEntity billingReference;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	protected CreditNoteEntity creditNote;

	/**
	 * @return the billingReference
	 */
	public BillingReferenceEntity getBillingReference() {
		return billingReference;
	}

	/**
	 * @param billingReference
	 *            the billingReference to set
	 */
	public void setBillingReference(BillingReferenceEntity billingReference) {
		this.billingReference = billingReference;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote
	 *            the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}

	public static class Key implements Serializable {

		protected BillingReferenceEntity billingReference;

		protected CreditNoteEntity creditNote;

		public Key() {

		}

		public Key(BillingReferenceEntity billingReference, CreditNoteEntity creditNote) {
			super();
			this.billingReference = billingReference;
			this.creditNote = creditNote;
		}

		/**
		 * @return the billingReference
		 */
		public BillingReferenceEntity getBillingReference() {
			return billingReference;
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

			if (billingReference != null
					? !billingReference.getId()
							.equals(key.billingReference != null ? key.billingReference.getId() : null)
					: key.billingReference != null)
				return false;
			if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
					: key.creditNote != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = billingReference != null ? billingReference.getId().hashCode() : 0;
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
		if (!(o instanceof CreditNoteBillingReferenceMappingEntity))
			return false;

		CreditNoteBillingReferenceMappingEntity key = (CreditNoteBillingReferenceMappingEntity) o;

		if (billingReference != null
				? !billingReference.getId().equals(key.billingReference != null ? key.billingReference.getId() : null)
				: key.billingReference != null)
			return false;
		if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
				: key.creditNote != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = billingReference != null ? billingReference.getId().hashCode() : 0;
		result = 31 * result + (creditNote != null ? creditNote.getId().hashCode() : 0);
		return result;
	}
}
