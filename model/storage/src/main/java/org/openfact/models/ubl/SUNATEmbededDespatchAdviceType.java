//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.26 a las 12:15:47 PM COT 
//


package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SUNATEmbededDespatchAdviceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATEmbededDespatchAdviceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryAddress" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginAddress" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATCarrierParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}DriverParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATRoadTransport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATEmbededDespatchAdviceType", namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", propOrder = {
    "deliveryAddress",
    "originAddress",
    "sunatCarrierParty",
    "driverParty",
    "sunatRoadTransport"
})
public class SUNATEmbededDespatchAdviceType {

    @XmlElement(name = "DeliveryAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType deliveryAddress;
    @XmlElement(name = "OriginAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType originAddress;
    @XmlElement(name = "SUNATCarrierParty")
    protected SUNATCarrierPartyType sunatCarrierParty;
    @XmlElement(name = "DriverParty")
    protected DriverPartyType driverParty;
    @XmlElement(name = "SUNATRoadTransport")
    protected List<SUNATRoadTransportType> sunatRoadTransport;

    /**
     * Obtiene el valor de la propiedad deliveryAddress.
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
     * Define el valor de la propiedad deliveryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setDeliveryAddress(AddressType value) {
        this.deliveryAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad originAddress.
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
     * Define el valor de la propiedad originAddress.
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
     * Obtiene el valor de la propiedad sunatCarrierParty.
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
     * Define el valor de la propiedad sunatCarrierParty.
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
     * Obtiene el valor de la propiedad driverParty.
     * 
     * @return
     *     possible object is
     *     {@link DriverPartyType }
     *     
     */
    public DriverPartyType getDriverParty() {
        return driverParty;
    }

    /**
     * Define el valor de la propiedad driverParty.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverPartyType }
     *     
     */
    public void setDriverParty(DriverPartyType value) {
        this.driverParty = value;
    }

    /**
     * Gets the value of the sunatRoadTransport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sunatRoadTransport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSUNATRoadTransport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SUNATRoadTransportType }
     * 
     * 
     */
    public List<SUNATRoadTransportType> getSUNATRoadTransport() {
        if (sunatRoadTransport == null) {
            sunatRoadTransport = new ArrayList<SUNATRoadTransportType>();
        }
        return this.sunatRoadTransport;
    }

}
