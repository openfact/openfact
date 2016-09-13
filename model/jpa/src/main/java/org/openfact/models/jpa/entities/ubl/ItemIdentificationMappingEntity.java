package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "ITEM_IDENTIFICATION_MAPPING")
@Entity
@IdClass(ItemIdentificationMappingEntity.Key.class)
public class ItemIdentificationMappingEntity {
	@Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    protected ItemEntity item;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_IDENTIFICATION_ID")
    protected ItemIdentificationEntity itemIdentification;

   
    public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public ItemIdentificationEntity getItemIdentification() {
		return itemIdentification;
	}

	public void setItemIdentification(ItemIdentificationEntity itemIdentification) {
		this.itemIdentification = itemIdentification;
	}

	public static class Key implements Serializable {

        protected ItemEntity item;

        protected ItemIdentificationEntity itemIdentification;        

        public Key() {

        }  

        public Key(ItemEntity item, ItemIdentificationEntity itemIdentification) {
			super();
			this.item = item;
			this.itemIdentification = itemIdentification;
		}



		public ItemEntity getItem() {
			return item;
		}

		public ItemIdentificationEntity getItemIdentification() {
			return itemIdentification;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Key key = (Key) o;

            if (item != null ? !item.getId().equals(key.item != null ? key.item.getId() : null)
                    : key.item != null)
                return false;
            if (itemIdentification != null
                    ? !itemIdentification.getId().equals(key.itemIdentification != null ? key.itemIdentification.getId() : null)
                    : key.itemIdentification != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = item != null ? item.getId().hashCode() : 0;
            result = 31 * result + (itemIdentification != null ? itemIdentification.getId().hashCode() : 0);
            return result;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof ItemIdentificationMappingEntity))
            return false;

        ItemIdentificationMappingEntity key = (ItemIdentificationMappingEntity) o;

        if (item != null ? !item.getId().equals(key.item != null ? key.item.getId() : null)
                : key.item != null)
            return false;
        if (itemIdentification != null ? !itemIdentification.getId().equals(key.itemIdentification != null ? key.itemIdentification.getId() : null)
                : key.itemIdentification != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.getId().hashCode() : 0;
        result = 31 * result + (itemIdentification != null ? itemIdentification.getId().hashCode() : 0);
        return result;
    }

}
