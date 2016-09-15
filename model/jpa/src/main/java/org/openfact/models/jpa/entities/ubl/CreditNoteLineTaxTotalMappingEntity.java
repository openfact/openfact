package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "CREDIT_NOTE_LINE_TAX_TOTAL_MAPPING")
@Entity
@IdClass(CreditNoteLineTaxTotalMappingEntity.Key.class)
public class CreditNoteLineTaxTotalMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_LINE_ID")
	protected CreditNoteLineEntity creditNoteLine;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAX_TOTAL_ID")
	protected TaxTotalEntity taxTotal;

	/**
	 * @return the creditNoteLine
	 */
	public CreditNoteLineEntity getCreditNoteLine() {
		return creditNoteLine;
	}

	/**
	 * @param creditNoteLine
	 *            the creditNoteLine to set
	 */
	public void setCreditNoteLine(CreditNoteLineEntity creditNoteLine) {
		this.creditNoteLine = creditNoteLine;
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

		protected CreditNoteLineEntity creditNoteLine;

		protected TaxTotalEntity taxTotal;

		public Key() {

		}

		public Key(CreditNoteLineEntity creditNoteLine, TaxTotalEntity taxTotal) {
			super();
			this.creditNoteLine = creditNoteLine;
			this.taxTotal = taxTotal;
		}

		/**
		 * @return the creditNoteLine
		 */
		public CreditNoteLineEntity getCreditNoteLine() {
			return creditNoteLine;
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

			if (creditNoteLine != null
					? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
					: key.creditNoteLine != null)
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
			int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
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
		if (!(o instanceof CreditNoteLineTaxTotalMappingEntity))
			return false;

		CreditNoteLineTaxTotalMappingEntity key = (CreditNoteLineTaxTotalMappingEntity) o;

		if (creditNoteLine != null
				? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
				: key.creditNoteLine != null)
			return false;
		if (taxTotal != null
				? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null)
				: key.taxTotal != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
		result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
		return result;
	}

}
