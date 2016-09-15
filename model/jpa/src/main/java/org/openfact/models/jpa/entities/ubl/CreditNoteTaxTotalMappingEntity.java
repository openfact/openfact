package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "CREDIT_NOTE_TAX_TOTAL_MAPPING")
@Entity
@IdClass(CreditNoteTaxTotalMappingEntity.Key.class)
public class CreditNoteTaxTotalMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	protected CreditNoteEntity creditNote;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAX_TOTAL_ID")
	protected TaxTotalEntity taxTotal;

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
	 * @return the taxTotal
	 */
	public TaxTotalEntity getTaxTotal() {
		return taxTotal;
	}

	/**
	 * @param taxTotal the taxTotal to set
	 */
	public void setTaxTotal(TaxTotalEntity taxTotal) {
		this.taxTotal = taxTotal;
	}


	public static class Key implements Serializable {

		protected CreditNoteEntity creditNote;

		protected TaxTotalEntity taxTotal;

		public Key() {

		}

		public Key(CreditNoteEntity creditNote, TaxTotalEntity taxTotal) {
			super();
			this.creditNote = creditNote;
			this.taxTotal = taxTotal;
		}

		/**
		 * @return the creditNote
		 */
		public CreditNoteEntity getCreditNote() {
			return creditNote;
		}

		/**
		 * @return the taxTotal
		 */
		public TaxTotalEntity getTaxTotal() {
			return taxTotal;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (creditNote != null
					? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
					: key.creditNote != null)
				return false;
			if (taxTotal != null
					? !taxTotal.getId()
							.equals(key.taxTotal != null ? key.taxTotal.getId() : null)
					: key.taxTotal != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = creditNote != null ? creditNote.getId().hashCode() : 0;
			result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CreditNoteTaxTotalMappingEntity))
			return false;

		CreditNoteTaxTotalMappingEntity key = (CreditNoteTaxTotalMappingEntity) o;

		if (creditNote != null
				? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
				: key.creditNote != null)
			return false;
		if (taxTotal != null
				? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null)
				: key.taxTotal != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = creditNote != null ? creditNote.getId().hashCode() : 0;
		result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
		return result;
	}

}
