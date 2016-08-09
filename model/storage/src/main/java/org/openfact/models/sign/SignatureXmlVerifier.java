package org.openfact.models.sign;

/*
import org.openfact.models.key.KeyEncriptation;
*/

import org.openfact.models.key.KeyStoreEncriptation;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class SignatureXmlVerifier {
    private static final String FACTORY = "DOM";
    private static final String SIGNATURE = "Signature";

    /**
     * Method used to get the XML document object by parsing xml file
     *
     * @param xmlFilePath
     * @return
     */
    private static Document getXmlDocument(String xmlFilePath) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        try {
            doc = dbf.newDocumentBuilder().parse(new FileInputStream(xmlFilePath));
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return doc;
    }

    /**
     * Method used to verify the XML digital signature
     */
    public static boolean isXmlSignatureValid(String signedXmlPath, String pathJSK, String passwordJSK, String signatureIdJSK) throws Exception {
        boolean validFlag = false;
        Document doc = getXmlDocument(signedXmlPath);
        NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, SIGNATURE);
        if (nl.getLength() == 0) {
            throw new Exception("No XML Digital Signature Found, document is discarded");
        }
        /*PublicKey publicKey = new KeyEncriptation().getStoredPublicKey(pubicKeyPath);*/
        PublicKey publicKey = new KeyStoreEncriptation().getPublicKey(pathJSK, passwordJSK, signatureIdJSK);
        DOMValidateContext valContext = new DOMValidateContext(publicKey, nl.item(0));
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance(FACTORY);
        XMLSignature signature = fac.unmarshalXMLSignature(valContext);
        validFlag = signature.validate(valContext);
        return validFlag;
    }
}
