package org.openfact.keys;

import org.jboss.logging.Logger;
import org.openfact.common.util.KeyUtils;
import org.openfact.common.util.Time;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.List;

public class FailsafeHmacKeyProvider implements HmacKeyProvider {

    private static final Logger logger = Logger.getLogger(FailsafeHmacKeyProvider.class);

    private static String KID;

    private static SecretKey KEY;

    private static long EXPIRES;

    private SecretKey key;

    private String kid;

    public FailsafeHmacKeyProvider() {
        logger.errorv("No active keys found, using failsafe provider, please login to admin console to add keys. Clustering is not supported.");

        synchronized (FailsafeHmacKeyProvider.class) {
            if (EXPIRES < Time.currentTime()) {
                KEY = KeyUtils.loadSecretKey(OpenfactModelUtils.generateSecret(32));
                KID = OpenfactModelUtils.generateId();
                EXPIRES = Time.currentTime() + 60 * 10;

                if (EXPIRES > 0) {
                    logger.warnv("Keys expired, re-generated kid={0}", KID);
                }
            }

            kid = KID;
            key = KEY;
        }
    }

    @Override
    public String getKid() {
        return kid;
    }

    @Override
    public SecretKey getSecretKey() {
        return key;
    }

    @Override
    public SecretKey getSecretKey(String kid) {
        return kid.equals(this.kid) ? key : null;
    }

    @Override
    public List<HmacKeyMetadata> getKeyMetadata() {
        return Collections.emptyList();
    }

    @Override
    public void close() {
    }

}
