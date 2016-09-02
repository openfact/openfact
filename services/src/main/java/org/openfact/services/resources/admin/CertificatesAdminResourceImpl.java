package org.openfact.services.resources.admin;


import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.common.util.PemUtils;
import org.openfact.common.util.StreamUtil;
import org.openfact.events.admin.OperationType;
import org.openfact.jose.jwk.JSONWebKeySet;
import org.openfact.models.*;
import org.openfact.protocol.oidc.utils.JWKSUtils;
import org.openfact.representations.KeyStoreConfig;
import org.openfact.representations.idm.CertificateRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.util.CertificateInfoHelper;
import org.openfact.util.JsonSerialization;
import org.openfact.jose.jwk.JWK;

import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.CacheControl;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertificatesAdminResourceImpl implements CertificatesAdminResource {

	private static final Logger logger = Logger.getLogger(CertificatesAdminResourceImpl.class);

	public static final String CERTIFICATE_PEM = "Certificate PEM";
	public static final String PUBLIC_KEY_PEM = "Public Key PEM";
	public static final String JSON_WEB_KEY_SET = "JSON Web Key Set";

	protected OrganizationAuth auth;

	protected AdminEventBuilder adminEvent;

	protected OrganizationModel organization;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected OpenfactSession session;

	@Context
	protected ClientConnection clientConnection;

	public CertificatesAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth,
			AdminEventBuilder adminEvent) {
		this.organization = organization;
		this.auth = auth;
		auth.init(OrganizationAuth.Resource.CERTIFIED);
		this.adminEvent = adminEvent;
	}

	public static final CacheControl noCache = new CacheControl();

	static {
		noCache.setNoCache(true);
	}	

	@Override
	public CertificateRepresentation getKeyInfo() {
		auth.requireView();

		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}

		CertificateRepresentation info = CertificateInfoHelper.getCertificateFromOrganization(organization,
				organization.getAssignedIdentificationId()/* "attributePrefix" */);
		return info;
	}

	@Override
	public CertificateRepresentation generate() {
		// TODO Auto-generated method stub
		auth.requireManage();

		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}

		CertificateRepresentation info = OpenfactModelUtils.generateKeyPairCertificate(organization.getId());

		CertificateInfoHelper.updateOrganizationModelCertificateInfo(organization, info,
				organization.getAssignedIdentificationId()/* "attributePrefix" */);

		adminEvent.operation(OperationType.ACTION).resourcePath(session.getContext().getUri()).representation(info)
				.success();

		return info;
	}

	@Override
	public CertificateRepresentation uploadJks(UriInfo uriInfo, MultipartFormDataInput input) {

		auth.requireManage();
		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}

		CertificateRepresentation info = null;
		try {
			info = getCertFromRequest(uriInfo, input);
			CertificateInfoHelper.updateOrganizationModelCertificateInfo(organization, info,
					organization.getAssignedIdentificationId()/* "attributePrefix" */);
		} catch (IllegalStateException ise) {
			throw new ErrorResponse("certificate-not-found",
					"Certificate or key with given alias not found in the keystore", Response.Status.BAD_REQUEST);
		} catch (IOException e) {
			throw new ErrorResponse("certificate-request-error", "Certificate or key incorred in error...",
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		adminEvent.operation(OperationType.ACTION).resourcePath(session.getContext().getUri()).representation(info)
				.success();

		return info;
	}

	@Override
	public CertificateRepresentation uploadJksCertificate(UriInfo uriInfo, MultipartFormDataInput input) {
		auth.requireManage();

		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}
		CertificateRepresentation info = null;
		try {
			info = getCertFromRequest(uriInfo, input);
			if (info != null)
				info.setPrivateKey(null);
			CertificateInfoHelper.updateOrganizationModelCertificateInfo(organization, info,
					organization.getAssignedIdentificationId()/* "attributePrefix" */);
		} catch (IllegalStateException ise) {
			throw new ErrorResponse("certificate-not-found",
					"Certificate or key with given alias not found in the keystore", Response.Status.BAD_REQUEST);
		} catch (IOException e) {
			throw new ErrorResponse("certificate-request-error", "Certificate or key incorred in error...",
					Response.Status.INTERNAL_SERVER_ERROR);
		}

		adminEvent.operation(OperationType.ACTION).resourcePath(session.getContext().getUri()).representation(info)
				.success();
		return info;
	}

	private CertificateRepresentation getCertFromRequest(UriInfo uriInfo, MultipartFormDataInput input)
			throws IOException {
		auth.requireManage();
		CertificateRepresentation info = new CertificateRepresentation();
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		String keystoreFormat = uploadForm.get("keystoreFormat").get(0).getBodyAsString();
		List<InputPart> inputParts = uploadForm.get("file");
		if (keystoreFormat.equals(CERTIFICATE_PEM)) {
			String pem = StreamUtil.readString(inputParts.get(0).getBody(InputStream.class, null));

			// Validate format
			OpenfactModelUtils.getCertificate(pem);

			info.setCertificate(pem);
			return info;
		} else if (keystoreFormat.equals(PUBLIC_KEY_PEM)) {
			String pem = StreamUtil.readString(inputParts.get(0).getBody(InputStream.class, null));

			// Validate format
			OpenfactModelUtils.getPublicKey(pem);

			info.setPublicKey(pem);
			return info;
		} else if (keystoreFormat.equals(JSON_WEB_KEY_SET)) {
			InputStream stream = inputParts.get(0).getBody(InputStream.class, null);
			JSONWebKeySet keySet = JsonSerialization.readValue(stream, JSONWebKeySet.class);
			PublicKey publicKey = JWKSUtils.getKeyForUse(keySet, JWK.Use.SIG);
			String publicKeyPem = OpenfactModelUtils.getPemFromKey(publicKey);
			info.setPublicKey(publicKeyPem);
			return info;
		}

		String keyAlias = uploadForm.get("keyAlias").get(0).getBodyAsString();
		List<InputPart> keyPasswordPart = uploadForm.get("keyPassword");
		char[] keyPassword = keyPasswordPart != null ? keyPasswordPart.get(0).getBodyAsString().toCharArray() : null;

		List<InputPart> storePasswordPart = uploadForm.get("storePassword");
		char[] storePassword = storePasswordPart != null ? storePasswordPart.get(0).getBodyAsString().toCharArray()
				: null;
		PrivateKey privateKey = null;
		X509Certificate certificate = null;
		try {
			KeyStore keyStore = null;
			if (keystoreFormat.equals("JKS"))
				keyStore = KeyStore.getInstance("JKS");
			else
				keyStore = KeyStore.getInstance(keystoreFormat, "BC");
			keyStore.load(inputParts.get(0).getBody(InputStream.class, null), storePassword);
			try {
				privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPassword);
			} catch (Exception e) {
				// ignore
			}
			certificate = (X509Certificate) keyStore.getCertificate(keyAlias);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (privateKey != null) {
			String privateKeyPem = OpenfactModelUtils.getPemFromKey(privateKey);
			info.setPrivateKey(privateKeyPem);
		}

		if (certificate != null) {
			String certPem = OpenfactModelUtils.getPemFromCertificate(certificate);
			info.setCertificate(certPem);
		}

		return info;
	}

	@Override
	public byte[] getKeystore(KeyStoreConfig config) {
		auth.requireView();

		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}

		if (config.getFormat() != null && !config.getFormat().equals("JKS") && !config.getFormat().equals("PKCS12")) {
			throw new NotAcceptableException("Only support jks or pkcs12 format.");
		}

		CertificateRepresentation info = CertificateInfoHelper.getCertificateFromOrganization(organization,
				organization.getAssignedIdentificationId()/* "attributePrefix" */);
		String privatePem = info.getPrivateKey();
		String certPem = info.getCertificate();

		if (privatePem == null && certPem == null) {
			throw new NotFoundException("keypair not generated for client");
		}
		if (privatePem != null && config.getKeyPassword() == null) {
			throw new ErrorResponse("password-missing", "Need to specify a key password for jks download",
					Response.Status.BAD_REQUEST);
		}
		if (config.getStorePassword() == null) {
			throw new ErrorResponse("password-missing", "Need to specify a store password for jks download",
					Response.Status.BAD_REQUEST);
		}

		byte[] rtn = getKeystore(config, privatePem, certPem);
		return rtn;
	}

	@Override
	public byte[] generateAndGetKeystore(KeyStoreConfig config) {
		auth.requireManage();

		if (organization == null) {
			throw new NotFoundException("Could not find organization");
		}

		if (config.getFormat() != null && !config.getFormat().equals("JKS") && !config.getFormat().equals("PKCS12")) {
			throw new NotAcceptableException("Only support jks or pkcs12 format.");
		}
		if (config.getKeyPassword() == null) {
			throw new ErrorResponse("password-missing",
					"Need to specify a key password for jks generation and download", Response.Status.BAD_REQUEST);
		}
		if (config.getStorePassword() == null) {
			throw new ErrorResponse("password-missing",
					"Need to specify a store password for jks generation and download", Response.Status.BAD_REQUEST);
		}

		CertificateRepresentation info = OpenfactModelUtils.generateKeyPairCertificate(organization.getId());
		byte[] rtn = getKeystore(config, info.getPrivateKey(), info.getCertificate());

		info.setPrivateKey(null);

		CertificateInfoHelper.updateOrganizationModelCertificateInfo(organization, info,
				organization.getAssignedIdentificationId()/* "attributePrefix" */);

		adminEvent.operation(OperationType.ACTION).resourcePath(session.getContext().getUri()).representation(info)
				.success();

		return rtn;
	}

	private byte[] getKeystore(KeyStoreConfig config, String privatePem, String certPem) {
		try {
			String format = config.getFormat();
			KeyStore keyStore;
			if (format.equals("JKS"))
				keyStore = KeyStore.getInstance("JKS");
			else
				keyStore = KeyStore.getInstance(format, "BC");
			keyStore.load(null, null);
			String keyAlias = config.getKeyAlias();
			if (keyAlias == null)
				keyAlias = organization.getId();
			if (privatePem != null) {
				PrivateKey privateKey = PemUtils.decodePrivateKey(privatePem);
				X509Certificate clientCert = PemUtils.decodeCertificate(certPem);

				Certificate[] chain = { clientCert };

				keyStore.setKeyEntry(keyAlias, privateKey, config.getKeyPassword().trim().toCharArray(), chain);
			} else {
				X509Certificate clientCert = PemUtils.decodeCertificate(certPem);
				keyStore.setCertificateEntry(keyAlias, clientCert);
			}

			if (config.isRealmCertificate() == null || config.isRealmCertificate().booleanValue()) {
				X509Certificate certificate = organization.getCertificate();
				if (certificate == null) {
					OpenfactModelUtils.generateRealmCertificate(organization);
					certificate = organization.getCertificate();
				}
				String certificateAlias = config.getRealmAlias();
				if (certificateAlias == null)
					certificateAlias = organization.getName();
				keyStore.setCertificateEntry(certificateAlias, certificate);

			}
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			keyStore.store(stream, config.getStorePassword().trim().toCharArray());
			stream.flush();
			stream.close();
			byte[] rtn = stream.toByteArray();
			return rtn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

