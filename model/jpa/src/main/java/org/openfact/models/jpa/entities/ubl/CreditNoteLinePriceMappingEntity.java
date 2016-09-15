package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "CREDIT_NOTE_LINE_PRICE_MAPPING")
@Entity
@IdClass(CreditNoteLinePriceMappingEntity.Key.class)
public class CreditNoteLinePriceMappingEntity {

	  @Id
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "CREDIT_NOTE_LINE_ID")
	    protected CreditNoteLineEntity creditNoteLine;

	    @Id
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "PRICE_ID")
	    protected PriceEntity price;

	   

	    /**
		 * @return the creditNoteLine
		 */
		public CreditNoteLineEntity getCreditNoteLine() {
			return creditNoteLine;
		}

		/**
		 * @param creditNoteLine the creditNoteLine to set
		 */
		public void setCreditNoteLine(CreditNoteLineEntity creditNoteLine) {
			this.creditNoteLine = creditNoteLine;
		}

		/**
		 * @return the price
		 */
		public PriceEntity getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(PriceEntity price) {
			this.price = price;
		}

		public static class Key implements Serializable {

	        protected CreditNoteLineEntity creditNoteLine;

	        protected PriceEntity price;

	        public Key() {

	        }
	        public Key(CreditNoteLineEntity creditNoteLine, PriceEntity price) {
				super();
				this.creditNoteLine = creditNoteLine;
				this.price = price;
			}

			/**
			 * @return the creditNoteLine
			 */
			public CreditNoteLineEntity getCreditNoteLine() {
				return creditNoteLine;
			}
			/**
			 * @return the price
			 */
			public PriceEntity getPrice() {
				return price;
			}
			@Override
	        public boolean equals(Object o) {
	            if (this == o)
	                return true;
	            if (o == null || getClass() != o.getClass())
	                return false;

	            Key key = (Key) o;

	            if (creditNoteLine != null ? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
	                    : key.creditNoteLine != null)
	                return false;
	            if (price != null
	                    ? !price.getId().equals(key.price != null ? key.price.getId() : null)
	                    : key.price != null)
	                return false;

	            return true;
	        }

	        @Override
	        public int hashCode() {
	            int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
	            result = 31 * result + (price != null ? price.getId().hashCode() : 0);
	            return result;
	        }

	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null)
	            return false;
	        if (!(o instanceof CreditNoteLinePriceMappingEntity))
	            return false;

	        CreditNoteLinePriceMappingEntity key = (CreditNoteLinePriceMappingEntity) o;

	        if (creditNoteLine != null ? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
	                : key.creditNoteLine != null)
	            return false;
	        if (price != null ? !price.getId().equals(key.price != null ? key.price.getId() : null)
	                : key.price != null)
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
	        result = 31 * result + (price != null ? price.getId().hashCode() : 0);
	        return result;
	    }
}
