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
 * <p>Clase Java para SUNATTransportMeansType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SUNATTransportMeansType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportMeansType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}DriverParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1}SUNATRoadTransport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUNATTransportMeansType", namespace = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1", propOrder = {
    "driverParty",
    "sunatRoadTransport"
})
public class SUNATTransportMeansType
    extends TransportMeansType
{

    @XmlElement(name = "DriverParty")
    protected List<DriverPartyType> driverParty;
    @XmlElement(name = "SUNATRoadTransport")
    protected List<SUNATRoadTransportType> sunatRoadTransport;

    /**
     * Gets the value of the driverParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the driverParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDriverParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DriverPartyType }
     * 
     * 
     */
    public List<DriverPartyType> getDriverParty() {
        if (driverParty == null) {
            driverParty = new ArrayList<DriverPartyType>();
        }
        return this.driverParty;
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
