package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.utils.finance.MoneyConverters;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.*;
import org.w3c.dom.Element;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.*;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class ModelToType {

    private ModelToType() {
        // Just util class
    }

    public static InvoiceType toInvoiceType(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, InvoiceModel invoice) {
        InvoiceType invoiceType = buildInvoiceType(organization, additionalInfo, invoice);
        invoiceType.setInvoiceTypeCode(TypeUtils.buildInvoiceTypeCodeType(TipoInvoice.BOLETA.getCodigo()));

        return invoiceType;
    }

    public static CreditNoteType toCreditNoteType(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, NotaModel nota, InvoiceModel invoiceAfectado) {
        oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
        CreditNoteType creditNoteType = factory.createCreditNoteType();

        DatosVentaModel datosVentaModel = nota.getDatosVenta();

        // General config
        creditNoteType.setUBLVersionID(TypeUtils.buildUBLVersionID("2.0"));
        creditNoteType.setCustomizationID(TypeUtils.buildCustomizationIDType("1.0"));

        // documentId
        creditNoteType.setID(TypeUtils.buildIDType(nota.getSerie() + "-" + nota.getNumero()));

        // Fechas
        XMLGregorianCalendar issueDate = toGregorianCalendar(datosVentaModel.getFecha().getEmision(), organization.getTimeZone());
        creditNoteType.setIssueDate(TypeUtils.buildIssueDateType(issueDate));

        // Proveedor
        creditNoteType.setAccountingSupplierParty(buildSupplierPartyType(additionalInfo));

        // Cliente
        creditNoteType.setAccountingCustomerParty(buildCustomerPartyType(datosVentaModel.getCliente()));

        // Moneda
        creditNoteType.setDocumentCurrencyCode(TypeUtils.buildDocumentCurrencyCodeType(datosVentaModel.getMoneda().getMoneda()));

        // Totales pagar/descuentos/otros cargos
        creditNoteType.setLegalMonetaryTotal(buildMonetaryTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal()));

        // Total impuestos IGV/ISC
        creditNoteType.getTaxTotal().addAll(buildTaxTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getImpuestos()));

        // Firma
        creditNoteType.getSignature().add(buildSignatureType(additionalInfo));
        creditNoteType.setUBLExtensions(buildUBLExtensionsType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal().getTotalPagar(), datosVentaModel.getTotalInformacionAdicional()));

        // Observaciones
        creditNoteType.getNote().add(TypeUtils.buildNoteType(datosVentaModel.getObservaciones()));

        // Invoice asociado
        String referenceID = invoiceAfectado.getSerie() + "-" + invoiceAfectado.getNumero();
        String responseCode = nota.getCodigoMotivo();
        String descripcion = datosVentaModel.getObservaciones() != null ? datosVentaModel.getObservaciones() : "Sin observación";

        creditNoteType.getDiscrepancyResponse().add(TypeUtils.buildResponseType(referenceID, responseCode, descripcion));


        BillingReferenceType billingReferenceType = new BillingReferenceType();
        billingReferenceType.setInvoiceDocumentReference(TypeUtils.buildDocumentReferenceType(referenceID, invoiceAfectado.getCodigoTipoComprobante()));
        creditNoteType.getBillingReference().add(billingReferenceType);

        // Detalle
        int i = 1;
        for (DatosVentaDetalleModel detalleModel : datosVentaModel.getDetalle()) {
            creditNoteType.getCreditNoteLine().add(buildCreditNoteLineType(i, datosVentaModel.getMoneda().getMoneda(), detalleModel));
            i++;
        }

        return creditNoteType;
    }

    public static DebitNoteType toDebitNoteType(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, NotaModel nota, InvoiceModel invoiceAfectado) {
        oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory();
        DebitNoteType debitNoteType = factory.createDebitNoteType();

        DatosVentaModel datosVentaModel = nota.getDatosVenta();

        // General config
        debitNoteType.setUBLVersionID(TypeUtils.buildUBLVersionID("2.0"));
        debitNoteType.setCustomizationID(TypeUtils.buildCustomizationIDType("1.0"));

        // documentId
        debitNoteType.setID(TypeUtils.buildIDType(nota.getSerie() + "-" + nota.getNumero()));

        // Fechas
        XMLGregorianCalendar issueDate = toGregorianCalendar(datosVentaModel.getFecha().getEmision(), organization.getTimeZone());
        debitNoteType.setIssueDate(TypeUtils.buildIssueDateType(issueDate));

        // Proveedor
        debitNoteType.setAccountingSupplierParty(buildSupplierPartyType(additionalInfo));

        // Cliente
        debitNoteType.setAccountingCustomerParty(buildCustomerPartyType(datosVentaModel.getCliente()));

        // Moneda
        debitNoteType.setDocumentCurrencyCode(TypeUtils.buildDocumentCurrencyCodeType(datosVentaModel.getMoneda().getMoneda()));

        // Totales pagar/descuentos/otros cargos
        debitNoteType.setRequestedMonetaryTotal(buildMonetaryTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal()));

        // Total impuestos IGV/ISC
        debitNoteType.getTaxTotal().addAll(buildTaxTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getImpuestos()));

        // Firma
        debitNoteType.getSignature().add(buildSignatureType(additionalInfo));
        debitNoteType.setUBLExtensions(buildUBLExtensionsType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal().getTotalPagar(), datosVentaModel.getTotalInformacionAdicional()));

        // Observaciones
        debitNoteType.getNote().add(TypeUtils.buildNoteType(datosVentaModel.getObservaciones()));

        // Invoice asociado
        String referenceID = invoiceAfectado.getSerie() + "-" + invoiceAfectado.getNumero();
        String responseCode = nota.getCodigoMotivo();
        String descripcion = datosVentaModel.getObservaciones() != null ? datosVentaModel.getObservaciones() : "Sin observación";

        debitNoteType.getDiscrepancyResponse().add(TypeUtils.buildResponseType(referenceID, responseCode, descripcion));


        BillingReferenceType billingReferenceType = new BillingReferenceType();
        billingReferenceType.setInvoiceDocumentReference(TypeUtils.buildDocumentReferenceType(referenceID, invoiceAfectado.getCodigoTipoComprobante()));
        debitNoteType.getBillingReference().add(billingReferenceType);

        // Detalle
        int i = 1;
        for (DatosVentaDetalleModel detalleModel : datosVentaModel.getDetalle()) {
            debitNoteType.getDebitNoteLine().add(buildDebitNoteLineType(i, datosVentaModel.getMoneda().getMoneda(), detalleModel));
            i++;
        }

        return debitNoteType;
    }

    public static VoidedDocumentsType toVoidedDocumentsType(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BajaModel baja, InvoiceModel invoiceAfectado) {
        sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory factory = new sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory();
        VoidedDocumentsType voidedDocumentsType = factory.createVoidedDocumentsType();

        // General config
        voidedDocumentsType.setUBLVersionID(TypeUtils.buildUBLVersionID("2.0"));
        voidedDocumentsType.setCustomizationID(TypeUtils.buildCustomizationIDType("1.0"));

        // documentId
        voidedDocumentsType.setID(TypeUtils.buildIDType(baja.getSerie() + "-" + baja.getNumero()));

        // Fechas
        XMLGregorianCalendar issueDate = toGregorianCalendar(baja.getFechaEmision(), organization.getTimeZone());
        voidedDocumentsType.setIssueDate(TypeUtils.buildIssueDateType(issueDate));

        // Fecha de emisión del documento relacionado
        Date fechaEmisionDocumentoRelacionado = null;
        Optional<ResumenDiarioModel> resumenDiarioAsociado = invoiceAfectado.getResumenDiario();
        if (resumenDiarioAsociado.isPresent()) {
            fechaEmisionDocumentoRelacionado = resumenDiarioAsociado.get().getIssueDate();
        } else {
            fechaEmisionDocumentoRelacionado = invoiceAfectado.getDatosVenta().getFecha().getEmision();
        }

        XMLGregorianCalendar referenceDate = toGregorianCalendar(fechaEmisionDocumentoRelacionado, organization.getTimeZone());
        voidedDocumentsType.setReferenceDate(TypeUtils.buildReferenceDateType(referenceDate));

        // Proveedor
        voidedDocumentsType.setAccountingSupplierParty(buildSupplierPartyType(additionalInfo));

        // Detalle
        VoidedDocumentsLineType voidedDocumentsLineType = new VoidedDocumentsLineType();

        voidedDocumentsLineType.setLineID(TypeUtils.buildLineIDType("1"));
        voidedDocumentsLineType.setDocumentTypeCode(TypeUtils.buildDocumentTypeCodeType(invoiceAfectado.getCodigoTipoComprobante()));
        voidedDocumentsLineType.setDocumentSerialID(TypeUtils.buildIdentifierType(invoiceAfectado.getSerie()));
        voidedDocumentsLineType.setDocumentNumberID(TypeUtils.buildIdentifierType(String.valueOf(invoiceAfectado.getNumero())));
        voidedDocumentsLineType.setVoidReasonDescription(TypeUtils.buildTextType(baja.getMotivoBaja()));

        return voidedDocumentsType;
    }

    private static XMLGregorianCalendar toGregorianCalendar(Date date, TimeZone zone) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(zone);
            String locale = sdf.format(date);

            return DatatypeFactory.newInstance().newXMLGregorianCalendar(locale);
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static InvoiceType buildInvoiceType(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, InvoiceModel invoice) {
        DatosVentaModel datosVentaModel = invoice.getDatosVenta();

        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        InvoiceType invoiceType = factory.createInvoiceType();

        // General config
        invoiceType.setUBLVersionID(TypeUtils.buildUBLVersionID("2.0"));
        invoiceType.setCustomizationID(TypeUtils.buildCustomizationIDType("1.0"));

        // documentId
        invoiceType.setID(TypeUtils.buildIDType(invoice.getSerie() + "-" + invoice.getNumero()));

        // Fechas
        XMLGregorianCalendar issueDate = toGregorianCalendar(datosVentaModel.getFecha().getEmision(), organization.getTimeZone());
        invoiceType.setIssueDate(TypeUtils.buildIssueDateType(issueDate));
        if (datosVentaModel.getFecha().getVencimiento() != null) {
            XMLGregorianCalendar paymentDate = toGregorianCalendar(datosVentaModel.getFecha().getVencimiento(), organization.getTimeZone());
            invoiceType.getPaymentMeans().add(TypeUtils.buildPaymentMeansType(paymentDate));
        }

        // Proveedor
        invoiceType.setAccountingSupplierParty(buildSupplierPartyType(additionalInfo));

        // Cliente
        invoiceType.setAccountingCustomerParty(buildCustomerPartyType(datosVentaModel.getCliente()));

        // Moneda
        invoiceType.setDocumentCurrencyCode(TypeUtils.buildDocumentCurrencyCodeType(datosVentaModel.getMoneda().getMoneda()));

        // Totales pagar/descuentos/otros cargos
        invoiceType.setLegalMonetaryTotal(buildMonetaryTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal()));

        // Total impuestos IGV/ISC
        invoiceType.getTaxTotal().addAll(buildTaxTotalType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getImpuestos()));

        // Firma
        invoiceType.getSignature().add(buildSignatureType(additionalInfo));
        invoiceType.setUBLExtensions(buildUBLExtensionsType(datosVentaModel.getMoneda().getMoneda(), datosVentaModel.getTotal().getTotalPagar(), datosVentaModel.getTotalInformacionAdicional()));

        // Observaciones
        invoiceType.getNote().add(TypeUtils.buildNoteType(datosVentaModel.getObservaciones()));

        // Detalle
        int i = 1;
        for (DatosVentaDetalleModel detalleModel : datosVentaModel.getDetalle()) {
            invoiceType.getInvoiceLine().add(buildInvoiceLineType(i, datosVentaModel.getMoneda().getMoneda(), detalleModel));
            i++;
        }

        return invoiceType;
    }

    private static SupplierPartyType buildSupplierPartyType(OrganizacionInformacionAdicionalModel model) {
        SupplierPartyType supplierPartyType = new SupplierPartyType();

        // Numero DNI/RUC
        supplierPartyType.setCustomerAssignedAccountID(TypeUtils.buildCustomerAssignedAccountIDType(model.getAssignedId()));

        // Codigo de DNI/RUC
        supplierPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(model.getAdditionalAssignedId()));

        // Party
        PartyType partyType = new PartyType();

        // Party Name
        partyType.getPartyName().add(TypeUtils.buildPartyNameType(model.getNombreComercial()));

        // Party Legal Entity
        partyType.getPartyLegalEntity().add(TypeUtils.buildPartyLegalEntityType(model.getRazonSocial()));

        // Party Address
        AddressType addressType = new AddressType();
        addressType.setID(TypeUtils.buildIDType(model.getCodigoPostal()));
        addressType.setStreetName(TypeUtils.buildStreetNameType(model.getDireccion()));
        addressType.setCitySubdivisionName(TypeUtils.buildCitySubdivisionNameType(model.getProvincia()));
        addressType.setCityName(TypeUtils.buildCityNameType(model.getDistrito()));
        addressType.setCountrySubentity(TypeUtils.buildCountrySubEntityType(model.getRegion()));
        addressType.setCountry(TypeUtils.buildCountryType(model.getCodigoPais()));
        partyType.setPostalAddress(addressType);

        supplierPartyType.setParty(partyType);
        return supplierPartyType;
    }

    private static CustomerPartyType buildCustomerPartyType(ClienteModel cliente) {
        CustomerPartyType customerPartyType = new CustomerPartyType();

        // Numero DNI/RUC
        customerPartyType.setCustomerAssignedAccountID(TypeUtils.buildCustomerAssignedAccountIDType(cliente.getNumeroDocumento()));

        // Código de DNI/RUC
        customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(cliente.getTipoDocumento()));

        // Party
        PartyType partyType = new PartyType();

        // Party Name
        partyType.getPartyName().add(TypeUtils.buildPartyNameType(cliente.getNombre()));

        // Party Legal Entity
        partyType.getPartyLegalEntity().add(TypeUtils.buildPartyLegalEntityType(cliente.getNombre()));

        // Party Address
        AddressType addressType = new AddressType();
        addressType.setStreetName(TypeUtils.buildStreetNameType(cliente.getDireccion()));

        customerPartyType.setParty(partyType);
        return customerPartyType;
    }

    private static MonetaryTotalType buildMonetaryTotalType(String currency, TotalModel total) {
        MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
        monetaryTotalType.setAllowanceTotalAmount(TypeUtils.buildAllowanceTotalAmountType(currency, total.getDescuentoGlobal()));
        monetaryTotalType.setChargeTotalAmount(TypeUtils.buildChargeTotalAmountType(currency, total.getOtrosCargos()));
        monetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(currency, total.getTotalPagar()));
        return monetaryTotalType;
    }

    private static List<TaxTotalType> buildTaxTotalType(String currency, ImpuestosModel impuestos) {
        List<TaxTotalType> result = new ArrayList<>();

        if (impuestos.getIgv() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, impuestos.getIgv()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getIgv(), TipoTributo.IGV));

            result.add(taxTotalType);
        }
        if (impuestos.getIsc() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, impuestos.getIsc()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getIsc(), TipoTributo.ISC));

            result.add(taxTotalType);
        }

        return result;
    }

    private static TaxSubtotalType buildTaxSubtotalType(String currency, BigDecimal value, TipoTributo tipoTributo) {
        TaxSubtotalType taxSubtotalType = new TaxSubtotalType();
        taxSubtotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, value));
        taxSubtotalType.setTaxCategory(TypeUtils.buildTaxCategoryType(tipoTributo.getId(), tipoTributo.getAbreviatura(), tipoTributo.getCodigo()));
        return taxSubtotalType;
    }

    private static ExtensionContentType buildExtensionContentType() {
        return new ExtensionContentType();
    }

    private static UBLExtensionType buildUBLExtensionType() {
        UBLExtensionType ublExtensionType = new UBLExtensionType();
        ublExtensionType.setExtensionContent(buildExtensionContentType());
        return ublExtensionType;
    }

    private static UBLExtensionsType buildUBLExtensionsType(String moneda, BigDecimal totalPagar, TotalInformacionAdicionalModel totalInformacionAdicional) {
        UBLExtensionsType ublExtensionsType = new UBLExtensionsType();

        // Totales
        UBLExtensionType ublExtensionType1 = new UBLExtensionType();
        ExtensionContentType extensionContentType1 = new ExtensionContentType();
        ublExtensionType1.setExtensionContent(extensionContentType1);
        ublExtensionsType.getUBLExtension().add(ublExtensionType1);

        AdditionalInformationType additionalInformationType = buildAdditionalInformationType(moneda, totalPagar, totalInformacionAdicional);

        sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory factory = new sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory();
        JAXBElement<AdditionalInformationType> jaxbElement = factory.createAdditionalInformation(additionalInformationType);

        try {
            Element element = JaxbUtils.marshalToElement(ObjectFactory.class, jaxbElement);
            extensionContentType1.setAny(element);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Firma Digital
        UBLExtensionType ublExtensionType2 = new UBLExtensionType();
        ExtensionContentType extensionContentType2 = new ExtensionContentType();
        ublExtensionType2.setExtensionContent(extensionContentType2);
        ublExtensionsType.getUBLExtension().add(ublExtensionType2);

        return ublExtensionsType;
    }

    private static sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType buildAdditionalInformationType(String moneda, BigDecimal totalPagar, TotalInformacionAdicionalModel totalInformacionAdicional) {
        sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType additionalInformationType = new sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType();

        if (totalInformacionAdicional.getTotalGravado() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalGravado()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }
        if (totalInformacionAdicional.getTotalInafecto() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalInafecto()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }
        if (totalInformacionAdicional.getTotalExonerado() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalExonerado()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }
        if (totalInformacionAdicional.getTotalGratuito() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalGratuito()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }

        // Monto en letras
        AdditionalPropertyType leyendaMontoTexto = new AdditionalPropertyType();
        leyendaMontoTexto.setID(TypeUtils.buildIDType(TipoElementosAdicionalesComprobante.MONTO_EN_LETRAS.getCodigo()));
        leyendaMontoTexto.setValue(TypeUtils.buildValueType(MoneyConverters.SPANISH_BANKING_MONEY_VALUE.asWords(totalPagar)));

        additionalInformationType.getAdditionalProperty().add(leyendaMontoTexto);

        return additionalInformationType;
    }

    private static SignatureType buildSignatureType(OrganizacionInformacionAdicionalModel informacionAdicional) {
        SignatureType signatureType = new SignatureType();

        String signID = "IDSign" + informacionAdicional.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        signatureType.setID(TypeUtils.buildIDType(signID));


        PartyType partyType = new PartyType();
        partyType.getPartyName().add(TypeUtils.buildPartyNameType(informacionAdicional.getNombreComercial()));
        partyType.getPartyIdentification().add(TypeUtils.buildPartyIdentificationType(informacionAdicional.getAssignedId()));

        signatureType.setSignatoryParty(partyType);

        String URI = "#signature" + informacionAdicional.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        AttachmentType attachmentType = new AttachmentType();
        attachmentType.setExternalReference(TypeUtils.buildExternalReferenceType(URI));
        signatureType.setDigitalSignatureAttachment(attachmentType);

        return signatureType;
    }

    private static InvoiceLineType buildInvoiceLineType(int index, String moneda, DatosVentaDetalleModel datosVentaModel) {
        InvoiceLineType invoiceLineType = new InvoiceLineType();

        invoiceLineType.setID(TypeUtils.buildIDType(String.valueOf(index)));
        invoiceLineType.setInvoicedQuantity(TypeUtils.buildInvoicedQuantityType(datosVentaModel.getUnidadMedida(), datosVentaModel.getCantidad()));
        invoiceLineType.setLineExtensionAmount(TypeUtils.buildLineExtensionAmountType(moneda, datosVentaModel.getSubtotal()));
        invoiceLineType.setItem(TypeUtils.buildItemType(datosVentaModel.getDescripcion()));
        invoiceLineType.setPricingReference(buildPricingReferenceType(moneda, datosVentaModel));
        invoiceLineType.setPrice(TypeUtils.buildPriceType(moneda, datosVentaModel.getValorUnitario()));

        if (datosVentaModel.getTotalIgv() != null) {
            invoiceLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIgv(), datosVentaModel.getTipoIgv(), TipoTributo.IGV));
        }
        if (datosVentaModel.getTotalIsc() != null) {
            invoiceLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIsc(), datosVentaModel.getTipoIgv(), TipoTributo.ISC));
        }

        return invoiceLineType;
    }

    private static CreditNoteLineType buildCreditNoteLineType(int index, String moneda, DatosVentaDetalleModel datosVentaModel) {
        CreditNoteLineType creditNoteLineType = new CreditNoteLineType();

        creditNoteLineType.setID(TypeUtils.buildIDType(String.valueOf(index)));
        creditNoteLineType.setCreditedQuantity(TypeUtils.buildCreditedQuantityType((datosVentaModel.getUnidadMedida()), datosVentaModel.getCantidad()));
        creditNoteLineType.setLineExtensionAmount(TypeUtils.buildLineExtensionAmountType(moneda, datosVentaModel.getSubtotal()));
        creditNoteLineType.setItem(TypeUtils.buildItemType(datosVentaModel.getDescripcion()));
        creditNoteLineType.setPricingReference(buildPricingReferenceType(moneda, datosVentaModel));
        creditNoteLineType.setPrice(TypeUtils.buildPriceType(moneda, datosVentaModel.getValorUnitario()));

        if (datosVentaModel.getTotalIgv() != null) {
            creditNoteLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIgv(), datosVentaModel.getTipoIgv(), TipoTributo.IGV));
        }
        if (datosVentaModel.getTotalIsc() != null) {
            creditNoteLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIsc(), datosVentaModel.getTipoIgv(), TipoTributo.ISC));
        }

        return creditNoteLineType;
    }

    private static DebitNoteLineType buildDebitNoteLineType(int index, String moneda, DatosVentaDetalleModel datosVentaModel) {
        DebitNoteLineType debitNoteLineType = new DebitNoteLineType();

        debitNoteLineType.setID(TypeUtils.buildIDType(String.valueOf(index)));
        debitNoteLineType.setDebitedQuantity(TypeUtils.buildDebitedQuantityType((datosVentaModel.getUnidadMedida()), datosVentaModel.getCantidad()));
        debitNoteLineType.setLineExtensionAmount(TypeUtils.buildLineExtensionAmountType(moneda, datosVentaModel.getSubtotal()));
        debitNoteLineType.setItem(TypeUtils.buildItemType(datosVentaModel.getDescripcion()));
        debitNoteLineType.setPricingReference(buildPricingReferenceType(moneda, datosVentaModel));
        debitNoteLineType.setPrice(TypeUtils.buildPriceType(moneda, datosVentaModel.getValorUnitario()));

        if (datosVentaModel.getTotalIgv() != null) {
            debitNoteLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIgv(), datosVentaModel.getTipoIgv(), TipoTributo.IGV));
        }
        if (datosVentaModel.getTotalIsc() != null) {
            debitNoteLineType.getTaxTotal().add(buildTaxTotalType(moneda, datosVentaModel.getTotalIsc(), datosVentaModel.getTipoIgv(), TipoTributo.ISC));
        }

        return debitNoteLineType;
    }

    private static PricingReferenceType buildPricingReferenceType(String moneda, DatosVentaDetalleModel detalleComprobantePagoModel) {
        PricingReferenceType pricingReferenceType = new PricingReferenceType();

        TipoAfectacionIgv tipoAfectacionIgv = TipoAfectacionIgv.searchFromCodigo(detalleComprobantePagoModel.getTipoIgv());
        if (tipoAfectacionIgv.isOperacionNoOnerosa()) {
            pricingReferenceType.getAlternativeConditionPrice().add(
                    TypeUtils.buildPriceType(moneda, BigDecimal.ZERO, TipoPrecioVentaUnitario.PRECIO_UNITARIO.getCodigo())
            );
            pricingReferenceType.getAlternativeConditionPrice().add(
                    TypeUtils.buildPriceType(moneda, detalleComprobantePagoModel.getPrecioUnitario(), TipoPrecioVentaUnitario.VALOR_REF_UNIT_EN_OPER_NO_ORENOSAS.getCodigo())
            );
        } else {
            pricingReferenceType.getAlternativeConditionPrice().add(
                    TypeUtils.buildPriceType(moneda, detalleComprobantePagoModel.getPrecioUnitario(), TipoPrecioVentaUnitario.PRECIO_UNITARIO.getCodigo())
            );
        }

        return pricingReferenceType;
    }

    private static TaxTotalType buildTaxTotalType(String currency, BigDecimal value, String tipoIGV, TipoTributo tipoTributo) {
        TaxTotalType taxTotalType = new TaxTotalType();
        taxTotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, value));
        taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, value, tipoIGV, tipoTributo));
        return taxTotalType;
    }

    private static TaxSubtotalType buildTaxSubtotalType(String currency, BigDecimal value, String tipoIGV, TipoTributo tipoTributo) {
        TaxSubtotalType taxSubtotalType = new TaxSubtotalType();
        taxSubtotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, value));
        taxSubtotalType.setTaxCategory(buildTaxCategoryType(tipoIGV, tipoTributo));
        return taxSubtotalType;
    }

    private static TaxCategoryType buildTaxCategoryType(String tipoIGV, TipoTributo tipoTributo) {
        TaxCategoryType taxCategoryType = new TaxCategoryType();
        taxCategoryType.setTaxScheme(TypeUtils.buildTaxSchemeType(tipoTributo.getId(), tipoTributo.getAbreviatura(), tipoTributo.getCodigo()));
        taxCategoryType.setTaxExemptionReasonCode(TypeUtils.buildTaxExemptionReasonCodeType(tipoIGV));
        return taxCategoryType;
    }


}
