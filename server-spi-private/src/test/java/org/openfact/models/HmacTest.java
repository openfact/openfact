package org.openfact.models;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.utils.Base32;
import org.openfact.models.utils.HmacOTP;

public class HmacTest {

    @Test
    public void testHmac() throws Exception {
        HmacOTP hmacOTP = new HmacOTP(6, HmacOTP.HMAC_SHA1, 10);
        String secret = "JNSVMMTEKZCUGSKJIVGHMNSQOZBDA5JT";
        String decoded = new String(Base32.decode(secret));
        System.out.println(hmacOTP.generateHOTP(decoded, 0));
        System.out.println(hmacOTP.validateHOTP("550233", decoded, 0));
        Assert.assertEquals(1, hmacOTP.validateHOTP("550233", decoded, 0));
    }
}
