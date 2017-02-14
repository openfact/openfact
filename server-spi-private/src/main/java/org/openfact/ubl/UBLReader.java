package org.openfact.ubl;

import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UBLReader<T> extends Provider {

    T read(byte[] bytes);

    T read(Document document);

}
