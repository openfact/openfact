package org.openfact.models.utils;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;

import org.w3c.dom.Document;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class UblSignature {
	private static final String FACTORY = "DOM";
	private static final String PREFIX = "ds";

	/**
	 * Method used to get the KeyInfo
	 */
	private static KeyInfo getKeyInfo(XMLSignatureFactory xmlSigFactory, OrganizationModel organization)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
			UnrecoverableEntryException {
		X509Certificate cert = organization.getCertificate();		
		KeyInfoFactory kif = xmlSigFactory.getKeyInfoFactory();
		List<Serializable> x509Content = new ArrayList<Serializable>();
		x509Content.add(cert.getSubjectX500Principal().getName());
		x509Content.add(cert);
		X509Data xd = kif.newX509Data(x509Content);
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
		return ki;
	}

	/**
	 * Method used to attach a generated digital signature to the existing
	 * document
	 */
	public static Document ublSignatureGenerate(OrganizationModel organization) throws KeyStoreException, IOException,
			NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {

		// Create XML Signature Factory
		XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance(FACTORY);
		PrivateKey privateKey = organization.getPrivateKey();

		Document document = newEmptyDocument();
		DOMSignContext domSignCtx = new DOMSignContext(privateKey, document);
		// DOMSignContext domSignCtx = new DOMSignContext(privateKey,
		// document.getDocumentElement().getFirstChild().getNextSibling().getFirstChild().getNextSibling()
		// .getNextSibling().getNextSibling().getFirstChild().getNextSibling());

		domSignCtx.setDefaultNamespacePrefix(PREFIX);
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
			throw new ModelException("No Such Algorithm");
		} catch (InvalidAlgorithmParameterException ex) {
			throw new ModelException("Invalid Algorithm Parameter");
		}
		KeyInfo keyInfo = getKeyInfo(xmlSigFactory, organization);
		// Create a new XML Signature
		XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo);
		try {
			// Sign the document
			xmlSignature.sign(domSignCtx);
		} catch (MarshalException ex) {
			throw new ModelException("Error in marshal create");
		} catch (XMLSignatureException ex) {
			throw new ModelException("Invalid XMLSignature");
		}
		return document;
	}

	public static Document newEmptyDocument() {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document ret;
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new ModelException("Invalid document create");
		}
		ret = builder.newDocument();
		return ret;
	}
}