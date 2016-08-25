package org.openfact.services.managers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.models.DocumentModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SimpleDocumentModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.InvoiceAdditionalInformationRepresentation;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceLineTotalTaxRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.InvoiceTaxTotalRepresentation;

public class ApplianceBootstrap {

    private static final Logger logger = Logger.getLogger(ApplianceBootstrap.class);
    private final OpenfactSession session;

    public ApplianceBootstrap(OpenfactSession session) {
        this.session = session;
    }

    public boolean isNewInstall() {
        if (session.organizations().getOrganizations().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createMasterOrganization(String contextPath) {
        if (!isNewInstall()) {
            throw new IllegalStateException("Can't create default organization as organizations already exists");
        }

        String adminOrganizationName = Config.getAdminOrganization();
        logger.info("Initializing Admin Organization " + adminOrganizationName);

        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(contextPath);
        OrganizationModel organization = manager.createOrganization(adminOrganizationName, adminOrganizationName);
        organization.setName(adminOrganizationName);
        organization.setEnabled(true);
        
        return true;
    }

    @Deprecated
    public void createTestOrganization() {
        OrganizationManager manager = new OrganizationManager(session);
        OrganizationModel organization = manager.createOrganization("test", "test");
        organization.setName("test");
        organization.setEnabled(true);       
    }

    @Deprecated
    public void createTestInvoices(OrganizationModel organization) {
        DocumentModel additionalAccount = organization.getDocumentByTymeAndName(DocumentType.ADDITIONAL_INFORMATION, "RUC");
        organization.setAdditionalAccountId((SimpleDocumentModel) additionalAccount);

        for (int i = 0; i < 100; i++) {
            Set<InvoiceAdditionalInformationRepresentation> additionalInformationRep1 = new HashSet<>();
            additionalInformationRep1.add(new InvoiceAdditionalInformationRepresentation("GRAVADO", new BigDecimal( (double) Math.round(Math.random() * Math.random() * 1000) / 100)));
            additionalInformationRep1.add(new InvoiceAdditionalInformationRepresentation("EXONERADO", new BigDecimal( (double) Math.round(Math.random() * Math.random() * 1000) / 100)));
            additionalInformationRep1.add(new InvoiceAdditionalInformationRepresentation("INAFECTO", new BigDecimal( (double) Math.round(Math.random() * Math.random() * 1000) / 100)));

            CustomerRepresentation customerRep1 = new CustomerRepresentation();
            customerRep1.setAdditionalIdentificationId("RUC");
            customerRep1.setAssignedIdentificationId("12345678910");
            customerRep1.setEmail("algo@domain.com");
            customerRep1.setRegistrationName("Joan Michael");

            Set<InvoiceTaxTotalRepresentation> totalTaxsRep1 = new HashSet<>();
            totalTaxsRep1.add(new InvoiceTaxTotalRepresentation("IGV", BigDecimal.ZERO, BigDecimal.TEN));
            totalTaxsRep1.add(new InvoiceTaxTotalRepresentation("ISC", BigDecimal.ZERO, BigDecimal.TEN));

            List<InvoiceLineRepresentation> lines = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Set<InvoiceLineTotalTaxRepresentation> lineTotalTaxs = new HashSet<>();
                lineTotalTaxs.add(new InvoiceLineTotalTaxRepresentation("GRAVADO", "Retiro por premio", BigDecimal.ZERO));
                lineTotalTaxs.add(new InvoiceLineTotalTaxRepresentation("INAFECTO", "Retiro por premio", BigDecimal.ZERO));
                lineTotalTaxs.add(new InvoiceLineTotalTaxRepresentation("EXONERADO", "Operacion por onerosa", BigDecimal.ZERO));

                InvoiceLineRepresentation line = new InvoiceLineRepresentation();
                line.setAllowanceCharge(BigDecimal.ONE);
                line.setAmount(BigDecimal.ZERO);
                line.setItemDescription("fdsfsd");
                line.setItemIdentification("sdfdsf");
                line.setOrderNumber(j);
                line.setPrice(BigDecimal.ONE);
                line.setQuantity(BigDecimal.ONE);
                line.setUnitCode("kg");
                line.setTotalTaxs(lineTotalTaxs);
            }

            InvoiceRepresentation rep1 = new InvoiceRepresentation();
            rep1.setAdditionalInformation(additionalInformationRep1);
            rep1.setAllowanceTotalAmount(new BigDecimal("123"));
            rep1.setChargeTotalAmount(new BigDecimal("123"));
            rep1.setCurrencyCode("PEN");
            rep1.setCustomer(customerRep1);
            rep1.setIssueDate(LocalDate.now());
            rep1.setLines(lines);
            rep1.setPayableAmount(new BigDecimal("123"));
            rep1.setTotalTaxs(totalTaxsRep1);
            rep1.setType("RUC");

            InvoiceModel invoice = session.invoices().addInvoice(organization);
            RepresentationToModel.updateInvoice(rep1, Collections.emptySet(), invoice, session, true);
            
            logger.info("Invoice temp created: " + invoice.getId());
        }
    }

}
