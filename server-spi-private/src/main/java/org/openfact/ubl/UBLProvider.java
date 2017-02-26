package org.openfact.ubl;

import org.openfact.models.DocumentModel;

public interface UBLProvider<T> {

    UBLIDGenerator<T> idGenerator();

    UBLReader<T> reader();

    UBLWriter<T> writer();

    UBLSender<DocumentModel> sender();

}