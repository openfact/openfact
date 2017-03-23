package org.openfact.ubl;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.openfact.models.KeyManager;
import org.openfact.models.ModelRuntimeException;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.SingleProviderType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Stateless
@SingleProviderType(provider = "ublSigner", value = "default")
public class DefaultUBLSigner implements UBLSigner {

    @Inject
    private KeyManager keystore;

    @Override
    public Document sign(Document document, OrganizationModel organizacion) {
        String idReference = "Sign" + organizacion.getName().toUpperCase();
        Document newdocument = addUBLExtensions(document);
        Node parentNode = addExtensionContent(newdocument);

        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
        try {
            Reference reference = signatureFactory.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null),
                    Collections.singletonList(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);

            SignedInfo signedInfo = signatureFactory.newSignedInfo(
                    signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                    signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));

            KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
            List<X509Certificate> x509Content = new ArrayList<>();

            // Certificate
            x509Content.add(keystore.getActiveRsaKey(organizacion).getCertificate());
            X509Data xdata = keyInfoFactory.newX509Data(x509Content);
            KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(xdata));

            DOMSignContext signContext = new DOMSignContext(keystore.getActiveRsaKey(organizacion).getPrivateKey(), newdocument.getDocumentElement());
            XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
            if (parentNode != null) {
                signContext.setParent(parentNode);
            }
            signContext.setDefaultNamespacePrefix("ds");
            signature.sign(signContext);
            Element elementParent = (Element) signContext.getParent();
            if ((idReference != null) && (elementParent.getElementsByTagName("ds:Signature") != null)) {
                Element elementSignature = (Element) elementParent.getElementsByTagName("ds:Signature").item(0);
                elementSignature.setAttribute("Id", idReference);
            }
            return newdocument;
        } catch (NoSuchAlgorithmException e) {
            throw new ModelRuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new ModelRuntimeException(e);
        } catch (MarshalException e) {
            throw new ModelRuntimeException(e);
        } catch (XMLSignatureException e) {
            throw new ModelRuntimeException(e);
        }
    }

    private static Document addUBLExtensions(Document document) {
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("cec:UBLExtensions");
        Node extensions = nodeList.item(0);
        if (extensions == null) {
            Element element = document.getDocumentElement();
            extensions = document.createElement("cec:UBLExtensions");
            element.appendChild(extensions);
            extensions.appendChild(document.createTextNode("\n"));
            return document;
        } else {
            return document;
        }
    }

    private static Node addExtensionContent(Document document) {
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("cec:UBLExtensions");
        Node extensions = nodeList.item(0);
        Node content = null;
        if (extensions != null) {
            Node extension = document.createElement("cec:UBLExtension");
            content = document.createElement("cec:ExtensionContent");
            extension.appendChild(content);
            extensions.appendChild(extension);
        }
        return content;
    }

}
