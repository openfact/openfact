package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "CREDIT_NOTE_LINE_ITEM_MAPPING")
@Entity
@IdClass(CreditNoteLineItemMappingEntity.Key.class)
public class CreditNoteLineItemMappingEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_NOTE_LINE_ID")
    protected CreditNoteLineEntity creditNoteLine;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    protected ItemEntity item;

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
	 * @return the item
	 */
	public ItemEntity getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(ItemEntity item) {
		this.item = item;
	}
    
	  public static class Key implements Serializable {

	        protected CreditNoteLineEntity creditNoteLine;

	        protected ItemEntity item;

	        public Key() {

	        }

	        public Key(CreditNoteLineEntity creditNoteLine, ItemEntity item) {
				super();
				this.creditNoteLine = creditNoteLine;
				this.item = item;
			}

			/**
			 * @return the creditNoteLine
			 */
			public CreditNoteLineEntity getCreditNoteLine() {
				return creditNoteLine;
			}

			/**
			 * @return the item
			 */
			public ItemEntity getItem() {
				return item;
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
	            if (item != null
	                    ? !item.getId().equals(key.item != null ? key.item.getId() : null)
	                    : key.item != null)
	                return false;

	            return true;
	        }

	        @Override
	        public int hashCode() {
	            int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
	            result = 31 * result + (item != null ? item.getId().hashCode() : 0);
	            return result;
	        }

	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null)
	            return false;
	        if (!(o instanceof CreditNoteLineItemMappingEntity))
	            return false;

	        CreditNoteLineItemMappingEntity key = (CreditNoteLineItemMappingEntity) o;

	        if (creditNoteLine != null ? !creditNoteLine.getId().equals(key.creditNoteLine != null ? key.creditNoteLine.getId() : null)
	                : key.creditNoteLine != null)
	            return false;
	        if (item != null ? !item.getId().equals(key.item != null ? key.item.getId() : null)
	                : key.item != null)
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = creditNoteLine != null ? creditNoteLine.getId().hashCode() : 0;
	        result = 31 * result + (item != null ? item.getId().hashCode() : 0);
	        return result;
	    }

}
