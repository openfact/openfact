package org.openfact.models.utils;

import java.util.UUID;

/**
 * Set of helper methods, which are useful in various model implementations.
 */
public final class OpenfactModelUtils {

	private OpenfactModelUtils() {
	}

	public static String generateId() {
		return UUID.randomUUID().toString();
	}

}
