package org.openfact.models;

/**
 * Task to be executed inside transaction
 */
public interface OpenfactSessionTask {

    void run(OpenfactSession session);

}
