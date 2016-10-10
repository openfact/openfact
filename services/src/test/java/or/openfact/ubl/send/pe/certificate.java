package or.openfact.ubl.send.pe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

public class certificate {

	public static void main(String[] args) throws CertificateException, IOException {
		InputStream inStream = null;
		try {
			inStream = new FileInputStream("/home/lxpary/ssl/ahren.cer");
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			
//			X509Certificate cert = getCertificate();
//			organization.setCertificate(cert);
//			organization.setPublicKey(cert.getPublicKey());
//			organization.setPrivateKey(getPrivateKey());
//			organization.setCodeSecret(UUID.randomUUID().toString());
//			// OpenfactModelUtils.generateOrganizationKeys(organization);
//			Map<String, String> config = new HashMap<>();
//			config.put("username", "20494637074MODDATOS");
//			config.put("password", "MODDATOS");
//			organization.setUblSenderConfig(config);
			
//			FileOutputStream os = new FileOutputStream(new File("/home/lxpary/" + fileName + ".zip"));
//			os.write(zip);
//			os.close();
	
		} finally {
			if (inStream != null) {
				inStream.close();
			}
		}
	}

	public X509Certificate getCertificate() throws CertificateException, IOException {
		InputStream inStream = null;
		try {
			inStream = new FileInputStream("/home/lxpary/ssl/ahren.cer");
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
			return cert;
		} finally {
			if (inStream != null) {
				inStream.close();
			}
		}
	}
	public PrivateKey getPrivateKey() throws IOException, GeneralSecurityException {
		PrivateKey key = null;
		InputStream is = null;
		try {
			is = new FileInputStream("/home/lxpary/ssl/ahren.key");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder builder = new StringBuilder();
			boolean inKey = false;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (!inKey) {
					if (line.startsWith("-----BEGIN ") && line.endsWith(" PRIVATE KEY-----")) {
						inKey = true;
					}
					continue;
				} else {
					if (line.startsWith("-----END ") && line.endsWith(" PRIVATE KEY-----")) {
						inKey = false;
						break;
					}
					builder.append(line);
				}
			}
			//
			byte[] encoded = DatatypeConverter.parseBase64Binary(builder.toString());
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			key = kf.generatePrivate(keySpec);
		} finally {
			closeSilent(is);
		}
		return key;
	}

	public void closeSilent(final InputStream is) {
		if (is == null)
			return;
		try {
			is.close();
		} catch (Exception ign) {
		}
	}

}
