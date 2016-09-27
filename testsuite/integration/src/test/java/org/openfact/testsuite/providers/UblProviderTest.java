package org.openfact.testsuite.providers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.error.list.IErrorList;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblProviderTest extends AbstractProviderTest {

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        commit();
    }

    @Test
    public void getDocument() throws Exception {
        createOrganization();

        InvoiceModel invoice = session.invoices().addInvoice(organization, "F001-0001");
        invoice.setUBLVersionID("2.0");
        invoice.setCustomizationID("1.0");

        invoice.setID("F001-0001");
        invoice.setIssueDate(LocalDate.now());
        invoice.setInvoiceTypeCode("01");
        invoice.setDocumentCurrencyCode("PEN");

        // signature
        SignatureModel signature = invoice.addSignature();
        signature.setID("IDSignOlva");

        PartyModel partySignature = signature.getSignatoryParty();
        partySignature.getPartyIdentification().add("20494637074");
        partySignature.getPartyName().add("AHREN CONTRATISTAS GENERALES S.A.C");

        AttachmentModel attachment = signature.getDigitalSignatureAttachment();

        ExternalReferenceModel externalReference = attachment.getExternalReference();
        externalReference.setURI("#SignatureOlva");

        // SupplierParty
        SupplierPartyModel supplierParty = invoice.getAccountingSupplierParty();
        supplierParty.setCustomerAssignedAccountID("20494637074");
        supplierParty.getAdditionalAccountID().add("6");

        PartyModel partySupplier = supplierParty.getParty();

        AddressModel address = partySupplier.getPostalAddress();
        address.setID("050101");
        address.setStreetName("MZA. A LOTE. 3");
        address.setCitySubdivisionName("ASOC. SANTA TERESA");
        address.setCityName("AYACUCHO");
        address.setCountrySubentity("HUAMANGA");
        address.setDistrict("AYACUCHO");
        address.getCountry().setIdentificationCode("PE");

        PartyLegalModel partyLegalSupplier = partySupplier.addPartyLegalEntity();
        partyLegalSupplier.setRegistrationName("SISTCOOP S.A.C");

        // CustomerParty
        CustomerPartyModel customerParty = invoice.getAccountingCustomerParty();
        customerParty.setCustomerAssignedAccountID("20407446497");
        customerParty.getAdditionalAccountID().add("6");

        PartyModel partyCustomer = customerParty.getParty();

        PartyLegalModel partyLegalCustomer = partyCustomer.addPartyLegalEntity();
        partyLegalCustomer.setRegistrationName("AHREN CONTRATISTAS");

        // TaxTotal
        TaxTotalModel taxTotalInvoice = invoice.addTaxTotal();
        taxTotalInvoice.setTaxAmount(new BigDecimal("62675.85"));

        TaxSubtotalModel taxSubtotalInvoice = taxTotalInvoice.addTaxSubtotal();
        taxSubtotalInvoice.setTaxAmount(new BigDecimal("62675.85"));

        TaxCategoryModel taxCategoryInvoice = taxSubtotalInvoice.getTaxCategory();

        TaxSchemeModel taxSchemeInvoice = taxCategoryInvoice.getTaxScheme();
        taxSchemeInvoice.setID("1000");
        taxSchemeInvoice.setName("IGV");
        taxSchemeInvoice.setTaxTypeCode("VAT");

        // LegalMonetaryTotal
        MonetaryTotalModel monetaryTotal = invoice.getLegalMonetaryTotal();
        monetaryTotal.setPayableAmount(new BigDecimal("423225.00"));

        // InvoiceLine
        InvoiceLineModel invoiceLine = invoice.addInvoiceLine();
        invoiceLine.setID("1");

        QuantityModel quantity = invoiceLine.getInvoicedQuantity();
        quantity.setUnitCode("NIU");
        quantity.setValue(new BigDecimal("2000"));

        invoiceLine.setLineExtensionAmount(new BigDecimal("149491.53"));

        PricingReferenceModel pricingReference = invoiceLine.getPricingReference();

        PriceModel price = pricingReference.addAlternativeConditionPrice();
        price.setPriceAmount(new BigDecimal("98.00"));
        price.setPriceTypeCode("01");

        TaxTotalModel taxTotalInvoiceLine = invoiceLine.addTaxTotal();
        taxTotalInvoiceLine.setTaxAmount(new BigDecimal("26908.47"));

        TaxSubtotalModel taxSubtotalInvoiceLine = taxTotalInvoiceLine.addTaxSubtotal();
        taxSubtotalInvoiceLine.setTaxAmount(new BigDecimal("26908.47"));

        TaxCategoryModel taxCategoryInvoiceLine = taxSubtotalInvoiceLine.getTaxCategory();
        taxCategoryInvoiceLine.setTaxExemptionReasonCode("10");

        TaxSchemeModel taxSchemeInvoiceLine = taxCategoryInvoiceLine.getTaxScheme();
        taxSchemeInvoiceLine.setID("1000");
        taxSchemeInvoiceLine.setName("IGV");
        taxSchemeInvoiceLine.setTaxTypeCode("VAT");

        ItemModel item = invoiceLine.getItem();
        item.getDescription().add("Grabadora LG Externo Modelo: GE20LU10");

        ItemIdentificationModel itemIdentification = item.getSellersItemIdentification();
        itemIdentification.setID("GLG199");
        invoiceLine.getPrice().setPriceAmount(new BigDecimal("83.05"));

        commit();

        Set<UblProvider> providers = session.getAllProviders(UblProvider.class);
        for (UblProvider provider : providers) {
            Document xml = provider.getDocument(organization, invoice);
            InvoiceType invoiceType = UBL21Reader.invoice().read(xml);
            IErrorList resourceErrorGroup = UBL21Validator.invoice().validate(invoiceType);

            UBL21Writer.invoice().write(invoiceType, new File("/home/admin/carlos.xml"));
            assertThat(xml, is(notNullValue()));
            assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
        }
    }

}
