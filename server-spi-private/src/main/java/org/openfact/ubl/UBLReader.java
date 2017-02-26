package org.openfact.ubl;

import org.w3c.dom.Document;

public interface UBLReader<T> {

    T read(byte[] bytes);

    T read(Document document);

}
