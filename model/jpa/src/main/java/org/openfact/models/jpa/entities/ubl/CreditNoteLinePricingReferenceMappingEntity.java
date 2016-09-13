package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "CREDIT_NOTE_LINE_PRICING_REFERENCE_MAPPING")
@Entity
@IdClass(CreditNoteLinePricingReferenceMappingEntity.Key.class)
public class CreditNoteLinePricingReferenceMappingEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_LINE_ID")
	protected CreditNoteLineEntity creditNoteLine;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICING_REFERENCE_ID")
	protected PricingReferenceEntity pricingReference;

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
	 * @return the pricingReference
	 */
	public PricingReferenceEntity getPricingReference() {
		return pricingReference;
	}

	/**
	 * @param pricingReference
	 *            the pricingReference to set
	 */
	public void setPricingReference(PricingReferenceEntity pricingReference) {
		this.pricingReference = pricingReference;
	}

	public static class Key implements Serializable {

		protected CreditNoteLineEntity creditNoteLine;

		protected PricingReferenceEntity pricingReference;

		public Key() {

		}

		public Key(CreditNoteLineEntity creditNoteLine, PricingReferenceEntity pricingReference) {
			super();
			this.creditNoteLine = creditNoteLine;
			this.pricingReference = pricingReference;
		}

		/**
		 * @return the creditNoteLine
		 */
		public CreditNoteLineEntity getCreditNoteLine() {
			return creditNoteLine;
		}

		/**
		 * @return the pricingReference
		 */
		public PricingReferenceEntity getPricingReference() {
			return pricingReference;
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
			if (pricingReference != null
					? !pricingReference.getId()
							.equals(key.pricingReference != null ? key.pricingReference.getId() : null)
					: key.pricingReference != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
			result = 31 * result + (pricingReference != null ? pricingReference.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CreditNoteLinePricingReferenceMappingEntity))
			return false;

		CreditNoteLinePricingReferenceMappingEntity key = (CreditNoteLinePricingReferenceMappingEntity) o;

		if (creditNoteLine != null
				? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
				: key.creditNoteLine != null)
			return false;
		if (pricingReference != null
				? !pricingReference.getId().equals(key.pricingReference != null ? key.pricingReference.getId() : null)
				: key.pricingReference != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
		result = 31 * result + (pricingReference != null ? pricingReference.getId().hashCode() : 0);
		return result;
	}

}
