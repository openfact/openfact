package org.openfact.models;

/**
 * Task to be executed inside transaction
 */
public interface OpenfactSessionTask {

    public void run(OpenfactSession session);

}
