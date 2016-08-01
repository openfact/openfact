package org.openfact.models.admin;

import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.enums.FileExtensionType;
import org.openfact.models.ubl.InvoiceType;

import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public interface AdminStorageInvoiceProvider {
    boolean createInvoice(InvoiceModel invoice,String xmlPath,String validatorPath,String ublVersion,String customizationId, String signatureId,String referenceURI);

    JAXBElement<InvoiceType> unCreateInvoice( String xmlPath);

    boolean signInvoice(String originalXmlPath, String destnSignedXmlPath, String privateKeyPath, String locationJSK, String nameJSK, String passwordJSK, String signatureIdJSK);

    boolean verifySignInvoice(String signedXmlPath,String publicKeyPath);

    boolean createZipInvoice(String signedXmlPath, String zipPath, FileExtensionType fileExtensionType);

    void unZipInvoice();
}
