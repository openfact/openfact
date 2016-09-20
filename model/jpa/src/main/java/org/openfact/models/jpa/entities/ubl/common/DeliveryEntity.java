//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "DeliveryType")
@Table(name = "DELIVERYTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class DeliveryEntity {

    protected IDType ID;
    protected QuantityTypeCommBas quantity;
    protected MinimumQuantityType minimumQuantity;
    protected MaximumQuantityType maximumQuantity;
    protected ActualDeliveryDateType actualDeliveryDate;
    protected ActualDeliveryTimeType actualDeliveryTime;
    protected LatestDeliveryDateType latestDeliveryDate;
    protected LatestDeliveryTimeType latestDeliveryTime;
    protected TrackingIDType trackingID;
    protected AddressEntity deliveryAddress;
    protected LocationCommAggEntity deliveryLocation;
    protected PeriodEntity requestedDeliveryPeriod;
    protected PeriodEntity promisedDeliveryPeriod;
    protected PeriodEntity estimatedDeliveryPeriod;
    protected PartyEntity deliveryParty;
    protected DespatchType despatch;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_DELIVERYTYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = QuantityTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "QUANTITY_DELIVERYTYPE_OFID")
    public QuantityTypeCommBas getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantityTypeCommBas value) {
        this.quantity = value;
    }

    @ManyToOne(targetEntity = MinimumQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMQUANTITY_DELIVERYTYPE_0")
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    @ManyToOne(targetEntity = MaximumQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMQUANTITY_DELIVERYTYPE_0")
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    @ManyToOne(targetEntity = ActualDeliveryDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACTUALDELIVERYDATE_DELIVERYT_0")
    public ActualDeliveryDateType getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(ActualDeliveryDateType value) {
        this.actualDeliveryDate = value;
    }

    @ManyToOne(targetEntity = ActualDeliveryTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACTUALDELIVERYTIME_DELIVERYT_0")
    public ActualDeliveryTimeType getActualDeliveryTime() {
        return actualDeliveryTime;
    }

    public void setActualDeliveryTime(ActualDeliveryTimeType value) {
        this.actualDeliveryTime = value;
    }

    @ManyToOne(targetEntity = LatestDeliveryDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LATESTDELIVERYDATE_DELIVERYT_0")
    public LatestDeliveryDateType getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public void setLatestDeliveryDate(LatestDeliveryDateType value) {
        this.latestDeliveryDate = value;
    }

    @ManyToOne(targetEntity = LatestDeliveryTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LATESTDELIVERYTIME_DELIVERYT_0")
    public LatestDeliveryTimeType getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    public void setLatestDeliveryTime(LatestDeliveryTimeType value) {
        this.latestDeliveryTime = value;
    }

    @ManyToOne(targetEntity = TrackingIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRACKINGID_DELIVERYTYPE_OFID")
    public TrackingIDType getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(TrackingIDType value) {
        this.trackingID = value;
    }

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYADDRESS_DELIVERYTYPE_0")
    public AddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressEntity value) {
        this.deliveryAddress = value;
    }

    @ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYLOCATION_DELIVERYTYP_0")
    public LocationCommAggEntity getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(LocationCommAggEntity value) {
        this.deliveryLocation = value;
    }

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUESTEDDELIVERYPERIOD_DELI_0")
    public PeriodEntity getRequestedDeliveryPeriod() {
        return requestedDeliveryPeriod;
    }

    public void setRequestedDeliveryPeriod(PeriodEntity value) {
        this.requestedDeliveryPeriod = value;
    }

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PROMISEDDELIVERYPERIOD_DELIV_0")
    public PeriodEntity getPromisedDeliveryPeriod() {
        return promisedDeliveryPeriod;
    }

    public void setPromisedDeliveryPeriod(PeriodEntity value) {
        this.promisedDeliveryPeriod = value;
    }

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ESTIMATEDDELIVERYPERIOD_DELI_0")
    public PeriodEntity getEstimatedDeliveryPeriod() {
        return estimatedDeliveryPeriod;
    }

    public void setEstimatedDeliveryPeriod(PeriodEntity value) {
        this.estimatedDeliveryPeriod = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYPARTY_DELIVERYTYPE_H_0")
    public PartyEntity getDeliveryParty() {
        return deliveryParty;
    }

    public void setDeliveryParty(PartyEntity value) {
        this.deliveryParty = value;
    }

    @ManyToOne(targetEntity = DespatchType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCH_DELIVERYTYPE_OFID")
    public DespatchType getDespatch() {
        return despatch;
    }

    public void setDespatch(DespatchType value) {
        this.despatch = value;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
