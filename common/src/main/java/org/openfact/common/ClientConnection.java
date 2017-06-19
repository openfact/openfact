package org.openfact.common;

/**
 * Information about the client connection
 */
public interface ClientConnection {

    String getRemoteAddr();
    String getRemoteHost();
    int getRemotePort();

    String getLocalAddr();
    int getLocalPort();

}
