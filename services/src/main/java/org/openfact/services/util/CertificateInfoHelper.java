package org.openfact.services.util;

import java.util.HashMap;

import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.CertificateRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

public class CertificateInfoHelper {

	public static final String PRIVATE_KEY = "private.key";
	public static final String X509CERTIFICATE = "certificate";
	public static final String PUBLIC_KEY = "public.key";

	public static CertificateRepresentation getCertificateFromOrganization(OrganizationModel organization,
			String attributePrefix) {
		String privateKeyAttribute = attributePrefix + "." + PRIVATE_KEY;
		String certificateAttribute = attributePrefix + "." + X509CERTIFICATE;
		String publicKeyAttribute = attributePrefix + "." + PUBLIC_KEY;

		CertificateRepresentation rep = new CertificateRepresentation();
		rep.setCertificate(organization.getAttribute(certificateAttribute));
		rep.setPublicKey(organization.getAttribute(publicKeyAttribute));
		rep.setPrivateKey(organization.getAttribute(privateKeyAttribute));

		return rep;
	}

	public static void updateOrganizationModelCertificateInfo(OrganizationModel organization, CertificateRepresentation rep,
			String attributePrefix) {
		String privateKeyAttribute = attributePrefix + "." + PRIVATE_KEY;
		String certificateAttribute = attributePrefix + "." + X509CERTIFICATE;
		String publicKeyAttribute = attributePrefix + "." + PUBLIC_KEY;

		if (rep.getPublicKey() == null && rep.getCertificate() == null) {
			throw new IllegalStateException("Both certificate and publicKey are null!");
		}

		if (rep.getPublicKey() != null && rep.getCertificate() != null) {
			throw new IllegalStateException("Both certificate and publicKey are not null!");
		}

		setOrRemoveAttr(organization, privateKeyAttribute, rep.getPrivateKey());
		setOrRemoveAttr(organization, publicKeyAttribute, rep.getPublicKey());
		setOrRemoveAttr(organization, certificateAttribute, rep.getCertificate());
	}

	private static void setOrRemoveAttr(OrganizationModel organization, String attrName, String attrValue) {
		if (attrValue != null) {
			organization.setAttribute(attrName, attrValue);
		} else {
			organization.removeAttribute(attrName);
		}
	}

	public static void updateOrganizationRepresentationCertificateInfo(OrganizationRepresentation organization,
			CertificateRepresentation rep, String attributePrefix) {
		String privateKeyAttribute = attributePrefix + "." + PRIVATE_KEY;
		String certificateAttribute = attributePrefix + "." + X509CERTIFICATE;
		String publicKeyAttribute = attributePrefix + "." + PUBLIC_KEY;

		if (rep.getPublicKey() == null && rep.getCertificate() == null) {
			throw new IllegalStateException("Both certificate and publicKey are null!");
		}

		if (rep.getPublicKey() != null && rep.getCertificate() != null) {
			throw new IllegalStateException("Both certificate and publicKey are not null!");
		}

		setOrRemoveAttr(organization, privateKeyAttribute, rep.getPrivateKey());
		setOrRemoveAttr(organization, publicKeyAttribute, rep.getPublicKey());
		setOrRemoveAttr(organization, certificateAttribute, rep.getCertificate());
	}

	private static void setOrRemoveAttr(OrganizationRepresentation organization, String attrName, String attrValue) {
		if (attrValue != null) {
			if (organization.getAttributes() == null) {
				organization.setAttributes(new HashMap<>());
			}
			organization.getAttributes().put(attrName, attrValue);
		} else {
			if (organization.getAttributes() != null) {
				organization.getAttributes().remove(attrName);
			}
		}
	}
}
