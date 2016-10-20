package org.openfact.ubl.pe;

import java.io.File;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.apache.commons.io.FileUtils;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.DocumentUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UblSignature_PE {

	public static Document signUblDocument(OrganizationModel organizacion, Document document) throws Exception {
		String idReference = "Sign" + organizacion.getName().toUpperCase();
		Document newdocument = addUBLExtensions(document);
		Node parentNode = addExtensionContent(newdocument);
		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
		Reference reference = signatureFactory
				.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null),
						Collections.singletonList(
								signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
						null, null);
		SignedInfo signedInfo = signatureFactory.newSignedInfo(
				signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
						(C14NMethodParameterSpec) null),
				signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
				Collections.singletonList(reference));
		KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
		List<X509Certificate> x509Content = new ArrayList();
		x509Content.add(organizacion.getCertificate());
		X509Data xdata = keyInfoFactory.newX509Data(x509Content);
		KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(xdata));

		DOMSignContext signContext = new DOMSignContext(organizacion.getPrivateKey(), newdocument.getDocumentElement());
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
	}

	public static boolean isSignUblDocumentValid(OrganizationModel organization, Document document) throws Exception {
		boolean xmlValid = false;
		NodeList nodeList = document.getElementsByTagName("ds:Signature");
		if (nodeList.getLength() == 0) {
			throw new Exception("No XML Digital Signature Found, document is discarded");
		}
		DOMValidateContext validateContext = new DOMValidateContext(organization.getPublicKey(), nodeList.item(0));
		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
		XMLSignature signature = signatureFactory.unmarshalXMLSignature(validateContext);
		xmlValid = signature.validate(validateContext);
		return xmlValid;
	}

	private static Node addExtensionContent(Document document) {
		NodeList nodeList = document.getDocumentElement().getElementsByTagName("ext:UBLExtensions");
		Node extensions = nodeList.item(0);
		Node content = null;
		if (extensions != null) {
			Node extension = document.createElement("ext:UBLExtension");
			content = document.createElement("ext:ExtensionContent");
			extension.appendChild(content);
			extensions.appendChild(extension);
		}
		return content;
	}

	private static Document addUBLExtensions(Document document) {
		NodeList nodeList = document.getDocumentElement().getElementsByTagName("ext:UBLExtensions");
		Node extensions = nodeList.item(0);
		if (extensions == null) {
			Element element = document.getDocumentElement();
			extensions = document.createElement("ext:UBLExtensions");
			element.appendChild(extensions);
			extensions.appendChild(document.createTextNode("\n"));
			return document;
		} else {
			return document;
		}
	}

}
