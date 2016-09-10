package org.openfact.ubl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalInformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CustomerAssignedAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoicedQuantityType;
/*import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IssueLocalDate;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.LineExtensionBigDecimal;*/
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.NameType;
/*import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableBigDecimal;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PriceBigDecimal;*/
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PriceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.StreetNameType;
//import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TaxBigDecimal;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TaxTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.UBLVersionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.URIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.ValueType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

public class ModelToUblRepresentation {
	private final GregorianCalendar c = new GregorianCalendar();

	private InvoiceType invoiceType;
	private UBLExtensionsType extensiones;
	private UBLExtensionType extensionInfAdicional, extensionSignAdicional;
	private ExtensionContentType contenidoDeExtension, contenidoSign;
	private AdditionalInformationType informacionAdicional;
	private SupplierPartyType supplierPartyType;
	private PartyType partyTypeSupplier, partyTypeCustomer;
	private AddressType addressType;
	private CountryType countryType;
	private PartyLegalEntityType partyLegalEntityTypeSupplier, partyLegalEntityTypeCustomer;
	private CustomerPartyType customerPartyType;
	private TaxTotalType taxTotalType;
	private TaxSubtotalType taxSubtotalType;
	private TaxCategoryType taxCategoryType;
	private TaxSchemeType taxSchemeType;
	private MonetaryTotalType monetaryTotalType;
	private SignatureType signatureType;
	private PartyType partyTypeSignature;
	private PartyIdentificationType identificationType;
	private PartyNameType partyNameType;
	private AttachmentType attachmentType;
	private ExternalReferenceType ert;

	public ModelToUblRepresentation(InvoiceType invoiceType) {
		this.invoiceType = invoiceType;
		inicializarElementosBasicos();
		invoiceType.setUBLExtensions(extensiones);
		extensiones.getUBLExtension().add(extensionInfAdicional);
		extensionInfAdicional.setExtensionContent(contenidoDeExtension);
		extensiones.getUBLExtension().add(extensionSignAdicional);
		extensionSignAdicional.setExtensionContent(contenidoSign);
		invoiceType.getSignature().add(signatureType);
		signatureType.setSignatoryParty(partyTypeSignature);
		partyTypeSignature.getPartyIdentification().add(identificationType);
		partyTypeSignature.getPartyName().add(partyNameType);
		signatureType.setDigitalSignatureAttachment(attachmentType);
		attachmentType.setExternalReference(ert);
		invoiceType.setAccountingSupplierParty(supplierPartyType);
		supplierPartyType.setParty(partyTypeSupplier);
		partyTypeSupplier.setPostalAddress(addressType);
		addressType.setCountry(countryType);
		partyTypeSupplier.getPartyLegalEntity().add(partyLegalEntityTypeSupplier);
		invoiceType.setAccountingCustomerParty(customerPartyType);
		customerPartyType.setParty(partyTypeCustomer);
		partyTypeCustomer.getPartyLegalEntity().add(partyLegalEntityTypeCustomer);
		invoiceType.getTaxTotal().add(taxTotalType);
		taxTotalType.getTaxSubtotal().add(taxSubtotalType);
		taxSubtotalType.setTaxCategory(taxCategoryType);
		taxCategoryType.setTaxScheme(taxSchemeType);
		invoiceType.setLegalMonetaryTotal(monetaryTotalType);
	}

	private void inicializarElementosBasicos() {
		// invoiceType = new InvoiceType();
		extensiones = new UBLExtensionsType();
		extensionInfAdicional = new UBLExtensionType();
		extensionSignAdicional = new UBLExtensionType();
		contenidoDeExtension = new ExtensionContentType();
		contenidoSign = new ExtensionContentType();
		informacionAdicional = new AdditionalInformationType();
		signatureType = new SignatureType();
		partyTypeSignature = new PartyType();
		identificationType = new PartyIdentificationType();
		supplierPartyType = new SupplierPartyType();
		partyTypeSupplier = new PartyType();
		addressType = new AddressType();
		countryType = new CountryType();
		partyLegalEntityTypeSupplier = new PartyLegalEntityType();
		customerPartyType = new CustomerPartyType();
		partyTypeCustomer = new PartyType();
		partyLegalEntityTypeCustomer = new PartyLegalEntityType();
		taxTotalType = new TaxTotalType();
		taxSubtotalType = new TaxSubtotalType();
		taxCategoryType = new TaxCategoryType();
		taxSchemeType = new TaxSchemeType();
		monetaryTotalType = new MonetaryTotalType();
		partyNameType = new PartyNameType();
		attachmentType = new AttachmentType();
		ert = new ExternalReferenceType();

	}

	public void addFacturaExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario(String cod,
			BigDecimal monto) {
		
		
		
		/*IDType idAMonetaryTotal = new IDType();
		idAMonetaryTotal.setValue(cod);
		
		PayableBigDecimal pa = new PayableBigDecimal();
		pa.setCurrencyID("PEN");		
		pa.setValue(monto);

		
		
		MonetaryTotalType amtt = new MonetaryTotalType();
		amtt.setPayableAmount(pa);
		
		ExtensionContentType e = new ExtensionContentType();
		e.setAny(amtt);

		UBLExtensionType ex = new UBLExtensionType();
		ex.setExtensionContent(e);

		UBLExtensionsType exx = new UBLExtensionsType();
		exx.addUBLExtension(ex);

		invoiceType.setUBLExtensions(exx);*/

	}
	public void addSignature(){
		/*SignatureType sign =new SignatureType();
		AttachmentType at=new AttachmentType();
		ExternalReferenceType exter=new ExternalReferenceType();
		URIType uri=new URIType();
		uri.setValue("#SignatureOpenFact");
		exter.setURI(uri);
		at.setExternalReference(exter);
		sign.setDigitalSignatureAttachment(at);
		
		sign.setID("IdSignOpenFact");
		
		SignatoryParty sig=new 
		sign.setSignatoryParty(value);*/
	}

	public void addFacturaExtensionesExtensionContenidoDeExtensionInformacionAdicionalPropiedadAdicional(String cod,
			String valor) {
		IDType IdPropiedadAdicional = new IDType();
		IdPropiedadAdicional.setValue(cod);
		ValueType valorDePropiedad = new ValueType();
		valorDePropiedad.setValue(valor);

		// AdditionalPropertyType propiedadAdicional =
		// FACTORIA.createAdditionalPropertyType();
		// propiedadAdicional.setID(IdPropiedadAdicional);
		// propiedadAdicional.setValue(valorDePropiedad);
		// informacionAdicional.getAdditionalProperty().add(propiedadAdicional);
	}

	public void setUBLIdVersion(String version) {
		UBLVersionIDType ublIdVersion = new UBLVersionIDType();
		ublIdVersion.setValue(version);
		invoiceType.setUBLVersionID(ublIdVersion);
	}

	public void setCustomizationId(String id) {
		CustomizationIDType cidt = new CustomizationIDType();
		cidt.setValue(id);
		invoiceType.setCustomizationID(cidt);
	}

	public void setId(String id) {
		IDType invoiceId = new IDType();
		invoiceId.setValue(id);
		invoiceType.setID(invoiceId);
	}

	public void setIssueDate(Date fecha) throws DatatypeConfigurationException {
		/*IssueLocalDate issueDate = new IssueLocalDate();
		c.setTime(fecha);
		issueDate.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendarDate(c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED));
		invoiceType.setIssueDate(issueDate);*/
	}

	public void setInvoiceTypeCode(String codigo) {
		InvoiceTypeCodeType invoiceTypeCod = new InvoiceTypeCodeType();
		invoiceTypeCod.setValue(codigo);
		invoiceType.setInvoiceTypeCode(invoiceTypeCod);
	}

	public void setDocumentCurrencyCode(String codigo) {
		DocumentCurrencyCodeType currencyCode = new DocumentCurrencyCodeType();
		currencyCode.setValue(codigo);
		invoiceType.setDocumentCurrencyCode(currencyCode);
	}

	public void setSignatureId(String id) {
		IDType dType = new IDType();
		dType.setValue(id);
		signatureType.setID(dType);
	}

	public void setSignatureSignatoryPartyPartyIdentificationId(String id) {
		IDType dType = new IDType();
		dType.setValue(id);
		identificationType.setID(dType);
	}

	public void setSignatureSignatoryPartyPartyNameName(String nombre) {
		partyNameType.setName(nombre);
	}

	public void setSignatureDigitalSignatureAttachmentExternalReferenceURI(String uri) {
		URIType uRIType = new URIType();
		uRIType.setValue(uri);
		ert.setURI(uRIType);
	}

	public void setAccountingSupplierPartyCustomerAssignedAccountID(String rucProveedor) {
		CustomerAssignedAccountIDType customerRuc = new CustomerAssignedAccountIDType();
		customerRuc.setValue(rucProveedor);
		supplierPartyType.setCustomerAssignedAccountID(customerRuc);
	}

	public void setAccountingSupplierPartyAdditionalAccountID(String codigo) {
		AdditionalAccountIDType tipDoc = new AdditionalAccountIDType();
		tipDoc.setValue(codigo);
		supplierPartyType.getAdditionalAccountID().add(tipDoc);
	}

	public void setAccountingSupplierPartyPartyPostalAddressId(String id) {
		IDType idType = new IDType();
		idType.setValue(id);
		addressType.setID(idType);
	}

	public void setAccountingSupplierPartyPartyPostalAddressStreetName(String direccion) {
		StreetNameType nombreDireccion = new StreetNameType();
		nombreDireccion.setValue(direccion);
		addressType.setStreetName(nombreDireccion);
	}

	public void setAccountingSupplierPartyPartyPostalAddressCitySubdivisionName(String nombre) {
		CitySubdivisionNameType nameType = new CitySubdivisionNameType();
		nameType.setValue(nombre);
		addressType.setCitySubdivisionName(nameType);
	}

	public void setAccountingSupplierPartyPartyPostalAddressCityName(String nombre) {
		CityNameType cityNameType = new CityNameType();
		cityNameType.setValue(nombre);
		addressType.setCityName(cityNameType);
	}

	public void setAccountingSupplierPartyPartyPostalAddressCountrySubentity(String nombre) {
		CountrySubentityType countrySubentityType = new CountrySubentityType();
		countrySubentityType.setValue(nombre);
		addressType.setCountrySubentity(countrySubentityType);
	}

	public void setAccountingSupplierPartyPartyPostalAddressDistrict(String nombre) {
		DistrictType districtType = new DistrictType();
		districtType.setValue(nombre);
		addressType.setDistrict(districtType);
	}

	public void setAccountingSupplierPartyPartyPostalAddressCountryIdentificationCode(String codigo) {
		IdentificationCodeType codeType = new IdentificationCodeType();
		codeType.setValue(codigo);
		countryType.setIdentificationCode(codeType);
	}

	public void setAccountingSupplierPartyPartyPartyLegalEntityRegistrationName(String nombre) {
		RegistrationNameType nameType = new RegistrationNameType();
		nameType.setValue(nombre);
		partyLegalEntityTypeSupplier.setRegistrationName(nameType);
	}

	public void setAccountingCustomerPartyCustomerAssignedAccountID(String rucCliente) {
		CustomerAssignedAccountIDType customerRuc = new CustomerAssignedAccountIDType();
		customerRuc.setValue(rucCliente);
		customerPartyType.setCustomerAssignedAccountID(customerRuc);
	}

	public void setAccountingCustomerPartyAdditionalAccountID(String codigo) {
		AdditionalAccountIDType tipDoc = new AdditionalAccountIDType();
		tipDoc.setValue(codigo);
		customerPartyType.getAdditionalAccountID().add(tipDoc);
	}

	public void setAccountingCustomerPartyPartyPartyLegalEntityRegistrationName(String nombre) {
		RegistrationNameType nameType = new RegistrationNameType();
		nameType.setValue(nombre);
		partyLegalEntityTypeCustomer.setRegistrationName(nameType);
	}

	public void setTaxTotalTaxAmount(BigDecimal monto, String codigo) {
		/*TaxBigDecimal taxBigDecimal = new TaxBigDecimal();
		taxBigDecimal.setValue(monto);
		taxBigDecimal.setCurrencyID(codigo);
		taxTotalType.setTaxAmount(taxBigDecimal);*/
	}

	public void setTaxTotalTaxSubtotalTaxAmount(BigDecimal monto, String codigo) {
		/*TaxBigDecimal taxBigDecimal = new TaxBigDecimal();
		taxBigDecimal.setValue(monto);
		taxBigDecimal.setCurrencyID(codigo);
		taxSubtotalType.setTaxAmount(taxBigDecimal);*/
	}

	public void setTaxTotalTaxSubtotalTaxCategoryTaxScheme(String id, String name, String codigo) {
		IDType iDType = new IDType();
		NameType nameTypeCommBas = new NameType();
		TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
		iDType.setValue(id);
		nameTypeCommBas.setValue(name);
		taxTypeCodeType.setValue(codigo);
		taxSchemeType.setID(iDType);
		taxSchemeType.setName(nameTypeCommBas);
		taxSchemeType.setTaxTypeCode(taxTypeCodeType);
	}

	public void setLegalMonetaryTotalPayableAmount(BigDecimal monto, String codigo) {
		/*PayableBigDecimal payableBigDecimal = new PayableBigDecimal();
		payableBigDecimal.setCurrencyID(codigo);
		payableBigDecimal.setValue(monto);
		monetaryTotalType.setPayableAmount(payableBigDecimal);*/
	}

	public void addInvoiceLine(DetalleFactura det) {
		/*InvoiceLineType ilt = new InvoiceLineType();
		IDType iDType = new IDType();
		iDType.setValue(det.getId());
		ilt.setID(iDType);
		InvoicedQuantityType iqt = new InvoicedQuantityType();
		iqt.setValue(det.getInvoicedQuantityMonto());
		iqt.setUnitCode(det.getInvoicedQuantityUnitCode());
		ilt.setInvoicedQuantity(iqt);
		LineExtensionBigDecimal leat = new LineExtensionBigDecimal();
		leat.setCurrencyID("PEN");
		leat.setValue(det.getLineExtensionAmountMonto());
		ilt.setLineExtensionAmount(leat);
		PricingReferenceType prt = new PricingReferenceType();
		PriceType priceType = new PriceType();
		PriceBigDecimal amountType = new PriceBigDecimal();
		amountType.setValue(det.getPriceAmountMonto());
		amountType.setCurrencyID("PEN");
		priceType.setPriceAmount(amountType);
		PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
		priceTypeCodeType.setValue(det.getPriceTypeCode());
		priceType.setPriceTypeCode(priceTypeCodeType);
		prt.getAlternativeConditionPrice().add(priceType);
		ilt.setPricingReference(prt);
		TaxTotalType ttt = new TaxTotalType();
		TaxBigDecimal tat = new TaxBigDecimal();
		tat.setValue(det.getTaxTotalTaxAmountMonto());
		tat.setCurrencyID("PEN");
		ttt.setTaxAmount(tat);
		TaxSubtotalType tst = new TaxSubtotalType();
		TaxBigDecimal taxAmountSub = new TaxBigDecimal();
		taxAmountSub.setValue(det.getTaxTotalTaxSubtotalTaxAmountMonto());
		taxAmountSub.setCurrencyID("PEN");
		tst.setTaxAmount(taxAmountSub);
		TaxCategoryType tct = new TaxCategoryType();
		TaxExemptionReasonCodeType terct = new TaxExemptionReasonCodeType();
		terct.setValue(det.getTaxExemptionReasonCode());
		tct.setTaxExemptionReasonCode(terct);
		TaxSchemeType taxSchemeType2 = new TaxSchemeType();
		IDType iDType2 = new IDType();
		NameType nameTypeCommBas = new NameType();
		TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
		iDType2.setValue(det.getCategoryTaxScheme());
		nameTypeCommBas.setValue(det.getCategoryTaxScheme());
		taxTypeCodeType.setValue(det.getCategoryTaxScheme());
		taxSchemeType2.setID(iDType2);
		taxSchemeType2.setName(nameTypeCommBas);
		taxSchemeType2.setTaxTypeCode(taxTypeCodeType);
		tct.setTaxScheme(taxSchemeType2);
		tst.setTaxCategory(tct);
		ttt.getTaxSubtotal().add(tst);
		ilt.getTaxTotal().add(ttt);
		ItemType itemType = new ItemType();
		DescriptionType descriptionType = new DescriptionType();
		descriptionType.setValue(det.getItemDescription());
		itemType.getDescription().add(descriptionType);
		ItemIdentificationType identificationType = new ItemIdentificationType();
		IDType dTypeItem = new IDType();
		dTypeItem.setValue(det.getItemDescriptionSellersItemIdentificationId());
		identificationType.setID(dTypeItem);
		itemType.setSellersItemIdentification(identificationType);
		ilt.setItem(itemType);
		PriceType priceTypeDet = new PriceType();
		PriceBigDecimal amountTypeDet = new PriceBigDecimal();
		amountTypeDet.setCurrencyID("PEN");
		amountTypeDet.setValue(det.getPricePriceAmountMonto());
		priceTypeDet.setPriceAmount(amountTypeDet);
		ilt.setPrice(priceTypeDet);
		invoiceType.getInvoiceLine().add(ilt);*/
	}
}
