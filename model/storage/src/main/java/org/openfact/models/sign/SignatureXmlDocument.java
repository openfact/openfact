package org.openfact.models.sign;

import org.openfact.models.key.KeyEncriptation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public class SignatureXmlDocument {
    /* Method used to get the XML document by parsing
    *
            * @param xmlFilePath
    *            , file path of the XML document
    * @return Document
    */
    private Document getXmlDocument(String xmlFilePath) {
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
     * Method used to get the KeyInfo
     *
     * @param xmlSigFactory
     * @param publicKeyPath
     * @return KeyInfo
     */
    private KeyInfo getKeyInfo(XMLSignatureFactory xmlSigFactory, String publicKeyPath) throws KeyStoreException,
            IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        X509Certificate cert = (X509Certificate) new KeyEncriptation().getLlave().getCertificate();

        KeyInfoFactory kif = xmlSigFactory.getKeyInfoFactory();
        List<Serializable> x509Content = new ArrayList<Serializable>();
        x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
        return ki;
    }

    /*
     * Method used to store the signed XMl document
     */
    private void storeSignedDoc(Document doc, String destnSignedXmlFilePath) {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer trans = null;
        try {
            trans = transFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        }
        try {
            StreamResult streamRes = new StreamResult(new File(destnSignedXmlFilePath));
            trans.transform(new DOMSource(doc), streamRes);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
        System.out.println("XML file with attached digital signature generated successfully ...");
    }

    /**
     * Method used to attach a generated digital signature to the existing
     * document
     *
     * @param originalXmlFilePath
     * @param destnSignedXmlFilePath
     * @param privateKeyFilePath
     * @param publicKeyFilePath
     */
    public void generateXMLDigitalSignature(String originalXmlFilePath, String destnSignedXmlFilePath,
                                            String privateKeyFilePath, String publicKeyFilePath) throws KeyStoreException, IOException,
            NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        // Get the XML Document object
        Document doc = getXmlDocument(originalXmlFilePath);
        // Create XML Signature Factory
        XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");
        // PrivateKey privateKey = new
        // KryptoUtil().getStoredPrivateKey(privateKeyFilePath);
        PrivateKey privateKey = new KeyEncriptation().getLlave().getPrivateKey();
        // DOMSignContext domSignCtx = new DOMSignContext(privateKey,
        // doc.getDocumentElement(),
        // doc.getDocumentElement().getFirstChild().getNextSibling().getFirstChild().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNextSibling().getNextSibling());
        DOMSignContext domSignCtx = new DOMSignContext(privateKey,
                doc.getDocumentElement().getFirstChild().getNextSibling().getFirstChild().getNextSibling()
                        .getNextSibling().getNextSibling().getFirstChild().getNextSibling());
        domSignCtx.setDefaultNamespacePrefix("ds");

        Reference ref = null;
        SignedInfo signedInfo = null;
        try {
            ref = xmlSigFactory.newReference("", xmlSigFactory.newDigestMethod(DigestMethod.SHA1, null),
                    Collections.singletonList(
                            xmlSigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                    null, null);
            signedInfo = xmlSigFactory.newSignedInfo(
                    xmlSigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                            (C14NMethodParameterSpec) null),
                    xmlSigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (InvalidAlgorithmParameterException ex) {
            ex.printStackTrace();
        }
        // Pass the Public Key File Path
        KeyInfo keyInfo = getKeyInfo(xmlSigFactory, publicKeyFilePath);
        // Create a new XML Signature
        XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo, null, "SignatureAhren", null);
        try {
            // Sign the document
            xmlSignature.sign(domSignCtx);
        } catch (MarshalException ex) {
            ex.printStackTrace();
        } catch (XMLSignatureException ex) {
            ex.printStackTrace();
        }
        // Store the digitally signed document inta a location
        storeSignedDoc(doc, destnSignedXmlFilePath);
    }
}