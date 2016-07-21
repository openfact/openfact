package org.openfact.common;

public interface ClientConnection {

    String getRemoteAddr();
    String getRemoteHost();
    int getRemotePort();

    String getLocalAddr();
    int getLocalPort();
}
