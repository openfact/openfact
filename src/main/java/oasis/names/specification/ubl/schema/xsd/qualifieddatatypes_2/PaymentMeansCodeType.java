//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.05 at 03:42:27 PM PET 
//


package oasis.names.specification.ubl.schema.xsd.qualifieddatatypes_2;

import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.CodeType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2" xmlns:udt="urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means_ Code. Type&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Version&gt;2.0&lt;/ccts:Version&gt;&lt;ccts:Definition&gt;The set of valid means of paying the debt incurred.&lt;/ccts:Definition&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:QualifierTerm&gt;Payment Means&lt;/ccts:QualifierTerm&gt;&lt;ccts:UniqueID/&gt;&lt;ccts:UsageRule&gt;Used under the terms of the UNECE  policy stated at http://www.unece.org/ece_legal.htm.&lt;/ccts:UsageRule&gt;&lt;/ccts:Component&gt;
 * </pre>
 * <p>
 * <p>
 * <p>Java class for PaymentMeansCodeType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PaymentMeansCodeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2&gt;CodeType"&gt;
 *       &lt;attribute name="listID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" default="UN/ECE 4461" /&gt;
 *       &lt;attribute name="listAgencyID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" default="6" /&gt;
 *       &lt;attribute name="listAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" default="United Nations Economic Commission for Europe" /&gt;
 *       &lt;attribute name="listName" type="{http://www.w3.org/2001/XMLSchema}string" default="Payment Means" /&gt;
 *       &lt;attribute name="listVersionID" type="{http://www.w3.org/2001/XMLSchema}normalizedString" default="D03A" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="languageID" type="{http://www.w3.org/2001/XMLSchema}language" default="en" /&gt;
 *       &lt;attribute name="listURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://docs.oasis-open.org/ubl/os-ubl-2.0/cl/gc/default/PaymentMeansCode-2.0.gc" /&gt;
 *       &lt;attribute name="listSchemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="urn:oasis:names:specification:ubl:codelist:gc:PaymentMeansCode-2.0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMeansCodeType")
@XmlSeeAlso({
        oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansCodeType.class
})
public class PaymentMeansCodeType
        extends CodeType {


}