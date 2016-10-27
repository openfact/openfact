package org.openfact.ubl.pe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.logging.Logger;
import org.openfact.common.finance.MoneyConverters;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.pe.constants.CodigoConceptosTributarios;
import org.openfact.ubl.pe.constants.CodigoElementosAdicionalesComprobante;
import org.openfact.ubl.pe.constants.CodigoTipoAfectacionIgv;
import org.openfact.ubl.pe.extensions.AdditionalInformationTypeSunatAgg;
import org.openfact.ubl.pe.extensions.AdditionalMonetaryTotalType;
import org.openfact.ubl.pe.extensions.AdditionalPropertyType;
import org.openfact.ubl.pe.extensions.InvoiceFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.helger.ubl21.UBL21Reader;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.ValueType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblExtensionContentGeneratorProvider_PE implements UblExtensionContentGeneratorProvider {

	private static final Logger log = Logger.getLogger(UblExtensionContentGeneratorProvider_PE.class);

	protected OpenfactSession session;

	public UblExtensionContentGeneratorProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}
	@Override
	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, InvoiceModel invoice) {
		try {
			UBLExtensionModel additionalInformation = generateAdditionalInformation(organization, invoice);
			// Result
			return new ArrayList<>(Arrays.asList(additionalInformation));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ModelException("No se pudo generar Ubl extensions PE");
		}
	}

	@Override
	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, CreditNoteModel creditNote) {
		try {
			UBLExtensionModel additiontalInformation = generateAdditionalInformation(organization, creditNote);
			List<UBLExtensionModel> addedUblExtensions = new ArrayList<>();
			addedUblExtensions.addAll(Arrays.asList(additiontalInformation));
			return addedUblExtensions;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ModelException("No se pudo generar Ubl extensions PE");
		}
	}

	@Override
	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, DebitNoteModel debitNote) {
		try {
			UBLExtensionModel additiontalInformation = generateAdditionalInformation(organization, debitNote);
			List<UBLExtensionModel> addedUblExtensions = new ArrayList<>();
			addedUblExtensions.addAll(Arrays.asList(additiontalInformation));
			return addedUblExtensions;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ModelException("No se pudo generar Ubl extensions PE");
		}
	}

	private UBLExtensionModel generateAdditionalInformation(OrganizationModel organization, InvoiceModel invoice) {
		try {
			// Totals
			AdditionalMonetaryTotalType gravado = generateAdditionalInformationSunatTotal(invoice,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS.getCodigo(),

					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_DONACION.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PUBLICIDAD.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_BONIFICACIONES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_IVAP.getCodigo());

			AdditionalMonetaryTotalType inafecto = generateAdditionalInformationSunatTotal(invoice,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS.getCodigo(),

					CodigoTipoAfectacionIgv.INAFECTO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_BONIFICACION.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PUBLICIDAD.getCodigo());

			AdditionalMonetaryTotalType exonerado = generateAdditionalInformationSunatTotal(invoice,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXONERADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.EXONERADO_TRANSFERENCIA_GRATUITA.getCodigo());

			AdditionalMonetaryTotalType gratuito = generateAdditionalInformationSunatTotal(invoice,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXPORTACION.getCodigo());

			// Additional property
			AdditionalPropertyType additionalProperty = generateAdditionalInformationSunatTotal(organization, invoice);

			// Put all in one
			AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
			additionalInformation.getAdditionalMonetaryTotal()
					.addAll(Arrays.asList(gravado, inafecto, exonerado, gratuito));
			additionalInformation.getAdditionalProperty().add(additionalProperty);

			UBLExtensionsModel ublExtensions = invoice.getUBLExtensions();
			UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
			ExtensionContentModel extensionContent = ublExtension.getExtensionContent();
			extensionContent.setAny(generateElement(additionalInformation));

			return ublExtension;
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new ModelException("Invalid marshall");
		}
	}

	private UBLExtensionModel generateAdditionalInformation(OrganizationModel organization,
			CreditNoteModel creditNote) {
		try {
			// Totals
			AdditionalMonetaryTotalType gravado = generateAdditionalInformationSunatTotal(creditNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS.getCodigo(),

					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_DONACION.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PUBLICIDAD.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_BONIFICACIONES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_IVAP.getCodigo());

			AdditionalMonetaryTotalType inafecto = generateAdditionalInformationSunatTotal(creditNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS.getCodigo(),

					CodigoTipoAfectacionIgv.INAFECTO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_BONIFICACION.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PUBLICIDAD.getCodigo());

			AdditionalMonetaryTotalType exonerado = generateAdditionalInformationSunatTotal(creditNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXONERADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.EXONERADO_TRANSFERENCIA_GRATUITA.getCodigo());

			AdditionalMonetaryTotalType gratuito = generateAdditionalInformationSunatTotal(creditNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXPORTACION.getCodigo());

			// Additional property
			AdditionalPropertyType additionalProperty = generateAdditionalInformationSunatTotal(organization,
					creditNote);

			// Put all in one
			AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
			additionalInformation.getAdditionalMonetaryTotal()
					.addAll(Arrays.asList(gravado, inafecto, exonerado, gratuito));
			additionalInformation.getAdditionalProperty().add(additionalProperty);

			UBLExtensionsModel ublExtensions = creditNote.getUBLExtensions();
			UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
			ExtensionContentModel extensionContent = ublExtension.getExtensionContent();
			extensionContent.setAny(generateElement(additionalInformation));

			return ublExtension;
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new ModelException("Invalid marshall");
		}
	}

	private UBLExtensionModel generateAdditionalInformation(OrganizationModel organization, DebitNoteModel debitNote) {
		try {
			// Totals
			AdditionalMonetaryTotalType gravado = generateAdditionalInformationSunatTotal(debitNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS.getCodigo(),

					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_DONACION.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_PUBLICIDAD.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_BONIFICACIONES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_RETIRO_POR_ENTREGA_A_TRABAJADORES.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.GRAVADO_IVAP.getCodigo());

			AdditionalMonetaryTotalType inafecto = generateAdditionalInformationSunatTotal(debitNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS.getCodigo(),

					CodigoTipoAfectacionIgv.INAFECTO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_BONIFICACION.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PREMIO.getCodigo(),
					CodigoTipoAfectacionIgv.INAFECTO_RETIRO_POR_PUBLICIDAD.getCodigo());

			AdditionalMonetaryTotalType exonerado = generateAdditionalInformationSunatTotal(debitNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXONERADO_OPERACION_ONEROSA.getCodigo(),
					CodigoTipoAfectacionIgv.EXONERADO_TRANSFERENCIA_GRATUITA.getCodigo());

			AdditionalMonetaryTotalType gratuito = generateAdditionalInformationSunatTotal(debitNote,
					CodigoConceptosTributarios.TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS.getCodigo(),

					CodigoTipoAfectacionIgv.EXPORTACION.getCodigo());

			// Additional property
			AdditionalPropertyType additionalProperty = generateAdditionalInformationSunatTotal(organization,
					debitNote);

			// Put all in one
			AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
			additionalInformation.getAdditionalMonetaryTotal()
					.addAll(Arrays.asList(gravado, inafecto, exonerado, gratuito));
			additionalInformation.getAdditionalProperty().add(additionalProperty);

			UBLExtensionsModel ublExtensions = debitNote.getUBLExtensions();
			UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
			ExtensionContentModel extensionContent = ublExtension.getExtensionContent();
			extensionContent.setAny(generateElement(additionalInformation));

			return ublExtension;
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new ModelException("Invalid marshall");
		}
	}

	private Element generateElement(AdditionalInformationTypeSunatAgg object) throws JAXBException {
		InvoiceFactory factory = new InvoiceFactory();
		JAXBContext context = JAXBContext.newInstance(InvoiceFactory.class);
		Marshaller marshallerElement = context.createMarshaller();

		JAXBElement<AdditionalInformationTypeSunatAgg> jaxbElement = factory.createAdditionalInformation(object);
		DOMResult res = new DOMResult();
		marshallerElement.marshal(jaxbElement, res);
		Element element = ((Document) res.getNode()).getDocumentElement();
		return element;
	}

	private AdditionalMonetaryTotalType generateAdditionalInformationSunatTotal(InvoiceModel invoice,
			String additionalMonetaryTotalCode, String... taxExemptionReasonCode) {
		String currencyID = invoice.getDocumentCurrencyCode();

		// Get discount percent = allowanceTotalAmmount/total
		// sum(lineExtensionAmount)
		MonetaryTotalModel monetaryTotal = invoice.getLegalMonetaryTotal();
		BigDecimal allowanceTotalAmount = monetaryTotal.getAllowanceTotalAmount() != null
				? monetaryTotal.getAllowanceTotalAmount() : BigDecimal.ZERO;
		BigDecimal discountPercent = allowanceTotalAmount.divide(getTotalLineExtensionAmmount(invoice));

		// Apply discount = sum(lineExtensionAmount) * (1 - discountPercent)
		BigDecimal payableAmountDiscount = getTotalGroupByExemptionReasonCode(invoice, taxExemptionReasonCode);
		payableAmountDiscount = payableAmountDiscount.multiply(BigDecimal.ONE.subtract(discountPercent));
		payableAmountDiscount = payableAmountDiscount.setScale(2, RoundingMode.CEILING);

		// Payable amount
		PayableAmountType payableAmount = new PayableAmountType();
		payableAmount.setCurrencyID(currencyID);
		payableAmount.setValue(payableAmountDiscount);

		AdditionalMonetaryTotalType additionalMonetaryTotal = new AdditionalMonetaryTotalType();
		additionalMonetaryTotal.setID(new IDType(additionalMonetaryTotalCode));
		additionalMonetaryTotal.setPayableAmount(payableAmount);
		return additionalMonetaryTotal;
	}

	private AdditionalMonetaryTotalType generateAdditionalInformationSunatTotal(CreditNoteModel creditNote,
			String additionalMonetaryTotalCode, String... taxExemptionReasonCode) {
		String currencyID = creditNote.getDocumentCurrencyCode();

		// Get discount percent = allowanceTotalAmmount/total
		// sum(lineExtensionAmount)
		MonetaryTotalModel monetaryTotal = creditNote.getLegalMonetaryTotal();
		BigDecimal allowanceTotalAmount = monetaryTotal.getAllowanceTotalAmount() != null
				? monetaryTotal.getAllowanceTotalAmount() : BigDecimal.ZERO;
		BigDecimal discountPercent = allowanceTotalAmount.divide(getTotalLineExtensionAmmount(creditNote));

		// Apply discount = sum(lineExtensionAmount) * (1 - discountPercent)
		BigDecimal payableAmountDiscount = getTotalGroupByExemptionReasonCode(creditNote, taxExemptionReasonCode);
		payableAmountDiscount = payableAmountDiscount.multiply(BigDecimal.ONE.subtract(discountPercent));
		payableAmountDiscount = payableAmountDiscount.setScale(2, RoundingMode.CEILING);

		// Payable amount
		PayableAmountType payableAmount = new PayableAmountType();
		payableAmount.setCurrencyID(currencyID);
		payableAmount.setValue(payableAmountDiscount);

		AdditionalMonetaryTotalType additionalMonetaryTotal = new AdditionalMonetaryTotalType();
		additionalMonetaryTotal.setID(new IDType(additionalMonetaryTotalCode));
		additionalMonetaryTotal.setPayableAmount(payableAmount);
		return additionalMonetaryTotal;
	}

	private AdditionalMonetaryTotalType generateAdditionalInformationSunatTotal(DebitNoteModel debitNote,
			String additionalMonetaryTotalCode, String... taxExemptionReasonCode) {
		String currencyID = debitNote.getDocumentCurrencyCode();

		// Get discount percent = allowanceTotalAmmount/total
		// sum(lineExtensionAmount)
		MonetaryTotalModel monetaryTotal = debitNote.getRequestedMonetaryTotal();
		BigDecimal allowanceTotalAmount = monetaryTotal.getAllowanceTotalAmount() != null
				? monetaryTotal.getAllowanceTotalAmount() : BigDecimal.ZERO;
		BigDecimal discountPercent = allowanceTotalAmount.divide(getTotalLineExtensionAmmount(debitNote));

		// Apply discount = sum(lineExtensionAmount) * (1 - discountPercent)
		BigDecimal payableAmountDiscount = getTotalGroupByExemptionReasonCode(debitNote, taxExemptionReasonCode);
		payableAmountDiscount = payableAmountDiscount.multiply(BigDecimal.ONE.subtract(discountPercent));
		payableAmountDiscount = payableAmountDiscount.setScale(2, RoundingMode.CEILING);

		// Payable amount
		PayableAmountType payableAmount = new PayableAmountType();
		payableAmount.setCurrencyID(currencyID);
		payableAmount.setValue(payableAmountDiscount);

		AdditionalMonetaryTotalType additionalMonetaryTotal = new AdditionalMonetaryTotalType();
		additionalMonetaryTotal.setID(new IDType(additionalMonetaryTotalCode));
		additionalMonetaryTotal.setPayableAmount(payableAmount);
		return additionalMonetaryTotal;
	}

	private AdditionalPropertyType generateAdditionalInformationSunatTotal(OrganizationModel organization,
			InvoiceModel invoice) {
		MoneyConverters converter;
		switch (organization.getDefaultLocale()) {
		case "en":
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		case "es":
			converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
			break;
		default:
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		}
		String valueAsWords = converter.asWords(invoice.getLegalMonetaryTotal().getPayableAmount());

		AdditionalPropertyType additionalProperty = new AdditionalPropertyType();
		additionalProperty.setID(new IDType(CodigoElementosAdicionalesComprobante.MONTO_EN_LETRAS.getCodigo()));
		additionalProperty.setValue(new ValueType(valueAsWords));
		return additionalProperty;
	}

	private AdditionalPropertyType generateAdditionalInformationSunatTotal(OrganizationModel organization,
			CreditNoteModel creditNote) {
		MoneyConverters converter;
		switch (organization.getDefaultLocale()) {
		case "en":
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		case "es":
			converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
			break;
		default:
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		}
		String valueAsWords = converter.asWords(creditNote.getLegalMonetaryTotal().getPayableAmount());

		AdditionalPropertyType additionalProperty = new AdditionalPropertyType();
		additionalProperty.setID(new IDType(CodigoElementosAdicionalesComprobante.MONTO_EN_LETRAS.getCodigo()));
		additionalProperty.setValue(new ValueType(valueAsWords));
		return additionalProperty;
	}

	private AdditionalPropertyType generateAdditionalInformationSunatTotal(OrganizationModel organization,
			DebitNoteModel debitNote) {
		MoneyConverters converter;
		switch (organization.getDefaultLocale()) {
		case "en":
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		case "es":
			converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
			break;
		default:
			converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
			break;
		}
		String valueAsWords = converter.asWords(debitNote.getRequestedMonetaryTotal().getPayableAmount());

		AdditionalPropertyType additionalProperty = new AdditionalPropertyType();
		additionalProperty.setID(new IDType(CodigoElementosAdicionalesComprobante.MONTO_EN_LETRAS.getCodigo()));
		additionalProperty.setValue(new ValueType(valueAsWords));
		return additionalProperty;
	}

	private BigDecimal getTotalLineExtensionAmmount(InvoiceModel invoice) {
		return invoice.getInvoiceLine().stream().map(f -> f.getLineExtensionAmount()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	private BigDecimal getTotalLineExtensionAmmount(CreditNoteModel creditNote) {
		return creditNote.getCreditNoteLine().stream().map(f -> f.getLineExtensionAmount()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	private BigDecimal getTotalLineExtensionAmmount(DebitNoteModel debitNote) {
		return debitNote.getDebitNoteLine().stream().map(f -> f.getLineExtensionAmount()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	private BigDecimal getTotalGroupByExemptionReasonCode(InvoiceModel invoice, String... taxExemptionReasonCode) {
		BigDecimal result = BigDecimal.ZERO;
		List<String> taxExemptionReasonCodes = Arrays.asList(taxExemptionReasonCode);

		for (InvoiceLineModel invoiceLine : invoice.getInvoiceLine()) {
			for (TaxTotalModel taxTotal : invoiceLine.getTaxTotal()) {
				for (TaxSubtotalModel taxSubtotal : taxTotal.getTaxSubtotal()) {
					TaxCategoryModel taxCategory = taxSubtotal.getTaxCategory();
					if (taxExemptionReasonCodes.contains(taxCategory.getTaxExemptionReason())) {
						result = result.add(invoiceLine.getLineExtensionAmount());
					}
				}
			}
		}
		return result;
	}

	private BigDecimal getTotalGroupByExemptionReasonCode(CreditNoteModel creditNote,
			String... taxExemptionReasonCode) {
		BigDecimal result = BigDecimal.ZERO;
		List<String> taxExemptionReasonCodes = Arrays.asList(taxExemptionReasonCode);

		for (CreditNoteLineModel creditNoteLine : creditNote.getCreditNoteLine()) {
			for (TaxTotalModel taxTotal : creditNoteLine.getTaxTotal()) {
				for (TaxSubtotalModel taxSubtotal : taxTotal.getTaxSubtotal()) {
					TaxCategoryModel taxCategory = taxSubtotal.getTaxCategory();
					if (taxExemptionReasonCodes.contains(taxCategory.getTaxExemptionReason())) {
						result = result.add(creditNoteLine.getLineExtensionAmount());
					}
				}
			}
		}
		return result;
	}

	private BigDecimal getTotalGroupByExemptionReasonCode(DebitNoteModel debitNote, String... taxExemptionReasonCode) {
		BigDecimal result = BigDecimal.ZERO;
		List<String> taxExemptionReasonCodes = Arrays.asList(taxExemptionReasonCode);

		for (DebitNoteLineModel debitNoteLine : debitNote.getDebitNoteLine()) {
			for (TaxTotalModel taxTotal : debitNoteLine.getTaxTotal()) {
				for (TaxSubtotalModel taxSubtotal : taxTotal.getTaxSubtotal()) {
					TaxCategoryModel taxCategory = taxSubtotal.getTaxCategory();
					if (taxExemptionReasonCodes.contains(taxCategory.getTaxExemptionReason())) {
						result = result.add(debitNoteLine.getLineExtensionAmount());
					}
				}
			}
		}
		return result;
	}

}
