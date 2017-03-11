package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

public interface UBLReaderWriter<T> {

    UBLReader<T> reader();

    UBLWriter<T> writer();

    default void validate(OrganizationModel organization, T t) throws UBLValidationException {
    }

    interface UBLReader<T> {
        T read(byte[] bytes);

        T read(Document document);
    }

    interface UBLWriter<T> {
        Document write(OrganizationModel organization, T t);
    }

}