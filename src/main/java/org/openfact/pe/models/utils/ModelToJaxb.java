package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.*;
import org.openfact.pe.utils.finance.MoneyConverters;
import org.w3c.dom.Element;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalMonetaryTotalType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalPropertyType;
import sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.util.*;

public class ModelToJaxb {

    private ModelToJaxb() {
        // Just util class
    }

    public static InvoiceType toBoletaType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, BoletaModel boleta, X509Certificate certificate) {
        InvoiceType invoiceType = buildInvoiceType(organization, informacionAdicional, boleta, certificate);
        invoiceType.setInvoiceTypeCode(TypeUtils.buildInvoiceTypeCodeType(TipoInvoice.BOLETA.getCodigo()));

        return invoiceType;
    }

    public static InvoiceType toFacturaType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura, X509Certificate certificate) {
        InvoiceType invoiceType = buildInvoiceType(organization, informacionAdicional, factura, certificate);
        invoiceType.setInvoiceTypeCode(TypeUtils.buildInvoiceTypeCodeType(TipoInvoice.FACTURA.getCodigo()));

        return invoiceType;
    }

    private static XMLGregorianCalendar toGregorianCalendar(Date date, TimeZone zone) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.setTimeZone(zone);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static InvoiceType buildInvoiceType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, AbstractInvoiceModel invoiceModel, X509Certificate certificate) {
        InvoiceType invoiceType = new InvoiceType();

        // General config
        invoiceType.setUBLVersionID(TypeUtils.buildUBLVersionID("2.0"));
        invoiceType.setCustomizationID(TypeUtils.buildCustomizationIDType("1.0"));

        // documentId
        invoiceType.setID(TypeUtils.buildIDType(invoiceModel.getSerie() + invoiceModel.getNumero()));

        // Fechas
        XMLGregorianCalendar issueDate = toGregorianCalendar(invoiceModel.getFecha().getEmision(), organization.getTimeZone());
        invoiceType.setIssueDate(TypeUtils.buildIssueDateType(issueDate));
        if (invoiceModel.getFecha().getVencimiento() != null) {
            XMLGregorianCalendar paymentDate = toGregorianCalendar(invoiceModel.getFecha().getVencimiento(), organization.getTimeZone());
            invoiceType.getPaymentMeans().add(TypeUtils.buildPaymentMeansType(paymentDate));
        }

        // Proveedor
        invoiceType.setAccountingSupplierParty(buildSupplierPartyType(informacionAdicional));

        // Cliente
        invoiceType.setAccountingCustomerParty(buildCustomerPartyType(invoiceModel.getCliente()));

        // Moneda
        invoiceType.setDocumentCurrencyCode(TypeUtils.buildDocumentCurrencyCodeType(invoiceModel.getMoneda().getMoneda()));

        // Totales pagar/descuentos/otros cargos
        invoiceType.setLegalMonetaryTotal(buildMonetaryTotalType(invoiceModel.getMoneda().getMoneda(), invoiceModel.getTotal()));

        // Total impuestos IGV/ISC
        invoiceType.getTaxTotal().addAll(buildTaxTotalType(invoiceModel.getMoneda().getMoneda(), invoiceModel.getImpuestos()));

        // Firma
        invoiceType.getSignature().add(buildSignatureType(informacionAdicional));
        invoiceType.setUBLExtensions(buildUBLExtensionsType(invoiceModel, certificate));

        // Observaciones
        invoiceType.getNote().add(TypeUtils.buildNoteType(invoiceModel.getObservaciones()));

        // Detalle
        int i = 1;
        for (DetalleComprobantePagoModel detalleModel : invoiceModel.getDetalle()) {
            invoiceType.getInvoiceLine().add(buildInvoiceLineType(i, invoiceModel.getMoneda().getMoneda(), detalleModel));
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
        switch (cliente.getTipoDocumento()) {
            case DOC_TRIB_NO_DOM_SIN_RUC:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.DOC_TRIB_NO_DOM_SIN_RUC.getCodigo()));
                break;
            case DNI:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.DNI.getCodigo()));
                break;
            case EXTRANJERIA:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.EXTRANJERIA.getCodigo()));
                break;
            case RUC:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.RUC.getCodigo()));
                break;
            case PASAPORTE:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.PASAPORTE.getCodigo()));
                break;
            case DEC_DIPLOMATICA:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.DEC_DIPLOMATICA.getCodigo()));
                break;
            case NO_IDENTIFICADO_EXPORTACION:
                customerPartyType.getAdditionalAccountID().add(TypeUtils.buildAdditionalAccountIDType(TipoDocumentoEntidad.NO_IDENTIFICADO_EXPORTACION.getCodigo()));
                break;
            default:
                throw new IllegalStateException("Tipo de documento invalido en customer");
        }

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

        if (impuestos.getIGV() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, impuestos.getIGV()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getIGV(), TipoTributo.IGV));

            result.add(taxTotalType);
        }
        if (impuestos.getISC() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(TypeUtils.buildTaxAmountType(currency, impuestos.getISC()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getISC(), TipoTributo.ISC));

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

    private static UBLExtensionsType buildUBLExtensionsType(AbstractInvoiceModel invoiceModel, X509Certificate certificate) {
        UBLExtensionsType ublExtensionsType = new UBLExtensionsType();

        // Totales
        UBLExtensionType ublExtensionType = new UBLExtensionType();
        ExtensionContentType extensionContentType = new ExtensionContentType();
        ublExtensionType.setExtensionContent(extensionContentType);
        ublExtensionsType.getUBLExtension().add(ublExtensionType);

        AdditionalInformationType additionalInformationType = buildAdditionalInformationType(invoiceModel);

        sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory factory = new sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.ObjectFactory();
        JAXBElement<AdditionalInformationType> jaxbElement = factory.createAdditionalInformation(additionalInformationType);

        try {
            Element element = JaxbUtils.marshalToElement(ObjectFactory.class, jaxbElement);
            extensionContentType.setAny(element);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Firma Digital
//        ublExtensionsType.getUBLExtension().add();
//
//        UBLExtensionType ublExtensionType = new UBLExtensionType();
//        ublExtensionType.setExtensionContent();
//
//        ExtensionContentType extensionContentType = new ExtensionContentType();
//        extensionContentType.setAny();


        return ublExtensionsType;
    }

    private static sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType buildAdditionalInformationType(AbstractInvoiceModel invoiceModel) {
        sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType additionalInformationType = new sunat.names.specification.ubl.peru.schema.xsd.sunataggregatecomponents_1.AdditionalInformationType();

        String moneda = invoiceModel.getMoneda().getMoneda();
        TotalInformacionAdicionalModel totalInformacionAdicional = invoiceModel.getTotalInformacionAdicional();

        if (totalInformacionAdicional.getTotalExonerado() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalGravado()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }
        if (totalInformacionAdicional.getTotalGratuito() != null) {
            AdditionalMonetaryTotalType additionalMonetaryTotalType = new AdditionalMonetaryTotalType();
            additionalMonetaryTotalType.setID(TypeUtils.buildIDType(TipoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS.getCodigo()));
            additionalMonetaryTotalType.setPayableAmount(TypeUtils.buildPayableAmountType(moneda, totalInformacionAdicional.getTotalGratuito()));

            additionalInformationType.getAdditionalMonetaryTotal().add(additionalMonetaryTotalType);
        }
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


        // Monto en letras
        AdditionalPropertyType leyendaMontoTexto = new AdditionalPropertyType();
        leyendaMontoTexto.setID(TypeUtils.buildIDType(TipoElementosAdicionalesComprobante.MONTO_EN_LETRAS.getCodigo()));
        leyendaMontoTexto.setValue(TypeUtils.buildValueType(MoneyConverters.SPANISH_BANKING_MONEY_VALUE.asWords(invoiceModel.getTotal().getTotalPagar())));

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

    private static InvoiceLineType buildInvoiceLineType(int index, String moneda, DetalleComprobantePagoModel detalleComprobantePagoModel) {
        InvoiceLineType invoiceLineType = new InvoiceLineType();

        invoiceLineType.setID(TypeUtils.buildIDType(String.valueOf(index)));
        invoiceLineType.setInvoicedQuantity(TypeUtils.buildInvoicedQuantityType(detalleComprobantePagoModel.getUnidadMedida(), detalleComprobantePagoModel.getCantidad()));
        invoiceLineType.setLineExtensionAmount(TypeUtils.buildLineExtensionAmountType(moneda, detalleComprobantePagoModel.getSubtotal()));
        invoiceLineType.setItem(TypeUtils.buildItemType(detalleComprobantePagoModel.getDescripcion()));
        invoiceLineType.setPricingReference(buildPricingReferenceType(moneda, detalleComprobantePagoModel));
        invoiceLineType.setPrice(TypeUtils.buildPriceType(moneda, detalleComprobantePagoModel.getValorUnitario()));

        if (detalleComprobantePagoModel.getTotalIGV() != null) {
            invoiceLineType.getTaxTotal().add(buildTaxTotalType(moneda, detalleComprobantePagoModel.getTotalIGV(), detalleComprobantePagoModel.getTipoIGV(), TipoTributo.IGV));
        }
        if (detalleComprobantePagoModel.getTotalISC() != null) {
            invoiceLineType.getTaxTotal().add(buildTaxTotalType(moneda, detalleComprobantePagoModel.getTotalISC(), detalleComprobantePagoModel.getTipoIGV(), TipoTributo.ISC));
        }

        return invoiceLineType;
    }

    private static PricingReferenceType buildPricingReferenceType(String moneda, DetalleComprobantePagoModel detalleComprobantePagoModel) {
        PricingReferenceType pricingReferenceType = new PricingReferenceType();

        TipoAfectacionIgv tipoAfectacionIgv = TipoAfectacionIgv.searchFromCodigo(detalleComprobantePagoModel.getTipoIGV());
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
