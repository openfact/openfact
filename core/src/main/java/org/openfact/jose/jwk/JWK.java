/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.jose.jwk;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JWK {

    public static final String KEY_ID = "kid";

    public static final String KEY_TYPE = "kty";

    public static final String ALGORITHM = "alg";

    public static final String PUBLIC_KEY_USE = "use";
    protected Map<String, Object> otherClaims = new HashMap<String, Object>();
    @JsonProperty(KEY_ID)
    private String keyId;

    @JsonProperty(KEY_TYPE)
    private String keyType;

    @JsonProperty(ALGORITHM)
    private String algorithm;

    @JsonProperty(PUBLIC_KEY_USE)
    private String publicKeyUse;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getPublicKeyUse() {
        return publicKeyUse;
    }

    public void setPublicKeyUse(String publicKeyUse) {
        this.publicKeyUse = publicKeyUse;
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherClaims() {
        return otherClaims;
    }

    @JsonAnySetter
    public void setOtherClaims(String name, Object value) {
        otherClaims.put(name, value);
    }

    public enum Use {
        SIG("sig"),
        ENCRYPTION("enc");

        private String str;

        Use(String str) {
            this.str = str;
        }

        public String asString() {
            return str;
        }
    }


}
