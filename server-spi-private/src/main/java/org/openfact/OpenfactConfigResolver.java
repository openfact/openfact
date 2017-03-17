package org.openfact;

import com.fasterxml.jackson.databind.JsonNode;

public interface OpenfactConfigResolver {

    JsonNode getNode();

}
