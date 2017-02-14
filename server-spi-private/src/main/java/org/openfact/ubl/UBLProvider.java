package org.openfact.ubl;

import org.openfact.models.DocumentModel;
import org.openfact.provider.Provider;

public interface UBLProvider<T> extends Provider {

    UBLIDGenerator<T> idGenerator();

    UBLReader<T> reader();

    UBLWriter<T> writer();

    UBLSender<DocumentModel> sender();

}