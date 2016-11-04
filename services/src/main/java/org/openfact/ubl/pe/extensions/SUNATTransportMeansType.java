/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.16 at 10:50:18 AM PET 
//


package org.openfact.ubl.pe.extensions;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TransportMeansType;


/**
 * <p>Java class for SUNATTransportMeansType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
