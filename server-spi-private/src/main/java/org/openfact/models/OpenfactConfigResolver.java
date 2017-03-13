package org.openfact.models;

import com.fasterxml.jackson.databind.JsonNode;

public interface OpenfactConfigResolver {

    JsonNode getNode();

}
