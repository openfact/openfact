package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "CREDIT_NOTE_MONETARY_TOTAL_MAPPING")
@Entity
@IdClass(CreditNoteMonetaryTotalMappingEntity.Key.class)
public class CreditNoteMonetaryTotalMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	protected CreditNoteEntity creditNote;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MONETARY_TOTAL_ID")
	protected MonetaryTotalEntity monetaryTotal;

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

	/**
	 * @return the monetaryTotal
	 */
	public MonetaryTotalEntity getMonetaryTotal() {
		return monetaryTotal;
	}

	/**
	 * @param monetaryTotal
	 *            the monetaryTotal to set
	 */
	public void setMonetaryTotal(MonetaryTotalEntity monetaryTotal) {
		this.monetaryTotal = monetaryTotal;
	}

	public static class Key implements Serializable {

		protected CreditNoteEntity creditNote;

		protected MonetaryTotalEntity monetaryTotal;

		public Key() {

		}

		public Key(CreditNoteEntity creditNote, MonetaryTotalEntity monetaryTotal) {
			super();
			this.creditNote = creditNote;
			this.monetaryTotal = monetaryTotal;
		}

		/**
		 * @return the creditNote
		 */
		public CreditNoteEntity getCreditNote() {
			return creditNote;
		}

		/**
		 * @return the monetaryTotal
		 */
		public MonetaryTotalEntity getMonetaryTotal() {
			return monetaryTotal;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
					: key.creditNote != null)
				return false;
			if (monetaryTotal != null
					? !monetaryTotal.getId().equals(key.monetaryTotal != null ? key.monetaryTotal.getId() : null)
					: key.monetaryTotal != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = creditNote != null ? creditNote.getId().hashCode() : 0;
			result = 31 * result + (monetaryTotal != null ? monetaryTotal.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CreditNoteMonetaryTotalMappingEntity))
			return false;

		CreditNoteMonetaryTotalMappingEntity key = (CreditNoteMonetaryTotalMappingEntity) o;

		if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
				: key.creditNote != null)
			return false;
		if (monetaryTotal != null
				? !monetaryTotal.getId().equals(key.monetaryTotal != null ? key.monetaryTotal.getId() : null)
				: key.monetaryTotal != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = creditNote != null ? creditNote.getId().hashCode() : 0;
		result = 31 * result + (monetaryTotal != null ? monetaryTotal.getId().hashCode() : 0);
		return result;
	}

}
