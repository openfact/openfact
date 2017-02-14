package org.openfact.keys;

import org.openfact.common.util.KeyUtils;
import org.openfact.common.util.PemUtils;
import org.openfact.component.ComponentModel;
import org.openfact.models.OrganizationModel;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

public class ImportedRsaKeyProvider extends AbstractRsaKeyProvider {

    public ImportedRsaKeyProvider(OrganizationModel realm, ComponentModel model) {
        super(realm, model);
    }

    @Override
    public Keys loadKeys(OrganizationModel realm, ComponentModel model) {
        String privateRsaKeyPem = model.getConfig().getFirst(Attributes.PRIVATE_KEY_KEY);
        String certificatePem = model.getConfig().getFirst(Attributes.CERTIFICATE_KEY);

        PrivateKey privateKey = PemUtils.decodePrivateKey(privateRsaKeyPem);
        PublicKey publicKey = KeyUtils.extractPublicKey(privateKey);

        KeyPair keyPair = new KeyPair(publicKey, privateKey);
        X509Certificate certificate = PemUtils.decodeCertificate(certificatePem);

        String kid = KeyUtils.createKeyId(keyPair.getPublic());

        return new Keys(kid, keyPair, certificate);
    }

}
