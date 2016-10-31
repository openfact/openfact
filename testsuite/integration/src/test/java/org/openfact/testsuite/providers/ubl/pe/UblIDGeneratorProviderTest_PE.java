package org.openfact.testsuite.providers.ubl.pe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.testsuite.providers.AbstractProviderTest;
import org.openfact.ubl.UblIDGeneratorProvider;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;

public class UblIDGeneratorProviderTest_PE extends AbstractProviderTest {

    public static final String LOCALE = "pe";

    protected OrganizationModel organization;

    public void createOrganization() {
        OrganizationProvider provider = session.organizations();
        organization = provider.createOrganization("SISTCOOP");
        organization.setDefaultUblLocale(LOCALE);
        commit();
    }

    @Test
    public void createInvoiceFacturaWithoutSeriesAndNumber() throws Exception {
        createOrganization();

        String idInvoice1, idInvoice2;
        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        // Try to create invoice with incorrect code
        try {
            idInvoice1 = provider.generateInvoiceID(organization, "XX");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelException e) {
        }
        idInvoice1 = provider.generateInvoiceID(organization, CodigoTipoDocumento.FACTURA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice1);

        idInvoice2 = provider.generateInvoiceID(organization, CodigoTipoDocumento.FACTURA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice2);
        commit();

        assertThat(idInvoice1, is("F001-00000001"));
        assertThat(idInvoice2, is("F001-00000002"));
    }

    @Test
    public void createInvoiceFacturaWithoutSeriesAndNumberAndPreviousData() throws Exception {
        createOrganization();

        // Previous data
        session.invoices().addInvoice(organization, "F01-001");
        session.invoices().addInvoice(organization, "X001-00000001");
        session.invoices().addInvoice(organization, "F123-99999999");

        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        String idInvoice1 = provider.generateInvoiceID(organization, CodigoTipoDocumento.FACTURA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice1);
        commit();

        assertThat(idInvoice1, is("F124-00000001"));
    }
    
    @Test
    public void createInvoiceBoletaWithoutSeriesAndNumber() throws Exception {
        createOrganization();

        String idInvoice1, idInvoice2;
        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        // Try to create invoice with incorrect code
        try {
            idInvoice1 = provider.generateInvoiceID(organization, "XX");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelException e) {
        }
        idInvoice1 = provider.generateInvoiceID(organization, CodigoTipoDocumento.BOLETA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice1);

        idInvoice2 = provider.generateInvoiceID(organization, CodigoTipoDocumento.BOLETA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice2);
        commit();

        assertThat(idInvoice1, is("B001-00000001"));
        assertThat(idInvoice2, is("B001-00000002"));
    }

    @Test
    public void createInvoiceBoletaWithoutSeriesAndNumberAndPreviousData() throws Exception {
        createOrganization();

        // Previous data
        session.invoices().addInvoice(organization, "B01-001");
        session.invoices().addInvoice(organization, "X001-00000001");
        session.invoices().addInvoice(organization, "B123-99999999");

        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        String idInvoice1 = provider.generateInvoiceID(organization, CodigoTipoDocumento.BOLETA.getCodigo());
        session.invoices().addInvoice(organization, idInvoice1);
        commit();

        assertThat(idInvoice1, is("B124-00000001"));
    }

    @Test
    public void createCreditNoteWithoutSeriesAndNumber() throws Exception {
        createOrganization();

        String idCreditNote1, idCreditNote2;
        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        // Try to create credit note with incorrect code
        try {
            idCreditNote1 = provider.generateCreditNoteID(organization, "XX");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelException e) {
        }
        idCreditNote1 = provider.generateCreditNoteID(organization, "F001-000000001");
        session.creditNotes().addCreditNote(organization, idCreditNote1);

        idCreditNote2 = provider.generateCreditNoteID(organization, "B001-000000001");
        session.creditNotes().addCreditNote(organization, idCreditNote2);
        commit();

        assertThat(idCreditNote1, is("FC01-00000001"));
        assertThat(idCreditNote2, is("BC01-00000001"));
    }

    @Test
    public void createCreditNoteWithoutSeriesAndNumberAndPreviousData() throws Exception {
        createOrganization();

        // Previous data
        session.creditNotes().addCreditNote(organization, "FC01-001");
        session.creditNotes().addCreditNote(organization, "FX01-00000001");
        session.creditNotes().addCreditNote(organization, "FC23-99999999");
        
        session.creditNotes().addCreditNote(organization, "BC01-001");
        session.creditNotes().addCreditNote(organization, "BX01-00000001");
        session.creditNotes().addCreditNote(organization, "BC23-99999999");

        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        String idCreditNote1 = provider.generateCreditNoteID(organization, "F001-000000001");
        session.creditNotes().addCreditNote(organization, idCreditNote1);
        String idCreditNote2 = provider.generateCreditNoteID(organization, "B001-000000001");
        session.creditNotes().addCreditNote(organization, idCreditNote2);        
        commit();

        assertThat(idCreditNote1, is("FC24-00000001"));
        assertThat(idCreditNote2, is("BC24-00000001"));
    }
    
    @Test
    public void createDebitNoteWithoutSeriesAndNumber() throws Exception {
        createOrganization();

        String idDebitNote1, idDebitNote2;
        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        // Try to create debit note with incorrect code
        try {
            idDebitNote1 = provider.generateDebitNoteID(organization, "XX");
            commit();
            Assert.fail("Expected exception");
        } catch (ModelException e) {
        }
        idDebitNote1 = provider.generateDebitNoteID(organization, "F001-000000001");
        session.debitNotes().addDebitNote(organization, idDebitNote1);

        idDebitNote2 = provider.generateDebitNoteID(organization, "B001-000000001");
        session.debitNotes().addDebitNote(organization, idDebitNote2);
        commit();

        assertThat(idDebitNote1, is("FD01-00000001"));
        assertThat(idDebitNote2, is("BD01-00000001"));
    }

    @Test
    public void createDebitNoteWithoutSeriesAndNumberAndPreviousData() throws Exception {
        createOrganization();

        // Previous data
        session.debitNotes().addDebitNote(organization, "FD01-001");
        session.debitNotes().addDebitNote(organization, "FX01-00000001");
        session.debitNotes().addDebitNote(organization, "FD23-99999999");
        
        session.debitNotes().addDebitNote(organization, "BD01-001");
        session.debitNotes().addDebitNote(organization, "BX01-00000001");
        session.debitNotes().addDebitNote(organization, "BD23-99999999");

        UblIDGeneratorProvider provider = session.getProvider(UblIDGeneratorProvider.class, LOCALE);

        String idDebitNote1 = provider.generateDebitNoteID(organization, "F001-000000001");
        session.creditNotes().addCreditNote(organization, idDebitNote1);
        String idDebitNote2 = provider.generateDebitNoteID(organization, "B001-000000001");
        session.creditNotes().addCreditNote(organization, idDebitNote2);        
        commit();

        assertThat(idDebitNote1, is("FD24-00000001"));
        assertThat(idDebitNote2, is("BD24-00000001"));
    }

}
