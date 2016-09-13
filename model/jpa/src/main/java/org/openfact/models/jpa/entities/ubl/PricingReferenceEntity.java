package org.openfact.models.jpa.entities.ubl;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * A reference to the basis for pricing. This may be based on a catalogue or a
 * quoted amount from a price list and include some alternative pricing
 * conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:57 a. m.
 */
@Entity
@Table(name = "PRICING_REFERENCE")
public class PricingReferenceEntity {

	@Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;
	@Transient
    private ItemLocationQuantityEntity originalItemLocationQuantity;
	
	@OneToMany(mappedBy = "pricingReference", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private PricingReferencePriceMappingEntity alternativeConditionPrice;
    
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ItemLocationQuantityEntity getOriginalItemLocationQuantity() {
		return originalItemLocationQuantity;
	}

	public void setOriginalItemLocationQuantity(ItemLocationQuantityEntity originalItemLocationQuantity) {
		this.originalItemLocationQuantity = originalItemLocationQuantity;
	}	

	public PricingReferencePriceMappingEntity getAlternativeConditionPrice() {
		return alternativeConditionPrice;
	}

	public void setAlternativeConditionPrice(PricingReferencePriceMappingEntity alternativeConditionPrice) {
		this.alternativeConditionPrice = alternativeConditionPrice;
	}

	public InvoiceLineEntity getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(InvoiceLineEntity invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

    
}
