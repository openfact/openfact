package org.openfact.models.utils;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.UUID;

import org.bouncycastle.openssl.PEMWriter;
import org.openfact.common.util.Base64Url;
import org.openfact.common.util.CertificateUtils;
import org.openfact.common.util.PemUtils;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.CertificateRepresentation;

public final class OpenfactModelUtils {

	private OpenfactModelUtils() {
	}

	public static String generateId() {
		return UUID.randomUUID().toString();
	}

	public static String generateSecret() {
		return generateSecret(32);
	}

	public static String generateSecret(int bytes) {
		byte[] buf = new byte[bytes];
		new SecureRandom().nextBytes(buf);
		return Base64Url.encode(buf);
	}

	public static PublicKey getPublicKey(String publicKeyPem) {
		if (publicKeyPem != null) {
			try {
				return PemUtils.decodePublicKey(publicKeyPem);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			return null;
		}
	}

	public static X509Certificate getCertificate(String cert) {
		if (cert != null) {
			try {
				return PemUtils.decodeCertificate(cert);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			return null;
		}
	}

	public static PrivateKey getPrivateKey(String privateKeyPem) {
		if (privateKeyPem != null) {
			try {
				return PemUtils.decodePrivateKey(privateKeyPem);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	public static Key getSecretKey(String secret) {
		return secret != null ? new SecretKeySpec(secret.getBytes(), "HmacSHA256") : null;
	}

	public static String getPemFromKey(Key key) {
		StringWriter writer = new StringWriter();
		PEMWriter pemWriter = new PEMWriter(writer);
		try {
			pemWriter.writeObject(key);
			pemWriter.flush();
			pemWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String s = writer.toString();
		return PemUtils.removeBeginEnd(s);
	}

	public static String getPemFromCertificate(X509Certificate certificate) {
		StringWriter writer = new StringWriter();
		PEMWriter pemWriter = new PEMWriter(writer);
		try {
			pemWriter.writeObject(certificate);
			pemWriter.flush();
			pemWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String s = writer.toString();
		return PemUtils.removeBeginEnd(s);
	}

	public static void generateOrganizationKeys(OrganizationModel organization) {
		KeyPair keyPair = null;
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			keyPair = generator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		organization.setPrivateKey(keyPair.getPrivate());
		organization.setPublicKey(keyPair.getPublic());
		X509Certificate certificate = null;
		try {
			certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organization.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		organization.setCertificate(certificate);

		organization.setCodeSecret(generateCodeSecret());
	}

	public static void generateOrganizationCertificate(OrganizationModel organization) {
		X509Certificate certificate = null;
		try {
			certificate = CertificateUtils.generateV1SelfSignedCertificate(
					new KeyPair(organization.getPublicKey(), organization.getPrivateKey()), organization.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		organization.setCertificate(certificate);
	}

	public static CertificateRepresentation generateKeyPairCertificate(String subject) {
		KeyPair keyPair = null;
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			keyPair = generator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		X509Certificate certificate = null;
		try {
			certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, subject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		String privateKeyPem = OpenfactModelUtils.getPemFromKey(keyPair.getPrivate());
		String certPem = OpenfactModelUtils.getPemFromCertificate(certificate);

		CertificateRepresentation rep = new CertificateRepresentation();
		rep.setPrivateKey(privateKeyPem);
		rep.setCertificate(certPem);
		return rep;
	}

	public static String getDefaultClientAuthenticatorType() {
		return "client-secret";
	}

	public static String generateCodeSecret() {
		return UUID.randomUUID().toString();
	}

	public static String getMasterRealmAdminApplicationClientId(String realmName) {
		return realmName + "-realm";
	}

	// END USER FEDERATION RELATED STUFF

	public static String toLowerCaseSafe(String str) {
		return str == null ? null : str.toLowerCase();
	}	

}
