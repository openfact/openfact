package org.openfact.jose.jwk;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfact.jose.jwk.JWK;

public class JSONWebKeySet {

	@JsonProperty("keys")
	private JWK[] keys;

	public JWK[] getKeys() {
		return keys;
	}

	public void setKeys(JWK[] keys) {
		this.keys = keys;
	}

}
