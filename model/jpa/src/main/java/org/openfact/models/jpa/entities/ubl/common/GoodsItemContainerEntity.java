package org.openfact.models.jpa.entities.ubl.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GOODS_ITEM_CONTAINER")
public class GoodsItemContainerEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "QUANTITY_GOODSITEMCONTAINER")
	protected QuantityEntity quantity;

	@OneToMany(targetEntity = TransportEquipmentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTEQUIPMENT_GOODSITEMCONTAINER")
	protected List<TransportEquipmentEntity> transportEquipment = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public QuantityEntity getQuantity() {
		return quantity;
	}

	public void setQuantity(QuantityEntity quantity) {
		this.quantity = quantity;
	}

	public List<TransportEquipmentEntity> getTransportEquipment() {
		return transportEquipment;
	}

	public void setTransportEquipment(List<TransportEquipmentEntity> transportEquipment) {
		this.transportEquipment = transportEquipment;
	}
	
}
