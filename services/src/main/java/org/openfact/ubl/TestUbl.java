package org.openfact.ubl;

import org.w3c.dom.Document;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.ubl21.EUBL21DocumentType;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;
import com.helger.ubl21.UBL21Writer;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalInformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.xml.sax.SAXException;

public class TestUbl {

	public static void main(String arg[]) throws SAXException, DatatypeConfigurationException {
		File file =new File("/home/lxpary/Escritorio/Signature/20494637074-01-F001-1_sign.xml");
		boolean a =file.exists();
		InvoiceType invoice=UBL21Reader.invoice().read(file);
		
		
		
		
		
		
		
		InvoiceType invoiceType = new InvoiceType();
		ModelToUblRepresentation factura = new ModelToUblRepresentation(invoiceType);
		factura.addFacturaExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario("1001",
				new BigDecimal("348199.15"));
		factura.addFacturaExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario("1003",
				new BigDecimal("12350.00"));
		factura.addFacturaExtensionesExtensionContenidoDeExtensionInformacionAdicionalPropiedadAdicional("1000",
				"CUATROCIENTOS VEINTITRES MIL DOSCIENTOS VEINTICINCO Y 00/100");
		factura.setUBLIdVersion("2.0");
		factura.setCustomizationId("1.0");
		factura.setId("F001-4355");
		factura.setIssueDate(new Date());
		factura.setInvoiceTypeCode("01");
		factura.setDocumentCurrencyCode("PEN");
		factura.setSignatureId("IDSignOlva");
		factura.setSignatureSignatoryPartyPartyIdentificationId("10428482072");
		factura.setSignatureSignatoryPartyPartyNameName("OLVA COURIER SAC");
		factura.setSignatureDigitalSignatureAttachmentExternalReferenceURI("#SignatureOlva");
		factura.setAccountingSupplierPartyCustomerAssignedAccountID("10428482072");
		factura.setAccountingSupplierPartyAdditionalAccountID("6");
		factura.setAccountingSupplierPartyPartyPostalAddressId("150111");
		factura.setAccountingSupplierPartyPartyPostalAddressStreetName("AV. LOS PRECURSORES #1245");
		factura.setAccountingSupplierPartyPartyPostalAddressCitySubdivisionName("URB. MIGUEL GRAU");
		factura.setAccountingSupplierPartyPartyPostalAddressCityName("LIMA");
		factura.setAccountingSupplierPartyPartyPostalAddressCountrySubentity("LIMA");
		factura.setAccountingSupplierPartyPartyPostalAddressDistrict("EL AGUSTINO");
		factura.setAccountingSupplierPartyPartyPostalAddressCountryIdentificationCode("PE");
		factura.setAccountingSupplierPartyPartyPartyLegalEntityRegistrationName("SOPORTE TECNOLOGICOS EIRL");
		factura.setAccountingCustomerPartyCustomerAssignedAccountID("20587896411");
		factura.setAccountingCustomerPartyAdditionalAccountID("6");
		factura.setAccountingCustomerPartyPartyPartyLegalEntityRegistrationName("SERVICABINAS S.A.");
		factura.setTaxTotalTaxAmount(new BigDecimal("62675.85"), "PEN");
		factura.setTaxTotalTaxSubtotalTaxAmount(new BigDecimal("62675.85"), "PEN");
		factura.setTaxTotalTaxSubtotalTaxCategoryTaxScheme("1000", "IGV", "VAT");
		factura.setLegalMonetaryTotalPayableAmount(new BigDecimal("423225.00"), "PEN");

		
		  DetalleFactura det1 = new DetalleFactura();
          det1.setId("1");
          det1.setInvoicedQuantity("NIU", new BigDecimal("2000"));
          CurrencyCodeType cur=new CurrencyCodeType();
          cur.setValue("PEN");
          
          det1.setLineExtensionAmount(cur, new BigDecimal("149491.53"));
          det1.setPricingReferenceAlternativeConditionPricePriceAmount(cur, new BigDecimal("98.00"));
          det1.setPricingReferenceAlternativeConditionPricePriceTypeCode("01"); //cambiar
          det1.setTaxTotalTaxAmount(new BigDecimal("26908.47"), cur);
          det1.setTaxTotalTaxSubtotalTaxAmount(new BigDecimal("26908.47"), cur);
          det1.setTaxTotalTaxSubtotalTaxCategoryTaxExemptionReasonCode("10");
          det1.setTaxTotalTaxSubtotalTaxCategoryTaxScheme("1000");
          det1.setItemDescription("Grabadora LG Externo Modelo: GE20LU10");
          det1.setItemDescriptionSellersItemIdentificationId("GLG199");
          det1.setPricePriceAmount(new BigDecimal("83.05"), cur);
          factura.addInvoiceLine(det1);
		
		
		
		
		final IResourceErrorGroup aErrors = UBL21Validator.invoice().validate(invoiceType);
		final Document aDoc = UBL21Writer.invoice().getAsDocument(invoiceType);
		assertNotNull(aDoc);
		if (aErrors != null) {
			System.out.println("Errors: " + aErrors.toString());
		} else {
			final Document aDoc1 = UBL21Writer.invoice().getAsDocument(invoiceType);
			assertNotNull(aDoc1);
			System.out.println("No errors::" + aDoc);
		}

	}

}
