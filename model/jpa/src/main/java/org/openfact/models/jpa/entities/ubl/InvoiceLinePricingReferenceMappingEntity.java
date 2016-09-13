package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "INVOICE_LINE_PRICING_REFERENCE_MAPPING")
@Entity
@IdClass(InvoiceLinePricingReferenceMappingEntity.Key.class)
public class InvoiceLinePricingReferenceMappingEntity {
	  @Id
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "INVOICE_LINE_ID")
	    protected InvoiceLineEntity invoiceLine;

	    @Id
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "pricingReference_ID")
	    protected PricingReferenceEntity pricingReference;

	   

	    /**
		 * @return the invoiceLine
		 */
		public InvoiceLineEntity getInvoiceLineLine() {
			return invoiceLine;
		}

		/**
		 * @param invoiceLine the invoiceLine to set
		 */
		public void setInvoiceLineLine(InvoiceLineEntity invoiceLine) {
			this.invoiceLine = invoiceLine;
		}

		/**
		 * @return the pricingReference
		 */
		public PricingReferenceEntity getPricingReference() {
			return pricingReference;
		}

		/**
		 * @param pricingReference the pricingReference to set
		 */
		public void setPricingReference(PricingReferenceEntity pricingReference) {
			this.pricingReference = pricingReference;
		}

		public static class Key implements Serializable {
	    	
	    	protected InvoiceLineEntity invoiceLine;


	        protected PricingReferenceEntity pricingReference;

	        public Key() {

	        }
	     

	        public Key(InvoiceLineEntity invoiceLine, PricingReferenceEntity pricingReference) {
				super();
				this.invoiceLine = invoiceLine;
				this.pricingReference = pricingReference;
			}

	        			/**
			 * @return the invoiceLine
			 */
			public InvoiceLineEntity getInvoiceLineLine() {
				return invoiceLine;
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

	            if (invoiceLine != null ? !invoiceLine.getId().equals(key.invoiceLine != null ? key.invoiceLine.getId() : null)
	                    : key.invoiceLine != null)
	                return false;
	            if (pricingReference != null
	                    ? !pricingReference.getId().equals(key.pricingReference != null ? key.pricingReference.getId() : null)
	                    : key.pricingReference != null)
	                return false;

	            return true;
	        }

	        @Override
	        public int hashCode() {
	            int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
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
	        if (!(o instanceof InvoiceLinePricingReferenceMappingEntity))
	            return false;

	        InvoiceLinePricingReferenceMappingEntity key = (InvoiceLinePricingReferenceMappingEntity) o;

	        if (invoiceLine != null ? !invoiceLine.getId().equals(key.invoiceLine != null ? key.invoiceLine.getId() : null)
	                : key.invoiceLine != null)
	            return false;
	        if (pricingReference != null ? !pricingReference.getId().equals(key.pricingReference != null ? key.pricingReference.getId() : null)
	                : key.pricingReference != null)
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = invoiceLine != null ? invoiceLine.getId().hashCode() : 0;
	        result = 31 * result + (pricingReference != null ? pricingReference.getId().hashCode() : 0);
	        return result;
	    }
}
