package org.openfact.ubl;

import org.apache.commons.validator.routines.EmailValidator;
import org.openfact.email.*;
import org.openfact.models.*;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.SendEventStatus;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.report.ReportTemplateConfiguration;
import org.openfact.report.ReportTemplateProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Arrays;

@Stateless
public class DefaultUBLEmailSender implements UBLEmailSender {

    @Inject
    private EmailTemplateProvider emailTemplateProvider;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private ReportTemplateProvider reportTemplateProvider;

    @Override
    public SendEventModel send(OrganizationModel organization, DocumentModel document, String email, DestinyType destinyType) throws ModelInsuficientData, SendEventException {
        if (email == null || !EmailValidator.getInstance().isValid(email)) {
            throw new ModelInsuficientData("Invalid Email");
        }
        if (organization.getSmtpConfig().size() == 0) {
            throw new ModelInsuficientData("Could not find a valid smtp configuration on organization");
        }

        // User where the email will be send
        EmailUserModel emailUserDestiny = new EmailUserModel(email);

        try {
            // Attatchments
            FileModel xmlFileModel = document.getXmlAsFile();
            EmailFileModel xmlFile = new EmailFileModel(xmlFileModel.getFile(), document.getDocumentId() + ".xml", "application/xml");

            ReportTemplateConfiguration reportConfig = new ReportTemplateConfiguration(organization);
            byte[] bytes = reportTemplateProvider.getReport(reportConfig, document, ExportFormat.PDF);
            EmailFileModel pdfFile = new EmailFileModel(bytes, document.getDocumentId() + ".pdf", "application/pdf");

            // Send Email
            EmailTemplateConfiguration emailConfig = new EmailTemplateConfiguration(organization, emailUserDestiny).setAttachments(Arrays.asList(xmlFile, pdfFile));
            emailTemplateProvider.sendDocument(emailConfig, document);

            // Write event to the database
            SendEventModel sendEvent = document.addSendEvent(destinyType);
            sendEvent.setDescription("Document successfully sended");
            sendEvent.setResult(SendEventStatus.SUCCESS);

            return sendEvent;
        } catch (ReportException e) {
            throw new SendEventException("Could not generate pdf report to attach file", e);
        } catch (EmailException e) {
            throw new SendEventException("Could not send email", e);
        }
    }

}
