package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "PRICING_REFERENCE_PRICE_MAPPING")
@Entity
@IdClass(PricingReferencePriceMappingEntity.Key.class)
public class PricingReferencePriceMappingEntity {

	@Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRICING_REFERENCE_ID")
    protected PricingReferenceEntity pricingReference;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRICE_ID")
    protected PriceEntity price;
    
    
    public PricingReferenceEntity getPricingReference() {
		return pricingReference;
	}

	public void setPricingReference(PricingReferenceEntity pricingReference) {
		this.pricingReference = pricingReference;
	}

	public PriceEntity getPrice() {
		return price;
	}

	public void setPrice(PriceEntity price) {
		this.price = price;
	}

	public static class Key implements Serializable {

        protected PricingReferenceEntity pricingReference;

        protected PriceEntity price;        

        public Key() {

        }  		
		
		public Key(PricingReferenceEntity pricingReference, PriceEntity price) {
			super();
			this.pricingReference = pricingReference;
			this.price = price;
		}

		public PricingReferenceEntity getInvoiceLine() {
			return pricingReference;
		}

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

            if (pricingReference != null ? !pricingReference.getId().equals(key.pricingReference != null ? key.pricingReference.getId() : null)
                    : key.pricingReference != null)
                return false;
            if (price != null
                    ? !price.getId().equals(key.price != null ? key.price.getId() : null)
                    : key.price != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = pricingReference != null ? pricingReference.getId().hashCode() : 0;
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
        if (!(o instanceof PricingReferencePriceMappingEntity))
            return false;

        PricingReferencePriceMappingEntity key = (PricingReferencePriceMappingEntity) o;

        if (pricingReference != null ? !pricingReference.getId().equals(key.pricingReference != null ? key.pricingReference.getId() : null)
                : key.pricingReference != null)
            return false;
        if (price != null ? !price.getId().equals(key.price != null ? key.price.getId() : null)
                : key.price != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pricingReference != null ? pricingReference.getId().hashCode() : 0;
        result = 31 * result + (price != null ? price.getId().hashCode() : 0);
        return result;
    }
}
