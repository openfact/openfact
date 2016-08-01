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
 * <p>Clase Java para SUNATRoadTransportType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATRoadTransportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RoadTransportType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportAuthorizationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SemiTrailer" maxOccurs="5" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BrandName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATRoadTransportType", namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", propOrder = {
    "transportMeansTypeCode",
    "transportAuthorizationCode",
    "semiTrailer",
    "brandName"
})
public class SUNATRoadTransportType
    extends RoadTransportType
{

    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "TransportAuthorizationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportAuthorizationCodeType transportAuthorizationCode;
    @XmlElement(name = "SemiTrailer")
    protected List<RoadTransportType> semiTrailer;
    @XmlElement(name = "BrandName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BrandNameType brandName;

    /**
     * Obtiene el valor de la propiedad transportMeansTypeCode.
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
     * Define el valor de la propiedad transportMeansTypeCode.
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
     * Obtiene el valor de la propiedad transportAuthorizationCode.
     * 
     * @return
     *     possible object is
     *     {@link TransportAuthorizationCodeType }
     *     
     */
    public TransportAuthorizationCodeType getTransportAuthorizationCode() {
        return transportAuthorizationCode;
    }

    /**
     * Define el valor de la propiedad transportAuthorizationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportAuthorizationCodeType }
     *     
     */
    public void setTransportAuthorizationCode(TransportAuthorizationCodeType value) {
        this.transportAuthorizationCode = value;
    }

    /**
     * Gets the value of the semiTrailer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the semiTrailer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSemiTrailer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoadTransportType }
     * 
     * 
     */
    public List<RoadTransportType> getSemiTrailer() {
        if (semiTrailer == null) {
            semiTrailer = new ArrayList<RoadTransportType>();
        }
        return this.semiTrailer;
    }

    /**
     * Obtiene el valor de la propiedad brandName.
     * 
     * @return
     *     possible object is
     *     {@link BrandNameType }
     *     
     */
    public BrandNameType getBrandName() {
        return brandName;
    }

    /**
     * Define el valor de la propiedad brandName.
     * 
     * @param value
     *     allowed object is
     *     {@link BrandNameType }
     *     
     */
    public void setBrandName(BrandNameType value) {
        this.brandName = value;
    }

}
