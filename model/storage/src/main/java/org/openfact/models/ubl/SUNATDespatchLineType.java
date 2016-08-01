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
 * <p>Clase Java para SUNATDespatchLineType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATDespatchLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeliveredQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BackorderQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BackorderReason" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OutstandingQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OutstandingReason" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OversupplyQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderLineReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossWeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Shipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATDespatchLineType", namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", propOrder = {
    "id",
    "uuid",
    "note",
    "lineStatusCode",
    "deliveredQuantity",
    "backorderQuantity",
    "backorderReason",
    "outstandingQuantity",
    "outstandingReason",
    "oversupplyQuantity",
    "orderLineReference",
    "documentReference",
    "item",
    "grossWeightMeasure",
    "shipment"
})
public class SUNATDespatchLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NoteType note;
    @XmlElement(name = "LineStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineStatusCodeTypeCommBas lineStatusCode;
    @XmlElement(name = "DeliveredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DeliveredQuantityType deliveredQuantity;
    @XmlElement(name = "BackorderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BackorderQuantityType backorderQuantity;
    @XmlElement(name = "BackorderReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BackorderReasonType backorderReason;
    @XmlElement(name = "OutstandingQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OutstandingQuantityType outstandingQuantity;
    @XmlElement(name = "OutstandingReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OutstandingReasonType outstandingReason;
    @XmlElement(name = "OversupplyQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OversupplyQuantityType oversupplyQuantity;
    @XmlElement(name = "OrderLineReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<OrderLineReferenceType> orderLineReference;
    @XmlElement(name = "DocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> documentReference;
    @XmlElement(name = "Item", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected ItemType item;
    @XmlElement(name = "GrossWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GrossWeightMeasureType grossWeightMeasure;
    @XmlElement(name = "Shipment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<ShipmentType> shipment;

    /**
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * Obtiene el valor de la propiedad note.
     * 
     * @return
     *     possible object is
     *     {@link NoteType }
     *     
     */
    public NoteType getNote() {
        return note;
    }

    /**
     * Define el valor de la propiedad note.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteType }
     *     
     */
    public void setNote(NoteType value) {
        this.note = value;
    }

    /**
     * Obtiene el valor de la propiedad lineStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link LineStatusCodeTypeCommBas }
     *     
     */
    public LineStatusCodeTypeCommBas getLineStatusCode() {
        return lineStatusCode;
    }

    /**
     * Define el valor de la propiedad lineStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStatusCodeTypeCommBas }
     *     
     */
    public void setLineStatusCode(LineStatusCodeTypeCommBas value) {
        this.lineStatusCode = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveredQuantity.
     * 
     * @return
     *     possible object is
     *     {@link DeliveredQuantityType }
     *     
     */
    public DeliveredQuantityType getDeliveredQuantity() {
        return deliveredQuantity;
    }

    /**
     * Define el valor de la propiedad deliveredQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveredQuantityType }
     *     
     */
    public void setDeliveredQuantity(DeliveredQuantityType value) {
        this.deliveredQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad backorderQuantity.
     * 
     * @return
     *     possible object is
     *     {@link BackorderQuantityType }
     *     
     */
    public BackorderQuantityType getBackorderQuantity() {
        return backorderQuantity;
    }

    /**
     * Define el valor de la propiedad backorderQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BackorderQuantityType }
     *     
     */
    public void setBackorderQuantity(BackorderQuantityType value) {
        this.backorderQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad backorderReason.
     * 
     * @return
     *     possible object is
     *     {@link BackorderReasonType }
     *     
     */
    public BackorderReasonType getBackorderReason() {
        return backorderReason;
    }

    /**
     * Define el valor de la propiedad backorderReason.
     * 
     * @param value
     *     allowed object is
     *     {@link BackorderReasonType }
     *     
     */
    public void setBackorderReason(BackorderReasonType value) {
        this.backorderReason = value;
    }

    /**
     * Obtiene el valor de la propiedad outstandingQuantity.
     * 
     * @return
     *     possible object is
     *     {@link OutstandingQuantityType }
     *     
     */
    public OutstandingQuantityType getOutstandingQuantity() {
        return outstandingQuantity;
    }

    /**
     * Define el valor de la propiedad outstandingQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link OutstandingQuantityType }
     *     
     */
    public void setOutstandingQuantity(OutstandingQuantityType value) {
        this.outstandingQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad outstandingReason.
     * 
     * @return
     *     possible object is
     *     {@link OutstandingReasonType }
     *     
     */
    public OutstandingReasonType getOutstandingReason() {
        return outstandingReason;
    }

    /**
     * Define el valor de la propiedad outstandingReason.
     * 
     * @param value
     *     allowed object is
     *     {@link OutstandingReasonType }
     *     
     */
    public void setOutstandingReason(OutstandingReasonType value) {
        this.outstandingReason = value;
    }

    /**
     * Obtiene el valor de la propiedad oversupplyQuantity.
     * 
     * @return
     *     possible object is
     *     {@link OversupplyQuantityType }
     *     
     */
    public OversupplyQuantityType getOversupplyQuantity() {
        return oversupplyQuantity;
    }

    /**
     * Define el valor de la propiedad oversupplyQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link OversupplyQuantityType }
     *     
     */
    public void setOversupplyQuantity(OversupplyQuantityType value) {
        this.oversupplyQuantity = value;
    }

    /**
     * Gets the value of the orderLineReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderLineReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderLineReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderLineReferenceType }
     * 
     * 
     */
    public List<OrderLineReferenceType> getOrderLineReference() {
        if (orderLineReference == null) {
            orderLineReference = new ArrayList<OrderLineReferenceType>();
        }
        return this.orderLineReference;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
    }

    /**
     * Obtiene el valor de la propiedad item.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getItem() {
        return item;
    }

    /**
     * Define el valor de la propiedad item.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setItem(ItemType value) {
        this.item = value;
    }

    /**
     * Obtiene el valor de la propiedad grossWeightMeasure.
     * 
     * @return
     *     possible object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public GrossWeightMeasureType getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    /**
     * Define el valor de la propiedad grossWeightMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossWeightMeasureType }
     *     
     */
    public void setGrossWeightMeasure(GrossWeightMeasureType value) {
        this.grossWeightMeasure = value;
    }

    /**
     * Gets the value of the shipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentType }
     * 
     * 
     */
    public List<ShipmentType> getShipment() {
        if (shipment == null) {
            shipment = new ArrayList<ShipmentType>();
        }
        return this.shipment;
    }

}
