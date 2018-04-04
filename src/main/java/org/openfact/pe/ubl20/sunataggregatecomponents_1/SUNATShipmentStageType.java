//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.04 at 05:10:17 PM PET 
//


package org.openfact.pe.ubl20.sunataggregatecomponents_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.openfact.pe.ubl20.xsd.commonaggregatecomponents_2.AddressType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.IDType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.TransportMeansTypeCodeType;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.TransportModeCodeType;


/**
 * <p>Java class for SUNATShipmentStageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SUNATShipmentStageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}ShipmentStageTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportModeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATCarrierParty" minOccurs="0"/>
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATTransportMeans" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginAddress" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATShipmentStageType", propOrder = {
    "id",
    "shipmentStageTypeCode",
    "transportModeCode",
    "transportMeansTypeCode",
    "sunatCarrierParty",
    "sunatTransportMeans",
    "originAddress",
    "deliveryAddress"
})
public class SUNATShipmentStageType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ShipmentStageTypeCode")
    protected IDType shipmentStageTypeCode;
    @XmlElement(name = "TransportModeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportModeCodeType transportModeCode;
    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "SUNATCarrierParty")
    protected SUNATCarrierPartyType sunatCarrierParty;
    @XmlElement(name = "SUNATTransportMeans")
    protected SUNATTransportMeansType sunatTransportMeans;
    @XmlElement(name = "OriginAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType originAddress;
    @XmlElement(name = "DeliveryAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType deliveryAddress;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the shipmentStageTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getShipmentStageTypeCode() {
        return shipmentStageTypeCode;
    }

    /**
     * Sets the value of the shipmentStageTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setShipmentStageTypeCode(IDType value) {
        this.shipmentStageTypeCode = value;
    }

    /**
     * Gets the value of the transportModeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TransportModeCodeType }
     *     
     */
    public TransportModeCodeType getTransportModeCode() {
        return transportModeCode;
    }

    /**
     * Sets the value of the transportModeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportModeCodeType }
     *     
     */
    public void setTransportModeCode(TransportModeCodeType value) {
        this.transportModeCode = value;
    }

    /**
     * Gets the value of the transportMeansTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public TransportMeansTypeCodeType getTransportMeansTypeCode() {
        return transportMeansTypeCode;
    }

    /**
     * Sets the value of the transportMeansTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public void setTransportMeansTypeCode(TransportMeansTypeCodeType value) {
        this.transportMeansTypeCode = value;
    }

    /**
     * Gets the value of the sunatCarrierParty property.
     * 
     * @return
     *     possible object is
     *     {@link SUNATCarrierPartyType }
     *     
     */
    public SUNATCarrierPartyType getSUNATCarrierParty() {
        return sunatCarrierParty;
    }

    /**
     * Sets the value of the sunatCarrierParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATCarrierPartyType }
     *     
     */
    public void setSUNATCarrierParty(SUNATCarrierPartyType value) {
        this.sunatCarrierParty = value;
    }

    /**
     * Gets the value of the sunatTransportMeans property.
     * 
     * @return
     *     possible object is
     *     {@link SUNATTransportMeansType }
     *     
     */
    public SUNATTransportMeansType getSUNATTransportMeans() {
        return sunatTransportMeans;
    }

    /**
     * Sets the value of the sunatTransportMeans property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUNATTransportMeansType }
     *     
     */
    public void setSUNATTransportMeans(SUNATTransportMeansType value) {
        this.sunatTransportMeans = value;
    }

    /**
     * Gets the value of the originAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getOriginAddress() {
        return originAddress;
    }

    /**
     * Sets the value of the originAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setOriginAddress(AddressType value) {
        this.originAddress = value;
    }

    /**
     * Gets the value of the deliveryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the value of the deliveryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setDeliveryAddress(AddressType value) {
        this.deliveryAddress = value;
    }

}
